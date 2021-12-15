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

        GraphicFunctions.setLabel(hoTen, contentPane, "Họ tên: Đặng Lê Quốc Bảo - Nguyễn Ngọc Thanh Danh", 795, 160,
                350,
                50);
        GraphicFunctions.setLabel(MSSV, contentPane, "MSSV: N19DCCN014 - N19DCCN027", 850, 190, 300, 50);
        GraphicFunctions.setLabel(lop, contentPane, "Lớp: D19CQCN02-N - D19CQCN02-N", 850, 220, 300, 50);

        GraphicFunctions.setButton(docGia, contentPane, "ĐỘC GIẢ", 850, 290, 200, 50);
        GraphicFunctions.setButton(danhMucSach, contentPane, "DANH MỤC SÁCH", 850, 370, 200, 50);
        GraphicFunctions.setButton(muonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 850, 450, 200, 50);
        GraphicFunctions.setButton(quit, contentPane, "THOÁT", 860, 550, 180, 40);

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
        JButton buttonSuaDocGia = new JButton();
        GraphicFunctions.setLabel(themDocGia, contentPane, "THÊM/SỬA ĐỘC GIẢ", 590, 170, 120, 20);
        GraphicFunctions.setLabel(maThe, contentPane, "Mã thẻ", 520, 210, 120, 20);
        GraphicFunctions.setLabel(ho, contentPane, "Họ", 520, 250, 120, 20);
        GraphicFunctions.setLabel(ten, contentPane, "Tên", 520, 290, 120, 20);
        GraphicFunctions.setLabel(gioiTinh, contentPane, "Giới tính", 520, 330, 120, 20);
        GraphicFunctions.setTextField(nhapMaThe, contentPane, 600, 210, 120, 20);
        GraphicFunctions.setTextField(nhapHo, contentPane, 600, 250, 120, 20);
        GraphicFunctions.setTextField(nhapTen, contentPane, 600, 290, 120, 20);
        GraphicFunctions.setTextField(nhapGioiTinh, contentPane, 600, 330, 120, 20);
        GraphicFunctions.setButton(buttonThemDocGia, contentPane, "THÊM ĐỘC GIẢ", 520, 370, 120, 30);
        GraphicFunctions.setButton(buttonSuaDocGia, contentPane, "SỬA ĐỘC GIẢ", 650, 370, 120, 30);
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
        GraphicFunctions.setLabel(khoaXoaDocGia, contentPane, "KHÓA/XÓA ĐỘC GIẢ", 590, 430, 120, 20);
        GraphicFunctions.setLabel(maTheXoa, contentPane, "Mã thẻ", 520, 460, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheDeXoa, contentPane, 600, 460, 120, 20);
        GraphicFunctions.setButton(buttonKhoaDocGia, contentPane, "KHÓA ĐỘC GIẢ", 520, 500, 120, 30);
        GraphicFunctions.setButton(buttonXoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 650, 500, 120, 30);

        JTable table = new JTable();
        String column[] = { "MÃ THẺ", "HỌ", "TÊN", "GIỚI TÍNH", "TRẠNG THÁI" };
        String data[][] = {
                { "1", "Dang", "Bao", "Nam", "Đang hoạt động" },
                { "2", "Dangg", "Bao0", "Nam", "Đang hoạt động" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(820, 170, 600, 460);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 520, 570, 200, 50);
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
        GraphicFunctions.setLabel(themSach, contentPane, "THÊM/SỬA SÁCH", 590, 170, 120, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 520, 210, 120, 20);
        GraphicFunctions.setLabel(tenSach, contentPane, "Tên sách", 520, 250, 120, 20);
        GraphicFunctions.setLabel(viTri, contentPane, "Vị trí", 520, 290, 120, 20);
        GraphicFunctions.setTextField(nhapMaSach, contentPane, 600, 210, 120, 20);
        GraphicFunctions.setTextField(nhapTenSach, contentPane, 600, 250, 120, 20);
        GraphicFunctions.setTextField(nhapViTri, contentPane, 600, 290, 120, 20);
        GraphicFunctions.setButton(buttonThemSach, contentPane, "THÊM SÁCH", 520, 350, 120, 30);
        GraphicFunctions.setButton(buttonSuaSach, contentPane, "SỬA SÁCH", 650, 350, 120, 30);

        JLabel khoaXoaSach = new JLabel();
        JLabel maTheSachXoa = new JLabel();
        JTextField nhapMaTheSachDeXoa = new JTextField();
        JButton buttonKhoaSach = new JButton();
        JButton buttonXoaSach = new JButton();
        GraphicFunctions.setLabel(khoaXoaSach, contentPane, "KHÓA/XÓA SÁCH", 590, 430, 120, 20);
        GraphicFunctions.setLabel(maTheSachXoa, contentPane, "Mã sách", 520, 460, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheSachDeXoa, contentPane, 600, 460, 120, 20);
        GraphicFunctions.setButton(buttonKhoaSach, contentPane, "KHÓA SÁCH", 520, 500, 120, 30);
        GraphicFunctions.setButton(buttonXoaSach, contentPane, "XÓA SÁCH", 650, 500, 120, 30);

        JTable table = new JTable();
        String column[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ", "TRẠNG THÁI" };
        String data[][] = {
                { "1", "OOP with JAVA", "Kệ 1 ngăn 1", "Cho mượn được" },
                { "2", "Python program language", "Kệ 1 ngăn 2", "Cho mượn được" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(820, 170, 600, 460);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 520, 570, 200, 50);
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
        GraphicFunctions.setLabel(muonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 590, 200, 120, 20);
        GraphicFunctions.setLabel(maDocGia, contentPane, "Mã độc giả", 520, 240, 120, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 520, 290, 120, 20);
        GraphicFunctions.setTextField(nhapMaSach, contentPane, 600, 240, 120, 20);
        GraphicFunctions.setTextField(nhapMaDocGia, contentPane, 600, 290, 120, 20);
        GraphicFunctions.setButton(buttonMuonSach, contentPane, "MƯỢN SÁCH", 510, 350, 120, 30);
        GraphicFunctions.setButton(buttonTraSach, contentPane, "TRẢ SÁCH", 660, 350, 120, 30);
        GraphicFunctions.setButton(buttonMatSach, contentPane, "LÀM MẤT SÁCH", 570, 410, 150, 30);

        JTable table = new JTable();
        String column[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ", "NGƯỜI MƯỢN" };
        String data[][] = {
                { "1", "OOP with JAVA", "Kệ 1 ngăn 1", "Dang Bao" },
                { "2", "Python program language", "Kệ 1 ngăn 2", "Dang Baoo" } };

        GraphicFunctions.setTable(table, contentPane, column, data);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(820, 170, 600, 460);
        contentPane.add(scrollPane);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, "QUAY LẠI", 520, 570, 200, 50);
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
