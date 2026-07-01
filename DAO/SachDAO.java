package DAO;

import java.util.List;

import Model.Sach;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class SachDAO extends BaseDAO<Sach, String> {

    public SachDAO() {
        super(Sach.class);
    }

    @Override
    public List<Sach> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT s FROM Sach s WHERE s.tenSach LIKE :keyword";

            return em.createQuery(jpql, Sach.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {

            em.close();

        }

    }

}