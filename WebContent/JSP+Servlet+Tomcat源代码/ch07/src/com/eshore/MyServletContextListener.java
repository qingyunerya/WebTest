package com.eshore;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;


@WebListener
public class MyServletContextListener implements ServletContextListener{

	private static Logger log = Logger.getLogger("MyServletContextListener");

	public void contextInitialized(ServletContextEvent sce) {
		//ͨ��ServletContextEvent���ServletContext����
		ServletContext context = sce.getServletContext();
		String name = context.getInitParameter("user_name");
		log.debug("��ʼ������name��ֵ��"+name);
		log.debug("Tomcat����������......");
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("Tomcat���ڹر���......");
	}
}
