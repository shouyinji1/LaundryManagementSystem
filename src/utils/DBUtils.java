package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtils {
	public static Connection getConnection(){
    	String dbUserName = "admin";
    	String dbUserPasswd = "123456";
    	String dbURL = "jdbc:mysql://localhost:3306/StudentInfoManagement?"
    	            + "user="+dbUserName+"&password="+dbUserPasswd+"&useUnicode=true&characterEncoding=UTF8";
    	//String dbURL="jdbc:mysql://localhost:3306/StudentInfoManagement";
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
