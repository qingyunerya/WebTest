package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "errorServlet", urlPatterns = { "/error.htm" })
public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);// ����doPost()����
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");//������Ӧ�����ͺͱ���
		PrintWriter out = response.getWriter();//ȡ��PrintWriter()����
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>������Աʧ��</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("<h2>������Աʧ��</h2>");
		//����������Ϣ
		List<String> list = (List<String>)request.getAttribute("errors");
		for(String str:list){
			out.println(str+"<br>");
		}
		out.print("<a href=\""+request.getContextPath()+"/register.jsp\">����ע����ҳ</a>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
