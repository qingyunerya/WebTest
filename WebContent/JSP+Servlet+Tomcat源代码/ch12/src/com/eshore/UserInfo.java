package com.eshore;

public class UserInfo {
	private String userName;//�û���
	private int age;//����
	private String email;//�û�����

	public UserInfo(String userName, int age, String email) {
		super();
		this.userName = userName;
		this.age = age;
		this.email = email;
	}

	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
