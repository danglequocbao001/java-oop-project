package dohoa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Toolkit;

public class DoHoa {
    private JFrame mainFrame;
    private JPanel contentPane;

    public DoHoa() {
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
        JLabel hoTen = new JLabel("", JLabel.CENTER);
        JLabel MSSV = new JLabel("", JLabel.CENTER);
        JLabel lop = new JLabel("", JLabel.CENTER);
        HamDoHoa.setLabel(hoTen, contentPane, "Đặng Lê Quốc Bảo - Nguyễn Hữu Phước", 70, 10, 300, 50);
        HamDoHoa.setLabel(MSSV, contentPane, "MSSV: N19DCCN014 - N19DCCN145", 70, 40, 300, 50);
        HamDoHoa.setLabel(lop, contentPane, "Lớp: D19CQCN02-N - D19CQCN03-N", 70, 70, 300, 50);

        JButton DocGia = new JButton();
        JButton DauSach = new JButton();
        JButton DanhMucSach = new JButton();
        JButton MuonTraSach = new JButton();
        JButton Thoat = new JButton();

        HamDoHoa.setButton(DocGia, contentPane, "ĐỘC GIẢ", 550, 50, 200, 50);
        DocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                docGia();
            }
        });

        HamDoHoa.setButton(DauSach, contentPane, "ĐẦU SÁCH", 550, 120, 200, 50);
        DauSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        HamDoHoa.setButton(DanhMucSach, contentPane, "DANH MỤC SÁCH", 550, 190, 200, 50);
        DanhMucSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        HamDoHoa.setButton(MuonTraSach, contentPane, "MƯỢN TRẢ SÁCH", 550, 260, 200, 50);
        MuonTraSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        HamDoHoa.setButton(Thoat, contentPane, "THOÁT", 120, 250, 200, 50);
        Thoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
            }
        });

        mainFrame.setVisible(true);
    }

    public void docGia() {
        mainFrame.setVisible(false);
        prepareGUI();
        JButton ThemDocGia = new JButton();
        JButton DanhSachDocGia = new JButton();
        JButton XoaDocGia = new JButton();
        JButton ChinhSuaDocGia = new JButton();
        JButton QuayLai = new JButton();

        HamDoHoa.setButton(ThemDocGia, contentPane, "THÊM ĐỘC GIẢ", 350, 50, 200, 50);
        ThemDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ThemDocGia");
            }
        });

        HamDoHoa.setButton(DanhSachDocGia, contentPane, "DANH SÁCH ĐỘC GIẢ", 350, 120, 200, 50);
        DanhSachDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("DanhSachDocGia");
            }
        });

        HamDoHoa.setButton(XoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 350, 190, 200, 50);
        XoaDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("XoaDocGia");
            }
        });

        HamDoHoa.setButton(ChinhSuaDocGia, contentPane, "CHỈNH SỬA ĐỘC GIẢ ", 350, 260, 200, 50);
        ChinhSuaDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ChinhSuaDocGia");
            }
        });

        HamDoHoa.setButton(QuayLai, contentPane, "QUAY LẠI", 350, 330, 200, 50);
        QuayLai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });
    }

    public static void main(String[] args) {
        DoHoa ChuongTrinh = new DoHoa();
        ChuongTrinh.mainMenu();
    }
}
