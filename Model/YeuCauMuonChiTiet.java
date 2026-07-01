package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "YeuCauMuonChiTiet")
public class YeuCauMuonChiTiet {

    @EmbeddedId
    private YeuCauMuonChiTietId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maYeuCau")
    @JoinColumn(name = "MaYeuCau")
    private YeuCauMuon yeuCauMuon;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maSach")
    @JoinColumn(name = "MaSach")
    private Sach sach;

    @Column(name = "SoLuong")
    private Integer soLuong;

    public YeuCauMuonChiTiet() {
    }

    public YeuCauMuonChiTiet(YeuCauMuonChiTietId id,
                             YeuCauMuon yeuCauMuon,
                             Sach sach,
                             Integer soLuong) {
        this.id = id;
        this.yeuCauMuon = yeuCauMuon;
        this.sach = sach;
        this.soLuong = soLuong;
    }

    public YeuCauMuonChiTietId getId() {
        return id;
    }

    public void setId(YeuCauMuonChiTietId id) {
        this.id = id;
    }

    public YeuCauMuon getYeuCauMuon() {
        return yeuCauMuon;
    }

    public void setYeuCauMuon(YeuCauMuon yeuCauMuon) {
        this.yeuCauMuon = yeuCauMuon;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}