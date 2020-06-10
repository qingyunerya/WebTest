package com.eshore.reponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.AsyncContext;


public class ClientService {
	 
	private final Queue<AsyncContext> ASYNC_QUEUE = 
		new ConcurrentLinkedQueue<AsyncContext>();//�첽Servlet�����Ķ���
 
	private final BlockingQueue<String> INFO_QUEUE = 
		new LinkedBlockingQueue<String>();		//��Ϣ����.
 
	private static ClientService instance  = new ClientService();
 
	private ClientService() {
		 new Thread(this.notifyRunnable).start();
	}
	 
	public static ClientService getInstance() {
		return instance;
	}

	public void addAsyncContext(final AsyncContext asyncContext) {
		ASYNC_QUEUE.add(asyncContext);//����첽Servlet������
	}

	public void removeAsyncContext(final AsyncContext asyncContext) {
		ASYNC_QUEUE.remove(asyncContext);//ɾ���첽Servlet������
	}

	/**
	 * 
	 * ������Ϣ���첽�̣߳����������http response �� .<br>
	 * @param str ���͸��ͻ��˵���Ϣ.<br>
	 */

	public void callClient(final String str) {
		try {
			INFO_QUEUE.put(str);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * ����Ϣ�����������ݣ������take()������
	 * �����ݷ��͵�response���� 
	 */
	private Runnable notifyRunnable = new Runnable() {
		public void run() {
			boolean done = false;
			while (!done) {
				try {
					final String script = INFO_QUEUE.take();
					System.out.println(script);
					for (AsyncContext ac : ASYNC_QUEUE) {
						try {
							PrintWriter writer = ac.getResponse().getWriter();
							writer.println(escapeHTML(script));
							writer.flush();
						} catch (IOException ex) {
							ASYNC_QUEUE.remove(ac);
							throw new RuntimeException(ex);
						}
					}
				}catch(InterruptedException e) {
					done = true;
					e.printStackTrace();
				}
			}
		}
	};

	/**
	 * 
	 * ɾ������Ŀո�
	 */
	private String escapeHTML(String str) {

		return "<script type='text/javascript'>\n"
		+ str.replaceAll("\n", "").replaceAll("\r", "")
		+ "</script>\n";

	}

}
