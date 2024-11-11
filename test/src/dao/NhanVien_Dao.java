package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_Dao {
	ArrayList<NhanVien> dsnv;
	NhanVien nv;
	public NhanVien_Dao(){
		dsnv= new ArrayList<NhanVien>();	
		nv = new NhanVien();
	}	
	public  ArrayList<NhanVien> getalltbNhanVien()  {
			
		try {
		Connection con = ConnectDB.getInstance().getConnection();
		 String sql = "Select * from nhanvien";
		 Statement statement = con.createStatement();
	      // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
	      ResultSet rs = statement.executeQuery(sql);
	      // Duyệt trên kết quả trả về.
	      while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
	          String manv = rs.getString(1);
	          String hoten= rs.getString(2);
	          int tuoi  = rs.getInt(3);
	          PhongBan pBan = new PhongBan(rs.getString(4));
	          double tien = rs.getDouble(5);
	          NhanVien s = new NhanVien(manv,hoten, tuoi, pBan, tien);
			  dsnv.add(s);
	      }
		} catch (SQLException e) {
			e.printStackTrace();
	      // Đóng kết nối
		}
	return dsnv;

	}
	public boolean create(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " NhanVien values(?, ?, ?, ?, ?)");
			stmt.setString(1,nv.getMaNV());
			stmt.setString(2,nv.getHoten());
			stmt.setInt(3, nv.getTuoi());
			stmt.setString(4, nv.getPhong().getMaPhong());
			stmt.setDouble(5, nv.getTienluong());
			n = stmt.executeUpdate();						
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return n > 0; 
	}
	
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set hoTen=?, tuoi=?, maPhong=?,tienLuong=? where maNV=?");	
			//stmt = con.prepareStatement("update LopHoc set tenLop = ?, maGiaoVien = ?, siSo = ? where maLop = ?");
			
			stmt.setString(1, nv.getHoten());
			stmt.setInt(2, nv.getTuoi());
			stmt.setString(3, nv.getPhong().getMaPhong());
			stmt.setDouble(4, nv.getTienluong());
			stmt.setString(5, nv.getMaNV());
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
			stmt = con.prepareStatement("delete from nhanvien where maNV = ?");
			stmt.setString(1, manv);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0; 
	}	
	
	public ArrayList<NhanVien> getNhanVienTheoPhongBan(String maP) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement =null;
		try {						
			String sql = "Select * from nhanvien where maPhong = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, maP);
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về.
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
				String maNV = rs.getString(1);
				String hoten = rs.getString(2);
				int tuoi = rs.getInt(3);
				PhongBan pBan = new PhongBan(rs.getString(4));
				double luong = rs.getDouble(5);		
				
				NhanVien nv = new NhanVien(maNV, hoten, tuoi, pBan, luong);
				dsnv.add(nv);
			}
		} catch (SQLException e) {			
			e.printStackTrace();				
		}
		return dsnv;
	}

}
