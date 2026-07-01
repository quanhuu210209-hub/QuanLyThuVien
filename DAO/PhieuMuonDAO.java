package DAO;

import java.util.List;

import Model.PhieuMuon;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class PhieuMuonDAO extends BaseDAO<PhieuMuon, String> {

    public PhieuMuonDAO() {
        super(PhieuMuon.class);
    }

    @Override
    public List<PhieuMuon> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT p FROM PhieuMuon p WHERE p.soPhieu LIKE :keyword";

            return em.createQuery(jpql, PhieuMuon.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public List<PhieuMuon> findByDocGia(String maDG) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT p FROM PhieuMuon p WHERE p.docGia.maDG = :maDG";

            return em.createQuery(jpql, PhieuMuon.class)
                    .setParameter("maDG", maDG)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public List<PhieuMuon> findByNhanVien(String maNV) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT p FROM PhieuMuon p WHERE p.nhanVien.maNV = :maNV";

            return em.createQuery(jpql, PhieuMuon.class)
                    .setParameter("maNV", maNV)
                    .getResultList();

        } finally {
            em.close();
        }
    }

}