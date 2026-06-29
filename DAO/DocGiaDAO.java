package DAO;

import Model.DocGia;
import DAO.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class DocGiaDAO {

    public List<DocGia> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM DocGia", DocGia.class).list();
        }
    }

    public DocGia findById(String maDG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(DocGia.class, maDG);
        }
    }

    public List<DocGia> findByName(String tenDG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM DocGia WHERE tenDG LIKE :ten", DocGia.class)
                    .setParameter("ten", "%" + tenDG + "%").list();
        }
    }

    public List<DocGia> findByLoai(String maLoaiDG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM DocGia WHERE loaiDocGia.maLoaiDG = :ma", DocGia.class)
                    .setParameter("ma", maLoaiDG).list();
        }
    }

    public boolean insert(DocGia obj) {
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

    public boolean update(DocGia obj) {
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

    public boolean remove(String maDG) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            DocGia obj = session.get(DocGia.class, maDG);
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
