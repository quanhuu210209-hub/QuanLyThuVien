package Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PhieuPhat")
public class PhieuPhat {
    @Id
    @Column(name = "MaPhieuPhat", length = 20)
    private String maPhieuPhat;

    @Column(name = "LyDoPhat", length = 250)
    private String lyDoPhat;

    @Column(name = "SoTienPhat", precision = 18, scale = 2)
    private BigDecimal soTienPhat;

    @Column(name = "TrangThaiThanhToan", length = 50)
    private String trangThaiThanhToan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "MaCuonSach", referencedColumnName = "MaCuonSach"),
        @JoinColumn(name = "MaSach", referencedColumnName = "MaSach"),
        @JoinColumn(name = "SoPhieu", referencedColumnName = "SoPhieu")
    })
    private ChiTietPhieuMuon chiTietPhieuMuon;

    public PhieuPhat() {}

	public String getMaPhieuPhat() {
		return maPhieuPhat;
	}

	public void setMaPhieuPhat(String maPhieuPhat) {
		this.maPhieuPhat = maPhieuPhat;
	}

	public String getLyDoPhat() {
		return lyDoPhat;
	}

	public void setLyDoPhat(String lyDoPhat) {
		this.lyDoPhat = lyDoPhat;
	}

	public BigDecimal getSoTienPhat() {
		return soTienPhat;
	}

	public void setSoTienPhat(BigDecimal soTienPhat) {
		this.soTienPhat = soTienPhat;
	}

	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public ChiTietPhieuMuon getChiTietPhieuMuon() {
		return chiTietPhieuMuon;
	}

	public void setChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) {
		this.chiTietPhieuMuon = chiTietPhieuMuon;
	}

	public PhieuPhat(String maPhieuPhat, String lyDoPhat, BigDecimal soTienPhat, String trangThaiThanhToan,
			ChiTietPhieuMuon chiTietPhieuMuon) {
		super();
		this.maPhieuPhat = maPhieuPhat;
		this.lyDoPhat = lyDoPhat;
		this.soTienPhat = soTienPhat;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.chiTietPhieuMuon = chiTietPhieuMuon;
	}
}