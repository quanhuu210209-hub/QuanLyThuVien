package DAO;

import DAO.HibernateUtil;
import Model.PhieuMuon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.LocalDate;
import java.util.List;

public class PhieuMuonDAO {

    public List<PhieuMuon> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuMuon", PhieuMuon.class).list();
        }
    }

    public PhieuMuon findById(String soPhieu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PhieuMuon.class, soPhieu);
        }
    }

    // findByName ở đây tìm theo soPhieu (không có tên)
    public List<PhieuMuon> findByName(String soPhieu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuMuon WHERE soPhieu LIKE :sp", PhieuMuon.class)
                    .setParameter("sp", "%" + soPhieu + "%").list();
        }
    }

    public List<PhieuMuon> findByDocGia(String maDG) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuMuon WHERE docGia.maDG = :ma", PhieuMuon.class)
                    .setParameter("ma", maDG).list();
        }
    }

    public List<PhieuMuon> findByNhanVien(String maNV) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuMuon WHERE nhanVien.maNV = :ma", PhieuMuon.class)
                    .setParameter("ma", maNV).list();
        }
    }

    public List<PhieuMuon> findQuaHan() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuMuon WHERE ngayHetHan < :today", PhieuMuon.class)
                    .setParameter("today", LocalDate.now()).list();
        }
    }

    public boolean insert(PhieuMuon obj) {
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

    public boolean update(PhieuMuon obj) {
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

    public boolean remove(String soPhieu) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            PhieuMuon obj = session.get(PhieuMuon.class, soPhieu);
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
