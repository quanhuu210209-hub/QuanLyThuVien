package ThuVien;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Sach")
public class Sach {
    @Id
    @Column(name = "MaSach", length = 20)
    private String maSach;

    @Column(name = "TenSach", nullable = false, length = 250)
    private String tenSach;

    @Column(name = "DonGia", precision = 18, scale = 2)
    private BigDecimal donGia;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTheLoai")
    private TheLoai theLoai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNgonNgu")
    private NgonNgu ngonNgu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNXB")
    private NhaXuatBan nhaXuatBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTG")
    private TacGia tacGia;

    public Sach() {}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public BigDecimal getDonGia() {
		return donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public NgonNgu getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(NgonNgu ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public Sach(String maSach, String tenSach, BigDecimal donGia, Integer soLuong, TheLoai theLoai, NgonNgu ngonNgu,
			NhaXuatBan nhaXuatBan, TacGia tacGia) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNgu = ngonNgu;
		this.nhaXuatBan = nhaXuatBan;
		this.tacGia = tacGia;
	}
}