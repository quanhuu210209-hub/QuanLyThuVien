package Model;
 
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
 
@Entity
@Table(name = "HoaDon")
public class HoaDon {
 
    @Id
    @Column(name = "MaHoaDon", length = 20)
    private String maHoaDon;
 
    @Column(name = "NgayLap", nullable = false)
    private LocalDate ngayLap;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDG")
    private DocGia docGia;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV")
    private NhanVien nhanVien;
 
    @Column(name = "TongTien", precision = 18, scale = 2)
    private BigDecimal tongTien;
 
    public HoaDon() {}
 
    public HoaDon(String maHoaDon, LocalDate ngayLap, DocGia docGia, NhanVien nhanVien, BigDecimal tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.docGia = docGia;
        this.nhanVien = nhanVien;
        this.tongTien = tongTien;
    }
 
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }
 
    public LocalDate getNgayLap() { return ngayLap; }
    public void setNgayLap(LocalDate ngayLap) { this.ngayLap = ngayLap; }
 
    public DocGia getDocGia() { return docGia; }
    public void setDocGia(DocGia docGia) { this.docGia = docGia; }
 
    public NhanVien getNhanVien() { return nhanVien; }
    public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; }
 
    public BigDecimal getTongTien() { return tongTien; }
    public void setTongTien(BigDecimal tongTien) { this.tongTien = tongTien; }
}