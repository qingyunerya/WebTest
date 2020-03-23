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
		name="registerHtm",
		urlPatterns= {"/register.htm"},
		loadOnStartup = 0
		)
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RegisterServlet() {
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
		String confirmPassword=req.getParameter("confirmPassword");
		String email=req.getParameter("email");
		List<String> errors=new ArrayList<String>();
		System.out.println("进入注册界面");
		if(!isValidEmail(email))
		{
			errors.add("无效的邮箱号码");
		}
		if(isValidUsername(username))
		{
			errors.add("用户名为空或者不存在");
		}
		if(isValidPassword(password,confirmPassword))
		{
			errors.add("密码为空或者密码不一致");
		}
		if(!errors.isEmpty())
		{
			req.setAttribute("errors",errors);
			req.getRequestDispatcher("/error.htm").forward(req, resp);
		}
		else
		{
			User user=User.getInstance();
			Map<String,String> map=user.getUserMap();
			map.put(username,password+"##"+email);
			req.getRequestDispatcher("/success.htm").forward(req, resp);
		}
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
