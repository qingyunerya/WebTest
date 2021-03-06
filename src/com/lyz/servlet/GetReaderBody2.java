package com.lyz.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns= {"/GetReaderBody2"},
		name="getReaderBody2"
		)
public class GetReaderBody2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("调用Post方法"+this.getClass().getResource("/").getPath());
		byte[] body=readBody(req);
		String textBody=new String(body,"UTF-8");
		//System.out.println("内容"+textBody);
		String filename=getFilename(textBody);
		//System.out.println("文件名："+filename+"结束");
		writeToFile(filename, body);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head><title>上传文件</title></head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script>alert(\"上传成功\");</script>");
		out.println("</body>");
		out.println("</html>");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	private byte[] readBody(HttpServletRequest req) throws IOException {
		int len=req.getContentLength();
		InputStream is =req.getInputStream();
		int total=0;
		byte[] b =new byte[len];
		while(total<len) {
			int bytes=is.read(b,total,len);
			total+=bytes;
		}
		
		return b;
	}
	private void writeToFile(String filename ,byte[] body) throws IOException
	{
		FileOutputStream fos=new FileOutputStream("F:\\"+filename);
		fos.write(body);
		fos.flush();
		fos.close();
	}
	private String getFilename(String textBody)
	{
		int start=textBody.indexOf("filename=\"")+10;
		int end=textBody.indexOf("\"", start);
		String filename=textBody.substring(start,end);
		filename=filename.substring(filename.lastIndexOf("\\")+1);
		return filename;
	}

	

}
