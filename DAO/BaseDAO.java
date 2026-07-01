package DAO;

import java.util.List;

import Utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class BaseDAO<E, K> implements InterfaceDAO<E, K> {

    protected Class<E> entityClass;

    public BaseDAO(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<E> loadAll() {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";

            return em.createQuery(jpql, entityClass).getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public E findById(K id) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            return em.find(entityClass, id);

        } finally {
            em.close();
        }

    }

    @Override
    public boolean insert(E entity) {

        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {

            trans.begin();

            em.persist(entity);

            trans.commit();

            return true;

        } catch (Exception e) {

            if (trans.isActive()) {
                trans.rollback();
            }

            e.printStackTrace();

            return false;

        } finally {

            em.close();

        }

    }

    @Override
    public boolean update(E entity) {

        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {

            trans.begin();

            em.merge(entity);

            trans.commit();

            return true;

        } catch (Exception e) {

            if (trans.isActive()) {
                trans.rollback();
            }

            e.printStackTrace();

            return false;

        } finally {

            em.close();

        }

    }

    @Override
    public boolean delete(K id) {

        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {

            trans.begin();

            E entity = em.find(entityClass, id);

            if (entity != null) {

                em.remove(entity);

            }

            trans.commit();

            return true;

        } catch (Exception e) {

            if (trans.isActive()) {
                trans.rollback();
            }

            e.printStackTrace();

            return false;

        } finally {

            em.close();

        }

    }

    @Override
    public boolean exists(K id) {

        return findById(id) != null;

    }

    @Override
    public long count() {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e";

            return em.createQuery(jpql, Long.class).getSingleResult();

        } finally {

            em.close();

        }

    }

}