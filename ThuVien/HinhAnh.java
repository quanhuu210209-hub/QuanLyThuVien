package ThuVien;

import jakarta.persistence.*;

@Entity
@Table(name = "HinhAnh")
public class HinhAnh {
    @Id
    @Column(name = "MaHinhAnh", length = 20)
    private String maHinhAnh;

    @Column(name = "TenHinhAnh", length = 100)
    private String tenHinhAnh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaSach")
    private Sach sach;

    public HinhAnh() {}

	public String getMaHinhAnh() {
		return maHinhAnh;
	}

	public void setMaHinhAnh(String maHinhAnh) {
		this.maHinhAnh = maHinhAnh;
	}

	public String getTenHinhAnh() {
		return tenHinhAnh;
	}

	public void setTenHinhAnh(String tenHinhAnh) {
		this.tenHinhAnh = tenHinhAnh;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public HinhAnh(String maHinhAnh, String tenHinhAnh, Sach sach) {
		super();
		this.maHinhAnh = maHinhAnh;
		this.tenHinhAnh = tenHinhAnh;
		this.sach = sach;
	}
}