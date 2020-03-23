package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyz.dao.HelloUser;

@WebServlet(
		name="successServlet",
		urlPatterns= {"/success.htm"}
		)
public class SuccessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SuccessServlet() {
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
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head>新增会员成功</head><body>");
		out.println("<h1>新增会员成功</h1>");
		req.setCharacterEncoding("UTF-8");
		out.println(req.getParameter("username")+"注册成功");
		out.println("<a href='login2.jsp'>返回首页</a>");
		out.println("</html>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		
	}

}
