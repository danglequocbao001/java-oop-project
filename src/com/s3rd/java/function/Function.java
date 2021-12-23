package com.s3rd.java.function;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.s3rd.java.config.GlobalVariable;
import com.s3rd.java.schema.DocGia;

public class Function {
    public static DocGia themDocGia(JButton button, String maThe, String ho, String ten,
            String gioiTinh) {
        DocGia docGia = new DocGia();
        if (maThe.equals("") || ho.equals("") || ten.equals("") || gioiTinh.equals("")) {
            JOptionPane.showMessageDialog(button, GlobalVariable.NOT_BLANK);
        } else {
            docGia.themDocGia(maThe, ho, ten, gioiTinh);
        }
        System.out.println(docGia);
        return docGia;
    }
}