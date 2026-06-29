package ThuVien;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietPhieuMuonId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maCuonSach;
    private String maSach;
    private String soPhieu;

    public ChiTietPhieuMuonId() {}

	public ChiTietPhieuMuonId(String maCuonSach, String maSach, String soPhieu) {
		super();
		this.maCuonSach = maCuonSach;
		this.maSach = maSach;
		this.soPhieu = soPhieu;
	}

	public String getMaCuonSach() {
		return maCuonSach;
	}

	public void setMaCuonSach(String maCuonSach) {
		this.maCuonSach = maCuonSach;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getSoPhieu() {
		return soPhieu;
	}

	public void setSoPhieu(String soPhieu) {
		this.soPhieu = soPhieu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietPhieuMuonId)) return false;
        ChiTietPhieuMuonId that = (ChiTietPhieuMuonId) o;
        return Objects.equals(maCuonSach, that.maCuonSach) &&
               Objects.equals(maSach, that.maSach) &&
               Objects.equals(soPhieu, that.soPhieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCuonSach, maSach, soPhieu);
    }
}