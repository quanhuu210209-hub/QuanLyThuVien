package ThuVien;

import jakarta.persistence.*;

@Entity
@Table(name = "LoaiDocGia")
public class LoaiDocGia {
    @Id
    @Column(name = "MaLoaiDG", length = 20)
    private String maLoaiDG;

    @Column(name = "TenLoaiDG", nullable = false, length = 100)
    private String tenLoaiDG;

    @Column(name = "SoSachToiDa")
    private Integer soSachToiDa;

    @Column(name = "SoNgayToiDa")
    private Integer soNgayToiDa;

    public LoaiDocGia() {}

	public String getMaLoaiDG() {
		return maLoaiDG;
	}

	public void setMaLoaiDG(String maLoaiDG) {
		this.maLoaiDG = maLoaiDG;
	}

	public String getTenLoaiDG() {
		return tenLoaiDG;
	}

	public void setTenLoaiDG(String tenLoaiDG) {
		this.tenLoaiDG = tenLoaiDG;
	}

	public Integer getSoSachToiDa() {
		return soSachToiDa;
	}

	public void setSoSachToiDa(Integer soSachToiDa) {
		this.soSachToiDa = soSachToiDa;
	}

	public Integer getSoNgayToiDa() {
		return soNgayToiDa;
	}

	public void setSoNgayToiDa(Integer soNgayToiDa) {
		this.soNgayToiDa = soNgayToiDa;
	}

	public LoaiDocGia(String maLoaiDG, String tenLoaiDG, Integer soSachToiDa, Integer soNgayToiDa) {
		super();
		this.maLoaiDG = maLoaiDG;
		this.tenLoaiDG = tenLoaiDG;
		this.soSachToiDa = soSachToiDa;
		this.soNgayToiDa = soNgayToiDa;
	} 
}