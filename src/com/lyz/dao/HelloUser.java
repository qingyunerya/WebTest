package com.lyz.dao;

import java.util.HashMap;
import java.util.Map;

public class HelloUser {
	
	private Map<String,String> map=new HashMap<String,String>();
	public HelloUser() {
		// TODO Auto-generated constructor stub
		map.put("John", "Hello John");
		map.put("Bob", "welcome Bob");
		map.put("ALice", "this is Alice");
	}
	public String sayHello(String name)
	{
		return  map.get(name);
	}

}

