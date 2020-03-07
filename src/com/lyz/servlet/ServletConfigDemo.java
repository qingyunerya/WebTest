package com.lyz.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		loadOnStartup = 0,
		name = "servletConfigDemo",
		urlPatterns = {"/ServletCongigDemo.do"},
		displayName = "demo",
		initParams= {
				@WebInitParam(name = "error", value = "success.html"),
				@WebInitParam(name = "success", value = "error.html")
		}
		)

public class ServletConfigDemo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig config=getServletConfig();
		String success=config.getInitParameter("success");
		String error=config.getInitParameter("error");
		System.out.println("success"+success+"error"+error+"\n"+getServletInfo()+"\n"+getServletContext());
		Enumeration<String> enumeration=getInitParameterNames();
		while(enumeration.hasMoreElements())
		{
			String name=(String) enumeration.nextElement();
			String value=getInitParameter(name);
		}
		
	}
}
