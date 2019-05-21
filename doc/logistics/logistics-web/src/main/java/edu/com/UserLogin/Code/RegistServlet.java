package edu.com.UserLogin.Code;

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
		// �����������
		String code=request.getParameter("code");
		System.out.println(code);
		
		//�����������
//		byte[] bytes = code.getBytes("ISO8859-1");
//		code=new String(bytes,"UTF-8");
//		System.out.println(code);
		
		String word=(String) this.getServletContext().getAttribute("checkCode");
		System.out.println(word);
		//�����ַ���
		response.setContentType("text/html;charset=UTF-8");
		//�������Ա�
		if(code.equals(word)) {
			response.getWriter().write("ע��ɹ���");
		}else {
			response.getWriter().write("��֤�����");
			//�����뷵��ע�����
			response.setHeader("refresh","3;url=http://localhost:8080/ceshi/code.html");
		}
	}

}
