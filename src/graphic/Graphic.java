package graphic;

import javax.swing.*;

import function.Function;

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

        GraphicFunctions.setLabel(quanLyThuVien, contentPane, "QUẢN LÝ THƯ VIỆN SÁCH", 750, 100, 600, 50);
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
        GraphicFunctions.setButton(buttonExit, contentPane, "THOÁT", 815, 530, 150, 40);
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
                    JOptionPane.showMessageDialog(buttonLogin, "Không được bỏ trống trường nhập liệu!");
                } else if (nhapTaiKhoan.getText().equals("admin") && password.equals("admin")) {
                    mainMenu();
                } else {
                    JOptionPane.showMessageDialog(buttonLogin, "Tài khoản hoặc mật khẩu không chính xác!");
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
        GraphicFunctions.setButton(exit, contentPane, "THOÁT", 1000, 660, 240, 70);

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
        JTextField nhapMaThe = new JTextField();
        JTextField nhapHo = new JTextField();
        JTextField nhapTen = new JTextField();
        JTextField nhapGioiTinh = new JTextField();
        JButton buttonThemDocGia = new JButton();
        JButton buttonSuaDocGia = new JButton();
        GraphicFunctions.setLabel(themDocGia, contentPane, "THÊM/SỬA ĐỘC GIẢ", 440, 170, 150, 20);
        GraphicFunctions.setLabel(maThe, contentPane, "Mã thẻ", 370, 230, 120, 20);
        GraphicFunctions.setLabel(ho, contentPane, "Họ", 370, 270, 120, 20);
        GraphicFunctions.setLabel(ten, contentPane, "Tên", 370, 310, 120, 20);
        GraphicFunctions.setLabel(gioiTinh, contentPane, "Giới tính", 370, 350, 120, 20);
        GraphicFunctions.setTextField(nhapMaThe, contentPane, 450, 230, 150, 20);
        GraphicFunctions.setTextField(nhapHo, contentPane, 450, 270, 150, 20);
        GraphicFunctions.setTextField(nhapTen, contentPane, 450, 310, 150, 20);
        GraphicFunctions.setTextField(nhapGioiTinh, contentPane, 450, 350, 150, 20);
        GraphicFunctions.setButton(buttonThemDocGia, contentPane, "THÊM ĐỘC GIẢ", 350, 400, 150, 40);
        GraphicFunctions.setButton(buttonSuaDocGia, contentPane, "SỬA ĐỘC GIẢ", 520, 400, 150, 40);
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
        GraphicFunctions.setLabel(khoaXoaDocGia, contentPane, "KHÓA/XÓA ĐỘC GIẢ", 440, 500, 150, 20);
        GraphicFunctions.setLabel(maTheXoa, contentPane, "Mã thẻ", 370, 550, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheDeXoa, contentPane, 450, 550, 150, 20);
        GraphicFunctions.setButton(buttonKhoaDocGia, contentPane, "KHÓA ĐỘC GIẢ", 350, 600, 150, 40);
        GraphicFunctions.setButton(buttonXoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 520, 600, 150, 40);

        JTable table = new JTable();
        String column[] = { "MÃ THẺ", "HỌ", "TÊN", "GIỚI TÍNH", "TRẠNG THÁI" };
        String data[][] = {
                { "1", "Dang", "Bao", "Nam", "Đang hoạt động" },
                { "2", "Dangg", "Bao0", "Nam", "Đang hoạt động" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(800, 100, 900, 800);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 350, 840, 230, 60);
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
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 350, 840, 230, 60);
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
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 350, 840, 230, 60);
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
