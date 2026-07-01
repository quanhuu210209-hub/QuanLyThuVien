package DAO;

import java.util.List;
import Model.CuonSachId;
import Model.CuonSach;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class CuonSachDAO extends BaseDAO<CuonSach, CuonSachId> {

    public CuonSachDAO() {
        super(CuonSach.class);
    }

    @Override
    public List<CuonSach> findByName(String keyword){

        EntityManager em = JpaUtils.getEntityManager();

        try{

            String jpql="""
                    SELECT c
                    FROM CuonSach c
                    WHERE c.id.maCuonSach LIKE :keyword
                    """;

            return em.createQuery(jpql,CuonSach.class)
                    .setParameter("keyword","%"+keyword+"%")
                    .getResultList();

        }finally{

            em.close();

        }

    }

    public List<CuonSach> findByTrangThai(String trangThai){

        EntityManager em = JpaUtils.getEntityManager();

        try{

            String jpql =
                    "SELECT c FROM CuonSach c WHERE c.trangThai = :tt";

            return em.createQuery(jpql,CuonSach.class)
                    .setParameter("tt",trangThai)
                    .getResultList();

        }finally{

            em.close();

        }

    }

}