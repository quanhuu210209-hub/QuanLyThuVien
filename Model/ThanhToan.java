package Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ThanhToan")
public class ThanhToan {
    @Id
    @Column(name = "MaThanhToan", length = 20)
    private String maThanhToan;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "SoTienNop", precision = 18, scale = 2)
    private BigDecimal soTienNop;

    @Column(name = "PhuongThucThanhToan", length = 50)
    private String phuongThucThanhToan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhieuPhat")
    private PhieuPhat phieuPhat;

    public ThanhToan() {}

	public String getMaThanhToan() {
		return maThanhToan;
	}

	public void setMaThanhToan(String maThanhToan) {
		this.maThanhToan = maThanhToan;
	}

	public LocalDate getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(LocalDate ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public BigDecimal getSoTienNop() {
		return soTienNop;
	}

	public void setSoTienNop(BigDecimal soTienNop) {
		this.soTienNop = soTienNop;
	}

	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}

	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public PhieuPhat getPhieuPhat() {
		return phieuPhat;
	}

	public void setPhieuPhat(PhieuPhat phieuPhat) {
		this.phieuPhat = phieuPhat;
	}

	public ThanhToan(String maThanhToan, LocalDate ngayThanhToan, BigDecimal soTienNop, String phuongThucThanhToan,
			PhieuPhat phieuPhat) {
		super();
		this.maThanhToan = maThanhToan;
		this.ngayThanhToan = ngayThanhToan;
		this.soTienNop = soTienNop;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.phieuPhat = phieuPhat;
	}
}