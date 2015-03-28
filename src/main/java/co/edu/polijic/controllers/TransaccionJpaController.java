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
import co.edu.polijic.beans.TipoPago;
import co.edu.polijic.beans.RegistroTransaccion;
import co.edu.polijic.beans.Transaccion;
import co.edu.polijic.controllers.exceptions.NonexistentEntityException;
import co.edu.polijic.controllers.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author felipe
 */
public class TransaccionJpaController implements Serializable {

    public TransaccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Transaccion transaccion) throws PreexistingEntityException, Exception {
        if (transaccion.getRegistroTransaccionList() == null) {
            transaccion.setRegistroTransaccionList(new ArrayList<RegistroTransaccion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CuentaBancaria cdcuentaorigen = transaccion.getCdcuentaorigen();
            if (cdcuentaorigen != null) {
                cdcuentaorigen = em.getReference(cdcuentaorigen.getClass(), cdcuentaorigen.getCdcuentabancaria());
                transaccion.setCdcuentaorigen(cdcuentaorigen);
            }
            TipoPago cdtipopago = transaccion.getCdtipopago();
            if (cdtipopago != null) {
                cdtipopago = em.getReference(cdtipopago.getClass(), cdtipopago.getCdtipopago());
                transaccion.setCdtipopago(cdtipopago);
            }
            List<RegistroTransaccion> attachedRegistroTransaccionList = new ArrayList<RegistroTransaccion>();
            for (RegistroTransaccion registroTransaccionListRegistroTransaccionToAttach : transaccion.getRegistroTransaccionList()) {
                registroTransaccionListRegistroTransaccionToAttach = em.getReference(registroTransaccionListRegistroTransaccionToAttach.getClass(), registroTransaccionListRegistroTransaccionToAttach.getCdregistro());
                attachedRegistroTransaccionList.add(registroTransaccionListRegistroTransaccionToAttach);
            }
            transaccion.setRegistroTransaccionList(attachedRegistroTransaccionList);
            em.persist(transaccion);
            if (cdcuentaorigen != null) {
                cdcuentaorigen.getTransaccionList().add(transaccion);
                cdcuentaorigen = em.merge(cdcuentaorigen);
            }
            if (cdtipopago != null) {
                cdtipopago.getTransaccionList().add(transaccion);
                cdtipopago = em.merge(cdtipopago);
            }
            for (RegistroTransaccion registroTransaccionListRegistroTransaccion : transaccion.getRegistroTransaccionList()) {
                Transaccion oldCdtransaccionOfRegistroTransaccionListRegistroTransaccion = registroTransaccionListRegistroTransaccion.getCdtransaccion();
                registroTransaccionListRegistroTransaccion.setCdtransaccion(transaccion);
                registroTransaccionListRegistroTransaccion = em.merge(registroTransaccionListRegistroTransaccion);
                if (oldCdtransaccionOfRegistroTransaccionListRegistroTransaccion != null) {
                    oldCdtransaccionOfRegistroTransaccionListRegistroTransaccion.getRegistroTransaccionList().remove(registroTransaccionListRegistroTransaccion);
                    oldCdtransaccionOfRegistroTransaccionListRegistroTransaccion = em.merge(oldCdtransaccionOfRegistroTransaccionListRegistroTransaccion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTransaccion(transaccion.getCdtransaccion()) != null) {
                throw new PreexistingEntityException("Transaccion " + transaccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transaccion transaccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaccion persistentTransaccion = em.find(Transaccion.class, transaccion.getCdtransaccion());
            CuentaBancaria cdcuentaorigenOld = persistentTransaccion.getCdcuentaorigen();
            CuentaBancaria cdcuentaorigenNew = transaccion.getCdcuentaorigen();
            TipoPago cdtipopagoOld = persistentTransaccion.getCdtipopago();
            TipoPago cdtipopagoNew = transaccion.getCdtipopago();
            List<RegistroTransaccion> registroTransaccionListOld = persistentTransaccion.getRegistroTransaccionList();
            List<RegistroTransaccion> registroTransaccionListNew = transaccion.getRegistroTransaccionList();
            if (cdcuentaorigenNew != null) {
                cdcuentaorigenNew = em.getReference(cdcuentaorigenNew.getClass(), cdcuentaorigenNew.getCdcuentabancaria());
                transaccion.setCdcuentaorigen(cdcuentaorigenNew);
            }
            if (cdtipopagoNew != null) {
                cdtipopagoNew = em.getReference(cdtipopagoNew.getClass(), cdtipopagoNew.getCdtipopago());
                transaccion.setCdtipopago(cdtipopagoNew);
            }
            List<RegistroTransaccion> attachedRegistroTransaccionListNew = new ArrayList<RegistroTransaccion>();
            for (RegistroTransaccion registroTransaccionListNewRegistroTransaccionToAttach : registroTransaccionListNew) {
                registroTransaccionListNewRegistroTransaccionToAttach = em.getReference(registroTransaccionListNewRegistroTransaccionToAttach.getClass(), registroTransaccionListNewRegistroTransaccionToAttach.getCdregistro());
                attachedRegistroTransaccionListNew.add(registroTransaccionListNewRegistroTransaccionToAttach);
            }
            registroTransaccionListNew = attachedRegistroTransaccionListNew;
            transaccion.setRegistroTransaccionList(registroTransaccionListNew);
            transaccion = em.merge(transaccion);
            if (cdcuentaorigenOld != null && !cdcuentaorigenOld.equals(cdcuentaorigenNew)) {
                cdcuentaorigenOld.getTransaccionList().remove(transaccion);
                cdcuentaorigenOld = em.merge(cdcuentaorigenOld);
            }
            if (cdcuentaorigenNew != null && !cdcuentaorigenNew.equals(cdcuentaorigenOld)) {
                cdcuentaorigenNew.getTransaccionList().add(transaccion);
                cdcuentaorigenNew = em.merge(cdcuentaorigenNew);
            }
            if (cdtipopagoOld != null && !cdtipopagoOld.equals(cdtipopagoNew)) {
                cdtipopagoOld.getTransaccionList().remove(transaccion);
                cdtipopagoOld = em.merge(cdtipopagoOld);
            }
            if (cdtipopagoNew != null && !cdtipopagoNew.equals(cdtipopagoOld)) {
                cdtipopagoNew.getTransaccionList().add(transaccion);
                cdtipopagoNew = em.merge(cdtipopagoNew);
            }
            for (RegistroTransaccion registroTransaccionListOldRegistroTransaccion : registroTransaccionListOld) {
                if (!registroTransaccionListNew.contains(registroTransaccionListOldRegistroTransaccion)) {
                    registroTransaccionListOldRegistroTransaccion.setCdtransaccion(null);
                    registroTransaccionListOldRegistroTransaccion = em.merge(registroTransaccionListOldRegistroTransaccion);
                }
            }
            for (RegistroTransaccion registroTransaccionListNewRegistroTransaccion : registroTransaccionListNew) {
                if (!registroTransaccionListOld.contains(registroTransaccionListNewRegistroTransaccion)) {
                    Transaccion oldCdtransaccionOfRegistroTransaccionListNewRegistroTransaccion = registroTransaccionListNewRegistroTransaccion.getCdtransaccion();
                    registroTransaccionListNewRegistroTransaccion.setCdtransaccion(transaccion);
                    registroTransaccionListNewRegistroTransaccion = em.merge(registroTransaccionListNewRegistroTransaccion);
                    if (oldCdtransaccionOfRegistroTransaccionListNewRegistroTransaccion != null && !oldCdtransaccionOfRegistroTransaccionListNewRegistroTransaccion.equals(transaccion)) {
                        oldCdtransaccionOfRegistroTransaccionListNewRegistroTransaccion.getRegistroTransaccionList().remove(registroTransaccionListNewRegistroTransaccion);
                        oldCdtransaccionOfRegistroTransaccionListNewRegistroTransaccion = em.merge(oldCdtransaccionOfRegistroTransaccionListNewRegistroTransaccion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transaccion.getCdtransaccion();
                if (findTransaccion(id) == null) {
                    throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.");
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
            Transaccion transaccion;
            try {
                transaccion = em.getReference(Transaccion.class, id);
                transaccion.getCdtransaccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.", enfe);
            }
            CuentaBancaria cdcuentaorigen = transaccion.getCdcuentaorigen();
            if (cdcuentaorigen != null) {
                cdcuentaorigen.getTransaccionList().remove(transaccion);
                cdcuentaorigen = em.merge(cdcuentaorigen);
            }
            TipoPago cdtipopago = transaccion.getCdtipopago();
            if (cdtipopago != null) {
                cdtipopago.getTransaccionList().remove(transaccion);
                cdtipopago = em.merge(cdtipopago);
            }
            List<RegistroTransaccion> registroTransaccionList = transaccion.getRegistroTransaccionList();
            for (RegistroTransaccion registroTransaccionListRegistroTransaccion : registroTransaccionList) {
                registroTransaccionListRegistroTransaccion.setCdtransaccion(null);
                registroTransaccionListRegistroTransaccion = em.merge(registroTransaccionListRegistroTransaccion);
            }
            em.remove(transaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transaccion> findTransaccionEntities() {
        return findTransaccionEntities(true, -1, -1);
    }

    public List<Transaccion> findTransaccionEntities(int maxResults, int firstResult) {
        return findTransaccionEntities(false, maxResults, firstResult);
    }

    private List<Transaccion> findTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transaccion.class));
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

    public Transaccion findTransaccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transaccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transaccion> rt = cq.from(Transaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
