<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网页设计</title>
</head>
<body>
<%@include file="John.html"%>
<div align="center">嵌入式网页设计</div>
<%@include file="copyright.jsp" %>
<table>
<tr>
<td align="center">卡片</td>
</tr>
<tr>
<td>姓名:John</td>
<td>性别:男</td>
</tr>
</table>
<%
request.setCharacterEncoding("UTF-8");
String info="";
int num=(int)(Math.random()*10);
System.out.println(""+num);
if(num>5)
	info="subPage.jsp";
else info="login.jsp";
%>
<jsp:forward page="<%=info %>">
<jsp:param value="John" name="name"/>
<jsp:param value="男" name="sex"/>
</jsp:forward>
</body>
</html>