package edu.com.software.ZLoca.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import edu.com.software.ZLoca.JdbcUtil.JDBCUtil;
import edu.com.software.ZLoca.dao.IUserDao;
import edu.com.software.ZLoca.domain.User;

public class UserDaoImpl implements IUserDao{

	@Override
	public void save(User stu) {
		Connection conn=null;
		PreparedStatement ps=null;
		Connection conn = JDBCUtil.getconn();
		String sql="insert into user valuse(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "name");
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id, User stu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
