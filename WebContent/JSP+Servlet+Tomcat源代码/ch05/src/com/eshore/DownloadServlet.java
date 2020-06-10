package com.eshore;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "downloadServlet", urlPatterns = { "/download.do" })
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������Ӧ����������
		response.setContentType("application/msword");
		//������Ӧ�ı�ͷ����
		response.addHeader("Content-disposition","attachment;filename=test.doc");
		//��ȡ��Դ�ļ�
		InputStream in = getServletContext().getResourceAsStream("/doc/test.doc");
		//������������
		ServletOutputStream os = response.getOutputStream();
		byte[] bytes = new byte[1024];
		int len = -1;
		while((len=in.read(bytes))!=-1){
			os.write(bytes, 0, len);
		}
		//�ر����������
		in.close();
		os.close();
	}
}
