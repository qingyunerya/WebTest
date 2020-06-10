package com.eshore;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseReplaceWrapper extends HttpServletResponseWrapper{

	private CharArrayWriter charWriter = new CharArrayWriter();
	public ResponseReplaceWrapper(HttpServletResponse response) {
		//������ø��๹�췽��
		super(response);
	}
    
	public PrintWriter getWriter() throws IOException{
		//�����ַ�����Writer����������
		return new PrintWriter(charWriter);
	}

	public CharArrayWriter getCharWriter() {
		return charWriter;
	}
}
