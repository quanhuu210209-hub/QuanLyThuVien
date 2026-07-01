package Model;
 
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
 
@Embeddable
public class HoaDonChiTietId implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private String maHoaDon;
    private String maSach;
 
    public HoaDonChiTietId() {}
 
    public HoaDonChiTietId(String maHoaDon, String maSach) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
    }
 
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }
 
    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoaDonChiTietId)) return false;
        HoaDonChiTietId that = (HoaDonChiTietId) o;
        return Objects.equals(maHoaDon, that.maHoaDon) &&
               Objects.equals(maSach, that.maSach);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(maHoaDon, maSach);
    }
}