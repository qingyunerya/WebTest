package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyz.dao.User;

@WebServlet(
		name="memberHtm",
		urlPatterns= {"/Member.htm"},
		loadOnStartup = 0
		)
public class MemberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MemberServlet() {
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
		req.setCharacterEncoding("UTF-8");
		String username=req.getParameter("username");
		System.out.println("进入注册界面");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head>会员登陆</head><body>");
		out.println("<h1>会员登陆成功</h1>");
		req.setCharacterEncoding("UTF-8");
		out.println(req.getParameter("username")+"登陆成功");
		out.println("<a href='login2.jsp'>返回首页登陆</a>");
		out.println("</html>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
}
