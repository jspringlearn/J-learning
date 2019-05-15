package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Blob {
    public static void main(String[] args)
            throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "123456";
        Connection conn=null;

        try {
            Class.forName(driver);//
            conn = DriverManager.getConnection(url, username, password);

            //插入操作

//            String sql = "insert into test.students (nam,image) values(?,?)";  //? 占位符
//            PreparedStatement ps  = conn.prepareStatement(sql);
            //set 函数传参数。
//            ps.setString(1, "shanshan");  //参数索引从1开始.
//            ps.setBlob(2, new FileInputStream("D:/JAVA/IDEA/JAVAreview/图片.jpg"));  //这里使用默认的jpg，我用的别的文件扩展就不对



            //取出信息。。

           PreparedStatement ps=conn.prepareStatement("select from test.students where nam=?");
            ps.setObject(1,"shanshan");

            ps.executeUpdate();  //执行


            System.out.println("执行成功！！！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) {
                conn.close();
            }
        }
    }
}

