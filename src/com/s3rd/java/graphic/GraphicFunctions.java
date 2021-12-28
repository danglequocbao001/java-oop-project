package com.s3rd.java.graphic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class GraphicFunctions {
    public static void setLabel(JLabel label, JPanel contentPane, String text, int x, int y, int width, int height) {
        Font bigBold = new Font("SansSerif", Font.BOLD, 15);
        label.setText(text);
        label.setBounds(x, y, width, height);
        label.setFont(bigBold);
        contentPane.add(label);
    }

    public static void setButton(JButton button, JPanel contentPane, String text, int x, int y, int width, int height) {
        button.setText(text);
        button.setBounds(x, y, width, height);
        contentPane.add(button);
    }

    public static void setTextField(JTextField textField, JPanel contentPage, int x, int y, int width,
            int height) {
        textField.setBounds(x, y, width, height);
        contentPage.add(textField);
    }

    public static void setTable(JTable table, JPanel contentPane, String column[], String data[][]) {
        Font bigBold = new Font("SansSerif", Font.PLAIN, 15);
        table.setModel(new DefaultTableModel(data, column));
        table.setFont(bigBold);
        contentPane.add(table);
    }

    public static void setPasswordField(JPasswordField passwordField, JPanel contentPage, int x, int y, int width,
            int height) {
        passwordField.setBounds(x, y, width, height);
        contentPage.add(passwordField);
    }

    public static void setRadioButton(JRadioButton radioButton, JPanel contentPane, String text, int x, int y,
            int width,
            int height) {
        radioButton.setText(text);
        radioButton.setBounds(x, y - 5, width, height);
        contentPane.add(radioButton);
    }
}