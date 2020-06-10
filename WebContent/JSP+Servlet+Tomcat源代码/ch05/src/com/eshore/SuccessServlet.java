package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "successServlet", urlPatterns = { "/success.htm" })
public class SuccessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);// ����doPost()����
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");// ������Ӧ�����ͺͱ���
		PrintWriter out = response.getWriter();// ȡ��PrintWriter()����
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>������Ա�ɹ�</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("<h2>��Ա,"+request.getParameter("username")+"ע��ɹ�</h2>");
		out.print("<a href=\"" + request.getContextPath()
				+ "/login.jsp\">������ҳ��¼</a>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
