package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyz.dao.HelloUser;

@WebServlet(
		name="helloHtml",
		urlPatterns= {"/Hello.htm"},
		loadOnStartup = 0
		)
public class HelloHtml extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HelloHtml() {
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
		String message=req.getParameter("message");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(message+"用户");
		out.flush();
		out.close();
		
	}

}
