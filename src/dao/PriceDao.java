package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Price;
import utils.DBUtils;

public class PriceDao {
	/** 增加记录 */
	public int insert(String mode,String price, String duration) {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into Price(Mode,Price,Duration) values(?,?,?);";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, mode);
			ps.setString(2, price);
			ps.setString(3, duration);
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
	public int deleteByMode(String mode) {
		Connection conn = DBUtils.getConnection();
		String sql = "delete from Price where mode=?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, mode);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	
	/** 更新记录 */
	public int update(String mode,String price,String duration) {
		Connection conn = DBUtils.getConnection();
		String sql = "update Price set mode=?,price=?,duration=?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, mode);
			ps.setString(2, price);
			ps.setString(3, duration);
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
	public ArrayList<Price> querySplitedList(int curPage,int pageSize){
		return null;
	}
}
