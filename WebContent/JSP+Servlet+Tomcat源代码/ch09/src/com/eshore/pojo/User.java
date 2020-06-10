package com.eshore.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable{

	private String username="";//�û���
	private String passwd="";	//����
	Map<String,String> userMap = null;//����û�
	Map<String,String> errorsMap = null;//��Ŵ�����Ϣ
	
	public User() {	//�޲εĹ��췽��
		super();
		this.username = "";
		this.passwd="";
		userMap = new HashMap<String,String>();
		errorsMap = new HashMap<String,String>();
		//����û���ģ������ݿ��в�ѯ�������ݿ�
		userMap.put("zhangsan", "123zs");
		userMap.put("lisi", "1234zs");
		userMap.put("wangwu", "1234ww");
		userMap.put("zhaoqi", "1234zq");
		userMap.put("zhengliu", "1234zl");
		// TODO Auto-generated constructor stub
	}
    //������֤
	public boolean isValidate(){
		boolean flag = true;
		//�û�����֤
		if(!this.userMap.containsKey(this.username)){
			flag = false;
			errorsMap.put("username", "���û������ڣ�");
			this.username = "";
		}
		//�����û�������������֤
		String password = this.userMap.get(this.username);
		if(password==null||!password.equals(this.passwd)){
			flag = false;
			this.passwd = "";
			errorsMap.put("passwd", "���������������ȷ���룡");
			this.username = "";
		}
		return flag;
	}
	//��ȡ������Ϣ
	public String getErrors(String key){
		String errorV = this.errorsMap.get(key);
		return errorV==null?"":errorV;
	}
	//���������Ե�get��set��������������public
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
