package com.software.rj;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Exe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/sampledb");
		ds.setUsername("root");
		ds.setPassword("201708044230");
		
		JdbcTemplate jdbcTemplate =new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);
		
		String sql="create table t_user(user_id int primary key,user_name varchar(60))";
		jdbcTemplate.execute(sql);

	}

}
