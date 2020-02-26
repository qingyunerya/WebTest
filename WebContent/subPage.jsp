<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网页设计</title>
</head>
<body>
<%
String name=request.getParameter("name");
String sex=request.getParameter("sex");
System.out.println(""+name+sex);
%>
<table>
<tr>
<td>姓名；<%=name %></td>
</tr>
<tr>
<td>性别：<%=sex %></td>
</tr>
</table>
</body>
</html>