<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'privilege.jsp' starting page</title>

  </head>
  
  <body>
  	<table width="60%">
   		<tr>
   			<td></td>
   			<td></td>
   			<td align="right">
   				<a href="${pageContext.request.contextPath }/servlet/PrivilegeServlet?method=addUI">添加权限</a>
   			</td>
   		</tr>
   	</table>
  
	<table width="300px" align="center" border="1">
		<tr>
			<td width="40%"> 权限名称 </td> <td>权限描述</td>
		</tr>
		
		<c:forEach items="${list}" var="p">
		<tr>
			<td width="20%"> ${p.name} </td> <td>${p.description}</td>
		</tr>
		</c:forEach>
		
	</table>
    
  </body>
</html>
