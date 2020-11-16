package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Washer;
import utils.DBUtils;

public class WasherDao {
	public ArrayList<Washer> query_all(){
		//查询所有信息
		Connection conn=DBUtils.getConnection();
		String sql="select * from Washer;";
		ArrayList<Washer> results=new ArrayList<Washer>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Washer washer=new Washer();
				washer.setId(rs.getString("id"));
				washer.setName(rs.getString("name"));
				washer.setPrice(rs.getString("price"));
				washer.setStatus(rs.getString("status"));
				washer.setType(rs.getString("type"));
				results.add(washer);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return results;
	}
}
