package DAO;

import java.util.List;

import Model.DocGia;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class DocGiaDAO extends BaseDAO<DocGia, String> {

    public DocGiaDAO() {
        super(DocGia.class);
    }

    @Override
    public List<DocGia> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT d FROM DocGia d WHERE d.tenDG LIKE :keyword";

            return em.createQuery(jpql, DocGia.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

    /**
     * Tìm độc giả theo Email
     */
    public DocGia findByEmail(String email) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT d FROM DocGia d WHERE d.email = :email";

            List<DocGia> list = em.createQuery(jpql, DocGia.class)
                    .setParameter("email", email)
                    .getResultList();

            return list.isEmpty() ? null : list.get(0);

        } finally {
            em.close();
        }

    }

}