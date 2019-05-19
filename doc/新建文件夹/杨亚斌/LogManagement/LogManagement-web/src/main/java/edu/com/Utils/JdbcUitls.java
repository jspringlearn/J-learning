package edu.com.Utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JdbcUitls {
	public static DataSource ds=null;
	static {
		try {
			Properties p=new Properties();
			String path=JdbcUitls.class.getClassLoader().getResource("db.properties").getPath();
			System.out.println(path);
			FileInputStream in=new FileInputStream(path);
			p.load(in);
			ds=DruidDataSourceFactory.createDataSource(p);
		
			}catch(Exception e){
				e.printStackTrace();
			}
			}
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getconn() {
		try {
			return ds.getConnection();
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
