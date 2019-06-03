package software.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {
	public static String driver;
	public static String url;
	public static String username;
	public static String password;

	public int insertData(String sql) throws Exception {

		Class.forName(driver);

		try (Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement()) {
			return stmt.executeUpdate(sql);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		File fil = new File("./dbcpCfg.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fil);
			props.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		// System.out.println(driver+" "+url+" "+username+" "+password);

		ExecuteDML pe = new ExecuteDML();
		int result=-1;
		try {
			result=pe.insertData("insert into jdbc_test(jdbc_name,jdbc_desc)"
					+"select s.student_name , t.teacher_name"
					+ "from student_table s,teacher_table t"
					+"where s.java_teacher =t.teacher_id;");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------"+result+"---------");

	}

}