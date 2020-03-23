<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>明星调查</title>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="keywords" content="demo">
	<meta http-equiv="author" content="liao">
	<meta http-equiv="description" content="demo test">
</head>
<body>
	<center><font size="4">明星调查</font></center>
	<hr/>
	<form action="<%=request.getContextPath()%>/diaocha.do" method="post">
	名字：<input type="text" name="username"><br/>
	邮件：<input type="text" name="email"><br/>
	你喜欢的明星：<br/>
	<select name="starname" multiple="multiple" size="2">
		<option value="成龙">成龙</option>
		<option value="诸葛亮">诸葛亮</option>
		<option value="毛泽东">毛泽东</option>
		<option value="习近平">习近平</option>
	</select>
	<input type="submit" value="提交">
	</form>
</body>
</html>
