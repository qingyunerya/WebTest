package com.eshore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.pojo.User;

@WebServlet(name = "registeServlet", urlPatterns = { "/register.htm" })
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");// ��ȡ����username��ֵ
		String passwd = request.getParameter("passwd");// ��ȡ����passwd��ֵ
		String confirdPasswd = request.getParameter("confirdPasswd");// ��ȡ����confirdPasswd��ֵ
		String email = request.getParameter("email");// ��ȡ����email��ֵ
		List<String> errors = new ArrayList<String>();//װ�ش�����Ϣ
		if(!isValidEmail(email)){//��֤����
			errors.add("��Ч��������룡");
		}
		if(isValidUsername(userName)){//��֤�û���
			errors.add("�û�Ϊ�ջ����Ѿ����ڣ�");
		}
		if(isValidPassword(passwd,confirdPasswd)){//��֤����
			errors.add("����Ϊ�ջ������벻һ�£�");
		}
		if(!errors.isEmpty()){//���List��Ϊ�գ�����ת������ҳ��
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/error.htm").//��ת�������ҳ��
			forward(request, response);
		}else{						//��֤ͨ������ȡUser�е�Map��������û�
			User user = User.getInstance();;
			Map<String,String> map = user.getUserMap();
			map.put(userName, passwd+"##"+email);
			request.getRequestDispatcher("/success.htm").//��ת���ɹ���ҳ��
			forward(request, response);
		}
	}
	//ʹ��������ʽ��֤����
	public boolean isValidEmail(String email){
		boolean flag = false;
		if(email==null||"".equals(email)) flag = false;
		if(email!=null&&!"".equals(email)){
			flag = email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
		}
		return flag;
	}
	//��֤�û����Ƿ���ڣ���ȡUser���е�Map����
	//����key�ж�Map���Ƿ�����û�
	public boolean isValidUsername(String userName){
		User user = User.getInstance();;
		Map<String,String> map = user.getUserMap();
		if(userName!=null&&!userName.equals("")){ 
			if(map.get(userName)!=null&&!map.get(userName).equals("")){
				return true;//�����û�
			}else return false;
		}
		if(userName==null&&userName.equals("")){ 
			return true;
		}
		return true;
	}
	//��֤���룬�������Ϊ���ҳ���С��6���Ҹ�ȷ�����벻ͳһ
	//����true
	public boolean isValidPassword(String passwd,String confirdPasswd){
		return passwd==null||confirdPasswd==null
		||passwd.length()<6||confirdPasswd.length()<6
		||!passwd.equals(confirdPasswd);
	}
}
