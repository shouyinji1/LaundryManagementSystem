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
	
	//删除用户信息，返回一个int值表示状态,1：成功，0失败
	public int deleteById(String id) {
		Connection conn = DBUtils.getConnection();
		String sql = "delete from Washer where id = ?;";
		
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
}