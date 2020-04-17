<%@page import="com.lyz.pojo.UserInfo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lyz.factory.DAOFactory"%>
<%@page import="com.lyz.pojo.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="lin1" uri="/copyr-tag"%>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<lin1:copyright/>
<lin1:copyright2 startY="2012" user="liaozhihua"/>
<lin1:copyright3 startY="2012" user="liaozhihua"><a href="http://www.sina.com">新浪</a></lin1:copyright3>
<lin1:copyright3 startY="2012" user="liaozhihua" time="2"><a href="http://www.sina.com">新浪</a></lin1:copyright3>
<center>
<table width="300px" border="1" align="center">
<tr>
	<td width="20%"> 用户名：</td>
	<td width="20%"> 年龄：</td>
	<td> 邮箱：：</td>
</tr>
<%
List<UserInfo> users=new ArrayList<>();
users.add(new UserInfo("张三",30,"2424753284@qq.com"));
users.add(new UserInfo("张三",30,"2424753284@qq.com"));
users.add(new UserInfo("张三",30,"2424753284@qq.com"));
request.setAttribute("users", users);
%>
<lin1:table var="item" items="${users }">
	<lin1:showUserInfo user="${item }"/>
</lin1:table>

</table>


</center>
</body>
</html>