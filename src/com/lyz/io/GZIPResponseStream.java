package com.lyz.io;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.zip.GZIPOutputStream;


public class GZIPResponseStream extends ServletOutputStream{
	protected ByteArrayOutputStream bArrayOutputStream=null;
	protected GZIPOutputStream gzipOutputStream =null;
	protected Boolean closed=false;
	protected HttpServletResponse response=null;
	protected ServletOutputStream outputStream=null;
	public GZIPResponseStream(HttpServletResponse response) throws IOException {
		super();
		closed=false;
		this.response=response;
		outputStream=response.getOutputStream();
		bArrayOutputStream=new ByteArrayOutputStream();
		gzipOutputStream=new GZIPOutputStream(bArrayOutputStream);
		
	}
	
	public void close() throws IOException {
		if(closed) {
			throw new IOException("输出流已经关闭了");
		}
		gzipOutputStream.finish();
		byte[] bytes=bArrayOutputStream.toByteArray();
		response.addHeader("Content-Length", Integer.toString(bytes.length));
		response.addHeader("Content-Encoding", "gizp");
		outputStream.write(bytes);
		System.out.println("调用io");
		outputStream.flush();
		outputStream.close();
		closed=true;
	}
	public void flush() throws IOException {
		if(closed) {
			throw new IOException("不能关闭刷新的数据流");
		}
		gzipOutputStream.flush();
	}
	public void write(int b) throws IOException {
		if(closed) {
			throw new IOException("输出流关闭中");
		}
		gzipOutputStream.write((byte)b);
	}
	public void write(byte[] b) throws IOException {
		write(b,0,b.length);
	}
	public void write(byte[] b,int off,int len)throws IOException{
		if(closed) {
			throw new IOException("输出流关闭中");
		}
		gzipOutputStream.write(b, off, len);
		
	}
	public Boolean closed() {
		return (this.closed());
	}
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub
		
	}
}
