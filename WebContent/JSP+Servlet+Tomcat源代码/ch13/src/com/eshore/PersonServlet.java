package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PersonServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
			Class.forName("com.mysql.jdbc.Driver");                            //ע�����ݿ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����������ش���");
		}
		try {
			con = DriverManager.
			getConnection("jdbc:mysql://localhost:3306/testWeb","root","admin");//��ȡ���ݿ�����
			st = con.createStatement();                                         //��ȡStatement
			rs = st.executeQuery("select * from person");                       //ִ�в�ѯ�����ؽ����
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>�г���Ա��Ϣ��</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("<center><h4>��Ա��Ϣ�б�</h4>");
			out.println("  <table border=\"1\" width=\"100%\" cellpadding=\"2\" cellspacing=\"1\">");
			out.println("<tr>");
			out.println("<td>ѡ��</td>");
			out.println("<td>����</td>");
			out.println("<td>����</td>");
			out.println("<td>�Ա�</td>");
			out.println("<td>����</td>");
			out.println("<td>��ע</td>");
			out.println("</tr>");
			while(rs.next()){                                      //���������ResultSet
				int id = rs.getInt("id");                          //��ȡID
				String name  = rs.getString("name");               //��ȡ����
				int age = rs.getInt("age");                        //��ȡ����
				String sex  = rs.getString("sex");                 //��ȡ�Ա�
				Date birthday = rs.getDate("birthday");            //��ȡ����
				String description = rs.getString("description");  //��ȡ��ע
				out.println("<tr>");
				out.println("<td><input type=\"checkbox\" name=\"id\" value=\""+id+"\"></td>");
				out.println("<td >"+name+"</td>");
				out.println("<td >"+age+"</td>");	 
				out.println("<td >"+sex+"</td>");
				out.println("<td >"+birthday+"</td>");
				out.println("<td >"+description+"</td>");
			    out.println("</tr>");
			}
			out.println("</table></center>"); 
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try { //��ס�ر�����
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
