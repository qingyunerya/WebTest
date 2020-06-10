package com.eshore;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
	urlPatterns = { "/servletContextDemo.do" }, 
	loadOnStartup = 0, 
	name = "ServletContextDemo", 
	displayName = "demo", 
	initParams = { 
		@WebInitParam(name = "dir", value = "/dir"), 
		@WebInitParam(name = "success", value = "success.html"),
		@WebInitParam(name = "resourcePath", value = "/dir/test.txt")
	}
)
public class ServletContextDemo extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dir = getInitParameter("dir");
		String success = getInitParameter("success");
		String resourcePath = getInitParameter("resourcePath");
		//��ȡServletContext����   
		ServletContext context =  getServletContext();
		//getRealPath�����ʵ·��
		String path = context.getRealPath(success);
		System.out.println("path��ʵ·��-----"+path);
		//getResourcePaths���ָ��·��������
		Set set = context.getResourcePaths(dir);
		for(Object str:set){
			System.out.println("�ļ�����-----"+(String)str);
		}
		//��÷������汾
		String serverInfo = context.getServerInfo();
		System.out.println("��÷������汾-----"+serverInfo);
		//getResourceAsStream�����Դ�ļ�����
		InputStream in = context.getResourceAsStream(resourcePath);
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		while(in.read(buffer)!=-1){
			out.write(buffer);
		}
		in.close();
		out.close();
	}
	
	public void init() throws ServletException {
		 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public ServletContextDemo() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
}
