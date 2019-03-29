package com.smart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
//import com.smart.domain.User;

import com.smart.domain.User;

@Repository
public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	private final static String MATCH_COUNT_SQL="SELECT count(*) FROM t_user"+
			"WHERE user_name =? and password=?";
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	public int getMatchCount(String userName,String password) {
		return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[] {userName,password},
				Integer.class);
	}
	//@Repository
		//private JdbcTemplate jdbcTemplate;
		//private final static String MATCH_COUNT_SQL="SELECT count(*) FROM"+
		//"t_user WHERE user_name=? and password=?";
		private final static String UPDATE_LOGIN_INFO_SQL="UPDATE t_user SET"+
		"last_visit=?,last_ip=?,credits=? WHERE user_id=?";
		private final static String QUERY_BY_USERNAME="SELECT user_id,user_name,credits"+
		"FROM t_user WHWRE user_name=?";
		public User findUserByUserName(final String userName) {
			final User user=new User();
			jdbcTemplate.query(QUERY_BY_USERNAME,new Object[] {userName},
					new RowCallbackHandler() {
				public void processRow(ResultSet rs)throws SQLException{
					user.setUserId(rs.getInt("user_id"));
					user.setUserName(userName);
					user.setCredits(rs.getInt("credits"));
				}
			});
			return user;
		}
		public void updateLoginInfo(User user) {
			jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[] {user.getLastVisit(),
					user.getLastIp(),user.getCredits(),user.getUserId()});
		}


}
