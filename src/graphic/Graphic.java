package graphic;

import javax.swing.*;
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
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void mainMenu() {
        mainFrame.setVisible(false);
        prepareGUI();
        JLabel hoTen = new JLabel();
        JLabel MSSV = new JLabel();
        JLabel lop = new JLabel();
        GraphicFunctions.setLabel(hoTen, contentPane, "Họ tên: Đặng Lê Quốc Bảo - Nguyễn Hữu Phước", 70, 10, 300, 50);
        GraphicFunctions.setLabel(MSSV, contentPane, "MSSV: N19DCCN014 - N19DCCN145", 70, 40, 300, 50);
        GraphicFunctions.setLabel(lop, contentPane, "Lớp: D19CQCN02-N - D19CQCN03-N", 70, 70, 300, 50);

        JButton DocGia = new JButton();
        JButton DanhMucSach = new JButton();
        JButton MuonTraSach = new JButton();
        JButton Thoat = new JButton();

        GraphicFunctions.setButton(DocGia, contentPane, "ĐỘC GIẢ", 550, 50, 200, 50);
        DocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                docGia();
            }
        });

        GraphicFunctions.setButton(DanhMucSach, contentPane, "DANH MỤC SÁCH", 550, 190, 200, 50);
        DanhMucSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        GraphicFunctions.setButton(MuonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 550, 260, 200, 50);
        MuonTraSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        GraphicFunctions.setButton(Thoat, contentPane, "THOÁT", 350, 400, 200, 50);
        Thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
            }
        });

        mainFrame.setVisible(true);
    }

    // public void docGia() {
    // mainFrame.setVisible(false);
    // prepareGUI();
    // JButton DanhSachDocGia = new JButton();
    // JButton ChinhSuaDocGia = new JButton();
    // JButton QuayLai = new JButton();

    // GraphicFunctions.setButton(DanhSachDocGia, contentPane, "DANH SÁCH ĐỘC GIẢ",
    // 350, 120, 200, 50);
    // DanhSachDocGia.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // danhSachDocGia();
    // }
    // });

    // GraphicFunctions.setButton(ChinhSuaDocGia, contentPane, "CHỈNH SỬA ĐỘC GIẢ ",
    // 350, 225, 200, 50);
    // ChinhSuaDocGia.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // System.out.println("ChinhSuaDocGia");
    // }
    // });

    // GraphicFunctions.setButton(QuayLai, contentPane, "QUAY LẠI", 350, 330, 200,
    // 50);
    // QuayLai.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // mainMenu();
    // }
    // });
    // }

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

        JButton QuayLai = new JButton();
        GraphicFunctions.setButton(QuayLai, contentPane, "QUAY LẠI", 20, 430, 200, 50);
        QuayLai.addActionListener(new ActionListener() {
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
