package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "NgonNgu")
public class NgonNgu {
    @Id
    @Column(name = "MaNgonNgu", length = 20)
    private String maNgonNgu;

    @Column(name = "TenNgonNgu", nullable = false, length = 100)
    private String tenNgonNgu;

    public NgonNgu() {}

	public String getMaNgonNgu() {
		return maNgonNgu;
	}

	public void setMaNgonNgu(String maNgonNgu) {
		this.maNgonNgu = maNgonNgu;
	}

	public String getTenNgonNgu() {
		return tenNgonNgu;
	}

	public void setTenNgonNgu(String tenNgonNgu) {
		this.tenNgonNgu = tenNgonNgu;
	}

	public NgonNgu(String maNgonNgu, String tenNgonNgu) {
		super();
		this.maNgonNgu = maNgonNgu;
		this.tenNgonNgu = tenNgonNgu;
	}
}