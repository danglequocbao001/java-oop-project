package schema;

public class DocGia {
    private String maThe;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String trangThai;

    public void themDocGia(String maThe, String ho, String ten, String gioiTinh) {
        this.setMaThe(maThe);
        this.setHo(ho);
        this.setTen(ten);
        this.setGioiTinh(gioiTinh);
    }

    public void xoaDocGia(DocGia docGia) {
        docGia = new DocGia();
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
