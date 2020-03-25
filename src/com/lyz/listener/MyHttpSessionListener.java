package com.lyz.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener{


	private static int count;
	public static int getCount() {
		return count;
	}
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		MyHttpSessionListener.count++;
		System.out.println("session创建中");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		MyHttpSessionListener.count--;
		System.out.println("session消灭中");
	}
}