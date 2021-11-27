package schema;

public class DanhMucSach {
    private String maSach;
    private String tenSach;
    private String viTri;
    private int trangThai;

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

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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