<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'listresource.jsp' starting page</title>
    

  </head>
  
  <body>
    <table width="60%">
   		<tr>
   			<td></td>
   			<td></td>
   			<td align="right">
   				<a href="${pageContext.request.contextPath }/servlet/ResourceServlet?method=addUI">添加权限</a>
   			</td>
   		</tr>
   	</table>
  
	<table width="600px" align="center" border="1">
		<tr>
			<td width="20%"> 资源名称 </td> <td>资源描述</td> <td>所属权限</td>
		</tr>
		
		<c:forEach items="${list}" var="r">
		<tr>
			<td width="20%"> ${r.uri} </td> <td>${r.description}</td> <td>${r.privilege.name}</td>
		</tr>
		</c:forEach>
		
	</table>
  </body>
</html>
