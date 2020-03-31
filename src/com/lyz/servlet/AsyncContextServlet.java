package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyz.service.ClientService;

@WebServlet(
		urlPatterns = {"/AsyncContextServlet"},
		name="asyncContextServlet",
		asyncSupported = true
)

public class AsyncContextServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		final AsyncContext asyncContext =req.startAsync();
		asyncContext.setTimeout(1000000);
		asyncContext.addListener(new AsyncListener() {
			
			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				// TODO Auto-generated method stub
				ClientService.getInstance().removeAsyncContext(asyncContext);
			}
			
			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(AsyncEvent event) throws IOException {
				// TODO Auto-generated method stub
				ClientService.getInstance().removeAsyncContext(asyncContext);
			}
			
			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				// TODO Auto-generated method stub
				ClientService.getInstance().removeAsyncContext(asyncContext);
			}
		});
		ClientService.getInstance().addAsyncContext(asyncContext);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
