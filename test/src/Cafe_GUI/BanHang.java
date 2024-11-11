package Cafe_GUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import connectDB.ConnectDB;
import dao.LoaiSP_Dao;
import dao.San_Pham_Dao;

public class BanHang extends JPanel{
	private JLabel lbMaHD;
	private JTextField txtMaHD;
	private JLabel lbSoLuong;
	private JTextField txtSoLuong;
	private JButton btnThemHD;
	private JButton btnXoaHD;
	private JLabel lbTong;
	private JTextField txtTong;
	private JLabel lbtitle;
	private San_Pham_Dao sp_dao;
	private LoaiSP_Dao loai_dao;
	private JButton btnThemSP;
	private JButton btnGiamSP;

	public BanHang() throws ClassNotFoundException {
		
		ConnectDB.getInstance().connect();
		sp_dao = new San_Pham_Dao();
		loai_dao = new LoaiSP_Dao();
		
		setSize(new Dimension(1100, 900));
		setLayout(new BorderLayout());
		
		JPanel emptyL = new JPanel();
        emptyL.setPreferredSize(new Dimension(16, 500));
        emptyL.setOpaque(false);
        add(emptyL, BorderLayout.WEST);
        
        JPanel pCen = new JPanel();
        
        pCen.setBorder(BorderFactory.createTitledBorder("Các sản phẩm"));
        pCen.setLayout(new GridLayout(4,4,10,10));
        
        pCen.setSize(300,300);
        Box b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        pCen.add(b1 = Box.createHorizontalBox());
        b1.setBorder(BorderFactory.createTitledBorder("SP1"));
        b1.setPreferredSize(new Dimension(185,200));
        
        
        String imagePath = "image/Macchiato.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(new Dimension(150, 80));
        b1.add(imageLabel);
        b1.add(Box.createHorizontalStrut(20));
        b1.add(btnThemSP = new JButton("Cộng"));
        b1.add(Box.createHorizontalStrut(10));
        b1.add(btnGiamSP = new JButton("Trừ"));
        
        
        pCen.add(b2 = Box.createHorizontalBox());
        b2.setBorder(BorderFactory.createTitledBorder("SP2"));
        b2.setPreferredSize(new Dimension(185,200));
        
        String imagePath2 = "image/Americano.jpg"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon2 = new ImageIcon(imagePath2);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setPreferredSize(new Dimension(150, 80));
        b2.add(imageLabel2);
        b2.add(Box.createHorizontalStrut(20));
        b2.add(btnThemSP = new JButton("Cộng"));
        b2.add(Box.createHorizontalStrut(10));
        b2.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b3 = Box.createHorizontalBox());
        b3.setBorder(BorderFactory.createTitledBorder("SP3"));
        b3.setPreferredSize(new Dimension(185,200));
        
        String imagePath3 = "image/sua_tuoi_cafe.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon3 = new ImageIcon(imagePath3);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel3 = new JLabel(imageIcon3);
        imageLabel3.setPreferredSize(new Dimension(150, 80));
        b3.add(imageLabel3);
        b3.add(Box.createHorizontalStrut(20));
        b3.add(btnThemSP = new JButton("Cộng"));
        b3.add(Box.createHorizontalStrut(10));
        b3.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b4 = Box.createHorizontalBox());
        b4.setBorder(BorderFactory.createTitledBorder("SP4"));
        b4.setPreferredSize(new Dimension(185,200));
        
        String imagePath4 = "image/Cocacola.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon4 = new ImageIcon(imagePath4);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel4 = new JLabel(imageIcon4);
        imageLabel4.setPreferredSize(new Dimension(150, 80));
        b4.add(imageLabel4);
        b4.add(Box.createHorizontalStrut(20));
        b4.add(btnThemSP = new JButton("Cộng"));
        b4.add(Box.createHorizontalStrut(10));
        b4.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b5 = Box.createHorizontalBox());
        b5.setBorder(BorderFactory.createTitledBorder("SP5"));
        b5.setPreferredSize(new Dimension(185,200));
        
        String imagePath5 = "image/chanh_day.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon5 = new ImageIcon(imagePath5);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel5 = new JLabel(imageIcon5);
        imageLabel5.setPreferredSize(new Dimension(150, 80));
        b5.add(imageLabel5);
        b5.add(Box.createHorizontalStrut(20));
        b5.add(btnThemSP = new JButton("Cộng"));
        b5.add(Box.createHorizontalStrut(10));
        b5.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b6 = Box.createHorizontalBox());
        b6.setBorder(BorderFactory.createTitledBorder("SP6"));
        b6.setPreferredSize(new Dimension(185,200));
        
        String imagePath6 = "image/tra_olong.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon6 = new ImageIcon(imagePath6);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel6 = new JLabel(imageIcon6);
        imageLabel6.setPreferredSize(new Dimension(150, 80));
        b6.add(imageLabel6);
        b6.add(Box.createHorizontalStrut(20));
        b6.add(btnThemSP = new JButton("Cộng"));
        b6.add(Box.createHorizontalStrut(10));
        b6.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b7 = Box.createHorizontalBox());
        b7.setBorder(BorderFactory.createTitledBorder("SP7"));
        b7.setPreferredSize(new Dimension(185,200));
        
        String imagePath7 = "image/tra_Dao.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon7 = new ImageIcon(imagePath7);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel7 = new JLabel(imageIcon7);
        imageLabel7.setPreferredSize(new Dimension(150, 80));
        b7.add(imageLabel7);
        b7.add(Box.createHorizontalStrut(20));
        b7.add(btnThemSP = new JButton("Cộng"));
        b7.add(Box.createHorizontalStrut(10));
        b7.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b8 = Box.createHorizontalBox());
        b8.setBorder(BorderFactory.createTitledBorder("SP8"));
        b8.setPreferredSize(new Dimension(185,200));
        
        String imagePath8 = "image/yougurt_dau_tam.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon8 = new ImageIcon(imagePath8);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel8 = new JLabel(imageIcon8);
        imageLabel8.setPreferredSize(new Dimension(150, 80));
        b8.add(imageLabel8);
        b8.add(Box.createHorizontalStrut(20));
        b8.add(btnThemSP = new JButton("Cộng"));
        b8.add(Box.createHorizontalStrut(10));
        b8.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b9 = Box.createHorizontalBox());
        b9.setBorder(BorderFactory.createTitledBorder("SP9"));
        b9.setPreferredSize(new Dimension(185,200));
        
        String imagePath9 = "image/nuoc_cam.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon9 = new ImageIcon(imagePath9);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel9 = new JLabel(imageIcon9);
        imageLabel9.setPreferredSize(new Dimension(150, 80));
        b9.add(imageLabel9);
        b9.add(Box.createHorizontalStrut(20));
        b9.add(btnThemSP = new JButton("Cộng"));
        b9.add(Box.createHorizontalStrut(10));
        b9.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b10 = Box.createHorizontalBox());
        b10.setBorder(BorderFactory.createTitledBorder("SP10"));
        b10.setPreferredSize(new Dimension(185,200));
        
        String imagePath10 = "image/cacao_nong.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon10 = new ImageIcon(imagePath10);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel10 = new JLabel(imageIcon10);
        imageLabel10.setPreferredSize(new Dimension(150, 80));
        b10.add(imageLabel10);
        b10.add(Box.createHorizontalStrut(20));
        b10.add(btnThemSP = new JButton("Cộng"));
        b10.add(Box.createHorizontalStrut(10));
        b10.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b11 = Box.createHorizontalBox());
        b11.setBorder(BorderFactory.createTitledBorder("SP11"));
        b11.setPreferredSize(new Dimension(185,200));
        
        String imagePath11 = "image/tra_lipton.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon11 = new ImageIcon(imagePath11);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel11 = new JLabel(imageIcon11);
        imageLabel11.setPreferredSize(new Dimension(150, 80));
        b11.add(imageLabel11);
        b11.add(Box.createHorizontalStrut(20));
        b11.add(btnThemSP = new JButton("Cộng"));
        b11.add(Box.createHorizontalStrut(10));
        b11.add(btnGiamSP = new JButton("Trừ"));
        
        pCen.add(b12 = Box.createHorizontalBox());
        b12.setBorder(BorderFactory.createTitledBorder("SP12"));
        b12.setPreferredSize(new Dimension(185,200));
        
        String imagePath12 = "image/soda_chanh.JPG"; // for eclipse, intelj
        //File imageFile = new File(imagePath);

        ImageIcon imageIcon12 = new ImageIcon(imagePath12);

        // Tạo imageLabel cho ảnh
        JLabel imageLabel12 = new JLabel(imageIcon12);
        imageLabel12.setPreferredSize(new Dimension(150, 80));
        b12.add(imageLabel12);
        b12.add(Box.createHorizontalStrut(20));
        b12.add(btnThemSP = new JButton("Cộng"));
        b12.add(Box.createHorizontalStrut(10));
        b12.add(btnGiamSP = new JButton("Trừ"));
        
        add(pCen, BorderLayout.CENTER);
        
//        JPanel pEast = new JPanel();
        Box c = Box.createVerticalBox();
        c.setPreferredSize(new Dimension(250, 500));
        c.setBorder(BorderFactory.createTitledBorder("Thanh toán"));
        c.add(Box.createVerticalStrut(10));
        Box c0,c1,c2,c3,c4;
        
        c.add(c0 = Box.createHorizontalBox());
        c.add(Box.createVerticalStrut(10));
        c0.add(lbtitle = new JLabel("Hóa đơn"));
        lbtitle.setFont(new Font("Times new Roman", Font.BOLD, 25));
		lbtitle.setForeground(Color.BLUE);
        
        c.add(c1 = Box.createHorizontalBox());
        c.add(Box.createVerticalStrut(10));
        c1.add(lbMaHD = new JLabel("Mã HD: "));
        c1.add(txtMaHD = new JTextField(10));
//        c1.setBorder(BorderFactory.createTitledBorder("ghg"));
        
        c.add(c2 = Box.createHorizontalBox());
        c.add(Box.createVerticalStrut(10));
        c2.add(lbSoLuong = new JLabel("Số lượng: "));
        c2.add(txtSoLuong = new JTextField(10));
        
        c.add(c3 = Box.createHorizontalBox());
        c.add(Box.createVerticalStrut(15));
        c3.add(lbTong = new JLabel("Thành tiền: "));
        c3.add(txtTong = new JTextField(10));
        
        c.add(c4 = Box.createHorizontalBox());
        c.add(Box.createVerticalStrut(440));
        c4.add(btnThemHD = new JButton("Thêm hóa đơn"));
        c4.add(Box.createHorizontalStrut(10));
        c4.add(btnXoaHD = new JButton("Hủy HĐ"));
        add(c, BorderLayout.EAST);
        
        JScrollPane scrollPane = new JScrollPane(pCen);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        
        lbMaHD.setPreferredSize(lbTong.getPreferredSize());
        lbSoLuong.setPreferredSize(lbTong.getPreferredSize());
	}
	
//	protected void paintComponent(Graphics g) {
//        String imagePath = "image/brown_color.png"; // Path to your GIF image file
//        File imageFile = new File(imagePath);
//
//        //Chèn ảnh vào Option menu
//        try {
//            // Đọc ảnh từ file
//            Image image = ImageIO.read(imageFile);
//
//            // Tạo icon cho ảnh
//            int newWidth = getWidth(); // Get the width of the panel
//            int newHeight = getHeight(); // Get the height of the panel
//            Image scaledImage = image; //getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//            g.drawImage(scaledImage, 0, 0, null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}