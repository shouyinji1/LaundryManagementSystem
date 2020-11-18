package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Washer;
import utils.DBUtils;
import utils.Page;

public class WasherDao {
	//分页查询所有信息
	public ArrayList<Washer> querySplitedList(int curPage,int pageSize){
		Connection conn=DBUtils.getConnection();
		String sql="select * from Washer order by id asc limit "+curPage+","+pageSize;
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
	
	//查询总记录数
	public int queryInfosCount() {
		String sql="select count(id) from Washer";
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
	
	//根据ID查询某洗衣机信息
	public Washer queryWasherInfoById(int id){
		String sql="select * from Washer where id=?";
		Connection conn=DBUtils.getConnection();
		Washer washer=new Washer();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				washer.setId(rs.getString("id"));
				washer.setName(rs.getString("name"));
				washer.setPrice(rs.getString("price"));
				washer.setStatus(rs.getString("status"));
				washer.setType(rs.getString("type"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return washer;
	}
	
	//删除洗衣机信息，返回一个int值表示状态,1：成功，0失败
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
	
	//插入洗衣机，1成功，0失败
	public int insertWasher(Washer washer) {
		String sql="insert into Washer(name,type,price) values(?,?,?);";
		Connection conn = DBUtils.getConnection();
		int flag=0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, washer.getName());
			ps.setString(2, washer.getType());
			ps.setString(3, washer.getPrice());
			flag = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

	//更新洗衣机信息，1：成功，0失败
	public int updateById(Washer washer) {
		Connection conn = DBUtils.getConnection();
		String sql = "update Washer set name=?,type=?,price=?,status=? where id=?";
		int flag = 0;
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, washer.getName());
			ps.setString(2, washer.getType());
			ps.setString(3, washer.getPrice());
			ps.setString(4, washer.getStatus());
			ps.setString(5, washer.getId());
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