package com.eshore;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestEncodingWrapper extends HttpServletRequestWrapper{

	private String encoding="";
	public RequestEncodingWrapper(HttpServletRequest request) {
		//������ø��๹�췽��
		super(request);
	}
	public RequestEncodingWrapper(HttpServletRequest request,String encoding) {
		//������ø��๹�췽��
		super(request);
		this.encoding = encoding;
	}
	//���¶���getParameter����
	public String getParameter(String name){
		String value = getRequest().getParameter(name);
		try {
			//������ֵ���б���ת��
			if(value!=null&&!"".equals(value))
				value = new String(value.trim().getBytes("ISO-8859-1"), encoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
