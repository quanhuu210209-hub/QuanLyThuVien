package Model;
 
import jakarta.persistence.*;
import java.math.BigDecimal;
 
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
 
    @EmbeddedId
    private HoaDonChiTietId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maHoaDon")
    @JoinColumn(name = "MaHoaDon")
    private HoaDon hoaDon;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maSach")
    @JoinColumn(name = "MaSach")
    private Sach sach;
 
    @Column(name = "SoLuong")
    private Integer soLuong;
 
    @Column(name = "DonGia", precision = 18, scale = 2)
    private BigDecimal donGia;
 
    // ThanhTien là cột computed (AS SoLuong * DonGia PERSISTED) nên chỉ đọc
    @Column(name = "ThanhTien", precision = 18, scale = 2, insertable = false, updatable = false)
    private BigDecimal thanhTien;
 
    public HoaDonChiTiet() {}
 
    public HoaDonChiTiet(HoaDonChiTietId id, HoaDon hoaDon, Sach sach, Integer soLuong, BigDecimal donGia) {
        this.id = id;
        this.hoaDon = hoaDon;
        this.sach = sach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
 
    public HoaDonChiTietId getId() { return id; }
    public void setId(HoaDonChiTietId id) { this.id = id; }
 
    public HoaDon getHoaDon() { return hoaDon; }
    public void setHoaDon(HoaDon hoaDon) { this.hoaDon = hoaDon; }
 
    public Sach getSach() { return sach; }
    public void setSach(Sach sach) { this.sach = sach; }
 
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
 
    public BigDecimal getDonGia() { return donGia; }
    public void setDonGia(BigDecimal donGia) { this.donGia = donGia; }
 
    public BigDecimal getThanhTien() { return thanhTien; }
}