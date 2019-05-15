package JDBC_Model;


import java.sql.*;

public class Demo_Util {
    public static void main(String[] args) throws SQLException {

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {
            conn = JDBC_Util.getConn();

            String sql = "insert into test.students (nam,id,age,newtime) values(?,?,?,?)";  //? 占位符
            ps  = conn.prepareStatement(sql);
            //set 函数传参数。
            ps.setString(1, "小王");
            ps.setString(2, "201706");
            ps.setInt(3, 28);
            ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));

            ps.executeUpdate();  //执行
            System.out.println("charujilu");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JDBC_Util.close(ps,conn);
        }

    }

}
