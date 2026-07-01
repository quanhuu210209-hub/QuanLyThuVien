package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "NhaXuatBan")
public class NhaXuatBan {
    @Id
    @Column(name = "MaNXB", length = 20)
    private String maNXB;

    @Column(name = "TenNXB", nullable = false, length = 100)
    private String tenNXB;

    public NhaXuatBan() {}

	public String getMaNXB() {
		return maNXB;
	}

	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public NhaXuatBan(String maNXB, String tenNXB) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
	}
}