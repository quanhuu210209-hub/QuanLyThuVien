package DAO;

import java.util.List;

import Model.NhaXuatBan;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class NhaXuatBanDAO extends BaseDAO<NhaXuatBan, String> {

    public NhaXuatBanDAO() {
        super(NhaXuatBan.class);
    }

    @Override
    public List<NhaXuatBan> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT n FROM NhaXuatBan n WHERE n.tenNXB LIKE :keyword";

            return em.createQuery(jpql, NhaXuatBan.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

}