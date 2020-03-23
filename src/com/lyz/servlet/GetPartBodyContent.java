package com.lyz.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.lang.StringUtils;


@WebServlet(
		urlPatterns= {"/upload.do"},
		name="getPartBodyContent",
		loadOnStartup=0
		)
@MultipartConfig(
		location="F:/tmp/test/",
		maxFileSize=1024*1024*10
		)
public class GetPartBodyContent extends HttpServlet {

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
		req.setCharacterEncoding("UTF-8");
		Part part=req.getPart("filename");
		String filename=getFilename(part.getHeader("content-disposition"));
		System.out.println("调用"+filename);
		part.write(filename);
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

	/*private String getFilename(Part part)
	{
		if(part==null) {
			return null;
		}
		String filename=part.getHeader("content-disposition");
		if(StringUtils.isBlank(filename))
		{
			return null;
			
		}
		return StringUtils.substringBetween(filename, "filename=\"", "\"");
	}*/
	private String getFilename(String textBody)
	{
		int start=textBody.indexOf("filename=\"")+10;
		int end=textBody.indexOf("\"", start);
		String filename=textBody.substring(start,end);
		filename=filename.substring(filename.lastIndexOf("\\")+1);
		return filename;
	}
}
