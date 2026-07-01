package DAO;

import java.util.List;

import Model.LoaiDocGia;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class LoaiDocGiaDAO extends BaseDAO<LoaiDocGia, String> {

    public LoaiDocGiaDAO() {
        super(LoaiDocGia.class);
    }

    @Override
    public List<LoaiDocGia> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT l FROM LoaiDocGia l WHERE l.tenLoaiDG LIKE :keyword";

            return em.createQuery(jpql, LoaiDocGia.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

}