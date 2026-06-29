package DAO;

import DAO.HibernateUtil;
import Model.HinhAnh;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class HinhAnhDAO {

    public List<HinhAnh> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM HinhAnh", HinhAnh.class).list();
        }
    }

    public HinhAnh findById(String maHinhAnh) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(HinhAnh.class, maHinhAnh);
        }
    }

    public List<HinhAnh> findByName(String tenHinhAnh) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM HinhAnh WHERE tenHinhAnh LIKE :ten", HinhAnh.class)
                    .setParameter("ten", "%" + tenHinhAnh + "%").list();
        }
    }

    public List<HinhAnh> findBySach(String maSach) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM HinhAnh WHERE sach.maSach = :ma", HinhAnh.class)
                    .setParameter("ma", maSach).list();
        }
    }

    public boolean insert(HinhAnh obj) {
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

    public boolean update(HinhAnh obj) {
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

    public boolean remove(String maHinhAnh) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            HinhAnh obj = session.get(HinhAnh.class, maHinhAnh);
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
