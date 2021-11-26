package schema;

public class MuonTra {
    private String maSach;
    private String ngayMuon;
    private String ngayTra;
    private int trangThai;

    public void muonSach(MuonTra muonTra, String ngayMuon) {
        muonTra.setNgayMuon(ngayMuon);
        muonTra.setTrangThai(0);
    }

    public void traSach(MuonTra muonTra, String ngayTra) {
        muonTra.setNgayTra(ngayTra);
        muonTra.setTrangThai(1);
    }

    public void lamMatSach(MuonTra muonTra) {
        muonTra.setTrangThai(2);
    }

    public int getTrangThai() {
        return trangThai;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}