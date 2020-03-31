package com.lyz.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.AsyncContext;

public class ClientService {

	private final Queue<AsyncContext> ASYNC_QUEUE=new ConcurrentLinkedQueue<AsyncContext>();
	private final BlockingQueue<String> INFO_QUEUE=new LinkedBlockingQueue<String>();
	private static ClientService instance =new ClientService();
	private ClientService() {
		new Thread(this.notifyRunnable).start();
	}
	public static ClientService getInstance() {
		return instance;
	}
	public void addAsyncContext(final AsyncContext asyncContext) {
		ASYNC_QUEUE.add(asyncContext);
	}
	public void removeAsyncContext(final AsyncContext asyncContext) {
		ASYNC_QUEUE.remove(asyncContext);
	}
	public void callClient(final String str) {
		try {
			INFO_QUEUE.put(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	private Runnable notifyRunnable=new Runnable() {
		
		@Override
		public void run() {
			boolean done=false;
			while(!done) {
				try {
					final String script=INFO_QUEUE.take();
					for(AsyncContext ac:ASYNC_QUEUE) {
						try {
							PrintWriter writer=ac.getResponse().getWriter();
							writer.println(escapeHTML(script));
							writer.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							ASYNC_QUEUE.remove(ac);
							throw new RuntimeException();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					done=true;
					e.printStackTrace();
				}
				
			}
		}
	};
	private String escapeHTML(String str) {
		
		return "<script type='text/javascript'>\n"
				+str.replace("\n", "").replace("\r", "")
				+"</script>\n";
	}
		
}
