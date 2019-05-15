package cn.gsonya.MessageHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConn() {
		String driver="com.mysql.cj.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/runoob?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
		String username="root";
		String password="123456";
		Connection conn=null;
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn=(Connection)DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
	}

}
