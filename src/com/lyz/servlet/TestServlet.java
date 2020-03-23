package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(
		urlPatterns = {"/HelloServlet"},
		name="helloServlet"
)
*/
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("欢迎收到doGet方法");
		out.println("<br/><center>九九乘法表</center>");
		out.println("<table align='center' style='border-collapse:collapse;border:1px solid #aaccbb;border-radius:5px;'>");
		for(int a=1;a<10;a++)
		{
			out.println("<tr style=\"padding:2px; border: 1px solid #aaccdd\">");
			for(int b=1;b<10;b++)
			{
				out.println("<td style=\"padding:2px; border: 1px solid #aaccdd\">");
				out.println(""+a*b);
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	

}
