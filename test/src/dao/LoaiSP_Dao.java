package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiSP;

public class LoaiSP_Dao {
	public ArrayList<LoaiSP> getalltbLoaiSP() {
			ArrayList<LoaiSP> dsloaiSP = new ArrayList<LoaiSP>();
			try {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String sql = "Select * from LoaiSanPham";
				Statement statement = con.createStatement();
				// Thá»±c thi cÃ¢u lá»‡nh SQL tráº£ vá»� Ä‘á»‘i tÆ°á»£ng ResultSet.
				ResultSet rs = statement.executeQuery(sql);
				// Duyá»‡t trÃªn káº¿t quáº£ tráº£ vá»�.
				while (rs.next()) {// Di chuyá»ƒn con trá»� xuá»‘ng báº£n ghi káº¿ tiáº¿p.
					String maLoai = rs.getString(1);
					String tenLoai = rs.getString(2);
					LoaiSP p = new LoaiSP(maLoai, tenLoai);
					dsloaiSP.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();		
			}
			return dsloaiSP;
		}
}
