package DAO;

import java.util.List;

import Model.NgonNgu;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class NgonNguDAO extends BaseDAO<NgonNgu, String> {

    public NgonNguDAO() {
        super(NgonNgu.class);
    }

    @Override
    public List<NgonNgu> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT n FROM NgonNgu n WHERE n.tenNgonNgu LIKE :keyword";

            return em.createQuery(jpql, NgonNgu.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }
    }

}