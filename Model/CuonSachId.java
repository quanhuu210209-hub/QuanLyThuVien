package Model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CuonSachId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSach;
    private String maCuonSach;

    public CuonSachId() {}

    public CuonSachId(String maSach, String maCuonSach) {
        this.maSach = maSach;
        this.maCuonSach = maCuonSach;
    }

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getMaCuonSach() {
		return maCuonSach;
	}

	public void setMaCuonSach(String maCuonSach) {
		this.maCuonSach = maCuonSach;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CuonSachId)) return false;
        CuonSachId that = (CuonSachId) o;
        return Objects.equals(maSach, that.maSach) &&
               Objects.equals(maCuonSach, that.maCuonSach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSach, maCuonSach);
    }
}