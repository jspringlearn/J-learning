package JDBC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DDBC_Clob {
    public static void main(String[] args) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "123456";
        Connection conn=null;

        try {
            Class.forName(driver);//
            conn = DriverManager.getConnection(url, username, password);

            //插入操作

            String sql = "insert into test.students (nam,info) values(?,?)";  //? 占位符
            PreparedStatement ps  = conn.prepareStatement(sql);
            //set 函数传参数。
            ps.setString(1, "小王");  //参数索引从1开始.
            ps.setClob(2, (new FileReader(new File("D:\\JAVA\\IDEA\\JAVAreview\\信息.txt"))));  //

            ps.executeUpdate();  //执行
            System.out.println("执行成功！！！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
}
