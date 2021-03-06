package com.stu.software.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://202.196.37.168:3306/logistics";
	private static final String URLNAME="student";
	private static final String PASSWORD="Student_123456";
	public Connection getConn(){
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,URLNAME,PASSWORD);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	public void closeResultset(ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	public void closePS(PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	public void closeS(Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public void closeConnation(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	public int exeUda(String[] prams,String sql) {
		int flag=0;
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=this.getConn();
			ps=conn.prepareStatement(sql);
			for(int i=0;i<prams.length;i++) {
				ps.setString(i+1, prams[i]);
			}
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closePS(ps);
			this.closeConnation(conn);
		}
		return flag;
	}
	public void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
