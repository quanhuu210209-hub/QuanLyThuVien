package DAO;

import java.util.List;

import Model.NhanVien;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;

public class NhanVienDAO extends BaseDAO<NhanVien, String>{

    public NhanVienDAO() {
        super(NhanVien.class);
    }

    @Override
    public List<NhanVien> findByName(String keyword) {

        EntityManager em = JpaUtils.getEntityManager();

        try {

            String jpql = "SELECT n FROM NhanVien n WHERE n.tenNV LIKE :keyword";

            return em.createQuery(jpql, NhanVien.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            em.close();
        }

    }

    public NhanVien findByEmail(String email){

        EntityManager em = JpaUtils.getEntityManager();

        try{

            String jpql = "SELECT n FROM NhanVien n WHERE n.email = :email";

            List<NhanVien> list = em.createQuery(jpql, NhanVien.class)
                    .setParameter("email", email)
                    .getResultList();

            return list.isEmpty() ? null : list.get(0);

        }finally{
            em.close();
        }

    }

}