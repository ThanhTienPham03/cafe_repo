package Cafe_GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class HoaDon_page extends JPanel{
	
	private DefaultTableModel tableModel;
	private JTable table;

	public HoaDon_page() {
		setSize(new Dimension(1000, 900));
		setLayout(new BorderLayout());
		
		JPanel p = new JPanel();
//		p.add(b7 = Box.createHorizontalBox());
//		b.add(Box.createVerticalStrut(10));
		String[] headers = "Mã Đon Hàng;Ma Sản Phẩm;Tên Sản Phẩm;Số lượng;Tổng Tiền".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

		p.add(scroll);
		add(p, BorderLayout.CENTER);
	}
}
