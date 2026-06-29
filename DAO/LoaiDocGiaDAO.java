package DAO;

import DAO.HibernateUtil;
import Model.LoaiDocGia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LoaiDocGiaDAO {

    public List<LoaiDocGia> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM LoaiDocGia", LoaiDocGia.class).list();
        }
    }

    public LoaiDocGia findById(String maLoaiDG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(LoaiDocGia.class, maLoaiDG);
        }
    }

    public List<LoaiDocGia> findByName(String tenLoaiDG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM LoaiDocGia WHERE tenLoaiDG LIKE :ten", LoaiDocGia.class)
                    .setParameter("ten", "%" + tenLoaiDG + "%").list();
        }
    }

    public boolean insert(LoaiDocGia obj) {
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

    public boolean update(LoaiDocGia obj) {
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

    public boolean remove(String maLoaiDG) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            LoaiDocGia obj = session.get(LoaiDocGia.class, maLoaiDG);
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
