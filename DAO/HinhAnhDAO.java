package DAO;

import java.util.List;

import Model.HinhAnh;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class HinhAnhDAO extends BaseDAO<HinhAnh, String> {

    public HinhAnhDAO() {
        super(HinhAnh.class);
    }

    @Override
    public List<HinhAnh> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT h FROM HinhAnh h WHERE h.tenHinhAnh LIKE :keyword";

            return em.createQuery(jpql, HinhAnh.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public List<HinhAnh> findBySach(String maSach) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT h FROM HinhAnh h WHERE h.sach.maSach = :maSach";

            return em.createQuery(jpql, HinhAnh.class)
                    .setParameter("maSach", maSach)
                    .getResultList();

        } finally {
            em.close();
        }
    }

}