package com.eshore;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

@WebListener
public class MyRequestListener implements ServletRequestListener,
		ServletRequestAttributeListener {
	private static Logger log = Logger.getLogger("MyRequestListener");
	public void requestDestroyed(ServletRequestEvent arg0) {
		log.debug("һ����������");
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		log.debug("����һ���µ�����");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		log.debug("����һ��request��Χ�����ԣ�����Ϊ��"+
		   arg0.getName()+",��ֵΪ��"+arg0.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		log.debug("�Ƴ�һ��request��Χ�����ԣ�����Ϊ��"+arg0.getName());
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		log.debug("�޸�һ��request��Χ�����ԣ�����Ϊ��"+
			arg0.getName()+",�޸�ǰ��ֵΪ��"+arg0.getValue());
	}
}
