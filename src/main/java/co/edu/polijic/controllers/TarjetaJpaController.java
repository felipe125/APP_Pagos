/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.polijic.beans.CuentaBancaria;
import co.edu.polijic.beans.Tarjeta;
import co.edu.polijic.controllers.exceptions.NonexistentEntityException;
import co.edu.polijic.controllers.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author felipe
 */
public class TarjetaJpaController implements Serializable {

    public TarjetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tarjeta tarjeta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CuentaBancaria cdcuentabancaria = tarjeta.getCdcuentabancaria();
            if (cdcuentabancaria != null) {
                cdcuentabancaria = em.getReference(cdcuentabancaria.getClass(), cdcuentabancaria.getCdcuentabancaria());
                tarjeta.setCdcuentabancaria(cdcuentabancaria);
            }
            em.persist(tarjeta);
            if (cdcuentabancaria != null) {
                cdcuentabancaria.getTarjetaList().add(tarjeta);
                cdcuentabancaria = em.merge(cdcuentabancaria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTarjeta(tarjeta.getCdtarjeta()) != null) {
                throw new PreexistingEntityException("Tarjeta " + tarjeta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tarjeta tarjeta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarjeta persistentTarjeta = em.find(Tarjeta.class, tarjeta.getCdtarjeta());
            CuentaBancaria cdcuentabancariaOld = persistentTarjeta.getCdcuentabancaria();
            CuentaBancaria cdcuentabancariaNew = tarjeta.getCdcuentabancaria();
            if (cdcuentabancariaNew != null) {
                cdcuentabancariaNew = em.getReference(cdcuentabancariaNew.getClass(), cdcuentabancariaNew.getCdcuentabancaria());
                tarjeta.setCdcuentabancaria(cdcuentabancariaNew);
            }
            tarjeta = em.merge(tarjeta);
            if (cdcuentabancariaOld != null && !cdcuentabancariaOld.equals(cdcuentabancariaNew)) {
                cdcuentabancariaOld.getTarjetaList().remove(tarjeta);
                cdcuentabancariaOld = em.merge(cdcuentabancariaOld);
            }
            if (cdcuentabancariaNew != null && !cdcuentabancariaNew.equals(cdcuentabancariaOld)) {
                cdcuentabancariaNew.getTarjetaList().add(tarjeta);
                cdcuentabancariaNew = em.merge(cdcuentabancariaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tarjeta.getCdtarjeta();
                if (findTarjeta(id) == null) {
                    throw new NonexistentEntityException("The tarjeta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarjeta tarjeta;
            try {
                tarjeta = em.getReference(Tarjeta.class, id);
                tarjeta.getCdtarjeta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarjeta with id " + id + " no longer exists.", enfe);
            }
            CuentaBancaria cdcuentabancaria = tarjeta.getCdcuentabancaria();
            if (cdcuentabancaria != null) {
                cdcuentabancaria.getTarjetaList().remove(tarjeta);
                cdcuentabancaria = em.merge(cdcuentabancaria);
            }
            em.remove(tarjeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tarjeta> findTarjetaEntities() {
        return findTarjetaEntities(true, -1, -1);
    }

    public List<Tarjeta> findTarjetaEntities(int maxResults, int firstResult) {
        return findTarjetaEntities(false, maxResults, firstResult);
    }

    private List<Tarjeta> findTarjetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tarjeta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tarjeta findTarjeta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tarjeta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTarjetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tarjeta> rt = cq.from(Tarjeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
