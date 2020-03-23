<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
String info="";
%>
<%
	Enumeration<String> e=session.getAttributeNames();
	while(e.hasMoreElements())
	{
		String name=e.nextElement();
		String value=(String)session.getAttribute(name);
		info=info+name+":"+value+"<br/>";
	}
	session.removeAttribute("username");
	session.removeAttribute("password");
	session.invalidate();
	response.sendRedirect("login.jsp");
	
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>logout</title>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="keywords" content="demo">
	<meta http-equiv="author" content="liao">
	<meta http-equiv="description" content="demo test">
</head>
<body>
<%--注释 --%>
<!-- 注释 -->
	<center>
		<a href="login.jsp">点击返回登录界面</a>
	</center>
	<div>
	<%=info %>
	</div>
	<%info=""; %>	
</body>
</html>
