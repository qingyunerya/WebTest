package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns= {"/diaocha.do"},
		name="starSurvey",
		loadOnStartup=0
		)
public class StarSurvey extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("调用Post方法"+this.getClass().getResource("/").getPath());
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		String[] starname=req.getParameterValues("starname");
		String starinfo=null;
		for(int i=0;i<starname.length;i++)
		{
			starinfo+=starname[i]+",";
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head><title>调查结果</title></head>");
		out.println("</head>");
		out.println("<body>");
		out.println("姓名："+name+"<br/>"+"邮件："+email+"<br/>"+starinfo);
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

}
