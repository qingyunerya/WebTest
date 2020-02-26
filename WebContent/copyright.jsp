<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
	String t =sdf.format(d);
	String copyRightMess="John 版权所有  2012-"+t;
%>
<br/>
<div align="center"><%=copyRightMess%></div>
