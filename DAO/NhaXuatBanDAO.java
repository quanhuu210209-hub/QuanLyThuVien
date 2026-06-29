package DAO;

import DAO.HibernateUtil;
import Model.NhaXuatBan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class NhaXuatBanDAO {

    public List<NhaXuatBan> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM NhaXuatBan", NhaXuatBan.class).list();
        }
    }

    public NhaXuatBan findById(String maNXB) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(NhaXuatBan.class, maNXB);
        }
    }

    public List<NhaXuatBan> findByName(String tenNXB) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM NhaXuatBan WHERE tenNXB LIKE :ten", NhaXuatBan.class)
                    .setParameter("ten", "%" + tenNXB + "%").list();
        }
    }

    public boolean insert(NhaXuatBan obj) {
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

    public boolean update(NhaXuatBan obj) {
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

    public boolean remove(String maNXB) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            NhaXuatBan obj = session.get(NhaXuatBan.class, maNXB);
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
