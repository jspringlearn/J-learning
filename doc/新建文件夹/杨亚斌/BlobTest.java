package com.jdbc.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.JDBCUtil.JDBCUtil;

public class BlobTest {

	public static void main(String[] args) throws Exception {
		Connection conn = JDBCUtil.getconn();
		String  sql="insert into user (img) values(?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		FileInputStream in=new FileInputStream("D:/QQ/1668395108/Video/conn.png");
		ps.setBlob(1, in);
		ps.executeUpdate();
		JDBCUtil.close(conn, ps, null);

	}

}
