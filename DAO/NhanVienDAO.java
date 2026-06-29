package DAO;

import DAO.HibernateUtil;
import Model.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class NhanVienDAO {

    public List<NhanVien> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM NhanVien", NhanVien.class).list();
        }
    }

    public NhanVien findById(String maNV) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(NhanVien.class, maNV);
        }
    }

    public List<NhanVien> findByName(String tenNV) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM NhanVien WHERE tenNV LIKE :ten", NhanVien.class)
                    .setParameter("ten", "%" + tenNV + "%").list();
        }
    }

    public boolean insert(NhanVien obj) {
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

    public boolean update(NhanVien obj) {
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

    public boolean remove(String maNV) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            NhanVien obj = session.get(NhanVien.class, maNV);
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
