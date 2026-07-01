package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HoaDonChiTietId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "MaHoaDon", length = 20)
    private String maHoaDon;

    @Column(name = "MaSach", length = 20)
    private String maSach;

    public HoaDonChiTietId() {}

    public HoaDonChiTietId(String maHoaDon, String maSach) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
    }


    public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonChiTietId that = (HoaDonChiTietId) o;
        return Objects.equals(maHoaDon, that.maHoaDon) && Objects.equals(maSach, that.maSach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHoaDon, maSach);
    }
}