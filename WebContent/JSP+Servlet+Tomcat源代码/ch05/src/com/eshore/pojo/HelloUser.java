package com.eshore.pojo;

import java.util.HashMap;
import java.util.Map;

public class HelloUser {

	private Map<String,String> helloMessage = new HashMap<String,String>();
	//�����û�ֵ��ģ������ݿ���ȡ����ֵ
	public HelloUser(){
		helloMessage.put("John", "Hello,John");
		helloMessage.put("Smith", "Welcome,Smith!");
		helloMessage.put("Rose", "Hi,Rose");
	}
	//�����û�������Map�е���Ϣ
	public String sayHello(String userName){
		return helloMessage.get(userName);
	}
}
