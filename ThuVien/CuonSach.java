package ThuVien;

import jakarta.persistence.*;

@Entity
@Table(name = "CuonSach")
public class CuonSach {

    @EmbeddedId
    private CuonSachId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maSach")
    @JoinColumn(name = "MaSach")
    private Sach sach;

    @Column(name = "TinhTrang", length = 100)
    private String tinhTrang;

    @Column(name = "TrangThai", length = 100)
    private String trangThai;

    public CuonSach() {}

	public CuonSachId getId() {
		return id;
	}

	public void setId(CuonSachId id) {
		this.id = id;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public CuonSach(CuonSachId id, Sach sach, String tinhTrang, String trangThai) {
		super();
		this.id = id;
		this.sach = sach;
		this.tinhTrang = tinhTrang;
		this.trangThai = trangThai;
	} 
}