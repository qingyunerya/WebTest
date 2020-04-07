<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="product_insert.jsp" method="post">
产品编号 <input name="product_id" type="text"><br/>
产品名称<input name="product_name" type="text"><br/>
产品 价格<input name="price" type="text"><br/>
产品 信息<textarea rows="" cols="" name="info"></textarea><br/>
<input type="submit" value="提交">&nbsp;&nbsp;
<input type="reset" value="重置">
</form>
</body>
</html>