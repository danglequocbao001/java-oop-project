package function;

import javax.swing.*;
import schema.DocGia;

public class Function {
    public static DocGia themDocGia(JButton button, String maThe, String ho, String ten,
            String gioiTinh) {
        DocGia docGia = new DocGia();
        if (maThe.equals("") || ho.equals("") || ten.equals("") || gioiTinh.equals("")) {
            JOptionPane.showMessageDialog(button, "Không được bỏ trống trường nhập liệu!");
        } else {
            docGia.themDocGia(maThe, ho, ten, gioiTinh);
        }
        System.out.println(docGia);
        return docGia;
    }
}