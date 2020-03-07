package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GuessNumber extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GuessNumber() {
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
		String guessNumber=req.getParameter("guessNumber");
		int number=Integer.parseInt(guessNumber);
		HttpSession session=req.getSession();
		Integer currentNumber=(Integer) session.getAttribute("currentNumber");
		String context=req.getContextPath();
		if(currentNumber==null)
		{
			currentNumber=1+(int) (Math.random()*50);
			session.setAttribute("currentNumber", currentNumber);
			System.out.println("null:"+currentNumber);
		}
		System.out.println(number+":"+currentNumber);
		if (currentNumber > number)
			resp.sendRedirect(context + "/guessNumber.jsp?flag=" + "lesser" + "&number=" + currentNumber);
		else if (currentNumber < number)
			resp.sendRedirect(context + "/guessNumber.jsp?flag=" + "larger" + "&number=" + currentNumber);
		else {
			resp.sendRedirect(context + "/guessNumber.jsp?flag=" + "success" + "&number=" + currentNumber);
			currentNumber = 1 + (int) (Math.random() * 50);
			session.setAttribute("currentNumber", currentNumber);
			System.out.println("re:"+currentNumber);
		}
		
		
	}

}
