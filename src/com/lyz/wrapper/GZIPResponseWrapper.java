package com.lyz.wrapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.lyz.io.GZIPResponseStream;

public class GZIPResponseWrapper extends HttpServletResponseWrapper{

	private HttpServletResponse response=null;
	private ServletOutputStream outputStream=null;
	private PrintWriter printWriter=null;
	public GZIPResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
		this.response=response;
	}
	public ServletOutputStream createOutputStream()throws IOException{
		
		return (new GZIPResponseStream(response));	
	}
	public void finishResponse() {
		
		try {
			if(printWriter!=null) {
				printWriter.close();
			}else {
				if(outputStream!=null) {
						outputStream.close();
					} 
				}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void flushBuffer() throws IOException {
		outputStream.flush();
	}
	public ServletOutputStream getOutputStream() throws IOException {
		if(printWriter!=null) {
			throw new IllegalStateException("getOutStream已经被回调");
		}
		if(outputStream==null) 
			outputStream=createOutputStream();
			return (outputStream);
	}
	public PrintWriter getWriter() throws IOException {
		if(printWriter!=null) {
			return (printWriter);
		}
		if(outputStream!=null) {
			throw new IllegalStateException("getOutputStream() has already been called");
		}
		outputStream=createOutputStream();
		printWriter=new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
		return (printWriter);
	}
	public void setContentLength(int length) {}	
}