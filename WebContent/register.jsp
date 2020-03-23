<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Enumeration<String> enumeration =request.getHeaderNames();
String info=null;
while(enumeration.hasMoreElements())
{
	String name=enumeration.nextElement();
	String value=request.getHeader(name);
	info=info+name+":"+value+"<br/>";
	
}
Integer count=(Integer)application.getAttribute("count");
if(count==null)count=1;
else count++;
application.setAttribute("count", count);
response.setContentType("text/html;charser=utf-8");
String pageinfo=Integer.toString(page.hashCode());  //Servlet类的哈希代码
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>login</title>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="keywords" content="demo">
	<meta http-equiv="author" content="liao">
	<meta http-equiv="description" content="demo test">
	<style type="text/css">
	.register-form tr{
	align:right;
	}
	
	</style>
</head>
<body>
<form action="<%=request.getContextPath()%>/register.htm" method="post">
	<table class="register-form" style="align:center;margin: 10px auto; border-collapse: collapse; border: 1px solid #aaccdd">
		<tr>
			<td align="center">
				<font size="4">用户注册</font>
			</td>
		</tr>
		<tr>
			<td>
				<label for="username">登陆名：</label>
				<input type="text" name="username">
			</td>
		</tr>
		<tr>
			<td>
				<label for="password">密码:</label>
				<input type="password" name="password">
			</td>
		<tr>
			<td>
				<label for="confirmPassword">密码:</label>
				<input type="password" name="confirmPassword">
			</td>
		</tr>
		<tr>
			<td>
				<label for="emial">邮件:</label>
				<input name="email">
			</td>
		</tr>
		<tr align="center">
			<td>
				<input type="submit" value="注册">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
</form>
<div>
<%=info %>
访问次数:<%=count %>
</div>
</body>
</html>
