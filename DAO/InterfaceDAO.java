package DAO;

import java.util.List;

public interface InterfaceDAO<E, K> {

    // Lấy tất cả dữ liệu
    List<E> loadAll();

    // Tìm theo khóa chính
    E findById(K id);

    // Tìm theo tên
    List<E> findByName(String keyword);

    // Thêm
    boolean insert(E entity);
    
    // Cập nhật
    boolean update(E entity);

    // Xóa
    boolean delete(K id);

    // Kiểm tra tồn tại
    boolean exists(K id);

    // Đếm số bản ghi
    long count();
}