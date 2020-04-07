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
<form action="" method="post">
输入产品名称：<input type="text" name="product_name">
输入产品id：<input type="text" name="product_id">
输入产品价格：<input type="text" name="price">
输入产品信息：<input type="text" name="info1">
<input type="submit" value="提交">
</form>
<jsp:setProperty property="*" name="product"/>
<jsp:setProperty property="info" name="product" param="info1"/>
<jsp:getProperty property="info" name="product"/>
<%=product.getProduct_name() %>

<%=product.getProduct_id() %>

<%=product.getPrice() %>

<%=product.getInfo() %>

</body>
</html>