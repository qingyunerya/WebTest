package com.lyz.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns= {"/GetReaderBody"},
		name="getReaderBody"
		)
public class GetReaderBody extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("调用Get方法"+this.getClass().getResource("/").getPath());
		BufferedReader br=req.getReader();
		String input="";
		String body="";
		while((input=br.readLine())!=null)
		{
			body+=input+"br/";
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head><title>a servlet</title></head>");
		out.println("<body>");
		out.println(body);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("调用Post方法"+this.getClass().getResource("/").getPath());
		BufferedReader br=req.getReader();
		String input="";
		String body="";
		while((input=br.readLine())!=null)
		{
			body+=input+"br/";
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head><title>a servlet</title></head>");
		out.println("<body>");
		out.println(body);
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
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
