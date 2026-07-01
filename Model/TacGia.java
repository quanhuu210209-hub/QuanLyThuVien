package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "TacGia")
public class TacGia {
    @Id
    @Column(name = "MaTG", length = 20)
    private String maTG;

    @Column(name = "TenTG", nullable = false, length = 100)
    private String tenTG;

    public TacGia() {}

    public String getMaTG() { return maTG; }
    public void setMaTG(String maTG) { this.maTG = maTG; }
    public String getTenTG() { return tenTG; }
    public void setTenTG(String tenTG) { this.tenTG = tenTG; }
}