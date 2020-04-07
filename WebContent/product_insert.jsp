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
Product product=new Product();
product.setProduct_id(request.getParameter("product_id"));
product.setProduct_name(request.getParameter("product_name"));
product.setPrice(Double.parseDouble(request.getParameter("price")));
product.setInfo(request.getParameter("info"));
boolean flag=DAOFactory.getIEmpDAOInstance().addProduct(product);
if(flag){
%>
<h4>添加产品成功</h4>
<%
}else{
%>
<h4>添加产品失败</h4>
<%} %>
</body>
</html>