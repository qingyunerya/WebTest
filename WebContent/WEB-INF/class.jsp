<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>class</title>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="keywords" content="demo">
	<meta http-equiv="author" content="liao">
	<meta http-equiv="description" content="demo test">
</head>
<body>
<%
	String username=(String)session.getAttribute("username"); 
	if(username==null)
	{
		response.sendRedirect("login.jsp");
	}

%>
	<center><font size="4">班级管理</font></center>
	<hr/>
	<table align="center" style="border-collapse:collapse;border:1px solid #ff0000;border-radius:5px">
		<tr  align="center">
		<td>姓名 :<%=username %></td>
		</tr>
		<tr>
		<td>
		<a href="addClass.jsp">班级录入</a>
		<a href="addClass.jsp">班级修改</a>
		<a href="addClass.jsp">班级查询</a>
		<a href="addClass.jsp">班级删除</a>
		</td>
		</tr>
		<tr align="center">
		<td><a href="logout.jsp">退出登录</a></td>
		</tr>
	</table>
</body>
</html>
