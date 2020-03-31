package com.lyz.servlet;

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
		name="gzipTestservlet",
		urlPatterns= {"/Gzip.action"},
		loadOnStartup = 0,
		displayName = "gzip"
		)
public class GzipTestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GzipTestServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		String[] urls= {
				"http://localhost:8080/WebTest/login2.jsp",
				"http://code.jquery.com/ui/1.10.3/jquery-ui.js",
				"http://localhost:8080/WebTest/login.jsp"	
		};
		
		out.println("<html>");
		out.println("<head><title>helloservlet</title></head>");
		out.println("<body>");
		out.println("这是内容色情");
		out.println("这是内容情色");
		out.println("这是内容赌博");
		/*RequestDispatcher dispatcher=req.getRequestDispatcher("/GetRequestDispatcherDemo");
		dispatcher.include(req, resp);*/
		//resp.sendRedirect(req.getContextPath()+"/download.do");
		//resp.sendError(resp.SC_BAD_REQUEST,"错误请求");
		for(String url:urls) {
			URLConnection connGzip=new URL(url).openConnection();
			connGzip.setRequestProperty("Accept-Encoding", "gzip");
			int lengthGzip=connGzip.getContentLength();
			URLConnection connCommon=new URL(url).openConnection();
			int lengthCommon=connCommon.getContentLength();
			double rate=new Double(lengthGzip)/lengthCommon;
			out.println("<table border='1' cellpadding='0' cellspacing='0'>");
			out.println("<tr><td colspan='3'>网站：url</td></tr>");
			out.println("<tr>");
			out.println("<td>压缩后数据："+lengthGzip+"bytes</td>");
			out.println("<td>压缩前数据："+lengthCommon+"bytes</td>");
			out.println("<td>压缩率："+NumberFormat.getPercentInstance().format(1-rate)+"</td>");
			out.println("</tr>");
			out.println("</table>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}
}
