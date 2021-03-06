﻿package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/** 数据库连接工具类 */
public class DBUtils {
	/** 创建数据库连接
	 * @return Connection对象 */
	public static Connection getConnection(){
    	String dbUserName = "sa";
    	String dbUserPasswd = "123456";
    	String dbURL = "jdbc:mysql://localhost:3306/LaundryManagementSystem?"
    	            + "user="+dbUserName+"&password="+dbUserPasswd+"&useUnicode=true&characterEncoding=UTF8";
    	Connection conn = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");	// 要求JVM去com.mysql.jdbc下找Driver类并将其载入内存
    		conn = (Connection) DriverManager.getConnection(dbURL,dbUserName,dbUserPasswd);
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	} 
    	return conn;
    }
    
    /**
     * 关闭数据库连接
     * @param conn Connection对象
     */
    public static void closeConnection(Connection conn) {
		//判断conn是否为空
    	if(conn != null){
    		try {
				conn.close();//关闭数据库连接
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	}
	}
}
