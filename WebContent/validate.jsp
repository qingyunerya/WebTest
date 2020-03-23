<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>validate</title>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="keywords" content="demo">
	<meta http-equiv="author" content="liao">
	<meta http-equiv="description" content="demo test">
</head>
<%!
	Map<String,String> map=new HashMap<String,String>();
	Boolean  flag=false;
	
	%>
	<%
	map.put("John","123456");
	map.put("Tom","123456");
	map.put("Bob","123456");
	map.put("Alice","123456");
	%>
	<%!
	Boolean validate(String userName,String passWord)
	{
		String passwd=map.get(userName);
		if(passwd!=null&&passwd.equals(passWord))
		{
			return true;
		}
		else return  false;
	}
	
	%>
	<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username==null||username==""||password==null||password=="")
	{
		response.sendRedirect("login.jsp");
	}
	flag=validate(username,password);
	if(flag)
	{
		session.setAttribute("username",username);
		session.setAttribute("password", password);
		response.sendRedirect("class.jsp");
	}
	%>
<body>
	<center><font size="4">用户登录</font></center>
	<center>
	<%if(!flag){ %>
	<a href="login.jsp">密码有误,点击返回</a>
	<%} %>
	</center>
	<div><%=basePath %></div>
	
</body>
</html>
