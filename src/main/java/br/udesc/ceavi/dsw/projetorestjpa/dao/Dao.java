package br.udesc.ceavi.dsw.projetorestjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Dao {

    public void salvar(Object obj) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetRESTJPAPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Object lerId(Class classe, long id) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetRESTJPAPU");
        EntityManager em = emf.createEntityManager();

        Object obj = null;
        em.getTransaction().begin();
        try {
            obj = em.find(classe, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return obj;
    }

    public Object deleteId(Class classe, long id) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetRESTJPAPU");
        EntityManager em = emf.createEntityManager();

        Object obj = null;
        em.getTransaction().begin();
        try {
            obj = em.find(classe, id);
            if (obj != null) {
                em.remove(obj);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return obj;
        }
    }

    public void updateId(Class classe, Long id, Object objParam) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetRESTJPAPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Object obj = null;
        try {
            obj = em.find(classe, id);
            if (obj != null) {
                em.merge(objParam);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
