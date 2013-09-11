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
   				<a href="${pageContext.request.contextPath }/servlet/RoleServlet?method=addUI">添加角色</a>
   			</td>
   		</tr>
   	</table>
  
	<table width="300px" align="center" border="1">
		<tr>
			<td width="40%"> 角色名称 </td> <td>角色描述</td> <td>角色拥有权限</td> 
		</tr>
		
		<c:forEach items="${list}" var="ro">
		<tr>
			<td width="20%"> ${ro.name} </td> <td>${ro.description}</td>
			<td>
				<c:forEach items="${ro.privilege}" var="p">
					${p.name}, 
				</c:forEach>
	
			</td>
		</tr>
		</c:forEach>
		
	</table>
    
  </body>
</html>
