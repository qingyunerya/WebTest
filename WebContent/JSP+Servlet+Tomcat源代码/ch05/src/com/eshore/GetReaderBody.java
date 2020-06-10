package com.eshore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetReaderBody extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = request.getReader();//��ȡBufferedReader����
		String input ="";
		String body = "";
		while((input = br.readLine())!=null){//����body����
			body+=input+"<br/>";
		}
		response.setContentType("text/html;charset=UTF-8");//������Ӧ�����ͺͱ���
		PrintWriter out = response.getWriter();//ȡ��PrintWriter()����
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(body);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
