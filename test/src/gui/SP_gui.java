package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
//import Cafe_GUI.SanPham;
import dao.LoaiSP_Dao;
import dao.San_Pham_Dao;
import entity.LoaiSP;
import entity.San_Pham;

public class SP_gui extends JFrame implements ActionListener, MouseListener{
	private JTable table;
	private JTextField txtMaNV;
	private JTextField txthoTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private DefaultTableModel tableModel;
	private JLabel lblPhong;
	private JTextField txtPhong;
	private JComboBox cboPhong;
	private JButton btnSua;
	private San_Pham_Dao sp_dao;
	private LoaiSP_Dao loai_dao;

	public SP_gui() throws ClassNotFoundException {
	ConnectDB.getInstance().connect();
  	sp_dao = new San_Pham_Dao();
	loai_dao = new LoaiSP_Dao();
	
	setTitle("^-^");
	setSize(700, 450);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	JPanel pnlNorth;
	add(pnlNorth = new JPanel(), BorderLayout.NORTH);
	JLabel lblTieuDe;
	pnlNorth.add(lblTieuDe = new JLabel("THÃ”NG TIN Sáº¢N PHáº¨M"));
	lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
	lblTieuDe.setForeground(Color.BLUE);

	Box b = Box.createVerticalBox();

	Box b1, b2, b3, b4, b5;
	JLabel lblMaNV, lblhoTen, lblTuoi, lblTienLuong;

	b.add(b1 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10));
	b1.add(lblMaNV = new JLabel("MÃ£ nhÃ¢n viÃªn: "));
	b1.add(txtMaNV = new JTextField());

	b.add(b2 = Box.createHorizontalBox()); 
	b.add(Box.createVerticalStrut(10));
	b2.add(lblhoTen = new JLabel("Há»� tÃªn: "));
	b2.add(txthoTen = new JTextField());
	
	b.add(b3 = Box.createHorizontalBox()); 
	b.add(Box.createVerticalStrut(10));
	b3.add(lblTuoi = new JLabel("Tuá»•i: ")); 
	b3.add(txtTuoi = new JTextField());
	b.add(b4 = Box.createHorizontalBox()); 
	b.add(Box.createVerticalStrut(10));
	
	b4.add(lblPhong = new JLabel("MÃ£ phÃ²ng: ")); 
	
	//Táº¡o vÃ  Ä‘á»• dá»¯ liá»‡u vÃ o comboBox
	b4.add(cboPhong = new JComboBox<String>());
	cboPhong.setEditable(true);		
			
	ArrayList<LoaiSP> listLoaiSP = loai_dao.getalltbLoaiSP();
	for (LoaiSP p : listLoaiSP) {
		cboPhong.addItem( p.getmaLoai() );
	}

	b4.add(lblTienLuong = new JLabel("Tiá»�n lÆ°Æ¡ng: ")); 
	b4.add(txtTienLuong = new JTextField());
	
	lblhoTen.setPreferredSize(lblMaNV.getPreferredSize());
	lblPhong.setPreferredSize(lblMaNV.getPreferredSize());
	lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());

	b.add(b5 = Box.createHorizontalBox()); 
	b.add(Box.createVerticalStrut(10));
	String [] headers = "MaNV;Há»� tÃªn;Tuá»•i;PhÃ²ng;Tiá»�n lÆ°Æ¡ng".split(";");
	tableModel=new DefaultTableModel(headers,0);
	JScrollPane scroll = new JScrollPane();
	scroll.setViewportView(table = new JTable(tableModel));
	table.setRowHeight(25);
	table.setAutoCreateRowSorter(true);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	
	b5.add(scroll);
	add(b, BorderLayout.CENTER);
	
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	add(split, BorderLayout.SOUTH);
	JPanel pnlLeft, pnlRight;
	split.add(pnlLeft = new JPanel());
	split.add(pnlRight = new JPanel());

	pnlLeft.add(new JLabel("Nháº­p mÃ£ sá»‘ cáº§n tÃ¬m: "));
	pnlLeft.add(txtTim = new JTextField(10));
	pnlLeft.add(btnTim = new JButton("TÃ¬m"));

	pnlRight.add(btnThem = new JButton("ThÃªm"));
	pnlRight.add(btnSua = new JButton("Sá»­a"));
	pnlRight.add(btnXoa = new JButton("XÃ³a"));
	pnlRight.add(btnLuu = new JButton("LÆ°u"));
	btnThem.addActionListener(this);
	btnLuu.addActionListener(this);
	btnSua.addActionListener(this);
	btnXoa.addActionListener(this);
	table.addMouseListener(this);
	
	
	// doc du lieu tu database SQL vao Jtable
	DocDuLieuDatabaseVaoTable();
}
	public static void main(String[] args) throws ClassNotFoundException {
	  new SP_gui().setVisible(true);
	}

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
  Object o = e.getSource();
//	if (o.equals(btnThem)) 
//		xoaTrang();
//	if(o.equals(btnLuu))
//		themNV();
//	if(o.equals(btnSua))
//		suaNV();
//	if(o.equals(btnXoa))
//		xoaNV();
}
//public void themNV() {
////pHai kiem tra Rang buoc truoc khi them
//	String ma = txtMaNV.getText();
//	String hoten = txthoTen.getText();
//	int tuoi = Integer.parseInt(txtTuoi.getText());
//	double luong = Double.parseDouble(txtTienLuong.getText());
//	String phongban = cboPhong.getSelectedItem().toString();
//	PhongBan phban = new PhongBan(phongban);
//	NhanVien nv = new NhanVien(ma, hoten, tuoi,  phban, luong);
//	try {
//		nv_dao.create(nv);
//		tableModel.addRow(new Object[] { nv.getMaNV(),
//				nv.getHoten(), nv.getTuoi(), nv.getPhong().getMaPhong(), nv.getTienluong() });
//	} catch (Exception e1) {
//		JOptionPane.showMessageDialog(this, "TrÃ¹ng");
//	}
//
//}
//public void suaNV() {
//  	int row = table.getSelectedRow();
//  	String ma = txtMaNV.getText();
//	String hoten = txthoTen.getText();
//	int tuoi = Integer.parseInt(txtTuoi.getText());
//	double luong = Double.parseDouble(txtTienLuong.getText());
//	String phongban = cboPhong.getSelectedItem().toString();
//	PhongBan phban = new PhongBan(phongban);
//	NhanVien nv = new NhanVien(ma, hoten, tuoi,  phban, luong);
//	if(row >= 0){
//			if(nv_dao.update(nv)){
//			table.setValueAt(txthoTen.getText(), row, 1);
//			table.setValueAt(txtTuoi.getText(), row, 2);
//			table.setValueAt(cboPhong.getSelectedItem().toString(), row, 3);
//			table.setValueAt(txtTienLuong.getText(), row, 4);
//			}						
//	}
//}
//public void xoaNV() {
//  int row = table.getSelectedRow();
//	if(row >= 0){
//			String manv = (String) table.getValueAt(row, 0);
//			if(nv_dao.delete(manv)){
//				tableModel.removeRow(row);
//				xoaTrang();
//			}
//	}
//
//}
public void xoaTrang() {
  	txtMaNV.setText("");
	txthoTen.setText("");
	txtTuoi.setText("");
	txtTienLuong.setText("");
	txtMaNV.requestFocus();
	
}
//Ä‘Æ°a dá»¯ liá»‡u vÃ o table
 private void DocDuLieuDatabaseVaoTable() {
	 San_Pham_Dao ds = new San_Pham_Dao();
	 List<San_Pham> list = ds.getalltbSan_Pham();
	for(San_Pham s : list){
		String [] rowData = {s.getMaSP(),s.getTenSP(),s.getDonGia()+"", s.getSize(),s.getImage(), s.getMaLoai()};
		tableModel.addRow(rowData);			
	}
	table.setModel(tableModel);
	}

 
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	int row = table.getSelectedRow();
	txtMaNV.setText(tableModel.getValueAt(row, 0).toString());
	txthoTen.setText(tableModel.getValueAt(row, 1).toString());
	txtTuoi.setText(tableModel.getValueAt(row, 2).toString());
	cboPhong.setSelectedItem(tableModel.getValueAt(row, 3).toString());
	txtTienLuong.setText(tableModel.getValueAt(row, 4).toString());

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
