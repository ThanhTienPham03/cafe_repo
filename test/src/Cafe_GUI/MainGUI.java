package Cafe_GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


public class MainGUI extends JFrame implements ActionListener{
	
	private JPanel right;
	private JLabel timeLabel;
	private JPanel pageContainer;
	private TrangChu trangChu;
	private BanHang banHang;
	private HoaDon_page hoaDon;
	private SanPham_page sanPham;
	private GiamGia giamGia;
	private ThongKe thongKe;
	private NhanVien_page nhanVien;
	private JLabel lblogo;
	private JButton btnTrangChu;
	private JButton btnBanHang;
	private JButton btnHoaDon;
	private JButton btnSanPham;
	private JButton btnKhuyenMai;
	private JButton btnThongKe;
	private JButton btnNhanVien;
	

	public MainGUI() throws ClassNotFoundException {
		setSize(new Dimension(1600, 730));
		setTitle("Quán cafe");
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    setBackground(new Color(96, 69, 113));
        setResizable(true);
        getContentPane().setBackground(new Color(225, 203, 177));
        
//        this.right = new JPanel();
//        this.right.setPreferredSize(new Dimension(660, 400));
//        this.right.setLayout(new BorderLayout());
        createGUIUserRelatedBar();
        createGUI();
	}
	
	public void createGUIUserRelatedBar() throws ClassNotFoundException {
        this.right = new JPanel();
        this.right.setPreferredSize(new Dimension(660, 400));
        this.right.setLayout(new BorderLayout());

        JPanel infoBar = new JPanel() {
//            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(79, 92, 133), 0, h, new Color(104, 101, 133));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        infoBar.setPreferredSize(new Dimension(670, 35));
        //infoBar.setBackground(new Color(51, 62, 116));
        infoBar.setLayout(new BorderLayout());
        //banner.setBorder(new LineBorder(Color.red, 3));

        JPanel userRelatedBar = new JPanel() {
//            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(139, 69, 19), 0, h, new Color(139, 69, 19));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        userRelatedBar.setPreferredSize(new Dimension(385, 35));
        //userRelatedBar.setBackground(new Color(51, 62, 116));

        JButton changePassButton = new JButton("Đổi mật khẩu");
        changePassButton.setPreferredSize(new Dimension(110, 25));
//        changePassButton.setFont(customFont.getFernandoFont(9));
        changePassButton.setBackground(Color.WHITE);
        userRelatedBar.add(changePassButton);

        JButton signOutButton = new JButton("Đăng xuất");
        signOutButton.setPreferredSize(new Dimension(110, 25));
//        signOutButton.setFont(customFont.getFernandoFont(9));
        signOutButton.setBackground(Color.WHITE);
        userRelatedBar.add(signOutButton);

        
//        infoBar.add(Box.createHorizontalStrut(170));

        // Tạo thanh ngày giờ
//        timeLabel = new JLabel();
//        timeLabel.setPreferredSize(new Dimension(130, 25));
////        timeLabel.setFont(customFont.getFernandoFont(9));
//        timeLabel.setForeground(Color.WHITE);
//        infoBar.add(timeLabel, BorderLayout.EAST);
        infoBar.add(userRelatedBar, BorderLayout.SOUTH); // căn chỉnh cho 2 button về phía south trong JPanel infobar

        // Khởi tạo trang chứa
        this.pageContainer = new JPanel();
        this.pageContainer.setPreferredSize(new Dimension(200, 200));
        //this.pageContainer.setBackground(new Color(225, 203, 177));
        this.pageContainer.setLayout(new CardLayout());

        this.trangChu = new TrangChu(); // Khởi tạo trang Trang chủ
        this.banHang = new BanHang(); // Khởi tạo trang Bán hàng
        this.hoaDon = new HoaDon_page();  // Khởi tạo trang Hóa đơn
        this.sanPham = new SanPham_page(); // Khởi tạo trang Sản phẩm
        this.giamGia = new GiamGia(); // Khởi tạo trang Giảm giá
        this.thongKe = new ThongKe(); // Khởi tạo trang Thống kê
        this.nhanVien = new NhanVien_page(); // Khởi tạo trang Nhân viên

        pageContainer.add(trangChu, "Home Page");
        pageContainer.add(banHang, "Sell Page");
        pageContainer.add(hoaDon, "Receipt Page");
        pageContainer.add(sanPham, "Product Page");
        pageContainer.add(giamGia, "Promotion Page");
        pageContainer.add(thongKe, "Statistic Page");
        pageContainer.add(nhanVien, "Employee Page");

        this.right.add(pageContainer);
        this.right.add(infoBar, BorderLayout.NORTH);
        add(this.right, BorderLayout.CENTER);
    }
	
	public void createGUI() {
		JPanel optionBar = new JPanel() {
			protected void paintComponent(Graphics g) {
                String imagePath = "image/brown_color.png"; // Path to your GIF image file
                File imageFile = new File(imagePath);

                //Chèn ảnh vào Option menu
                try {
                    // Đọc ảnh từ file
                    Image image = ImageIO.read(imageFile);

                    // Tạo icon cho ảnh
                    int newWidth = getWidth(); // Get the width of the panel
                    int newHeight = getHeight(); // Get the height of the panel
                    Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                    g.drawImage(scaledImage, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		};
		optionBar.setPreferredSize(new Dimension(220, 500));
//		Box b = Box.createVerticalBox();
//		b.setPreferredSize(new Dimension(200, 500));
//		Box b1,b2,b3,b4,b5;
//		
//		b.add(b1 = Box.createHorizontalBox());
//		b.add(Box.createVerticalStrut(10));
//		b1.add(lblogo = new JLabel("Dev-cafe"));
//		b1.setPreferredSize(new Dimension(110, 50));
//		lblogo.setPreferredSize(new Dimension(110, 50));
//		
//		b.add(b2 = Box.createHorizontalBox());
//		b.add(Box.createVerticalStrut(10));
//		b2.add(btnTrangChu = new JButton("Trang chủ"));
////		b2.setPreferredSize(new Dimension(300, 600));
//		btnTrangChu.setPreferredSize(new Dimension(300, 100));
//		
//		b.add(b3 = Box.createHorizontalBox());
//		b.add(Box.createVerticalStrut(10));
//		b3.add(btnBanHang = new JButton("Bán hàng"));
//		
//		b.add(b4 = Box.createHorizontalBox());
//		b.add(Box.createVerticalStrut(10));
//		b4.add(btnHoaDon = new JButton("Hóa đơn"));
//		
//		b.add(b5 = Box.createHorizontalBox());
//		b.add(Box.createVerticalStrut(10));
//		b5.add(btnSanPham = new JButton("Sản phẩm"));
//		add(b, BorderLayout.WEST);
		
		JPanel empty = new JPanel();
        empty.setPreferredSize(new Dimension(110, 30));
        empty.setOpaque(false);
        optionBar.add(empty);
		
		String imagePath = "image/logo_cafe.png"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(new Dimension(153, 107));

        optionBar.add(imageLabel);

		
		lblogo = new JLabel("Dev-cafe");
		lblogo.setFont(new Font("Arial", Font.BOLD, 15));
		lblogo.setPreferredSize(new Dimension(80, 20));
		lblogo.setForeground(Color.WHITE);
		optionBar.add(lblogo);
		
		btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setPreferredSize(new Dimension(195, 60));
//		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.addActionListener(this);
		optionBar.add(btnTrangChu);
		
		btnBanHang = new JButton("Bán Hàng");
		btnBanHang.setPreferredSize(new Dimension(195, 60));
		btnBanHang.addActionListener(this);
		optionBar.add(btnBanHang);
		
		btnHoaDon = new JButton("Hóa Đơn");
		btnHoaDon.setPreferredSize(new Dimension(195, 60));
		btnHoaDon.addActionListener(this);
		optionBar.add(btnHoaDon);
		
		btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setPreferredSize(new Dimension(195, 60));
		btnSanPham.addActionListener(this);
		optionBar.add(btnSanPham);
		
//		btnKhuyenMai = new JButton("Khuyến Mại");
//		btnKhuyenMai.setPreferredSize(new Dimension(195, 60));
//		optionBar.add(btnKhuyenMai);
		
//		btnThongKe = new JButton("Thống Kê");
//		btnThongKe.setPreferredSize(new Dimension(195, 60));
//		optionBar.add(btnThongKe);
		
		btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setPreferredSize(new Dimension(195, 60));
		optionBar.add(btnNhanVien);
		btnNhanVien.addActionListener(this);
		
		add(optionBar, BorderLayout.WEST);
	}
	public static void main(String[] args) throws ClassNotFoundException {
		new MainGUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CardLayout cardLayout = (CardLayout) pageContainer.getLayout();
        String command = e.getActionCommand();
        
        switch (command) {
            case "Trang Chủ":
                cardLayout.show(pageContainer, "Home Page");
                break;
            case "Bán Hàng":
                cardLayout.show(pageContainer, "Sell Page");
                break;
            case "Hóa Đơn":
                cardLayout.show(pageContainer, "Receipt Page");
                break;
            case "Sản Phẩm":
                cardLayout.show(pageContainer, "Product Page");
                break;
            case "Khuyến Mại":
                cardLayout.show(pageContainer, "Promotion Page");
                break;
            case "Thống Kê":
                cardLayout.show(pageContainer, "Statistic Page");
                break;
            case "Nhân Viên":
                cardLayout.show(pageContainer, "Employee Page");
                break;
        }
	}
}
