package JDBC;

import java.sql.*;

public class DbUtil {
    public DbUtil(){}

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

                String sql = "insert into test.students (nam,id,age,newtime) values(?,?,?,?)";  //? 占位符
                PreparedStatement ps  = conn.prepareStatement(sql);
                //set 函数传参数。
                ps.setString(1, "小王");  //参数索引从1开始.
                ps.setString(2, "201706");
                ps.setInt(3, 28);
                ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));

                ps.executeUpdate();  //执行
                System.out.println("charujilu");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                if(conn!=null) {
                    conn.close();
                }
            }
        }


    }

