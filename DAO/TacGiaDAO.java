package DAO;

import DAO.HibernateUtil;
import Model.TacGia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TacGiaDAO {

    public List<TacGia> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TacGia", TacGia.class).list();
        }
    }

    public TacGia findById(String maTG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(TacGia.class, maTG);
        }
    }

    public List<TacGia> findByName(String tenTG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TacGia WHERE tenTG LIKE :ten", TacGia.class)
                    .setParameter("ten", "%" + tenTG + "%").list();
        }
    }

    public boolean insert(TacGia obj) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(TacGia obj) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(String maTG) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            TacGia obj = session.get(TacGia.class, maTG);
            if (obj != null) session.remove(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
