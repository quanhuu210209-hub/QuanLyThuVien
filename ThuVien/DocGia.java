package ThuVien;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DocGia")
public class DocGia {
    @Id
    @Column(name = "MaDG", length = 20)
    private String maDG;

    @Column(name = "TenDG", nullable = false, length = 100)
    private String tenDG;

    @Column(name = "DiaChi", length = 200)
    private String diaChi;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh", length = 10)
    private String gioiTinh;

    @Column(name = "Email", length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoaiDG")
    private LoaiDocGia loaiDocGia;

    public DocGia() {}

	public String getMaDG() {
		return maDG;
	}

	public void setMaDG(String maDG) {
		this.maDG = maDG;
	}

	public String getTenDG() {
		return tenDG;
	}

	public void setTenDG(String tenDG) {
		this.tenDG = tenDG;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoaiDocGia getLoaiDocGia() {
		return loaiDocGia;
	}

	public void setLoaiDocGia(LoaiDocGia loaiDocGia) {
		this.loaiDocGia = loaiDocGia;
	}

	public DocGia(String maDG, String tenDG, String diaChi, LocalDate ngaySinh, String gioiTinh, String email,
			LoaiDocGia loaiDocGia) {
		super();
		this.maDG = maDG;
		this.tenDG = tenDG;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.loaiDocGia = loaiDocGia;
	}

}