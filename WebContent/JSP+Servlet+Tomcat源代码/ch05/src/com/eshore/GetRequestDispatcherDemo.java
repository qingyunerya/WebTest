package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "getDispatcherDemo", 
		urlPatterns = { "/include.do" }, 
		loadOnStartup = 0)
public class GetRequestDispatcherDemo extends HttpServlet {

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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("  The First Servlet<br/>");
		//��ȡRequestDispatcher����
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/includeSeconde.do");
		dispatcher.include(request, response);
		out.println("  Including Servlet<br/>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.close();
	}
}
