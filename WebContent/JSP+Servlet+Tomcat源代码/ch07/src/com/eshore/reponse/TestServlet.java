package com.eshore.reponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test.action")
public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {

		try {
			//��1���ӵ���һ�οͻ��˷���
			for (int i = 0; i < 20; i++) {
				final String str = "window.parent.update(\""
						+ String.valueOf("����--"+i) + "\");";
				ClientService.getInstance().callClient(str);
				Thread.sleep(2 * 1000);
				if (i == 10) {
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
