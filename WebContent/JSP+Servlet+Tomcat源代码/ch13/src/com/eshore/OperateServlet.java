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

public class OperateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OperateServlet() {
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
		request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String description = request.getParameter("description");
        String sql = "insert into person(name,age,sex,birthday,description) "+
                     "values('"+name+"','"+age+"','"+sex+"','"+birthday+"','"+description+"')";
        Connection con = null;
        Statement st = null;
        int  result = 0;
        try {
			Class.forName("com.mysql.jdbc.Driver");//ע�����ݿ�
			con = DriverManager.
			getConnection("jdbc:mysql://localhost:3306/testWeb","root","admin");//��ȡ���ݿ�����
			st = con.createStatement();            //��ȡStatement
			result = st.executeUpdate(sql);        //ִ�в�ѯ�����ؽ����
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>�г���Ա��Ϣ��</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("");
			out.println("<a href=\""+request.getContextPath()+"/listPerson.jsp\">������Ա�б�</a>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {//��ס�ر�����
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
