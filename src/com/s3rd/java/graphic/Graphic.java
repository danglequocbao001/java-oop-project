package com.s3rd.java.graphic;

import javax.swing.*;

import com.s3rd.java.config.GlobalVariable;
import com.s3rd.java.database.PostgreSql;
import com.s3rd.java.models.Book;
import com.s3rd.java.models.Reader;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Graphic {
    private JFrame mainFrame;
    private JPanel contentPane;
    private PostgreSql connector;

    public Graphic() {
        prepareGUI();
    }

    public void loadModels(PostgreSql connector) {
        this.connector = connector;
    }

    public void prepareGUI() {
        mainFrame = new JFrame("Đồ án kết môn OOP với JAVA");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        mainFrame.setSize(width, height);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        contentPane = new JPanel();
        contentPane.setLayout(null);
        mainFrame.add(contentPane);
        mainFrame.setVisible(true); // hide when enter next frame
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen size mode
    }

    public void run() {
        mainFrame.setVisible(false);
        prepareGUI();
        JButton buttonLRun = new JButton();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        GraphicFunctions.setButton(buttonLRun, contentPane, "CHẠY CHƯƠNG TRÌNH", 0, 0, screenSize.width,
                screenSize.height);
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
        JLabel maDocGia = new JLabel();
        JLabel ho = new JLabel();
        JLabel ten = new JLabel();
        JLabel gioiTinh = new JLabel();
        JLabel trangThai = new JLabel();
        JLabel nhapMaThe = new JLabel();
        JTextField nhapHo = new JTextField();
        JTextField nhapTen = new JTextField();
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
        Reader reader = new Reader(this.connector);
        GraphicFunctions.setLabel(themDocGia, contentPane, "THÊM/SỬA ĐỘC GIẢ", 440, 170, 150, 20);
        GraphicFunctions.setLabel(maDocGia, contentPane, "Mã độc giả", 370, 230, 120, 20);
        GraphicFunctions.setLabel(ho, contentPane, "Họ", 370, 270, 120, 20);
        GraphicFunctions.setLabel(ten, contentPane, "Tên", 370, 310, 120, 20);
        GraphicFunctions.setLabel(gioiTinh, contentPane, "Giới tính", 370, 350, 120, 20);
        GraphicFunctions.setLabel(trangThai, contentPane, "Trạng thái", 370, 450, 120, 20);
        GraphicFunctions.setLabel(nhapMaThe, contentPane, "Chọn vào bảng để hiển thị!", 465, 230, 200, 20);
        GraphicFunctions.setTextField(nhapHo, contentPane, 465, 270, 150, 20);
        GraphicFunctions.setTextField(nhapTen, contentPane, 465, 310, 150, 20);
        GraphicFunctions.setRadioButton(nam, contentPane, "Nam", 460, 350, 170, 30);
        GraphicFunctions.setRadioButton(nu, contentPane, "Nữ", 460, 380, 170, 30);
        GraphicFunctions.setRadioButton(khac, contentPane, "Khác", 460, 410, 170, 30);
        GraphicFunctions.setRadioButton(hoatDong, contentPane, "Hoạt động", 460, 450, 170, 30);
        GraphicFunctions.setRadioButton(khoa, contentPane, "Khóa", 460, 480, 170, 30);
        GraphicFunctions.setButton(buttonThemDocGia, contentPane, "THÊM ĐỘC GIẢ", 350, 520, 150, 40);
        GraphicFunctions.setButton(buttonSuaDocGia, contentPane, "SỬA ĐỘC GIẢ", 520, 520, 150, 40);
        buttonThemDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (nhapHo.getText().equals("") || nhapTen.getText().equals("")
                        || Gender.getSelection().getActionCommand().equals("")) {
                    JOptionPane.showMessageDialog(buttonThemDocGia, GlobalVariable.NOT_BLANK);
                } else {
                    int inputshowMessageDialog = JOptionPane.showOptionDialog(null,
                            "Thêm độc giả mới với tên: " + nhapHo.getText() + " " + nhapTen.getText()
                                    + " và giới tính: "
                                    + Gender.getSelection().getActionCommand() + " ?",
                            "Thông báo", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (inputshowMessageDialog == JOptionPane.OK_OPTION) {
                        reader.createOne(
                                nhapHo.getText(),
                                nhapTen.getText(),
                                Gender.getSelection().getActionCommand(),
                                "Hoạt động");
                        docGia();
                    }
                }
            }
        });
        buttonSuaDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nhapMaThe.getText().equals("") || nhapHo.getText().equals("") || nhapTen.getText().equals("")
                        || Gender.getSelection().getActionCommand().equals("")
                        || Status.getSelection().getActionCommand().equals("")) {
                    JOptionPane.showMessageDialog(buttonSuaDocGia, GlobalVariable.NOT_BLANK);
                } else {
                    int inputshowMessageDialog = JOptionPane.showOptionDialog(null,
                            "Bạn có muốn sửa lại độc giả có mã độc giả " + nhapMaThe.getText() + " này?",
                            "Thông báo", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);

                    if (inputshowMessageDialog == JOptionPane.OK_OPTION) {
                        reader.updateOne(
                                nhapMaThe.getText(),
                                nhapHo.getText(),
                                nhapTen.getText(),
                                Gender.getSelection().getActionCommand(),
                                Status.getSelection().getActionCommand());
                        docGia();
                    }
                }
            }
        });

        JLabel khoaXoaDocGia = new JLabel();
        JLabel maDocGiaXoa = new JLabel();
        JTextField nhapMaTheDeXoa = new JTextField();
        JButton buttonXoaDocGia = new JButton();
        GraphicFunctions.setLabel(khoaXoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 440, 600, 150, 20);
        GraphicFunctions.setLabel(maDocGiaXoa, contentPane, "Mã độc giả", 370, 660, 120, 20);
        GraphicFunctions.setTextField(nhapMaTheDeXoa, contentPane, 465, 660, 150, 20);
        GraphicFunctions.setButton(buttonXoaDocGia, contentPane, "XÓA ĐỘC GIẢ", 440, 710, 150, 40);

        buttonXoaDocGia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nhapMaTheDeXoa.getText().equals("")) {
                    JOptionPane.showMessageDialog(buttonXoaDocGia, GlobalVariable.NOT_BLANK);
                } else {
                    int inputshowMessageDialog = JOptionPane.showOptionDialog(null,
                            "Bạn có muốn xóa độc giả có mã " + nhapMaTheDeXoa.getText() + " ?",
                            "Thông báo", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);

                    if (inputshowMessageDialog == JOptionPane.OK_OPTION) {
                        reader.deleteOne(nhapMaThe.getText());
                        docGia();
                    }
                }
            }
        });

        JTable tableDocGia = new JTable();
        String firstRow[] = { "MÃ ĐỘC GIẢ", "HỌ", "TÊN", "GIỚI TÍNH", "TRẠNG THÁI", "SỐ SÁCH ĐANG MƯỢN" };
        String[][] data = (String[][]) reader.getAll().data;
        tableDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int rowDocGia = tableDocGia.rowAtPoint(evt.getPoint());
                nhapMaThe.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 0));
                nhapHo.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 1));
                nhapTen.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 2));

                if (((String) tableDocGia.getModel().getValueAt(rowDocGia, 3)).equals("Nam")) {
                    nam.setSelected(true);
                    nu.setSelected(false);
                    khac.setSelected(false);

                } else if (((String) tableDocGia.getModel().getValueAt(rowDocGia, 3)).equals("Nữ")) {
                    nam.setSelected(false);
                    nu.setSelected(true);
                    khac.setSelected(false);
                } else {
                    nam.setSelected(false);
                    nu.setSelected(false);
                    khac.setSelected(true);
                }

                if (((String) tableDocGia.getModel().getValueAt(rowDocGia, 4)).equals("Hoạt động")) {
                    hoatDong.setSelected(true);
                    khoa.setSelected(false);

                } else {
                    hoatDong.setSelected(false);
                    khoa.setSelected(true);
                }
                nhapMaTheDeXoa.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 0));
                tableDocGia.getSelectionModel().clearSelection();
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
        JLabel trangThai = new JLabel();
        JLabel nhapMaSach = new JLabel();
        JTextField nhapTenSach = new JTextField();
        JTextField nhapViTri = new JTextField();
        JRadioButton choMuonDuoc = new JRadioButton();
        JRadioButton daKhoa = new JRadioButton();
        JRadioButton daMat = new JRadioButton();
        ButtonGroup Status = new ButtonGroup();
        Status.add(choMuonDuoc);
        Status.add(daKhoa);
        Status.add(daMat);
        JButton buttonThemSach = new JButton();
        JButton buttonSuaSach = new JButton();
        Book book = new Book(this.connector);
        GraphicFunctions.setLabel(themSach, contentPane, "THÊM/SỬA SÁCH", 440, 170, 150, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 370, 230, 120, 20);
        GraphicFunctions.setLabel(tenSach, contentPane, "Tên sách", 370, 270, 120, 20);
        GraphicFunctions.setLabel(viTri, contentPane, "Vị trí", 370, 310, 120, 20);
        GraphicFunctions.setLabel(trangThai, contentPane, "Trạng thái", 370, 350, 120, 20);
        GraphicFunctions.setLabel(nhapMaSach, contentPane, "Chọn vào bảng để hiển thị!", 465, 230, 200, 20);
        GraphicFunctions.setTextField(nhapTenSach, contentPane, 465, 270, 150, 20);
        GraphicFunctions.setTextField(nhapViTri, contentPane, 465, 310, 150, 20);
        GraphicFunctions.setRadioButton(choMuonDuoc, contentPane, "Cho mượn được", 460, 350, 170, 30);
        GraphicFunctions.setRadioButton(daKhoa, contentPane, "Đã khóa", 460, 380, 170, 30);
        GraphicFunctions.setButton(buttonThemSach, contentPane, "THÊM SÁCH", 350, 460, 150, 40);
        GraphicFunctions.setButton(buttonSuaSach, contentPane, "SỬA SÁCH", 520, 460, 150, 40);

        buttonThemSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (nhapTenSach.getText().equals("") || nhapViTri.getText().equals("")) {
                    JOptionPane.showMessageDialog(buttonThemSach, GlobalVariable.NOT_BLANK);
                } else {
                    int inputshowMessageDialog = JOptionPane.showOptionDialog(null,
                            "Thêm sách mới với tên: " + nhapTenSach.getText()
                                    + " và vị trí: "
                                    + nhapViTri.getText() + " ?",
                            "Thông báo", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (inputshowMessageDialog == JOptionPane.OK_OPTION) {
                        book.createOne(
                                nhapTenSach.getText(),
                                nhapViTri.getText(),
                                "Cho mượn được");
                        danhMucSach();
                    }
                }
            }
        });
        buttonSuaSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nhapMaSach.getText().equals("") || nhapTenSach.getText().equals("")
                        || nhapViTri.getText().equals("") || Status.getSelection().getActionCommand().equals("")) {
                    JOptionPane.showMessageDialog(buttonSuaSach, GlobalVariable.NOT_BLANK);
                } else {
                    int inputshowMessageDialog = JOptionPane.showOptionDialog(null,
                            "Bạn có muốn sửa lại sách có mã sách " + nhapMaSach.getText() + " này?",
                            "Thông báo", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (inputshowMessageDialog == JOptionPane.OK_OPTION) {
                        book.updateOne(
                                nhapMaSach.getText(),
                                nhapTenSach.getText(),
                                nhapViTri.getText(),
                                Status.getSelection().getActionCommand());
                        danhMucSach();
                    }
                }
            }
        });

        JLabel khoaXoaSach = new JLabel();
        JLabel maSachXoa = new JLabel();
        JTextField nhapMaSachDeXoa = new JTextField();
        JButton buttonXoaSach = new JButton();
        GraphicFunctions.setLabel(khoaXoaSach, contentPane, "XÓA SÁCH", 460, 550, 150, 20);
        GraphicFunctions.setLabel(maSachXoa, contentPane, "Mã sách", 370, 600, 120, 20);
        GraphicFunctions.setTextField(nhapMaSachDeXoa, contentPane, 465, 600, 150, 20);
        GraphicFunctions.setButton(buttonXoaSach, contentPane, "XÓA SÁCH", 420, 650, 150, 40);

        buttonXoaSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nhapMaSachDeXoa.getText().equals("")) {
                    JOptionPane.showMessageDialog(buttonXoaSach, GlobalVariable.NOT_BLANK);
                } else {
                    int inputshowMessageDialog = JOptionPane.showOptionDialog(null,
                            "Bạn có muốn xóa sách có mã sách: " + nhapMaSachDeXoa.getText() + " ?",
                            "Thông báo", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (inputshowMessageDialog == JOptionPane.OK_OPTION) {
                        book.deleteOne(nhapMaSach.getText());
                        danhMucSach();
                    }

                }
            }
        });

        JTable tableDMS = new JTable();
        String firstRow[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ", "TRẠNG THÁI" };
        String[][] data = (String[][]) book.getAll().data;
        tableDMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int rowDMS = tableDMS.rowAtPoint(evt.getPoint());
                nhapMaSach.setText((String) tableDMS.getModel().getValueAt(rowDMS, 0));
                nhapTenSach.setText((String) tableDMS.getModel().getValueAt(rowDMS, 1));
                nhapViTri.setText((String) tableDMS.getModel().getValueAt(rowDMS, 2));

                if (((String) tableDMS.getModel().getValueAt(rowDMS, 3)).equals("Cho mượn được")) {
                    choMuonDuoc.setSelected(true);
                    daKhoa.setSelected(false);
                    daMat.setSelected(false);

                } else if (((String) tableDMS.getModel().getValueAt(rowDMS, 3)).equals("Đã khóa")) {
                    choMuonDuoc.setSelected(false);
                    daKhoa.setSelected(true);
                    daMat.setSelected(false);
                } else {
                    choMuonDuoc.setSelected(false);
                    daKhoa.setSelected(false);
                    daMat.setSelected(true);
                }
                nhapMaSachDeXoa.setText((String) tableDMS.getModel().getValueAt(rowDMS, 0));
                tableDMS.getSelectionModel().clearSelection();
            }
        });
        GraphicFunctions.setTable(tableDMS, contentPane, firstRow, data);
        JScrollPane scrollPane = new JScrollPane(tableDMS);
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

        JLabel muonSach = new JLabel();
        JLabel traMatSach = new JLabel();
        JLabel maDocGia = new JLabel();
        JLabel maSach = new JLabel();
        JLabel maMuonTra = new JLabel();
        JTextField nhapMaDocGia = new JTextField();
        JTextField nhapMaSach = new JTextField();
        JTextField nhapMaMuonTra = new JTextField();
        JButton buttonMuonSach = new JButton();
        JButton buttonTraSach = new JButton();
        JButton buttonMatSach = new JButton();
        GraphicFunctions.setLabel(muonSach, contentPane, "MƯỢN SÁCH", 140, 170, 150, 20);
        GraphicFunctions.setLabel(traMatSach, contentPane, "TRẢ/MẤT SÁCH", 130, 450, 150, 20);
        GraphicFunctions.setLabel(maDocGia, contentPane, "Mã độc giả", 70, 240, 120, 20);
        GraphicFunctions.setLabel(maSach, contentPane, "Mã sách", 70, 280, 120, 20);
        GraphicFunctions.setLabel(maMuonTra, contentPane, "Mã mượn trả", 60, 520, 120, 20);
        GraphicFunctions.setTextField(nhapMaDocGia, contentPane, 170, 240, 150, 20);
        GraphicFunctions.setTextField(nhapMaSach, contentPane, 170, 280, 150, 20);
        GraphicFunctions.setTextField(nhapMaMuonTra, contentPane, 180, 520, 150, 20);
        GraphicFunctions.setButton(buttonMuonSach, contentPane, "MƯỢN SÁCH", 120, 330, 150, 40);
        GraphicFunctions.setButton(buttonTraSach, contentPane, "TRẢ SÁCH", 50, 570, 150, 40);
        GraphicFunctions.setButton(buttonMatSach, contentPane, "LÀM MẤT SÁCH", 220, 570, 150, 40);

        buttonMuonSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nhapMaDocGia.getText().equals("") || nhapMaSach.getText().equals("")) {
                    JOptionPane.showMessageDialog(buttonMuonSach, GlobalVariable.NOT_BLANK);
                } else {
                    System.out.println(nhapMaDocGia.getText() + " " + nhapMaSach.getText());
                }
            }
        });

        buttonTraSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nhapMaMuonTra.getText());

            }
        });

        buttonMatSach.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nhapMaMuonTra.getText());

            }
        });

        JTable tableDocGia = new JTable();
        JTable tableSach = new JTable();
        JTable tableMuonTra = new JTable();

        String firstRowDocGia[] = { "MÃ ĐỘC GIẢ", "HỌ", "TÊN", "SỐ SÁCH ĐANG MƯỢN" };
        String firstRowSach[] = { "MÃ SÁCH", "TÊN SÁCH", "VỊ TRÍ" };
        String firstRowMuonTra[] = { "MÃ MƯỢN TRẢ", "TÊN SÁCH", "NGƯỜI MƯỢN", "THỜI ĐIỂM MƯỢN", "THỜI ĐIỂM TRẢ" };

        String dataDocGia[][] = {
                { "1", "Dang", "Bao", "2" },
                { "2", "Dangg", "Bao0", "1" },
                { "3", "Nguyen", "Danh", "0" },
                { "4", "Nguyen", "Thi", "0" },
        };
        String dataSach[][] = {
                { "1", "OOP with JAVA", "Kệ 1 ngăn 1" },
                { "2", "Python program language", "Kệ 1 ngăn 2" } };
        String dataMuonTra[][] = {
                { "11", "OOP with JAVA", "Dang Bao", "01/01/22", "05/01/22" },
                { "12", "Python program language", "Nguyễn Danh", "02/02/22", "" } };
        tableDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int rowDocGia = tableDocGia.rowAtPoint(evt.getPoint());
                nhapMaDocGia.setText((String) tableDocGia.getModel().getValueAt(rowDocGia, 0));
                tableDocGia.getSelectionModel().clearSelection();
            }
        });
        tableSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int rowSach = tableSach.rowAtPoint(evt.getPoint());
                nhapMaSach.setText((String) tableSach.getModel().getValueAt(rowSach, 0));
                tableSach.getSelectionModel().clearSelection();
            }
        });

        tableMuonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int rowMuonTra = tableMuonTra.rowAtPoint(evt.getPoint());
                nhapMaMuonTra.setText((String) tableMuonTra.getModel().getValueAt(rowMuonTra, 0));
                tableMuonTra.getSelectionModel().clearSelection();
            }
        });

        GraphicFunctions.setTable(tableDocGia, contentPane, firstRowDocGia, dataDocGia);
        GraphicFunctions.setTable(tableSach, contentPane, firstRowSach, dataSach);
        GraphicFunctions.setTable(tableMuonTra, contentPane, firstRowMuonTra, dataMuonTra);

        JScrollPane scrollPaneDocGia = new JScrollPane(tableDocGia);
        JScrollPane scrollPaneSach = new JScrollPane(tableSach);
        JScrollPane scrollPaneMuonTra = new JScrollPane(tableMuonTra);

        scrollPaneDocGia.setBounds(390, 10, 750, 490);
        scrollPaneSach.setBounds(1155, 10, 750, 490);
        scrollPaneMuonTra.setBounds(390, 515, 1515, 490);

        contentPane.add(scrollPaneDocGia);
        contentPane.add(scrollPaneSach);
        contentPane.add(scrollPaneMuonTra);

        JButton goBack = new JButton();
        GraphicFunctions.setButton(goBack, contentPane, GlobalVariable.GO_BACK, 100, 840, 230, 60);
        goBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });
    }
}
