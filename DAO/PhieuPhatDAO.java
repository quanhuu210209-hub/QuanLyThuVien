package DAO;

import java.util.List;

import Model.PhieuPhat;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class PhieuPhatDAO extends BaseDAO<PhieuPhat, String> {

    public PhieuPhatDAO() {
        super(PhieuPhat.class);
    }

    @Override
    public List<PhieuPhat> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT p FROM PhieuPhat p WHERE p.maPhieuPhat LIKE :keyword";

            return em.createQuery(jpql, PhieuPhat.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public List<PhieuPhat> findByTrangThaiThanhToan(String trangThai) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT p FROM PhieuPhat p WHERE p.trangThaiThanhToan = :tt";

            return em.createQuery(jpql, PhieuPhat.class)
                    .setParameter("tt", trangThai)
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public List<PhieuPhat> findByLyDo(String lyDo) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql =
                    "SELECT p FROM PhieuPhat p WHERE p.lyDoPhat LIKE :lyDo";

            return em.createQuery(jpql, PhieuPhat.class)
                    .setParameter("lyDo", "%" + lyDo + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

}