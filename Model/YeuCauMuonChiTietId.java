package Model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class YeuCauMuonChiTietId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String maYeuCau;
    private String maSach;

    public YeuCauMuonChiTietId() {
    }

    public YeuCauMuonChiTietId(String maYeuCau, String maSach) {
        this.maYeuCau = maYeuCau;
        this.maSach = maSach;
    }

    public String getMaYeuCau() {
        return maYeuCau;
    }

    public void setMaYeuCau(String maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YeuCauMuonChiTietId)) return false;
        YeuCauMuonChiTietId that = (YeuCauMuonChiTietId) o;
        return Objects.equals(maYeuCau, that.maYeuCau)
                && Objects.equals(maSach, that.maSach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maYeuCau, maSach);
    }
}