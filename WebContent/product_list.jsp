<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
String product_id =request.getParameter("product_id");
List<Product> list=DAOFactory.getIEmpDAOInstance().findAll(product_name);
Product product=DAOFactory.getIEmpDAOInstance().findProductById(product_id);
%>

<form action="product_list.jsp" method="post">
请输入产品名称<input name="product_name" type="text">
<input type="submit" value="提交">
</form>
<form action="product_list.jsp" method="post">
请输入产品编号<input name="product_id" type="text">
<input type="submit" value="提交">
</form>
<form action="product_insert.jsp" method="post">
产品编号 <input name="product_id" type="text"><br/>
产品名称<input name="product_name" type="text"><br/>
产品 价格<input name="price" type="text"><br/>
产品 信息<textarea rows="" cols="" name="info"></textarea><br/>
<input type="submit" value="提交">&nbsp;&nbsp;
<input type="reset" value="重置">
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
	<tr>
		<td><%=p.getProduct_id() %></td>
		<td><%=p.getProduct_name() %></td>
		<td><%=p.getPrice() %> </td>
		<td><%=p.getInfo() %> </td>
	</tr>
	<% 
		}
	%>
	<tr><td>查询编号结果<br/>
	<%if(product!=null){ %>
	<%=product.getProduct_id() %><br/>
	<%=product.getProduct_name() %><br/>
	<%=product.getPrice() %><br/>
	<%=product.getInfo() %>
	<%} %>
	</td>
	</tr>

</table>

</body>
</html>