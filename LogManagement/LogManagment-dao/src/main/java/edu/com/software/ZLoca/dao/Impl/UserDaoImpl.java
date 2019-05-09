package edu.com.software.ZLoca.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.com.software.ZLoca.JdbcUtil.JDBCUtil;
import edu.com.software.ZLoca.dao.IUserDao;
import edu.com.software.ZLoca.domain.User;

public class UserDaoImpl implements IUserDao{

	@Override
	public void save(User user)  {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			 conn = JDBCUtil.getconn();
		     String sql="insert into user(Name,Address,Phone) values(?,?,?)";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,user.getName());
		     ps.setString(2,user.getAddress());
		     ps.setString(3,user.getPhone());
		     ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, ps, null);
		}
	}

	@Override
	public void delete(String name) {
		Connection conn=null;
		PreparedStatement ps=null;
	     try {
	    	 conn=JDBCUtil.getconn();
	    String sql="delete from user where Name=?";
	    ps=conn.prepareStatement(sql);
	    ps.setString(1,name);
	     ps.executeUpdate();    	 
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 JDBCUtil.close(conn, ps, null);
	     }	
	}

	@Override
	public void update(int id, User user) {
		Connection conn=null;
		PreparedStatement ps=null;
	     try {
	    	 conn=JDBCUtil.getconn();
	  
	    String sql="update user set Name=?,Address=?,Phone=? where id='"+id+"'";
	      ps=conn.prepareStatement(sql);
	      ps.setString(1, user.getName());
	      ps.setString(2, user.getAddress());
	      ps.setString(3, user.getPhone());
	     ps.executeUpdate();
	    	 
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 JDBCUtil.close(conn, ps, null);
	    	 }

		
	}

	@Override
	public User get(String name) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	     try {
	    	 conn=JDBCUtil.getconn();
	    st=conn.createStatement();
	    String sql="select * from user where Name='"+name+"'";
	    rs= st.executeQuery(sql);
	     if(rs.next()) {
	    	 User user=new User();
	    	 user.setName(rs.getString("Name"));
	    	 user.setAddress(rs.getString("Address"));
	    	 user.setPhone(rs.getString("Phone"));
	    	 return user;
	     } 
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	JDBCUtil.close(conn, st, rs);
	     }	
		return null;

	}

	@Override
	public List<User> getAll() {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	     try {
	    	 conn=JDBCUtil.getconn();
	    st=conn.createStatement();
	    String sql="select * from user ";
	    rs= st.executeQuery(sql);
	    List<User> list=new ArrayList<User>();
	     while(rs.next()) {
	    	User user=new User();
	    	user.setName(rs.getString("Name"));
	    	user.setAddress(rs.getString("Address"));
	    	user.setPhone(rs.getString("Phone"));
	    	 list.add(user);
	     } 
	     return list;
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	JDBCUtil.close(conn, st, rs);
	     }
		return null;
	}
}
