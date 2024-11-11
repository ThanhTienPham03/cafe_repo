package Cafe_GUI;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.San_Pham_Dao;
import dao.LoaiSP_Dao;
//import dao.NhanVien_Dao;
//import dao.PhongBan_DAO;
import entity.San_Pham;
import entity.LoaiSP;

import connectDB.ConnectDB;

public class SanPham_page extends JPanel implements ActionListener, MouseListener {
	private JTable table;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGia;
//	private JTextField txtTienLuong;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private DefaultTableModel tableModel;
	private JLabel lblMaLoai;
	private JTextField txtMaLoai;
	private JComboBox cboMaLoai;
	private JTextField txtImage;
//	private JComboBox cboSize;
	private JButton btnSua;
	private San_Pham_Dao sp_dao;
	private LoaiSP_Dao loai_dao;
	private JLabel lblMaSP;
	private JLabel lblTenSP;
	private JLabel lblGia;
	private JLabel lblImage;
	private JLabel lblSize;
	private JComboBox comboOne;

	public SanPham_page() throws ClassNotFoundException {
		ConnectDB.getInstance().connect();
		sp_dao = new San_Pham_Dao();
		loai_dao = new LoaiSP_Dao();

//	setTitle("^-^");
		setSize(700, 450);
//	setDefaultCloseOperation(EXIT_ON_CLOSE);
//	setLocationRelativeTo(null);
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		JLabel lblTieuDe;
		pnlNorth.add(lblTieuDe = new JLabel("THÔNG TIN SẢN PHẨM"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);

		Box b = Box.createVerticalBox();

		Box b1, b2, b3, b4, b5, b6,b7;

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaSP = new JLabel("Mã sản phẩm: "));
		b1.add(txtMaSP = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenSP = new JLabel("Tên sản phẩm: "));
		b2.add(txtTenSP = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblGia = new JLabel("Giá: "));
		b3.add(txtGia = new JTextField());

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String [] items = { "Vừa", "Nhỏ", "Lớn"};
		comboOne = new JComboBox (items);
		b4.add(lblSize = new JLabel("Kích cỡ: "));
		b4.add(comboOne);
		
//			
//
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(lblImage = new JLabel("Hình : ")); 
		b5.add(txtImage = new JTextField());
		
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(lblMaLoai = new JLabel("Mã Loai: "));
		b6.add(cboMaLoai = new JComboBox<String>());
		cboMaLoai.setEditable(true);
		
		ArrayList<LoaiSP> listLoaiSP = loai_dao.getalltbLoaiSP();
		for (LoaiSP p : listLoaiSP) {
			cboMaLoai.addItem(p.getmaLoai());
		}
		
//	
//	lblhoTen.setPreferredSize(lblMaNV.getPreferredSize());
//	lblPhong.setPreferredSize(lblMaNV.getPreferredSize());
//	lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
//
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		String[] headers = "MaSP;tênSP;Gia;Size;image;MaLoai".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		b7.add(scroll);
		add(b, BorderLayout.CENTER);
//	
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);
		JPanel pnlLeft, pnlRight;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());

		pnlLeft.add(new JLabel("Nhập mã số cần tìm: "));
		pnlLeft.add(txtTim = new JTextField(10));
		pnlLeft.add(btnTim = new JButton("Tìm"));

		pnlRight.add(btnThem = new JButton("Thêm"));
		pnlRight.add(btnSua = new JButton("Sửa"));
		pnlRight.add(btnXoa = new JButton("Xóa"));
		pnlRight.add(btnLuu = new JButton("Lưu"));
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);
//		
		lblMaSP.setPreferredSize(lblTenSP.getPreferredSize());
		lblGia.setPreferredSize(lblTenSP.getPreferredSize());
		lblSize.setPreferredSize(lblTenSP.getPreferredSize());
		lblImage.setPreferredSize(lblTenSP.getPreferredSize());
		lblMaLoai.setPreferredSize(lblTenSP.getPreferredSize());
//	
//	// doc du lieu tu database SQL vao Jtable
		DocDuLieuDatabaseVaoTable();
	}

//	public static void main(String[] args) {
//		new SanPham_page().setVisible(true);
//	}

//
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	  Object o = e.getSource();
		if (o.equals(btnThem)) {
			xoaTrang();
		}	
		if(o.equals(btnLuu)) {
			themNV();
		}	
		if(o.equals(btnSua))
			suaNV();
		if(o.equals(btnXoa)) {
			xoaNV();
		}
	}
	public void themNV() {
	//pHai kiem tra Rang buoc truoc khi them
		String maSP = txtMaSP.getText();
		String hoten = txtTenSP.getText();
		int gia = Integer.parseInt(txtGia.getText());
		String size = comboOne.getSelectedItem().toString();
		String image = txtImage.getText();
		String maLoai = cboMaLoai.getSelectedItem().toString();
//		PhongBan phban = new PhongBan(phongban);
		San_Pham sp = new San_Pham(maSP, hoten, gia,  size, image, maLoai);
		try {
			sp_dao.create(sp);
			tableModel.addRow(new Object[] { sp.getMaSP(),
					sp.getTenSP(), sp.getDonGia(), sp.getSize(), sp.getImage(), sp.getMaLoai() });
			xoaTrang();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Trùng");
		}
	
	}
	public void suaNV() {
	  	int row = table.getSelectedRow();
	  	String ma = txtMaSP.getText();
		String ten = txtTenSP.getText();
		int gia = Integer.parseInt(txtGia.getText());
		String size = comboOne.getSelectedItem().toString();
//		String phongban = cboPhong.getSelectedItem().toString();
		String hinh = txtImage.getText();
//		PhongBan phban = new PhongBan(phongban);
		String maLoai = cboMaLoai.getSelectedItem().toString();
		San_Pham sp = new San_Pham(ma,ten,gia,size,hinh,maLoai);
//		NhanVien nv = new NhanVien(ma, hoten, tuoi,  phban, luong);
		if(row >= 0){
				if(sp_dao.update(sp)){
				table.setValueAt(txtTenSP.getText(), row, 1);
				table.setValueAt(txtGia.getText(), row, 2);
				table.setValueAt(comboOne.getSelectedItem().toString(), row, 3);
				table.setValueAt(txtImage.getText(), row, 4);
				table.setValueAt(txtMaLoai.getText(), row, 5);
				}						
		}
	}
	public void xoaNV() {
	  int row = table.getSelectedRow();
		if(row >= 0){
				String masp = (String) table.getValueAt(row, 0);
				if(sp_dao.delete(masp)){
					tableModel.removeRow(row);
					xoaTrang();
				}
		}
	
	}
	public void xoaTrang() {
	  	txtMaSP.setText("");
		txtTenSP.setText("");
		txtGia.setText("");
//		txtMaNV.requestFocus();
		txtImage.setText("");
	}
//đưa dữ liệu vào table
	private void DocDuLieuDatabaseVaoTable() {
		San_Pham_Dao ds = new San_Pham_Dao();
		List<San_Pham> list = ds.getalltbSan_Pham();
		for (San_Pham s : list) {
			String[] rowData = { s.getMaSP(), s.getTenSP(), s.getDonGia() + "", s.getSize(), s.getImage(),
					s.getMaLoai() };
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);
	}
//	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaSP.setText(tableModel.getValueAt(row, 0).toString());
		txtTenSP.setText(tableModel.getValueAt(row, 1).toString());
		txtGia.setText(tableModel.getValueAt(row, 2).toString());
		comboOne.setSelectedItem(tableModel.getValueAt(row, 3).toString());
		txtImage.setText(tableModel.getValueAt(row, 4).toString());
		cboMaLoai.setSelectedItem(tableModel.getValueAt(row, 5).toString());
		
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
