package dao;

import java.sql.ResultSet;
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
	
	/** 查询所有价目信息 */
	public ArrayList<Price> queryAll(){
		Connection conn = DBUtils.getConnection();
		Price price=null;
		ArrayList<Price> results=new ArrayList<Price>();
		String sql = "select * from Price;";
		try {
			//获取PreparedStatement对象
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			//对sql参数进行动态赋值
			ResultSet rs = ps.executeQuery();//查询结果集
			
			while(rs.next()){	
				price=new Price();
				price.setMode(rs.getString("mode"));
				price.setPrice(rs.getString("price"));
				price.setDuration(rs.getString("duration"));
				results.add(price);
			}
			//释放资源
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(conn);
		}
		return results;
	}

	/** 分页查询 */
	public ArrayList<Price> querySplitedList(int curPage,int pageSize){
		return null;
	}
}
