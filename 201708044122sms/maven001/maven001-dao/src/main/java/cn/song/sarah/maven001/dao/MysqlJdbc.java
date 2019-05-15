package cn.song.sarah.maven001.dao;

import java.sql.*;

import javax.persistence.Entity;
import javax.persistence.Table;
@Table(name = "t3")
@Entity

/*
public class MysqlJdbc {
	public static void main(String[] args) {
        //获得连接数据库连接
        Connection conn=null;
        try {
        //初始化Driver类，注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sarah", "root", "123456");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
*/








public class MysqlJdbc {

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/sarah";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册 JDBC 驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name, url FROM websites";
			ResultSet rs = stmt.executeQuery(sql);

			String kinds = rs.getString("kinds");
			
			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				
				//String kinds = rs.getString("kinds");
				String address = rs.getString("address");
				String volumn = rs.getString("volumn");
				
				
				// 输出数据
				System.out.print("kinds: " + kinds);
				System.out.print(", address: " + address);
				System.out.print(", volumn: " + volumn);
				System.out.print("\n");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}











/*
 * public static void main(String args[]) { try {
 * Class.forName("com.mysql.jdbc.Driver"); //加载MYSQL JDBC驱动程序
 * //Class.forName("org.gjt.mm.mysql.Driver");
 * System.out.println("Success loading Mysql Driver!"); } catch (Exception e) {
 * System.out.print("Error loading Mysql Driver!"); e.printStackTrace(); } try {
 * Connection connect = DriverManager.getConnection(
 * "jdbc:mysql://localhost:3306/tx","root","123456"); //连接URL为
 * jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
 * 
 * System.out.println("Success connect Mysql server!"); Statement stmt =
 * connect.createStatement(); ResultSet rs =
 * stmt.executeQuery("select * from myclass");
 * 
 * while (rs.next()) { System.out.println(rs.getInt(1)+"\t"
 * +rs.getString(2)+"\t" +rs.getString(3)+"\t" +rs.getString(4)+"\t"
 * +rs.getInt(5)+"\t" +rs.getString(6)+"\t" +rs.getString(7)+"\t"
 * +rs.getString(8)+"\t"); } } catch (Exception e) {
 * System.out.print("get data error!"); e.printStackTrace(); }
 * 
 * } }
 */