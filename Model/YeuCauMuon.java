package Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "YeuCauMuon")
public class YeuCauMuon {

    @Id
    @Column(name = "MaYeuCau", length = 20)
    private String maYeuCau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDG", nullable = false)
    private DocGia docGia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaSach", nullable = false)
    private Sach sach;

    @Column(name = "NgayGui", nullable = false)
    private LocalDate ngayGui;

    @Column(name = "TrangThai", length = 50, nullable = false)
    private String trangThai; // "Chờ duyệt", "Đã duyệt", "Từ chối", "Đã hủy"

    @Column(name = "GhiChu", length = 250)
    private String ghiChu;

    public YeuCauMuon() {}

    public YeuCauMuon(String maYeuCau, DocGia docGia, Sach sach,
                      LocalDate ngayGui, String trangThai, String ghiChu) {
        this.maYeuCau = maYeuCau;
        this.docGia = docGia;
        this.sach = sach;
        this.ngayGui = ngayGui;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getMaYeuCau() { return maYeuCau; }
    public void setMaYeuCau(String maYeuCau) { this.maYeuCau = maYeuCau; }

    public DocGia getDocGia() { return docGia; }
    public void setDocGia(DocGia docGia) { this.docGia = docGia; }

    public Sach getSach() { return sach; }
    public void setSach(Sach sach) { this.sach = sach; }

    public LocalDate getNgayGui() { return ngayGui; }
    public void setNgayGui(LocalDate ngayGui) { this.ngayGui = ngayGui; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}