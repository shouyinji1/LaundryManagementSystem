package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.tools.doclint.Checker.Flag;

import entity.User;
import utils.DBUtils;

public class UserDao {
	/** 判断用户在数据库中是否存在
	 * @return 存在返回true，不存在返回false */
	public boolean userIsExist(String username) {
		Connection conn = DBUtils.getConnection();
		String sql = "select * from User where name = ?";
		try{
			//获取PreparedStatement对象
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, username);//给用户对象属性赋值
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//数据库中存在此用户
				return true;
			}
			//释放资源
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(conn);
		}
		return false;
	}
	
	/** 用户登录账户信息查询
	 * @return 登录成功返回一个含值User对象,如果登录失败返回一个User空对象 */
	public User login(String username,String password,String level) {
		Connection conn = DBUtils.getConnection();
		User user = null;
		String sql = "select * from User where name = ? and password = ? and level= ?;";
		try {
			//获取PreparedStatement对象
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			//对sql参数进行动态赋值
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, level);
			ResultSet rs = ps.executeQuery();//查询结果集
			
			if(rs.next()){	//判断数据库中是否存在该用户
				user = new User();//实例化一个user对象
				//给用户对象赋值
				user.setName(username);
				user.setPassword(password);
				user.setLevel(level);
			}
			//释放资源
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(conn);
		}
		return user;
	}
	
	/** 注册用户
	 * @return 1注册成功，0失败 */
	public int register(String username,String password,String level) {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into User(name,password,level) values(?,?,?);";
		int flag=0;
		try {
			//获取PreparedStatement对象
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			//对sql参数进行动态赋值
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, level);
			flag = ps.executeUpdate();//查询结果集
			ps.close();	//释放资源
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
}
