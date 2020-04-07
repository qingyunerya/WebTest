<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<jsp:useBean id="product" class="com.lyz.pojo.Product" scope="page"></jsp:useBean>
</head>
<body>
<jsp:setProperty property="product_name" name="product" value="Struct教程"/>
<%=product.getProduct_name() %>
<jsp:setProperty property="product_id" name="product" value="123456"/>
<%=product.getProduct_id() %>
<%
double price=24.3;
%>
<jsp:setProperty property="price" name="product" value="<%=price+12.2 %>"/>
<%=product.getPrice() %>

</body>
</html>