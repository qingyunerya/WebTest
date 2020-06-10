package com.eshore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetReaderBody3 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����Body
		byte[] body = readBody(request);
		//�����ݽ���ͳһ����
		String textBody = new String(body,"UTF-8");
		//����ļ�����
		String filename = getFilename(textBody);
		//ȡ���ļ���ʼ�ͽ���λ��
		Integer[] p = getFilePosition(request, textBody);
		//д��ָ��λ��
		writeToFile(filename, body,p);
		//����ҳ����Ϣ
		response.setContentType("text/html;charset=UTF-8");//������Ӧ�����ͺͱ���
		PrintWriter out = response.getWriter();//ȡ��PrintWriter()����
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <script>alert(\"�ϴ��ɹ�\")</script><BODY>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	//��ȡ�����������
	private byte[] readBody(HttpServletRequest request) 
					throws IOException{
		//��ȡ�������ݳ���
		int len = request.getContentLength();
		//��ȡ�����������
		InputStream is = request.getInputStream();
		//�½�һ�ֽ�����
		byte b[] = new byte[len];
		int total = 0;
		while(total<len){//��ȡ�ֽ���
			int bytes = is.read(b, total, len);
			total += bytes;
		}
		return b;
	}
	//����λ����Ϣ���ⲿ��Ҫ����ʵ�ʵ��ļ����н���
	private Integer[] getFilePosition(HttpServletRequest request,
			String textBody)throws IOException{
		//�����������
		String contentType = request.getContentType();
		//��ȡ�ļ����ظ�������
		String text = contentType.
				substring(contentType.indexOf("=")+1, contentType.length());
		int pos = textBody.indexOf("filename=\"");
		pos = textBody.indexOf("\n",pos)+1;
		pos = textBody.indexOf("\n",pos)+1;
		pos = textBody.indexOf("\n",pos)+1;
		//��ȡ����Ҫ���ַ��������Ҫ����ʵ�ʵ��ļ����н���
		int location = textBody.indexOf(text,pos)-11;
		int begin = ((textBody.substring(0, pos)).getBytes("UTF-8")).length;
		int end = ((textBody.substring(0, location)).getBytes("UTF-8")).length;
		Integer[] position = new Integer[2];
		position[0]=begin;
		position[1]=end;
		return position;
	}
	//��ȡ�ļ�����
	private String getFilename(String bodyText){
		String filename = bodyText.substring(bodyText.indexOf("filename=\"")+10);
		filename = filename.substring(filename.lastIndexOf("\\")+1,filename.indexOf("\""));
		return filename;
	}
	//д�뵽ָ���ļ�
	private void writeToFile(String filename,byte[] body,Integer[] p)
			throws FileNotFoundException,IOException{
		//д��ָ�����ļ���ַ
		FileOutputStream fileOutputStream = 
			new FileOutputStream("d:/file/"+filename);
		fileOutputStream.write(body, p[0], (p[1]-p[0]));
		fileOutputStream.flush();
		fileOutputStream.close();//ע��ر������
	}
}
