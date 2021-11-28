package function;

import javax.swing.*;
import graphic.Graphic;
import schema.DocGia;

public class Function {
    public static DocGia themDocGia(JFrame frame, JPanel contentPane, String maThe, String ho, String ten,
            String gioiTinh) {
        DocGia docGia = new DocGia();
        if (maThe.equals("") || ho.equals("") || ten.equals("") || gioiTinh.equals("")) {
            Graphic.notification("Không được bỏ trống trường nhập liệu!", frame, contentPane);
        } else {
            docGia.themDocGia(maThe, ho, ten, gioiTinh);
        }
        return docGia;
    }

}