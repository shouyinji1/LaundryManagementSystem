package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Order;
import utils.DBUtils;

public class OrderDao {
	/** 插入记录 */
	public int insert(String id,String userID,String washerID,String mode,String generatedTime) {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into `Order`(ID,UserID,WasherID,Mode,GeneratedTime) values(?,?,?,?,?);";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, userID);
			ps.setString(3, washerID);
			ps.setString(4, mode);
			ps.setString(5, generatedTime);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	
	/** 删除记录 */
	public int deleteById(String id) {
		Connection conn = DBUtils.getConnection();
		String sql = "delete from `Order` where ID=?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	
	/** 修改记录 */
	public int update(String id,String userID,String washerID,String mode,String generatedTime) {
		Connection conn = DBUtils.getConnection();
		String sql = "update `Order` set ID=?,UserID=?,WasherID=?,Mode=?,GeneratedTime=?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, userID);
			ps.setString(3, washerID);
			ps.setString(4, mode);
			ps.setString(5, generatedTime);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	/** 分页查询 */
	public ArrayList<Order> querySplitedList(int curPage,int pageSize){
		return null;
	}
}
