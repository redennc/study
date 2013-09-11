<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listusers.jsp' starting page</title>
    
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
	  <table>
	    <c:forEach items="${pageBean.list}" var="user" >
	      <tr>
	    	<td>${user.username}</td>  <td>${user.hobby}</td>  <td>${user.nikename}</td>
	      </tr>
	    </c:forEach>
	  </table>
      <c:forEach items="${pageBean.pageBar}" var="bar" >
      	<a href="${pageContext.request.contextPath}/servlet/ListUsersServlet?startIndex=${bar}">${bar}</a> &nbsp;&nbsp;
      </c:forEach>
  </body>
</html>
