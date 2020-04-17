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
<<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] str=new String[]{"f","g"};
String[] str1=new String[]{"f","g"};
request.setAttribute("hello", "你好");
System.out.println();
class User{
	int id ;
	String name;
	void setName(String name){
		this.name=name;
	}
	void setId(int id ){
		this.id=id;
	}
}
Date d=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
String date=sdf.format(d);
request.setAttribute("date", date);
User  user=new User();
user.setId(1);
user.setName("bob");
request.setAttribute("user", user);
request.setAttribute("str", str);
List<String> list=new ArrayList<String>();
list.add("这是第一");
list.add("这是第二");
request.setAttribute("list", list);
%>
<c:out value="this is jstl标签测试"></c:out>
<c:out value="fdfdf"></c:out>
${pageContext.request.remoteUser }
${pageContext.request.method }
${pageContext.session.id }
${header["accept-Encoding"]}
${pageContext.request.remoteAddr }
${requestScope.hello }
${hello }
${str[1]}
${user}
${6>5?"大":"小"}
<c:set value="你好 " var="hello" scope="page"></c:set>
<c:out value="${hello }"></c:out>
<c:if test="${2%2==0 }" var="num">这是偶数</c:if>
<c:out value="${num }"></c:out>
<c:set var="number" value="2"></c:set>
<c:choose>
<c:when test="${number%2!=0 }">这是奇数</c:when>
<c:otherwise>这是偶数</c:otherwise>
</c:choose>
<c:set value="nihao" var="hello"></c:set>
<c:if test="${6>5?'大':'小'}" var="result">显示大小</c:if>
<c:out value="${result }"></c:out>
<c:forEach items="${list }" var="name" varStatus="status">
这是list项：<c:out value="${name }"></c:out>
这是项状态：<c:out value="${status.index }"></c:out>
<c:if test="${status.last }">已经介绍</c:if>
</c:forEach>
<c:forTokens items="你，他，妈，的" delims="，" var="name">
<c:out value="${name }"></c:out><br/>
</c:forTokens>
<fmt:requestEncoding value="utf-8"/>
<fmt:setLocale value="zh" variant="win" />
<fmt:bundle basename="JSTLtest" prefix="test.">
<fmt:message key="name" var="name"></fmt:message>
<%-- <fmt:message key="age" var="age"></fmt:message>
<fmt:message key="data">
<fmt:param>line</fmt:param>
<fmt:param value="<%=new Date() %>"></fmt:param>
</fmt:message> --%>
</fmt:bundle>
<%-- <c:out value="${name }"></c:out> --%>
<%-- <c:out value="${age }"></c:out>
<c:out value="${date }"></c:out> --%>
<%-- <c:redirect url="login.jsp"></c:redirect> --%>
<fmt:bundle basename="message" prefix="my.">
<fmt:message key="name" var="name"></fmt:message>
<fmt:message key="teacher" var="teacher"></fmt:message>
<fmt:message key="data" var="data">
<fmt:param >lily</fmt:param>
</fmt:message>
</fmt:bundle>

<c:out value="${name }"></c:out>
<c:out value="${teacher }"></c:out>
<c:out value="${data }"></c:out>
${fn:indexOf("iubde","u") }
${fn:contains("ijiji","i") }
${fn:join(str,"|") }

</body>
</html>