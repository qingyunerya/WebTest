package com.lyz.wrapper;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestEncodingWrapper extends  HttpServletRequestWrapper {

	private String encoding="";
	public RequestEncodingWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	public RequestEncodingWrapper(HttpServletRequest request,String encoding) {
		super(request);
		this.encoding=encoding;
		// TODO Auto-generated constructor stub
	}
	public String getParameter(String name) {
		String value =getRequest().getParameter(name);
		if(value!=null&&value.equals("")) {
			try {
				value=new String(value.trim().getBytes("ISO-8859-1"),encoding);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}


}
