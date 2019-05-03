package JDBC_Model;

import jdk.internal.dynalink.beans.StaticClass;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBC_Util {
    static Properties pros=null; //帮助读取信息
    static{  //加载JDBCUtil 该类时调用，且只调用一次！！(静态代码块)
        pros=new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public static Connection getConn(){
       Connection conn=null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "123456");
            Class.forName(pros.getProperty("mysqlDriver"));
            conn = (Connection) DriverManager.getConnection(pros.getProperty("mysqlURL"),
                    pros.getProperty("mysqlusername"),
                    pros.getProperty("mysqlpassword"));
            return conn;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public  static void close(ResultSet rs,Statement stmt,Connection conn){
        try {
            if(stmt!=null){
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  static void close(Statement stmt,Connection conn){
        try {
            if(stmt!=null){
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  static void close(Connection conn){
       try{
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }







}
