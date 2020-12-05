package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Order;
import utils.DBUtils;

public class OrderDao {
	/** 插入记录 */
	public int insert(String userID,String washerID,String mode,String generatedTime) {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into `Order`(UserID,WasherID,Mode,GeneratedTime) values(?,?,?,?);";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, washerID);
			ps.setString(3, mode);
			ps.setString(4, generatedTime);
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
	public int deleteByID(String id) {
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
	
	/** 根据洗衣机ID删除订单记录 */
	public int deleteByWasherID(String washerID) {
		Connection conn = DBUtils.getConnection();
		String sql = "delete from `Order` where washerID=?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, washerID);
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
	public int update(String id,String mode) {
		Connection conn = DBUtils.getConnection();
		String sql = "update `Order` set Mode=? where ID=?;";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, mode);
			ps.setString(2, id);
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	/** 分页查询所有订单 */
	public ArrayList<Order> querySplitedList(int curPage,int pageSize){
		Connection conn=DBUtils.getConnection();
		String sql="select * from `Order` order by ID asc limit "+curPage+","+pageSize+";";
		ArrayList<Order> results=new ArrayList<Order>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Order order=new Order();
				order.setId(rs.getString("ID"));
				order.setUserID(rs.getString("UserID"));
				order.setWasherID(rs.getString("WasherID"));
				order.setMode(rs.getString("Mode"));
				order.setGeneratedTime(rs.getString("GeneratedTime"));
				results.add(order);
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
	
	/** 分页查询指定用户的所有订单 */
	public ArrayList<Order> querySplitedList(String userID,int curPage,int pageSize){
		Connection conn=DBUtils.getConnection();
		String sql="select * from `Order` where UserID=? order by ID asc limit "+curPage+","+pageSize+";";
		ArrayList<Order> results=new ArrayList<Order>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, userID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Order order=new Order();
				order.setId(rs.getString("ID"));
				order.setUserID(rs.getString("UserID"));
				order.setWasherID(rs.getString("WasherID"));
				order.setMode(rs.getString("Mode"));
				order.setGeneratedTime(rs.getString("GeneratedTime"));
				results.add(order);
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

	//查询总记录数
	public int queryInfosCount() {
		String sql="select count(id) from `Order`";
		Connection conn=DBUtils.getConnection();
		int count=0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				count=Integer.parseInt(rs.getString("count(id)"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return count;
	}
	
	/** 根据ID查询某订单信息 */
	public Order queryOrderInfoById(String id){
		String sql="select * from `Order` where id=?";
		Connection conn=DBUtils.getConnection();
		Order order=new Order();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				order.setId(rs.getString("ID"));
				order.setUserID(rs.getString("UserID"));
				order.setWasherID(rs.getString("WasherID"));
				order.setMode(rs.getString("Mode"));
				order.setGeneratedTime(rs.getString("GeneratedTime"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return order;
	}
}
