package graphic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GraphicFunctions {
    public static void setLabel(JLabel label, JPanel contentPane, String text, int x, int y, int width, int height) {
        label.setText(text);
        label.setBounds(x, y, width, height);
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
        textField.setColumns(10);
        contentPage.add(textField);
    }

    public static void setTable(JTable table, JPanel contentPane, String column[], String data[][]) {
        table.setModel(new DefaultTableModel(data, column));
        contentPane.add(table);
    }
}