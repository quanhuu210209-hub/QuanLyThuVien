package DAO;

import Model.CuonSach;
import Model.CuonSachId;
import DAO.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CuonSachDAO {

    public List<CuonSach> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM CuonSach", CuonSach.class).list();
        }
    }

    public CuonSach findById(CuonSachId id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(CuonSach.class, id);
        }
    }

    public List<CuonSach> findBySach(String maSach) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM CuonSach WHERE sach.maSach = :ma", CuonSach.class)
                    .setParameter("ma", maSach).list();
        }
    }

    public List<CuonSach> findByTrangThai(String trangThai) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM CuonSach WHERE trangThai = :tt", CuonSach.class)
                    .setParameter("tt", trangThai).list();
        }
    }

    public boolean insert(CuonSach obj) {
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

    public boolean update(CuonSach obj) {
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

    public boolean remove(CuonSachId id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            CuonSach obj = session.get(CuonSach.class, id);
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
