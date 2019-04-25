package com.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.jdbc.JDBCUtil.JDBCUtil;

public class BatchTets {

	public static void main(String[] args) throws Exception {
		Connection conn = JDBCUtil.getconn();
		String sql="insert into user values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		long begin=System.currentTimeMillis();  //开始计时
		for(int i=0;i<500;i++) {
		
		      ps.setString(1, "李四");
	        	ps.setInt(2, 1234);
	       	ps.addBatch(); //添加到批处理
		
		}
		ps.executeBatch();  //提交到数据库进行操作
		long end=System.currentTimeMillis();   //终止计时
		long time=end-begin;     //输出时差
		System.out.println(time);
	    
		conn.close();

	}

}
