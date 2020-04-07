<%@page import="com.lyz.factory.DAOFactory"%>
<%@page import="com.lyz.pojo.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String product_name=request.getParameter("product_name");
List<Product> list=DAOFactory.getIEmpDAOInstance().findAll(product_name);
%>
<form action="product_list.jsp" method="post">
请输入产品名称<input name="product_name" tyep="text">
<input tyep="submit" value="提交">
</form>
<table border="1">
	<tr>
		<td>产品编号</td>
		<td>产品名称</td>
		<td>产品价格 </td>
		<td>产品信息</td>
	</tr>
	<%
		
		for(int i=0;i<list.size();i++){
		Product p=list.get(i);
	%>	
		<tr><%=p.getProduct_id() %> </tr>
		<tr><%=p.getProduct_name() %> </tr>
		<tr><%=p.getPrice() %> </tr>
		<tr><%=p.getInfo() %> </tr>
	<% 
		}
	%>

</table>

</body>
</html>