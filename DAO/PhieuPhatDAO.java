package DAO;

import DAO.HibernateUtil;
import Model.PhieuPhat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PhieuPhatDAO {

    public List<PhieuPhat> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuPhat", PhieuPhat.class).list();
        }
    }

    public PhieuPhat findById(String maPhieuPhat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PhieuPhat.class, maPhieuPhat);
        }
    }

    public List<PhieuPhat> findByName(String maPhieuPhat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuPhat WHERE maPhieuPhat LIKE :ma", PhieuPhat.class)
                    .setParameter("ma", "%" + maPhieuPhat + "%").list();
        }
    }

    public List<PhieuPhat> findChuaThanhToan() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuPhat WHERE trangThaiThanhToan != 'Đã thanh toán'", PhieuPhat.class).list();
        }
    }

    public boolean insert(PhieuPhat obj) {
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

    public boolean update(PhieuPhat obj) {
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

    public boolean remove(String maPhieuPhat) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            PhieuPhat obj = session.get(PhieuPhat.class, maPhieuPhat);
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
