package com.eshore;

import java.io.FileNotFoundException;
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


public class CopyOfGetPartBodyContent extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// �õ�ע����Ϣ
	private static final MultipartConfig config;
	static {
		config = CopyOfGetPartBodyContent.class.getAnnotation(MultipartConfig.class);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("file");
		// ����ļ�����
		String filename = getFilename(part);
		part.write(filename);
		// д��ָ��λ��
//		writeToFile(filename, part);
		// ����ҳ����Ϣ
		response.setContentType("text/html;charset=UTF-8");// ������Ӧ�����ͺͱ���
		PrintWriter out = response.getWriter();// ȡ��PrintWriter()����
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <script>alert(\"�ϴ��ɹ�\")</script><BODY>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	// ��ȡ�ļ�����
	private String getFilename(Part part) {
		if (part == null)
			return null;
		String fileName = part.getHeader("content-disposition");
		if (StringUtils.isBlank(fileName)) {
			return null;
		}
		return StringUtils.substringBetween(fileName, "filename=\"", "\"");
	}
	//д�뵽ָ���ļ�
	private void writeToFile(String filename,Part part)
			throws FileNotFoundException,IOException{
		//д��ָ�����ļ���ַ
		InputStream is = part.getInputStream();
		FileOutputStream fos = 
			new FileOutputStream("d:/file/"+filename);
		byte[] b = new byte[1024];
		int len=-1;
		while((len=is.read(b))!=-1){
			fos.write(b,0,len);
		}
		is.close();
		fos.close();
	}
}
