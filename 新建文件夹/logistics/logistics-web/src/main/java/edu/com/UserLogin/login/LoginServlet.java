package edu.com.UserLogin.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import edu.com.UserLogin.Utils.JdbcUitls;
import edu.com.UserLogin.domain.student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet 响应");
		//1.获取请求参数
		String name=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		System.out.println("name="+name+"pwd="+pwd);
		//2.连接数据库
		QueryRunner qr=new QueryRunner(JdbcUitls.getDataSource());
		String sql="select * from student where name=? and pwd=?";
		student stu=null;
		try {
			stu=qr.query(sql, new BeanHandler<student>(student.class),name,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//检查用户名密码是否正确
		if(stu!=null) {
			response.getWriter().write("Login Success!");
		}else
		{
			response.getWriter().write("Login failed!");
		}
	}

}
