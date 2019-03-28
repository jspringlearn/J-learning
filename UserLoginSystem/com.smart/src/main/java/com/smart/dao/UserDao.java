package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import com.smart.domain.User;

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

}
