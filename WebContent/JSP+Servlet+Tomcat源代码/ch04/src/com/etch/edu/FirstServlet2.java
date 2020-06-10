package com.etch.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet2 extends HttpServlet {
    
	//���л�  �����Զ����ɻ������ж���
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
    	System.out.println("��ʼ��  init()");
    }
	 
	public void doGet(HttpServletRequest request, 
			          HttpServletResponse response)
	               throws ServletException,IOException
	{
		System.out.println("���� doGet����");
        //������Ӧ��ҳ������ҳ�����
	    response.setContentType("text/html;charset=gbk");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>����0��10ѭ�����</title>");
        out.println("<body>");
        out.println("��ʼִ�С���������");
        int count=0;
        for(int i=0;i<=10;i++){
        	count+=i;
        }
        out.println("����ִ�н����"+count);
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
	}
	public void doPost(HttpServletRequest request, 
	          		HttpServletResponse response)
    			     throws ServletException,IOException{
		doGet(request,response);
	}
	public void destory(){
		System.out.println("���� destory()����");
	}
}