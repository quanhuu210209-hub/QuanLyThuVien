package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {

    @Id
    @Column(name = "MaTK", length = 20)
    private String maTK;

    @Column(name = "TenDangNhap", length = 50, nullable = false, unique = true)
    private String tenDangNhap;

    @Column(name = "MatKhau", length = 255, nullable = false)
    private String matKhau;

    @Column(name = "Role", length = 20, nullable = false)
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDG")
    private DocGia docGia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV")
    private NhanVien nhanVien;

    @Column(name = "TrangThai", length = 20, nullable = false)
    private String trangThai;

    public TaiKhoan() {}

    public TaiKhoan(String maTK, String tenDangNhap, String matKhau, String role,
                    DocGia docGia, NhanVien nhanVien, String trangThai) {
        this.maTK = maTK;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.role = role;
        this.docGia = docGia;
        this.nhanVien = nhanVien;
        this.trangThai = trangThai;
    }

    public String getMaTK() { return maTK; }
    public void setMaTK(String maTK) { this.maTK = maTK; }

    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }

    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public DocGia getDocGia() { return docGia; }
    public void setDocGia(DocGia docGia) { this.docGia = docGia; }

    public NhanVien getNhanVien() { return nhanVien; }
    public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}