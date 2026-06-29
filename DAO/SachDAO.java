package DAO;

import DAO.HibernateUtil;
import Model.Sach;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class SachDAO {

    public List<Sach> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Sach", Sach.class).list();
        }
    }

    public Sach findById(String maSach) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Sach.class, maSach);
        }
    }

    public List<Sach> findByName(String tenSach) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Sach WHERE tenSach LIKE :ten", Sach.class)
                    .setParameter("ten", "%" + tenSach + "%").list();
        }
    }

    public List<Sach> findByTheLoai(String maTheLoai) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Sach WHERE theLoai.maTheLoai = :ma", Sach.class)
                    .setParameter("ma", maTheLoai).list();
        }
    }

    public List<Sach> findByTacGia(String maTG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Sach WHERE tacGia.maTG = :ma", Sach.class)
                    .setParameter("ma", maTG).list();
        }
    }

    public boolean insert(Sach obj) {
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

    public boolean update(Sach obj) {
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

    public boolean remove(String maSach) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Sach obj = session.get(Sach.class, maSach);
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
