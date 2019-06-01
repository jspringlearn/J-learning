package cn.gsonya.MessageHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCOperation {
	public static int insert(String[] excelCell,int mark) throws SQLException {
		Connection conn=JDBCUtil.getConn();
		String sql="insert into Student (stu_no,number,name,grade) values(?,?,?,?)";
		PreparedStatement psmt;
		psmt=(PreparedStatement)conn.prepareStatement(sql);
		psmt.setInt(1, Integer.parseInt(excelCell[mark++].trim()));
		psmt.setString(2, excelCell[mark++].trim());
		psmt.setString(3, excelCell[mark++].trim());
		if((excelCell[mark])==null||(excelCell[mark]).equals("")||(excelCell[mark]).equals("null")) {
			psmt.setInt(4,0);
			mark++;
		}else {
			psmt.setInt(4, Integer.parseInt(excelCell[mark++].trim()));
			
		}
		psmt.executeUpdate();
		psmt.close();
		return mark;
	}

}
