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
	<center><font size="4">上传文件</font></center>
	<hr/>
	<form action="<%=request.getContextPath()%>/uploads.do" method="post" enctype="multipart/form-data">
	<input type="file" name="filename">
	<input type="file" name=filename2>
	<input type="file" name="filename3">
	<input type="submit" value="提交">
	</form>
</body>
</html>
