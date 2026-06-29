package DAO;

import DAO.HibernateUtil;
import Model.NgonNgu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class NgonNguDAO {

    public List<NgonNgu> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM NgonNgu", NgonNgu.class).list();
        }
    }

    public NgonNgu findById(String maNgonNgu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(NgonNgu.class, maNgonNgu);
        }
    }

    public List<NgonNgu> findByName(String tenNgonNgu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM NgonNgu WHERE tenNgonNgu LIKE :ten", NgonNgu.class)
                    .setParameter("ten", "%" + tenNgonNgu + "%").list();
        }
    }

    public boolean insert(NgonNgu obj) {
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

    public boolean update(NgonNgu obj) {
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

    public boolean remove(String maNgonNgu) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            NgonNgu obj = session.get(NgonNgu.class, maNgonNgu);
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
