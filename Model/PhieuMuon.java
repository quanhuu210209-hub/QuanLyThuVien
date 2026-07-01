package Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PhieuMuon")
public class PhieuMuon {
    @Id
    @Column(name = "SoPhieu", length = 20)
    private String soPhieu;

    @Column(name = "NgayMuon")
    private LocalDate ngayMuon;

    @Column(name = "NgayHetHan")
    private LocalDate ngayHetHan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV")
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDG")
    private DocGia docGia;

    public PhieuMuon() {}

	public String getSoPhieu() {
		return soPhieu;
	}

	public void setSoPhieu(String soPhieu) {
		this.soPhieu = soPhieu;
	}

	public LocalDate getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(LocalDate ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public DocGia getDocGia() {
		return docGia;
	}

	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}

	public PhieuMuon(String soPhieu, LocalDate ngayMuon, LocalDate ngayHetHan, NhanVien nhanVien, DocGia docGia) {
		super();
		this.soPhieu = soPhieu;
		this.ngayMuon = ngayMuon;
		this.ngayHetHan = ngayHetHan;
		this.nhanVien = nhanVien;
		this.docGia = docGia;
	}
}