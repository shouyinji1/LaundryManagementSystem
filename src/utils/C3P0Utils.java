package utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//数据库连接池

public class C3P0Utils {
	//获取c3p0-config.xml配置文件里的数据库驱动信息
	private static ComboPooledDataSource ds = new ComboPooledDataSource("db");
	
	// 获得数据源
	public static DataSource getDataSource() {
		return ds;
	}
	
	// 获取连接
	public static Connection getConnection() throws SQLException {
		Connection connection = ds.getConnection();
		return connection;
	}
}
