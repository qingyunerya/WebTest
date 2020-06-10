package com.eshore;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	asyncSupported = true, 
	urlPatterns = { "/asyncdemo.do" }, 
	name = "myAsyncServlet"
)
public class MyAsyncServlet extends HttpServlet {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("��ʼʱ�䣺" + sdf.format(new Date()) + " <br/> ");
        out.flush();
        //�����߳���ִ��ҵ����ã������为�������Ӧ�����߳��˳�
        AsyncContext asyncContext = request.startAsync(request,response);
        asyncContext.setTimeout(900000000);//�������ĳ�ʱʱ��
        new Thread(new Executor(asyncContext)).start();
        out.println("����ʱ�䣺" + sdf.format(new Date())+ " <br/> ");
        out.flush();
	}
	//�ڲ���
	public class Executor implements Runnable {
	    private AsyncContext ctx = null;
	    public Executor(AsyncContext ctx){
	        this.ctx = ctx;
	    }
	    public void run(){
	        try {
	            //�ȴ���ʮ���ӣ���ģ��ҵ�񷽷���ִ��
	            Thread.sleep(20000);
	            PrintWriter out = ctx.getResponse().getWriter();
	            out.println("ҵ������ϵ�ʱ�䣺" + sdf.format(new Date()) + " <br/> ");
	            out.flush();
	            ctx.complete();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
