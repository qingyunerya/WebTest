
package com.lyz.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="downloadServlet",
		urlPatterns= {"/download.do"}
		)
public class DownloadServlet extends HttpServlet {

	/**
	 *   
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/msword");
		resp.setHeader("content-disposition","attachment;filename=test.doc");
		InputStream is=getServletContext().getResourceAsStream("/doc/test.doc");
		ServletOutputStream sos=resp.getOutputStream();
		byte[] b=new byte[1024];
		int len=-1;
		while((len=is.read(b))!=-1)
		{
			sos.write(b, 0, len);
		}
		is.close();
		sos.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
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
	

}
