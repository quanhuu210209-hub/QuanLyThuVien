package DAO;

import java.util.List;

import Model.YeuCauMuonChiTiet;
import Model.YeuCauMuonChiTietId;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class YeuCauMuonChiTietDAO extends BaseDAO<YeuCauMuonChiTiet, YeuCauMuonChiTietId> {

    public YeuCauMuonChiTietDAO() {
        super(YeuCauMuonChiTiet.class);
    }

    @Override
    public List<YeuCauMuonChiTiet> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT y FROM YeuCauMuonChiTiet y WHERE y.id.maYeuCau LIKE :keyword";

            return em.createQuery(jpql, YeuCauMuonChiTiet.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {

            em.close();

        }

    }

    public List<YeuCauMuonChiTiet> findByYeuCau(String maYeuCau) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT y FROM YeuCauMuonChiTiet y WHERE y.yeuCauMuon.maYeuCau = :maYeuCau";

            return em.createQuery(jpql, YeuCauMuonChiTiet.class)
                    .setParameter("maYeuCau", maYeuCau)
                    .getResultList();

        } finally {

            em.close();

        }

    }

    public List<YeuCauMuonChiTiet> findBySach(String maSach) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT y FROM YeuCauMuonChiTiet y WHERE y.sach.maSach = :maSach";

            return em.createQuery(jpql, YeuCauMuonChiTiet.class)
                    .setParameter("maSach", maSach)
                    .getResultList();

        } finally {

            em.close();

        }

    }

}