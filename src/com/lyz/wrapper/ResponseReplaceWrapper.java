package com.lyz.wrapper;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseReplaceWrapper extends HttpServletResponseWrapper{

	private CharArrayWriter charWriter=new CharArrayWriter();
	public ResponseReplaceWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}
	public CharArrayWriter getCharWritter() {
		return charWriter;
	}
	public PrintWriter getWriter() {
		
		return new PrintWriter(charWriter);
	}
	
	
}