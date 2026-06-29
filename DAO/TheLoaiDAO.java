package DAO;

import DAO.HibernateUtil;
import Model.TheLoai;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TheLoaiDAO {

    public List<TheLoai> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TheLoai", TheLoai.class).list();
        }
    }

    public TheLoai findById(String maTheLoai) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(TheLoai.class, maTheLoai);
        }
    }

    public List<TheLoai> findByName(String tenTheLoai) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TheLoai WHERE tenTheLoai LIKE :ten", TheLoai.class)
                    .setParameter("ten", "%" + tenTheLoai + "%").list();
        }
    }

    public boolean insert(TheLoai obj) {
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

    public boolean update(TheLoai obj) {
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

    public boolean remove(String maTheLoai) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            TheLoai obj = session.get(TheLoai.class, maTheLoai);
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
