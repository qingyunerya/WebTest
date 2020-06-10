package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/gzip.action" }, 
		loadOnStartup = 0, 
		name = "gzipServlet" 
	)
public class GzipServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	    String[] urls = {//����һ��URL��ַ
	        	"http://localhost:8080/ch07/11.png",
	        	"http://code.jquery.com/ui/1.10.3/jquery-ui.js",
	        	"http://localhost:8080/ch07/login.jsp"
	         };
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>��������ѹ���������</TITLE></HEAD>");
		out.println("  <BODY>");
		
		for(String url:urls){
			//ģ��һ�������
            URLConnection connGzip = new URL(url).openConnection();
            //ģ��ʵ��������ı�ͷ��Ϣ֧��gzipѹ����ʽ
     		connGzip.setRequestProperty("Accept-Encoding", "gzip");
     		int lengthGzip = connGzip.getContentLength();//��ȡѹ����ĳ���
     		//ģ����һ�������
     		URLConnection connCommon = new URL(url).openConnection();
     	    int lengthCommon = connCommon.getContentLength();//��ȡѹ��ǰ�ĳ���
    	    double rate = new Double(lengthGzip)/lengthCommon;//����ѹ������
    	    out.println("<table border=\"1\" cellpadding=\"2\" cellspacing=\"1\">");
    	    out.println("<tr>");
    	    out.println("<td colspan=\"3\">��ַ��"+url+"</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td>ѹ�������ݣ�"+lengthGzip+"byte</td>");
    	    out.println("<td>ѹ��ǰ���ݣ�"+lengthCommon+"byte</td>");
    	    out.println("<td>ѹ����&nbsp;&nbsp;��"+NumberFormat.getPercentInstance().format(1-rate)+"</td>");
    	    out.println("</tr>");
    	    out.println("</table>");
        }
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}
}
