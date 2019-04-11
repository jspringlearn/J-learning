package software.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TransactionTest {

	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	public void initParam(String paramFile) throws Exception{
		Properties props=new Properties();
		props.load(new FileInputStream(paramFile));
		driver=props.getProperty("driver");
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
	//	Class.forName(driver);
	}
	public void insertInTransaction(String[] sqls) throws Exception {
		Class.forName(driver);
		try(Connection conn=DriverManager.getConnection(url,username,password)){
			//�ر��Զ��ύ����������
			conn.setAutoCommit(false);
			try(
					//ʹ��Connection����Statment����
					Statement stmt=conn.createStatement()){
				for(String sql:sqls) {
					stmt.executeUpdate(sql);
				}
			}
			//�ύ���� 
			conn.commit();
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TransactionTest tt=new TransactionTest();
		tt.initParam("mysql.ini");
		String[] sqls=new String[] {
				"insert into student_table values(null,'aaa',1)",
				"insert into student_table values(null,'bbb',1)",
				"insert into student_table values(null,'ccc',1)",
				"insert into student_table values(null,'ccc',5)",//1Υ�����Լ������
		};
		tt.insertInTransaction(sqls);
		

	}

}
