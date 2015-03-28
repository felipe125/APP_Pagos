/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.controllers;

import co.edu.polijic.beans.CuentaBancaria;
import co.edu.polijic.controllers.exceptions.NonexistentEntityException;
import co.edu.polijic.controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author felipe
 */
public class CuentaBancariaJpaController implements Serializable {

    public CuentaBancariaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CuentaBancaria cuentaBancaria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cuentaBancaria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCuentaBancaria(cuentaBancaria.getCdcuentabancaria()) != null) {
                throw new PreexistingEntityException("CuentaBancaria " + cuentaBancaria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CuentaBancaria cuentaBancaria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cuentaBancaria = em.merge(cuentaBancaria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cuentaBancaria.getCdcuentabancaria();
                if (findCuentaBancaria(id) == null) {
                    throw new NonexistentEntityException("The cuentaBancaria with id " + id + " no longer exists.");
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
            CuentaBancaria cuentaBancaria;
            try {
                cuentaBancaria = em.getReference(CuentaBancaria.class, id);
                cuentaBancaria.getCdcuentabancaria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuentaBancaria with id " + id + " no longer exists.", enfe);
            }
            em.remove(cuentaBancaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CuentaBancaria> findCuentaBancariaEntities() {
        return findCuentaBancariaEntities(true, -1, -1);
    }

    public List<CuentaBancaria> findCuentaBancariaEntities(int maxResults, int firstResult) {
        return findCuentaBancariaEntities(false, maxResults, firstResult);
    }

    private List<CuentaBancaria> findCuentaBancariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CuentaBancaria.class));
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

    public CuentaBancaria findCuentaBancaria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CuentaBancaria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuentaBancariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CuentaBancaria> rt = cq.from(CuentaBancaria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
