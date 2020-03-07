<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>login</title>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="keywords" content="demo">
	<meta http-equiv="author" content="liao">
	<meta http-equiv="description" content="demo test">
</head>
<% 
String flag=request.getParameter("flag");
String message=""; 
if(flag!=null&&flag.equals("larger"))
{
	message="太大了！";	
}
else if(flag!=null&&flag.equals("lesser"))
{
	message="太小了！";
}
else if(flag!=null&&flag.equals("success"))
{
	message="猜对了！";
}
session.getAttribute("guessNumber");
%>
<body>
<form action="GuessNumber" method="post">
	<span>请输入待猜测数字</span>
	<input type="text" name="guessNumber" size="10">
	<input type="submit" value="提交">
	<span style="color:red"><%=message%>=<%=request.getParameter("number") %>+":"+<%=session.getAttribute("currentNumber") %></span>
</form>
</body>
</html>
