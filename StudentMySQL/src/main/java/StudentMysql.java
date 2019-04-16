import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	
public class StudentMysql {
	   public static void main(String[] args)  {
	    String url="jdbc:mysql://127.0.0.1:3306/sampledb";
	    String username="root",password="20161121bin";
	       Connection con = null;
	       try {
	       	Class.forName("com.mysql.jdbc.Driver");
	       	con=DriverManager.getConnection(url, username, password);
	        Statement stmt=con.createStatement();
	        ResultSet rs=stmt.executeQuery("select * from t_user");
	       	while(rs.next())
	       	{
	        	System.out.println(rs.getString("user_name")+"\t"+rs.getString("password"));
	       	}
	       	rs.close();stmt.close();
	       }catch(SQLException e) {
	       	e.printStackTrace();
	       }catch(ClassNotFoundException e) {
	       	e.printStackTrace();
	       }finally {
	       	try {
	       		con.close();
	       }catch(SQLException e) {
	       	e.printStackTrace();
	       }
	       	}
	       }
	   }
	
	
