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
</head>
<%response.encodeUrl("login.jsp"); %>
<body>
<form action="<%=request.getContextPath()%>/Login" method="post">
	<table align="center" style="margin: 10px auto; border-collapse: collapse; border: 1px solid #aaccdd">
		<tr>
			<td align="center">
				<font size="4">用户登录</font>
			</td>
		</tr>
		<tr>
			<td>
				<label for="username">用户名：</label>
				<input type="text" name="username">
			</td>
		</tr>
		<tr>
			<td>
				<label for="userpassword">用户密码:</label>
				<input type="password" name="password">
			</td>
		</tr>
		<tr align="center">
			<td>
				<input type="submit" value="登陆">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
</form>
<div>
<%=info %>
访问次数:<%=count %>
当前在线人数：${sessionScope.count}
<a href="Login.htm;jsessionid=ajfjfkjsjfsjkfdjsfj?username=nima&password=123456">Url重写</a>
</div>
</body>
</html>
