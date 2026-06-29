package DAO;

import Model.ChiTietPhieuMuon;
import Model.ChiTietPhieuMuonId;
import DAO.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ChiTietPhieuMuonDAO {

    public List<ChiTietPhieuMuon> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ChiTietPhieuMuon", ChiTietPhieuMuon.class).list();
        }
    }

    public ChiTietPhieuMuon findById(ChiTietPhieuMuonId id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ChiTietPhieuMuon.class, id);
        }
    }

    public List<ChiTietPhieuMuon> findByPhieuMuon(String soPhieu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ChiTietPhieuMuon WHERE phieuMuon.soPhieu = :sp", ChiTietPhieuMuon.class)
                    .setParameter("sp", soPhieu).list();
        }
    }

    public List<ChiTietPhieuMuon> findByCuonSach(String maSach, String maCuonSach) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM ChiTietPhieuMuon WHERE id.maSach = :ms AND id.maCuonSach = :mc",
                    ChiTietPhieuMuon.class)
                    .setParameter("ms", maSach)
                    .setParameter("mc", maCuonSach).list();
        }
    }

    // findByName không áp dụng, dùng findByPhieuMuon thay thế
    public List<ChiTietPhieuMuon> findByName(String soPhieu) {
        return findByPhieuMuon(soPhieu);
    }

    public boolean insert(ChiTietPhieuMuon obj) {
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

    public boolean update(ChiTietPhieuMuon obj) {
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

    public boolean remove(ChiTietPhieuMuonId id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            ChiTietPhieuMuon obj = session.get(ChiTietPhieuMuon.class, id);
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
