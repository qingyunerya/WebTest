package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/HelloServlet"},
		name="helloServlet",
		loadOnStartup = 0
)
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("调用Get方法");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
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
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		//System.out.println("调用Get方法"+this.getClass().getResource("/").getPath());
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("调用post方法");
		doGet(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		//System.out.println("调用protected service方法");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		//System.out.println("调用service方法");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("调用destroy方法");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//System.out.println("调用init方法");
	}
	

}
