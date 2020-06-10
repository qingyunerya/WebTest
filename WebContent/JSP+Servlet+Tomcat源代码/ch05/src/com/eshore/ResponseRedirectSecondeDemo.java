package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseRedirectSecodDemo", 
		urlPatterns = { "/redirSeconde.do" })
public class ResponseRedirectSecondeDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ҳ����Ϣ
		response.setContentType("text/html;charset=UTF-8");// ������Ӧ�����ͺͱ���
		PrintWriter out = response.getWriter();// ȡ��PrintWriter()����
		out.println(" Redirect��תҳ��ĵڶ���ҳ��<br/>");
	}
}
