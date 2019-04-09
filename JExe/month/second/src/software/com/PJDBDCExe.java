package software.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PJDBDCExe {
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	
	

	public void createTable(String sql) throws Exception {
		
			Class.forName(driver);
		
		try (
			Connection conn=DriverManager.getConnection(url, username, password);
			Statement stmt=conn.createStatement()){
				stmt.executeUpdate(sql);
			}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props=new Properties();
		File fil=new File("./dbcpCfg.properties");
		FileInputStream fis=null;
		try {
		    fis=new FileInputStream(fil);
			props.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver=props.getProperty("driver");
		url=props.getProperty("url");
		username=props.getProperty("username");
		password=props.getProperty("password");
		//System.out.println(driver+" "+url+" "+username+" "+password);
		
		PJDBDCExe pe=new PJDBDCExe();
		try {
			pe.createTable("create table jdbc_test"
			+"(jdbc_id int auto_increment primary key,"
			+"jdbc_name varchar(255),"
			+"jdbc_desc text);");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
