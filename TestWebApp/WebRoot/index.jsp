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
  <c:if test="${user.username !=null }">
  	欢迎  ${user.username}
  </c:if>
  
    <a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet">注册</a> <br/>
    <a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">登录</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ListUsersServlet">显示用户</a> <br/>
  </body>
</html>