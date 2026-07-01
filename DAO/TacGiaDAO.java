package DAO;

import java.util.List;

import Model.TacGia;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class TacGiaDAO extends BaseDAO<TacGia, String> {

    public TacGiaDAO() {
        super(TacGia.class);
    }

    @Override
    public List<TacGia> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT t FROM TacGia t WHERE t.tenTG LIKE :keyword";

            return em.createQuery(jpql, TacGia.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }
    }

}