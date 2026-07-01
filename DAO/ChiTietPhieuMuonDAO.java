package DAO;

import java.util.List;

import Model.ChiTietPhieuMuon;
import Model.ChiTietPhieuMuonId;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class ChiTietPhieuMuonDAO extends BaseDAO<ChiTietPhieuMuon, ChiTietPhieuMuonId> {

    public ChiTietPhieuMuonDAO() {
        super(ChiTietPhieuMuon.class);
    }

    @Override
    public List<ChiTietPhieuMuon> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT c FROM ChiTietPhieuMuon c WHERE c.id.soPhieu LIKE :keyword";

            return em.createQuery(jpql, ChiTietPhieuMuon.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {

            em.close();

        }

    }

    public List<ChiTietPhieuMuon> findBySoPhieu(String soPhieu) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT c FROM ChiTietPhieuMuon c WHERE c.phieuMuon.soPhieu = :soPhieu";

            return em.createQuery(jpql, ChiTietPhieuMuon.class)
                    .setParameter("soPhieu", soPhieu)
                    .getResultList();

        } finally {

            em.close();

        }

    }

}