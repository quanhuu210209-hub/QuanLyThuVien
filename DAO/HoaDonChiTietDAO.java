package DAO;

import java.util.List;

import Model.HoaDonChiTiet;
import Model.HoaDonChiTietId;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class HoaDonChiTietDAO extends BaseDAO<HoaDonChiTiet, HoaDonChiTietId> {

    public HoaDonChiTietDAO() {
        super(HoaDonChiTiet.class);
    }

    @Override
    public List<HoaDonChiTiet> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT h FROM HoaDonChiTiet h WHERE h.id.maHoaDon LIKE :keyword";

            return em.createQuery(jpql, HoaDonChiTiet.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public List<HoaDonChiTiet> findByHoaDon(String maHoaDon) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT h FROM HoaDonChiTiet h WHERE h.hoaDon.maHoaDon = :maHoaDon";

            return em.createQuery(jpql, HoaDonChiTiet.class)
                    .setParameter("maHoaDon", maHoaDon)
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public List<HoaDonChiTiet> findBySach(String maSach) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT h FROM HoaDonChiTiet h WHERE h.sach.maSach = :maSach";

            return em.createQuery(jpql, HoaDonChiTiet.class)
                    .setParameter("maSach", maSach)
                    .getResultList();

        } finally {
            em.close();
        }

    }

}