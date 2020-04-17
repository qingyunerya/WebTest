<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
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
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"  %>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource driver="com.mysql.jdbc.Driver" password="123456" user="root" url="jdbc:mysql://localhost:3306/webtest" var="test"/>
<sql:update dataSource="${test }" var="updatePrice">update product set price=price+?
<c:set var="price" value="2"></c:set>
<sql:param value="${price }"></sql:param>
</sql:update>
<%
String product_name="鼠标";
int product_id=123456;
String hello ="你";
request.setAttribute("hello", hello);
%>
<sql:update dataSource="${test }" var="updateName">
update product set product_name=? where product_id=?
<sql:param value="${product_name }"></sql:param>
<%-- <sql:dateParam value="${nowdate }" type="timestamp"/> --%>
<sql:param value="${product_id }"></sql:param>

</sql:update>
<sql:query var="result" dataSource="${test }" >
select *from product;
</sql:query>
<c:out value="${hello }"></c:out>
<table border="1" width="100%" >
<tr colspan="4" align="center">
共查询到${result.rowCount }  
</tr>
<tr>
<th>产品编号</th>
<th>产品名称 </th>
<th>产品价格</th>
<th>产品信息 </th>
</tr>
<c:forEach var="product" items="${result.rows }">
<tr>
<td><c:out value="${product.product_id }"></c:out></td>
<td><c:out value="${product.product_name }"></c:out></td>
<td><c:out value="${product.price }"></c:out></td>
<td><c:out value="${product.info }"></c:out></td>
</tr>
</c:forEach>
</table>
<%-- <c:import var="xinlangInfo" url="http://rss.sina.com.cn/sina_all_opml.xml"></c:import>
<x:parse var="output" xml="${xinlangInfo }"></x:parse>
<x:out select="$output/opml/body/outline[1]@xmlUrl"/> --%>

</body>
</html>