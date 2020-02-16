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
<body>
<form action="load.jsp" method="post">
	<table align="center" style="width：300px;margin: 10px auto; border-collapse: collapse; border: 1px solid #aaccdd">
		<tr>
			<td>
				<label for="username">用户名：</label>
				<input type="text" name="username">
			</td>
		</tr>
		<tr>
			<td>
				<label for="userpassword">用户密码:</label>
				<input type="password" name="userpassword">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="登陆">
			</td>
		</tr>
	</table>

</form>
</body>
</html>
