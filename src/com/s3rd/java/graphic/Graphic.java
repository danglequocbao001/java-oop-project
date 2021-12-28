package com.s3rd.java.graphic;

import javax.swing.*;

import com.s3rd.java.config.GlobalVariable;
import com.s3rd.java.function.Function;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;

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
        mainFrame.setSize(width, height);
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
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void run() {
        mainFrame.setVisible(false);
        prepareGUI();
        JButton buttonLRun = new JButton();
        GraphicFunctions.setButton(buttonLRun, contentPane, "CHẠY CHƯƠNG TRÌNH", 830, 400, 300, 150);

        buttonLRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    public void login() {
        mainFrame.setVisible(false);
        prepareGUI();
        Font bigBold = new Font("SansSerif", Font.BOLD, 35);
        JLabel quanLyThuVien = new JLabel();
        JLabel hoTen = new JLabel();
        JLabel MSSV = new JLabel();
        JLabel lop = new JLabel();
        JLabel taiKhoan = new JLabel();
        JLabel matKhau = new JLabel();
        JTextField nhapTaiKhoan = new JTextField();
        JPasswordField nhapMatKhau = new JPasswordField();
        JButton buttonLogin = new JButton();
        JButton buttonExit = new JButton();

        GraphicFunctions.setLabel(quanLyThuVien, contentPane, GlobalVariable.MAIN_TITLE, 750, 100, 600, 50);
        quanLyThuVien.setFont(bigBold);
        GraphicFunctions.setLabel(hoTen, contentPane, "Họ tên: Đặng Lê Quốc Bảo - Nguyễn Ngọc Thanh Danh", 780, 180,
                550,
                50);
        GraphicFunctions.setLabel(MSSV, contentPane, "MSSV: N19DCCN014 - N19DCCN027", 850, 210, 300, 50);
        GraphicFunctions.setLabel(lop, contentPane, "Lớp: D19CQCN02-N - D19CQCN02-N", 845, 240, 300, 50);
        GraphicFunctions.setLabel(taiKhoan, contentPane, "TÀI KHOẢN", 845, 350, 300, 50);
        GraphicFunctions.setLabel(matKhau, contentPane, "MẬT KHẨU", 845, 430, 300, 50);
        GraphicFunctions.setTextField(nhapTaiKhoan, contentPane, 950, 365, 150, 20);
        GraphicFunctions.setPasswordField(nhapMatKhau, contentPane, 950, 445, 150, 20);
        GraphicFunctions.setButton(buttonExit, contentPane, GlobalVariable.QUIT, 815, 530, 150, 40);
        GraphicFunctions.setButton(buttonLogin, contentPane, "ĐĂNG NHẬP", 975, 530, 150, 40);

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = new String(nhapMatKhau.getPassword());
                if (nhapTaiKhoan.getText().equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(buttonLogin, GlobalVariable.NOT_BLANK);
                } else if (nhapTaiKhoan.getText().equals("admin") && password.equals("admin")) {
                    mainMenu();
                } else {
                    JOptionPane.showMessageDialog(buttonLogin, GlobalVariable.NOT_CORRECT_ACCOUNT);
                }
            }
        });
    }

    public void mainMenu() {
        mainFrame.setVisible(false);
        prepareGUI();
        Font bigBold = new Font("SansSerif", Font.BOLD, 35);
        JLabel quanLyThuVien = new JLabel();
        JLabel hoTen = new JLabel();
        JLabel MSSV = new JLabel();
        JLabel lop = new JLabel();
        JButton docGia = new JButton();
        JButton danhMucSach = new JButton();
        JButton muonTraSach = new JButton();
        JButton logout = new JButton();
        JButton exit = new JButton();

        GraphicFunctions.setLabel(quanLyThuVien, contentPane, "QUẢN LÝ THƯ VIỆN SÁCH", 750, 100, 600, 50);
        quanLyThuVien.setFont(bigBold);
        GraphicFunctions.setLabel(hoTen, contentPane, "Họ tên: Đặng Lê Quốc Bảo - Nguyễn Ngọc Thanh Danh", 780, 180,
                550,
                50);
        GraphicFunctions.setLabel(MSSV, contentPane, "MSSV: N19DCCN014 - N19DCCN027", 850, 210, 300, 50);
        GraphicFunctions.setLabel(lop, contentPane, "Lớp: D19CQCN02-N - D19CQCN02-N", 845, 240, 300, 50);

        GraphicFunctions.setButton(docGia, contentPane, "ĐỘC GIẢ", 855, 320, 240, 70);
        GraphicFunctions.setButton(danhMucSach, contentPane, "DANH MỤC SÁCH", 855, 420, 240, 70);
        GraphicFunctions.setButton(muonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 855, 520, 240, 70);
        GraphicFunctions.setButton(logout, contentPane, "ĐĂNG XUẤT", 700, 660, 240, 70);
        GraphicFunctions.setButton(exit, contentPane, GlobalVariable.QUIT, 1000, 660, 240, 70);

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
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
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
        JLabel trangThai = new JLabel();
        JTextField nhapMaThe = new JTextField();
        JTextField nhapHo = new JTextField();
        JTextField nhapTen = new JTextField();
        JTextField nhapGioiTinh = new JTextField();
        JRadioButton khoa = new JRadioButton();
        JRadioButton hoatDong = new JRadioButton();
        JRadioButton nam = new JRadioButton();
        JRadioButton nu = new JRadioButton();
        JRadioButton khac = new JRadioButton();
        ButtonGroup Status = new ButtonGroup();
        Status.add(khoa);
        Status.add(hoatDong);
        ButtonGroup Gender = new ButtonGroup();
        Gender.add(nam);
        Gender.add(nu);
        Gender.add(khac);
        JButton buttonThemDocGia = new JButton();
        JButton buttonSuaDocGia = new JButton();
        GraphicFunctions.setLabel(themDocGia, contentPane, "THÊM/SỬA ĐỘC GIẢ", 440, 170, 150, 20);
        GraphicFunctions.setLabel(maThe, contentPane, "Mã thẻ", 370, 230, 120, 20);
        GraphicFunctions.setLabel(ho, contentPane, "Họ", 370, 270, 120, 20);
        GraphicFunctions.setLabel(ten, contentPane, "Tên", 370, 310, 120, 20);
        GraphicFunctions.setLabel(gioiTinh, contentPane, "Giới tính", 370, 350, 120, 20);
        GraphicFunctions.setLabel(trangThai, contentPane, "Trạng thái", 370, 390, 120, 20);
        GraphicFunctions.setTextField(nhapMaThe, contentPane, 450, 230, 150, 20);
        GraphicFunctions.setTextField(nhapHo, contentPane, 450, 270, 150, 20);
        GraphicFunctions.setTextField(nhapTen, contentPane, 450, 310, 150, 20);
        GraphicFunctions.setTextField(nhapGioiTinh, contentPane, 450, 350, 150, 20);
        GraphicFunctions.setRadioButton(hoatDong, contentPane, "Hoạt động", 460, 390, 170, 30);
        GraphicFunctions.setRadioButton(khoa, contentPane, "Khóa", 460, 420, 170, 30);
        GraphicFunctions.setButton(buttonThemDocGia, contentPane, "THÊM ĐỘC GIẢ", 350, 460, 150, 40);
        GraphicFunctions.setButton(buttonSuaDocGia, contentPane, "SỬA ĐỘC GIẢ", 520, 460, 150, 40);
        buttonThemDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Function.themDocGia(buttonThemDocGia, nhapMaThe.getText(),
                        nhapHo.getText(), nhapTen.getText(),
                        nhapGioiTinh.getText());
            }
        });

        JLabel khoaXoaDocGia = new JLabel();
        JLabel maTheXoa = new JLabel();
        JTextField nhapMaTheDeXoa = new JTextField();
        JButton buttonKhoaDocGia = new JButton();
        JButton buttonXoaDocGia = new JButton();
        GraphicFunctions.setLabel(khoaXoaDocGia, contentPane, "KHÓA/XÓA ĐỘC GIẢ", 440, 560, 150, 20);
        GraphicFunctions.setLabel(maTheXoa, contentPane, "Mã thẻ", 370, 610, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheDeXoa, contentPane, 450, 610, 150, 20);
        GraphicFunctions.setButton(buttonKhoaDocGia, contentPane, "KHÓA ĐỘC GIẢ", 350, 660, 150, 40);
        GraphicFunctions.setButton(buttonXoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 520, 660, 150, 40);

        JTable tableDocGia = new JTable();
        String firstRow[] = { "MÃ THẺ", "HỌ", "TÊN", "GIỚI TÍNH", "TRẠNG THÁI" };
        String data[][] = {
                { "1", "Dang", "Bao", "Nam", "Hoạt động" },
                { "2", "Dangg", "Bao0", "Nam", "Hoạt động" },
                { "3", "Nguyen", "Danh", "Nam", "Khóa" } };
        tableDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int rowDocGia = tableDocGia.rowAtPoint(evt.getPoint());
                nhapMaThe.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 0));
                nhapHo.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 1));
                nhapTen.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 2));
                nhapGioiTinh.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 3));
                if (((String) tableDocGia.getModel().getValueAt(rowDocGia, 4)).equals("Hoạt động")) {
                    hoatDong.setSelected(true);
                    khoa.setSelected(false);

                } else {
                    hoatDong.setSelected(false);
                    khoa.setSelected(true);
                }
                nhapMaTheDeXoa.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 0));
            }
        });

        GraphicFunctions.setTable(tableDocGia, contentPane, firstRow, data);
        JScrollPane scrollPane = new JScrollPane(tableDocGia);
        scrollPane.setBounds(800, 100, 900, 800);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, GlobalVariable.GO_BACK, 350, 840, 230, 60);
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
        JButton buttonSuaSach = new JButton();
        GraphicFunctions.setLabel(themSach, contentPane, "THÊM/SỬA SÁCH", 440, 170, 150, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 370, 230, 120, 20);
        GraphicFunctions.setLabel(tenSach, contentPane, "Tên sách", 370, 270, 120, 20);
        GraphicFunctions.setLabel(viTri, contentPane, "Vị trí", 370, 310, 120, 20);
        GraphicFunctions.setTextField(nhapMaSach, contentPane, 450, 230, 150, 20);
        GraphicFunctions.setTextField(nhapTenSach, contentPane, 450, 270, 150, 20);
        GraphicFunctions.setTextField(nhapViTri, contentPane, 450, 310, 150, 20);
        GraphicFunctions.setButton(buttonThemSach, contentPane, "THÊM SÁCH", 350, 360, 150, 40);
        GraphicFunctions.setButton(buttonSuaSach, contentPane, "SỬA SÁCH", 520, 360, 150, 40);

        JLabel khoaXoaSach = new JLabel();
        JLabel maTheSachXoa = new JLabel();
        JTextField nhapMaTheSachDeXoa = new JTextField();
        JButton buttonKhoaSach = new JButton();
        JButton buttonXoaSach = new JButton();
        GraphicFunctions.setLabel(khoaXoaSach, contentPane, "KHÓA/XÓA SÁCH", 440, 500, 150, 20);
        GraphicFunctions.setLabel(maTheSachXoa, contentPane, "Mã sách", 370, 550, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheSachDeXoa, contentPane, 450, 550, 150, 20);
        GraphicFunctions.setButton(buttonKhoaSach, contentPane, "KHÓA SÁCH", 350, 600, 150, 40);
        GraphicFunctions.setButton(buttonXoaSach, contentPane, "XÓA SÁCH", 520, 600, 150, 40);

        JTable table = new JTable();
        String column[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ", "TRẠNG THÁI" };
        String data[][] = {
                { "1", "OOP with JAVA", "Kệ 1 ngăn 1", "Cho mượn được" },
                { "2", "Python program language", "Kệ 1 ngăn 2", "Cho mượn được" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(800, 100, 900, 800);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, GlobalVariable.GO_BACK, 350, 840, 230, 60);
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
        JButton buttonMatSach = new JButton();
        GraphicFunctions.setLabel(muonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 440, 170, 150, 20);
        GraphicFunctions.setLabel(maDocGia, contentPane, "Mã độc giả", 370, 240, 120, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 370, 280, 120, 20);
        GraphicFunctions.setTextField(nhapMaSach, contentPane, 470, 240, 150, 20);
        GraphicFunctions.setTextField(nhapMaDocGia, contentPane, 470, 280, 150, 20);
        GraphicFunctions.setButton(buttonMuonSach, contentPane, "MƯỢN SÁCH", 350, 360, 150, 40);
        GraphicFunctions.setButton(buttonTraSach, contentPane, "TRẢ SÁCH", 520, 360, 150, 40);
        GraphicFunctions.setButton(buttonMatSach, contentPane, "LÀM MẤT SÁCH", 440, 430, 150, 40);

        JTable table = new JTable();
        String column[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ", "NGƯỜI MƯỢN" };
        String data[][] = {
                { "1", "OOP with JAVA", "Kệ 1 ngăn 1", "Dang Bao" },
                { "2", "Python program language", "Kệ 1 ngăn 2", "Dang Baoo" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(800, 100, 900, 800);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, GlobalVariable.GO_BACK, 350, 840, 230, 60);
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
