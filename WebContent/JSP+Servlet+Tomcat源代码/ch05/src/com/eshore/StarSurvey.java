package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "starSurvey", 
		urlPatterns = { "/diaocha.do" })
public class StarSurvey extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��������ı�������
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String[] starname = request.getParameterValues("starname");
		// ������Ӧ�����ͺͱ���
		response.setContentType("text/html;charset=UTF-8");
		// ȡ��PrintWriter()����
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>��л���ĵ���</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("��ϵ�ˣ�<a href='"+email+"'>"+username+"</a>");
		out.println("<br/>ϲ�������ǣ�");
		String str = "";
		for(int i=0;i<starname.length;i++){
			str +=starname[i]+"��";
		}
		str = str.substring(0, str.length()-1);
		out.println(str);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.close();
	}
}
