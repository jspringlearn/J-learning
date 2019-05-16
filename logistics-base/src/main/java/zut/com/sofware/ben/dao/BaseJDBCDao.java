package zut.com.sofware.ben.dao;

import java.sql.*;

public class BaseJDBCDao {

	
		public static final String DRIVER="com.mysql.jdbc.Driver";
		public static final String URL="jdbc:mysql://localhost/webchat";
		public static final String USERNAME="root";
		public static final String PASSWORD="root";
		//获得conn
		public Connection getConn(){
			Connection conn=null;
			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
		//释放资源
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
		/**
		 * 数据库操作
		 * @param sql 带问号的SQL语句
		 * @param params 与问号对应的参数数组
		 * @return 受影响的行数
		 */
		public int exeUpd(String sql,String[] params){
			int flag=0;
			Connection conn=null;
			PreparedStatement ps=null;
			try {
				conn=this.getConn();
				ps=conn.prepareStatement(sql);
				
				for (int i = 0; i < params.length; i++) {
					ps.setString(i+1, params[i]);
				}
				flag=ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(null, ps, conn);
			}
			return flag;
		}
}
