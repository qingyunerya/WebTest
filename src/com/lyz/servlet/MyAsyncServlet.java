package com.lyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/asyncdemo"},
		name="myAsyncServlet",
		description="异步通信",
		displayName = "demo",
		asyncSupported = true
)


public class MyAsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("异步通信测试"+sdf.format(new Date()));
		/*AsyncContext asyncContext=req.startAsync(req, resp);
		asyncContext.setTimeout(90000000);
		new Thread(new Executor(asyncContext));*/
		out.println("结束时间："+sdf.format(new Date()));
		out.flush();
		
		
	}
	class Executor implements  Runnable{

		private AsyncContext ctx=null;
		Executor(AsyncContext ctx){
			this.ctx=ctx;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
				PrintWriter outPrintWriter=ctx.getResponse().getWriter();
				outPrintWriter.write("业务处理完毕时间："+sdf.format(new Date()));
				outPrintWriter.flush();
				ctx.complete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	

}
