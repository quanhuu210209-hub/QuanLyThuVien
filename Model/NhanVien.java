package Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @Column(name = "MaNV", length = 20)
    private String maNV;

    @Column(name = "TenNV", nullable = false, length = 100)
    private String tenNV;

    @Column(name = "DiaChi", length = 200)
    private String diaChi;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh", length = 10)
    private String gioiTinh;

    @Column(name = "DienThoai", length = 15)
    private String dienThoai;

    @Column(name = "Email", length = 100)
    private String email;

    public NhanVien() {}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NhanVien(String maNV, String tenNV, String diaChi, LocalDate ngaySinh, String gioiTinh, String dienThoai,
			String email) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.dienThoai = dienThoai;
		this.email = email;
	}
}