package ThuVien;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ChiTietPhieuMuon")
public class ChiTietPhieuMuon {

    @EmbeddedId
    private ChiTietPhieuMuonId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "soPhieu")
    @JoinColumn(name = "SoPhieu")
    private PhieuMuon phieuMuon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "MaSach", referencedColumnName = "MaSach", insertable = false, updatable = false),
        @JoinColumn(name = "MaCuonSach", referencedColumnName = "MaCuonSach", insertable = false, updatable = false)
    })
    private CuonSach cuonSach;

    @Column(name = "NgayTra")
    private LocalDate ngayTra;

    public ChiTietPhieuMuon() {}

	public ChiTietPhieuMuonId getId() {
		return id;
	}

	public void setId(ChiTietPhieuMuonId id) {
		this.id = id;
	}

	public PhieuMuon getPhieuMuon() {
		return phieuMuon;
	}

	public void setPhieuMuon(PhieuMuon phieuMuon) {
		this.phieuMuon = phieuMuon;
	}

	public CuonSach getCuonSach() {
		return cuonSach;
	}

	public void setCuonSach(CuonSach cuonSach) {
		this.cuonSach = cuonSach;
	}

	public LocalDate getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(LocalDate ngayTra) {
		this.ngayTra = ngayTra;
	}

	public ChiTietPhieuMuon(ChiTietPhieuMuonId id, PhieuMuon phieuMuon, CuonSach cuonSach, LocalDate ngayTra) {
		super();
		this.id = id;
		this.phieuMuon = phieuMuon;
		this.cuonSach = cuonSach;
		this.ngayTra = ngayTra;
	}

}