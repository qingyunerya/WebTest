package com.lyz.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyz.dao.HelloUser;

@WebServlet(
		name="ServletContextDemo",
		urlPatterns = {"/servletContextDemmo.do"},
		loadOnStartup = 1,
		displayName = "demo",
		initParams = {
				@WebInitParam(name="dir",value = "/WEB-INF/classes"),
				@WebInitParam(name="success",value="login.jsp"),
				@WebInitParam(name="resourcePath",value="/WEB-INF/web.xml")	
		}
		
		)
public class ServletContextDemo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ServletContextDemo() {
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
		String dir=getInitParameter("dir");
		
		String success=getInitParameter("success");
		
		String resourcePath=getInitParameter("resourcePath");
		
		ServletContext context=getServletContext();
		
		String path=context.getRealPath(success);
		System.out.println("文件真实路径："+path);
		Set<String> set=context.getResourcePaths(dir);
		for(Object o:set) {
			System.out.println("文件内容："+o);
		}
		InputStream in=context.getResourceAsStream(resourcePath);
		OutputStream out=resp.getOutputStream();
		byte[] buffer=new byte[2048];
		while(in.read(buffer)!=-1) {
			out.write(buffer);
		}
		String info=context.getServerInfo();
		System.out.println("获取服务器版本："+info);
		in.close();
		out.close();
		
	}

}
