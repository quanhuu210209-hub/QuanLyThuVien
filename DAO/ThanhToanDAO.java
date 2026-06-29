package DAO;

import DAO.HibernateUtil;
import Model.ThanhToan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ThanhToanDAO {

    public List<ThanhToan> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ThanhToan", ThanhToan.class).list();
        }
    }

    public ThanhToan findById(String maThanhToan) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ThanhToan.class, maThanhToan);
        }
    }

    public List<ThanhToan> findByName(String maThanhToan) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ThanhToan WHERE maThanhToan LIKE :ma", ThanhToan.class)
                    .setParameter("ma", "%" + maThanhToan + "%").list();
        }
    }

    public List<ThanhToan> findByPhieuPhat(String maPhieuPhat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ThanhToan WHERE phieuPhat.maPhieuPhat = :ma", ThanhToan.class)
                    .setParameter("ma", maPhieuPhat).list();
        }
    }

    public boolean insert(ThanhToan obj) {
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

    public boolean update(ThanhToan obj) {
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

    public boolean remove(String maThanhToan) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            ThanhToan obj = session.get(ThanhToan.class, maThanhToan);
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
