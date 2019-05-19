package software.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class PerparedStatementTest {
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	public void insertUseStatement() throws Exception {

		long start=System.currentTimeMillis();

		try (Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement()) {
			for(int i=0;i<100;i++) {
				stmt.executeUpdate("insert into student_table values("+"null,'姓名"+i+"',1)");
			}
			System.out.println("Statement费时为："+(System.currentTimeMillis()-start));
		}

	}
	public void insertUsePrepare() throws Exception {

		long start=System.currentTimeMillis();

		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement("insert into student_table values(null,?,1)")) {
			for(int i=0;i<100;i++) {
				pstmt.setString(1,"姓名"+i);
				pstmt.executeUpdate();
			}
			System.out.println("PreparedStatement费时为："+(System.currentTimeMillis()-start));
		}

	}

	public static void main(String[] args) throws Exception {
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
		Class.forName(driver);
		PerparedStatementTest pt=new PerparedStatementTest();
		pt.insertUseStatement();
		pt.insertUsePrepare();

	}

}
