package edu.com.software.ZLoca.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	  public static  String url="jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true";
	  public static String user="root";
	  public static String password="20161121bin";
	  public static String Drivername="com.mysql.jdbc.Driver";
	  static {
		  try {
			Class.forName(JDBCUtil.Drivername);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	  }
	  public static Connection getconn() {
		  try {
		  
			return DriverManager.getConnection(JDBCUtil.url, JDBCUtil.user, JDBCUtil.password);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
		  return null;
	  }
	  public static void close(Connection conn,Statement st,ResultSet rs) {
		  if(rs!=null) {
	    		 try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	 }
	    	 if(st!=null) {
		    	 try {
		    		 st.close();
	   		 }catch(SQLException e) {
	   			 e.printStackTrace();
	   		 }}
	    	 if( conn!=null) {
	    		 try {
	    			  conn.close();
	    		 }catch(SQLException e) {
	    			 e.printStackTrace();
	    		 }
	    	 }	    	
	  }
}
