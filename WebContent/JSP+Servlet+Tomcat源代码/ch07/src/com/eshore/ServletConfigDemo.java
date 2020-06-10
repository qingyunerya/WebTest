package com.eshore;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(
	urlPatterns = { "/servletConfigDemo.do" }, 
	loadOnStartup = 1, 
	name = "ServletConfigDemo", 
	displayName = "demo", 
	initParams = { 
		@WebInitParam(name = "success", value = "success.html"), 
		@WebInitParam(name = "error", value = "error.html")
	}
)
public class ServletConfigDemo extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡServletConfig����   
        ServletConfig config = getServletConfig();  
          
        //1.getInitParameter(name)����   
        String success = config.getInitParameter("success");  
        String error = config.getInitParameter("error");  
          
        System.out.println("success-----------"+success);  
        System.out.println("error-----------"+error);  
          
        //2.getInitParameterNames����   
        Enumeration enumeration = config.getInitParameterNames();  
        while(enumeration.hasMoreElements()){  
            String name = (String) enumeration.nextElement();  
            String value = config.getInitParameter(name);  
            System.out.println("name-----------"+name);  
            System.out.println("value-----------"+value);  
        }  
        //3.getServletContext����   
        ServletContext servletContext = config.getServletContext();  
        System.out.println("servletContext-----------"+servletContext);  
        //4.getServletName����   
        String servletName = config.getServletName();  
        System.out.println("servletName-----------"+servletName);
		 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		//�ж��Ƿ���linl�û������������
		if(userId!=null&&"linl".equals(userId)
				&&passwd!=null&&"123456".equals(passwd)){
			//���sessioin����
			HttpSession session = request.getSession();
			//����user����
			session.setAttribute("user", userId);
			//��תҳ��
			RequestDispatcher dispatcher = request.
					getRequestDispatcher(success);
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.
					getRequestDispatcher(error);
			dispatcher.forward(request, response);
		}
	}
	
	public void init() throws ServletException {
		 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public ServletConfigDemo() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
}
