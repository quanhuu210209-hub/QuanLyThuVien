package Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {

    @EmbeddedId
    private HoaDonChiTietId id;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "DonGia", precision = 18, scale = 2, nullable = false)
    private BigDecimal donGia;

    // ThanhTien là cột thuộc tính tự tính toán ở SQL Server, ở đây set ở chế độ chỉ đọc (Read-only)
    @Column(name = "ThanhTien", precision = 18, scale = 2, insertable = false, updatable = false)
    private BigDecimal thanhTien;

    @ManyToOne
    @MapsId("maHoaDon") 
    @JoinColumn(name = "MaHoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("maSach") 
    @JoinColumn(name = "MaSach")
    private Sach sach;

    public HoaDonChiTiet() {}

	public HoaDonChiTiet(HoaDonChiTietId id, Integer soLuong, BigDecimal donGia, BigDecimal thanhTien, HoaDon hoaDon,
			Sach sach) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.hoaDon = hoaDon;
		this.sach = sach;
	}

	public HoaDonChiTietId getId() {
		return id;
	}

	public void setId(HoaDonChiTietId id) {
		this.id = id;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public BigDecimal getDonGia() {
		return donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public BigDecimal getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(BigDecimal thanhTien) {
		this.thanhTien = thanhTien;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

    
}