package ThuVien;

import jakarta.persistence.*;

@Entity
@Table(name = "TheLoai")
public class TheLoai {
    @Id
    @Column(name = "MaTheLoai", length = 20)
    private String maTheLoai;

    @Column(name = "TenTheLoai", nullable = false, length = 100)
    private String tenTheLoai;

    public TheLoai() {}

	public String getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public TheLoai(String maTheLoai, String tenTheLoai) {
		super();
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}
}