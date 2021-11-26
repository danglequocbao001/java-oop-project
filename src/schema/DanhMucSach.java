package schema;

public class DanhMucSach {
    private String maSach;
    private int trangThai;
    private String viTri;

    public void themSachVaoDauSach(String maSach, int trangThai, String viTri) {
        this.setMaSach(maSach);
        this.setTrangThai(trangThai);
        this.setViTri(viTri);
    }

    public void xoaSachTrongDauSach(DanhMucSach danhMucSach) {
        danhMucSach = new DanhMucSach();
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}