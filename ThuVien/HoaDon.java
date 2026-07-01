package Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "HoaDon")
public class HoaDon {

    @Id
    @Column(name = "MaHoaDon", length = 20)
    private String maHoaDon;

    @Column(name = "NgayLap", nullable = false)
    private LocalDate ngayLap;

    @Column(name = "TongTien", precision = 18, scale = 2)
    private BigDecimal tongTien;

    @ManyToOne
    @JoinColumn(name = "MaDG")
    private DocGia docGia;

    @ManyToOne
    @JoinColumn(name = "MaNV")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<HoaDonChiTiet> danhSachChiTiet;

    public HoaDon() {}

	public HoaDon(String maHoaDon, LocalDate ngayLap, BigDecimal tongTien, DocGia docGia, NhanVien nhanVien,
			List<HoaDonChiTiet> danhSachChiTiet) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.docGia = docGia;
		this.nhanVien = nhanVien;
		this.danhSachChiTiet = danhSachChiTiet;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public BigDecimal getTongTien() {
		return tongTien;
	}

	public void setTongTien(BigDecimal tongTien) {
		this.tongTien = tongTien;
	}

	public DocGia getDocGia() {
		return docGia;
	}

	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public List<HoaDonChiTiet> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}

	public void setDanhSachChiTiet(List<HoaDonChiTiet> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}

    
}