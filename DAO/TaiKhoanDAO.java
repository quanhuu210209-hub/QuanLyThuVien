package DAO;

import java.util.List;

import Model.TaiKhoan;
import Utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TaiKhoanDAO extends BaseDAO<TaiKhoan,String>{

    public TaiKhoanDAO() {
        super(TaiKhoan.class);
    }

    @Override
    public List<TaiKhoan> findByName(String keyword){

        EntityManager em = JpaUtils.getEntityManager();

        try{

            String jpql =
                    "SELECT t FROM TaiKhoan t WHERE t.tenDangNhap LIKE :keyword";

            return em.createQuery(jpql,TaiKhoan.class)
                    .setParameter("keyword","%"+keyword+"%")
                    .getResultList();

        }finally{
            em.close();
        }

    }

    public TaiKhoan findByUsername(String username){

        EntityManager em = JpaUtils.getEntityManager();

        try{

            String jpql =
                    "SELECT t FROM TaiKhoan t WHERE t.tenDangNhap = :username";

            List<TaiKhoan> list = em.createQuery(jpql,TaiKhoan.class)
                    .setParameter("username",username)
                    .getResultList();

            return list.isEmpty() ? null : list.get(0);

        }finally{
            em.close();
        }

    }

    public TaiKhoan login(String username,String password){

        EntityManager em = JpaUtils.getEntityManager();

        try{

            String jpql = """
                    SELECT t
                    FROM TaiKhoan t
                    WHERE t.tenDangNhap = :username
                    AND t.matKhau = :password
                    AND t.trangThai = 'Hoạt động'
                    """;

            List<TaiKhoan> list = em.createQuery(jpql,TaiKhoan.class)
                    .setParameter("username",username)
                    .setParameter("password",password)
                    .getResultList();

            return list.isEmpty() ? null : list.get(0);

        }finally{
            em.close();
        }

    }

    public boolean changePassword(String maTK,String newPassword){

        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{

            trans.begin();

            TaiKhoan tk = em.find(TaiKhoan.class,maTK);

            if(tk==null) return false;

            tk.setMatKhau(newPassword);

            em.merge(tk);

            trans.commit();

            return true;

        }catch(Exception e){

            if(trans.isActive())
                trans.rollback();

            e.printStackTrace();

            return false;

        }finally{

            em.close();

        }

    }

}