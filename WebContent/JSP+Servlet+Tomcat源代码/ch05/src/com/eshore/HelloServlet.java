package com.eshore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.pojo.HelloUser;

@WebServlet(
		name = "helloServlet", 
		urlPatterns = { "/hello.do" })
public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private HelloUser user = new HelloUser();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request,response);//����doPost()����
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("username");//��ȡ����username��ֵ
		String message = user.sayHello(userName);//��ȡ��Ϣֵ
		request.setAttribute("message", message);//���ò���ֵ
		request.getRequestDispatcher("/hello.htm").//��ת��hello.htm
				forward(request, response);
	}
}
