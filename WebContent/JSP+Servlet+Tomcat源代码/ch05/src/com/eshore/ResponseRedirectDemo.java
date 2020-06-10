package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseRedirectDemo", 
		urlPatterns = { "/redirect.do" })
public class ResponseRedirectDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");// ������Ӧ�����ͺͱ���
		PrintWriter out = response.getWriter();// ȡ��PrintWriter()����
		out.println("  Redirect��תҳ��ĵ�һ��ҳ��<br/>");
		response.sendRedirect(request.getContextPath()+"/redirSeconde.do");
		out.println("  Redirect Servlet<br/>");
		out.close();
	}
}
