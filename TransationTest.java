package com.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.JDBCUtil.JDBCUtil;

public class TransationTest {

	public static void main(String[] args) throws Exception {
		Connection conn = JDBCUtil.getconn();
		String sql="select * from acount where name=? and money>?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, "张三");
		ps.setInt(2, 1000);
		ResultSet rs=ps.executeQuery();
		if(!rs.next())
		{
			throw new RuntimeException("没钱了！");
		}
		try {
			conn.setAutoCommit(false);   //开启事务（手动开启）
		sql="update acount set money=money-? where name=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "张三");
		ps.executeUpdate();

		sql="update acount set money=money+? where name=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "李四");
		ps.executeUpdate();
		conn.commit();   //提交事务
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();   //事务回滚
		}finally {
			JDBCUtil.close(conn, ps, rs);
		}
	}
}
