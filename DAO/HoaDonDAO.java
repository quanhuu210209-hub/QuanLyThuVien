package DAO;

import java.time.LocalDate;
import java.util.List;

import Model.HoaDon;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class HoaDonDAO extends BaseDAO<HoaDon, String> {

    public HoaDonDAO() {
        super(HoaDon.class);
    }

    @Override
    public List<HoaDon> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT h FROM HoaDon h WHERE h.maHoaDon LIKE :keyword";

            return em.createQuery(jpql, HoaDon.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public List<HoaDon> findByDocGia(String maDG) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT h FROM HoaDon h WHERE h.docGia.maDG = :maDG";

            return em.createQuery(jpql, HoaDon.class)
                    .setParameter("maDG", maDG)
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public List<HoaDon> findByNhanVien(String maNV) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT h FROM HoaDon h WHERE h.nhanVien.maNV = :maNV";

            return em.createQuery(jpql, HoaDon.class)
                    .setParameter("maNV", maNV)
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public List<HoaDon> findByNgayLap(LocalDate ngayLap) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT h FROM HoaDon h WHERE h.ngayLap = :ngay";

            return em.createQuery(jpql, HoaDon.class)
                    .setParameter("ngay", ngayLap)
                    .getResultList();

        } finally {
            em.close();
        }

    }

}