package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyz.dao.User;

@WebServlet(
		name="loginHtm",
		urlPatterns= {"/Login.htm"},
		loadOnStartup = 0
		)
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(checkLogin(username,password))
		{
			req.getRequestDispatcher("/Member.htm").forward(req, resp);
		}else
		{
			resp.sendRedirect("login2.jsp");
		}
	}
	public boolean checkLogin(String username,String password)
	{
		User user=User.getInstance();
		Map<String,String> map=user.getUserMap();
		if(username!=null&&!username.equals("")&&password!=null&&!password.equals(""))
		{
			String[] pwd=map.get(username).split("##");
			if(pwd[0].equals(password))
				return true;
			else return false;
		}
		return false;
		
	}
	public boolean isValidEmail(String email)
	{
		boolean flag=false;
		if(email==null||email.equals(""))flag=false;
		if(email!=null&&!email.equals(""))
		{
			flag=email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
		}
		return flag;
	}
	public boolean isValidUsername(String username)
	{
		User user=User.getInstance();
		Map<String,String> map=user.getUserMap();
		if(username!=null&&!username.equals(""))
		{
			if(map.get(username) != null&&map.get(username).equals(""))
				return true;
				else return false;		
		}
		if(username==null||username.equals(""))
			return true;
		return true;
		
	}
	public boolean isValidPassword(String password,String confirmPassword)
	{
		return password==null||confirmPassword==null||password.length()<6||confirmPassword.length()<6||!password.equals(confirmPassword);
	}

}
