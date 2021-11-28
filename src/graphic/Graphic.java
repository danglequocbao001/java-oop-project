package graphic;

import javax.swing.*;

import function.Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Graphic {
    private JFrame mainFrame;
    private JPanel contentPane;

    public Graphic() {
        prepareGUI();
    }

    public void prepareGUI() {
        mainFrame = new JFrame("Đồ án kết môn OOP với JAVA");
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        mainFrame.setSize(width / 2, height / 2);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        contentPane = new JPanel();
        contentPane.setLayout(null);
        mainFrame.add(contentPane);
        mainFrame.setVisible(true);
    }

    public static void notification(String string, JFrame frame, JPanel contentPane) {
        frame = new JFrame("Thông báo!");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width / 5, height / 7);
        frame.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        frame.add(contentPane);
        frame.setVisible(true);

        JLabel notification = new JLabel();
        JButton confirm = new JButton();
        GraphicFunctions.setLabel(notification, contentPane, "Thông báo: " + string,
                10, 0, 300, 50);
    }

    public void mainMenu() {
        mainFrame.setVisible(false);
        prepareGUI();
        JLabel hoTen = new JLabel();
        JLabel MSSV = new JLabel();
        JLabel lop = new JLabel();
        JButton docGia = new JButton();
        JButton danhMucSach = new JButton();
        JButton muonTraSach = new JButton();
        JButton quit = new JButton();

        GraphicFunctions.setLabel(hoTen, contentPane, "Họ tên: Đặng Lê Quốc Bảo - Nguyễn Hữu Phước", 315, 10, 300, 50);
        GraphicFunctions.setLabel(MSSV, contentPane, "MSSV: N19DCCN014 - N19DCCN145", 350, 40, 300, 50);
        GraphicFunctions.setLabel(lop, contentPane, "Lớp: D19CQCN02-N - D19CQCN03-N", 350, 70, 300, 50);

        GraphicFunctions.setButton(docGia, contentPane, "ĐỘC GIẢ", 350, 140, 200, 50);
        GraphicFunctions.setButton(danhMucSach, contentPane, "DANH MỤC SÁCH", 350, 220, 200, 50);
        GraphicFunctions.setButton(muonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 350, 300, 200, 50);
        GraphicFunctions.setButton(quit, contentPane, "THOÁT", 360, 400, 180, 40);

        docGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                docGia();
            }
        });
        danhMucSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                danhMucSach();
            }
        });
        muonTraSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                muonTraSach();
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                // notification("Hello", mainFrame, contentPane);
            }
        });

        mainFrame.setVisible(true);
    }

    public void docGia() {
        mainFrame.setVisible(false);
        prepareGUI();

        JLabel themDocGia = new JLabel();
        JLabel maThe = new JLabel();
        JLabel ho = new JLabel();
        JLabel ten = new JLabel();
        JLabel gioiTinh = new JLabel();
        JTextField nhapMaThe = new JTextField();
        JTextField nhapHo = new JTextField();
        JTextField nhapTen = new JTextField();
        JTextField nhapGioiTinh = new JTextField();
        JButton buttonThemDocGia = new JButton();
        GraphicFunctions.setLabel(themDocGia, contentPane, "THÊM ĐỘC GIẢ", 90, 20, 120, 20);
        GraphicFunctions.setLabel(maThe, contentPane, "Mã thẻ", 20, 60, 120, 20);
        GraphicFunctions.setLabel(ho, contentPane, "Họ", 20, 100, 120, 20);
        GraphicFunctions.setLabel(ten, contentPane, "Tên", 20, 140, 120, 20);
        GraphicFunctions.setLabel(gioiTinh, contentPane, "Giới tính", 20, 180, 120, 20);
        GraphicFunctions.setTextField(nhapMaThe, contentPane, 100, 60, 120, 20);
        GraphicFunctions.setTextField(nhapHo, contentPane, 100, 100, 120, 20);
        GraphicFunctions.setTextField(nhapTen, contentPane, 100, 140, 120, 20);
        GraphicFunctions.setTextField(nhapGioiTinh, contentPane, 100, 180, 120, 20);
        GraphicFunctions.setButton(buttonThemDocGia, contentPane, "THÊM ĐỘC GIẢ", 55, 220, 150, 30);
        buttonThemDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Function.themDocGia(mainFrame, contentPane, nhapMaThe.getText(),
                        nhapHo.getText(), nhapTen.getText(),
                        nhapGioiTinh.getText());
            }
        });

        JLabel xoaDocGia = new JLabel();
        JLabel maTheXoa = new JLabel();
        JTextField nhapMaTheDeXoa = new JTextField();
        JButton buttonXoaDocGia = new JButton();
        GraphicFunctions.setLabel(xoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 90, 280, 120, 20);
        GraphicFunctions.setLabel(maTheXoa, contentPane, "Mã thẻ", 20, 310, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheDeXoa, contentPane, 100, 310, 120, 20);
        GraphicFunctions.setButton(buttonXoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 55, 350, 150, 30);

        JTable table = new JTable();
        String column[] = { "MÃ THẺ", "HỌ", "TÊN", "GIỚI TÍNH", "TRẠNG THÁI" };
        String data[][] = {
                { "1", "Dang", "Bao", "Nam", "Đang hoạt động" },
                { "2", "Dangg", "Bao0", "Nam", "Đang hoạt động" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(320, 20, 600, 460);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 20, 430, 200, 50);
        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });
    }

    public void danhMucSach() {
        mainFrame.setVisible(false);
        prepareGUI();

        JLabel themSach = new JLabel();
        JLabel maSach = new JLabel();
        JLabel tenSach = new JLabel();
        JLabel viTri = new JLabel();
        JTextField nhapMaSach = new JTextField();
        JTextField nhapTenSach = new JTextField();
        JTextField nhapViTri = new JTextField();
        JButton buttonThemSach = new JButton();
        GraphicFunctions.setLabel(themSach, contentPane, "THÊM SÁCH", 90, 20, 120, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 20, 60, 120, 20);
        GraphicFunctions.setLabel(tenSach, contentPane, "Tên sách", 20, 100, 120, 20);
        GraphicFunctions.setLabel(viTri, contentPane, "Vị trí", 20, 140, 120, 20);
        GraphicFunctions.setTextField(nhapMaSach, contentPane, 100, 60, 120, 20);
        GraphicFunctions.setTextField(nhapTenSach, contentPane, 100, 100, 120, 20);
        GraphicFunctions.setTextField(nhapViTri, contentPane, 100, 140, 120, 20);
        GraphicFunctions.setButton(buttonThemSach, contentPane, "THÊM SÁCH", 55, 180, 150, 30);

        JLabel xoaSach = new JLabel();
        JLabel maTheSachXoa = new JLabel();
        JTextField nhapMaTheSachDeXoa = new JTextField();
        JButton buttonXoaSach = new JButton();
        GraphicFunctions.setLabel(xoaSach, contentPane, "XÓA SÁCH", 90, 250, 120, 20);
        GraphicFunctions.setLabel(maTheSachXoa, contentPane, "Mã sách", 20, 290, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheSachDeXoa, contentPane, 100, 290, 120, 20);
        GraphicFunctions.setButton(buttonXoaSach, contentPane, "XÓA SÁCH", 55, 330, 150, 30);

        JTable table = new JTable();
        String column[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ", "TRẠNG THÁI" };
        String data[][] = {
                { "1", "OOP with JAVA", "Kệ 1 ngăn 1", "Cho mượn được" },
                { "2", "Python program language", "Kệ 1 ngăn 2", "Cho mượn được" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(320, 20, 600, 460);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 20, 430, 200, 50);
        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });
    }

    public void muonTraSach() {
        mainFrame.setVisible(false);
        prepareGUI();

        JLabel muonTraSach = new JLabel();
        JLabel maDocGia = new JLabel();
        JLabel maSach = new JLabel();
        JTextField nhapMaDocGia = new JTextField();
        JTextField nhapMaSach = new JTextField();
        JButton buttonMuonSach = new JButton();
        JButton buttonTraSach = new JButton();
        GraphicFunctions.setLabel(muonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 90, 40, 120, 20);
        GraphicFunctions.setLabel(maDocGia, contentPane, "Mã độc giả", 20, 100, 120, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 20, 150, 120, 20);
        GraphicFunctions.setTextField(nhapMaSach, contentPane, 100, 100, 120, 20);
        GraphicFunctions.setTextField(nhapMaDocGia, contentPane, 100, 150, 120, 20);
        GraphicFunctions.setButton(buttonMuonSach, contentPane, "MƯỢN SÁCH", 20, 210, 120, 30);
        GraphicFunctions.setButton(buttonTraSach, contentPane, "TRẢ SÁCH", 170, 210, 120, 30);

        JTable table = new JTable();
        String column[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ", "NGƯỜI MƯỢN" };
        String data[][] = {
                { "1", "OOP with JAVA", "Kệ 1 ngăn 1", "Dang Bao" },
                { "2", "Python program language", "Kệ 1 ngăn 2", "Dang Baoo" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(320, 20, 600, 460);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 20, 430, 200, 50);
        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });
    }

    public static void main(String[] args) {
        Graphic Program = new Graphic();
        Program.mainMenu();
    }
}
