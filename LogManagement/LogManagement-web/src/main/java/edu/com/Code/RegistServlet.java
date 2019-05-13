package edu.com.Code;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接受请求参数
		String code=request.getParameter("code");
		System.out.println(code);
		
		//解决乱码问题
//		byte[] bytes = code.getBytes("ISO8859-1");
//		code=new String(bytes,"UTF-8");
//		System.out.println(code);
		
		String word=(String) this.getServletContext().getAttribute("checkCode");
		System.out.println(word);
		//设置字符集
		response.setContentType("text/html;charset=UTF-8");
		//两个作对比
		if(code.equals(word)) {
			response.getWriter().write("注册成功！");
		}else {
			response.getWriter().write("验证码错误！");
			//隔三秒返回注册界面
			response.setHeader("refresh","3;url=http://localhost:8080/ceshi/code.html");
		}
	}

}
