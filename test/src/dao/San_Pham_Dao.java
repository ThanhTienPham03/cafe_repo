package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import connectDB.ConnectDB;
import entity.San_Pham;
import entity.LoaiSP;


public class San_Pham_Dao {

	ArrayList<San_Pham> dssp;
	San_Pham sp;
	public San_Pham_Dao(){
		dssp= new ArrayList<San_Pham>();	
		sp = new San_Pham();
	}	
	public  ArrayList<San_Pham> getalltbSan_Pham()  {
			
		try {
		Connection con = ConnectDB.getInstance().getConnection();
		 String sql = "Select MaSanPham,TenSanPham,DonGia,Size,Hinh, a.MaLoai,TenLoai from SanPham a\r\n"
		 		+ "INNER JOIN LoaiSanPham b on a.MaLoai = b.MaLoai";
		 Statement statement = con.createStatement();
	      // Thá»±c thi cÃ¢u lá»‡nh SQL tráº£ vá»� Ä‘á»‘i tÆ°á»£ng ResultSet.
	      ResultSet rs = statement.executeQuery(sql);
	      // Duyá»‡t trÃªn káº¿t quáº£ tráº£ vá»�.
	      while (rs.next()) {// Di chuyá»ƒn con trá»� xuá»‘ng báº£n ghi káº¿ tiáº¿p.
	          String masp = rs.getString(1);
	          String tensp= rs.getString(2);
	          int dongia  = rs.getInt(3);
	          String size= rs.getString(4);
	          String image= rs.getString(5);
//	          LoaiSP loaiSP = new LoaiSP(rs.getString(6));
//	          LoaiSP tenLoai = new LoaiSP(rs.getString(7));
	          String maLoai = rs.getString(6);
	          San_Pham s = new San_Pham(masp,tensp, dongia,size, image,maLoai);
			  dssp.add(s);
	      }
		} catch (SQLException e) {
			e.printStackTrace();
	      // Ä�Ã³ng káº¿t ná»‘i
		}
	return dssp;

	}
	public boolean create(San_Pham sp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " SanPham values(?, ?, ?, ?, ?, ? )");
			stmt.setString(1,sp.getMaSP());
			stmt.setString(2,sp.getTenSP());
			stmt.setInt(3, sp.getDonGia());
			stmt.setString(4, sp.getSize());
			stmt.setString(5, sp.getImage());
//			stmt.setString(6, sp.getloaiSP().getmaLoai());
			stmt.setString(6, sp.getMaLoai());
			n = stmt.executeUpdate();						
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return n > 0; 
	}
	
	public boolean update(San_Pham sp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update San_Pham set TenSanPham=?, DonGia=?,Siez=?, Hinh=?, MaLoai=? where MaSan_Pham=?");	
			//stmt = con.prepareStatement("update LopHoc set tenLop = ?, maGiaoVien = ?, siSo = ? where maLop = ?");
			
			stmt.setString(1, sp.getTenSP());
			stmt.setInt(2, sp.getDonGia());
			stmt.setString(3, sp.getSize());
			stmt.setString(4, sp.getImage());
//			stmt.setString(5, sp.getloaiSP().getmaLoai());
			stmt.setString(5, sp.getMaLoai());
			stmt.setString(6, sp.getMaSP());
			
			n = stmt.executeUpdate();						
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return n > 0; 
	}
	
	public boolean delete(String manv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from San_Pham where MaSanPham = ?");
			stmt.setString(1, manv);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0; 
	}	
	
	public ArrayList<San_Pham> getSan_PhamTheoLoaiSP(String maP) {
		ArrayList<San_Pham> dssp = new ArrayList<San_Pham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement =null;
		try {						
			String sql = "Select MaSanPham,TenSanPham,DonGia,Size,Hinh, a.MaLoai,TenLoai from SanPham a\r\n"
					+ "INNER JOIN LoaiSanPham b on a.MaLoai = b.MaLoai where MaSanPham= = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, maP);
			// Thá»±c thi cÃ¢u lá»‡nh SQL tráº£ vá»� Ä‘á»‘i tÆ°á»£ng ResultSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyá»‡t trÃªn káº¿t quáº£ tráº£ vá»�.
			while (rs.next()) {// Di chuyá»ƒn con trá»� xuá»‘ng báº£n ghi káº¿ tiáº¿p.
				  String masp = rs.getString(1);
		          String tensp= rs.getString(2);
		          int dongia  = rs.getInt(3);
		          String size= rs.getString(4);
		          String image= rs.getString(5);
//		          LoaiSP loaiSP = new LoaiSP(rs.getString(6));
//		          LoaiSP tenLoai = new LoaiSP(rs.getString(7));
		          String maLoai = rs.getString(6);
		          San_Pham s = new San_Pham(masp,tensp, dongia,size, image,maLoai);
				dssp.add(sp);
			}
		} catch (SQLException e) {			
			e.printStackTrace();				
		}
		return dssp;
	}
}
