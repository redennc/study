<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 <c:choose>
 	<c:when test="${empty user}">
 		<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet" >登陆</a> <br>
 	</c:when>
 	<c:otherwise>
 		欢迎 ${user.username} 登陆
 	</c:otherwise>
 </c:choose>
  <a href="${pageContext.request.contextPath}/manager/fahuo.jsp">发货</a>
  <a href="${pageContext.request.contextPath}/manager/dingdan.jsp">订单</a>
  </body>
</html>
