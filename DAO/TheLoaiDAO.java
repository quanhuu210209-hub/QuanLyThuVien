package DAO;

import java.util.List;

import Model.TheLoai;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class TheLoaiDAO extends BaseDAO<TheLoai, String> {

    public TheLoaiDAO() {
        super(TheLoai.class);
    }

    @Override
    public List<TheLoai> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT t FROM TheLoai t WHERE t.tenTheLoai LIKE :keyword";

            return em.createQuery(jpql, TheLoai.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }
    }

}