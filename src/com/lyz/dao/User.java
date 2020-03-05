package com.lyz.dao;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	private Map<String,String> map=new HashMap<String,String>();
	private static User user;
	public User() {
		// TODO Auto-generated constructor stub
		map.put("John", "111111##John@sina.com");
		map.put("Bob", "222222##Bob@sina.com");
		map.put("ALice", "333333##@sina.com");
	}
	public static User getInstance()
	{
		if(user==null)
		{
			user=new User();
		}
		return  user;
	}
	public Map<String, String> getUserMap()
	{
		return map;
	}
	public String sayHello(String name)
	{
		return  map.get(name);
	}

}

