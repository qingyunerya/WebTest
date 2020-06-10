package com.eshore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.pojo.User;

@WebServlet(name = "loginServlet", urlPatterns = { "/login.htm" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");// ��ȡ����username��ֵ
		String passwd = request.getParameter("passwd");// ��ȡ����passwd��ֵ
		if(checkLogin(userName,passwd)){//�û���¼�ɹ�����ת���û�ҳ��
			request.getRequestDispatcher("/member.htm").
			forward(request, response);
		}else{
			response.sendRedirect("login.jsp");//�ض��򵽵�¼��ҳ
		}
	}
	//��֤��¼�û�
	public boolean checkLogin(String username,String passwd){
		User user = User.getInstance();
		Map<String,String> map = user.getUserMap();
		if(username!=null&&!"".equals(username)&&		//�û���Ϊ�ղ��ж�
			passwd!=null&&!"".equals(passwd)){
			String[] arr = map.get(username).split("##");//�ָ�Map�е�ֵ
			if(arr[0].equals(passwd)) return true;
			else return false;
		}else
			return false;
	}
}
