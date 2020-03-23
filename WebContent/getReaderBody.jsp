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
	<center><font size="4">获取body内容</font></center>
	<hr/>
	<form action="<%=request.getContextPath()%>/GetReaderBody" method="post">
	<table align="center" style="border-collapse:collapse;border:1px solid #ff0000;border-radius:5px">
		<tr>
			<td>
				<label for="username">用户名:</label>
				<input type="text" name="username">
			</td>
		</tr>
		<tr align="right">
			<td>
				<label for="password">密码:</label>
				<input type="text" name="password">
			</td>
		</tr>
		<tr align="center">
			<td>
				<button type="submit">提交</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
