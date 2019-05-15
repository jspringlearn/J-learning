package JDBC;

import java.sql.*;

public class DbUtil_pichuli {
    public DbUtil_pichuli(){}

    public static void main(String[] args) throws SQLException {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mysql";
            String username = "root";
            String password = "123456";
        Connection conn=null;

            try {
                Class.forName(driver);//
                conn = DriverManager.getConnection(url, username, password);

               conn.setAutoCommit(false);// 改为手动提交

                Statement sm  = conn.createStatement();
                //set 函数传参数。
                for(int i=1;i<=20000;i++)
                    sm.addBatch("insert into test.tt (nam,nowtime) values ('xiao"+i+"',2019/5/2");

               sm.executeBatch();
               conn.commit();
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

