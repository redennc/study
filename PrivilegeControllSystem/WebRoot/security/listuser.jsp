<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'privilege.jsp' starting page</title>

  </head>
  
  <body>
  
	<table width="500px" align="center" border="1">
		<tr>
			<td width="30%"> 用户名称 </td> <td>用户描述</td> <td>所属角色</td> <td>修改权限</td>
		</tr>
		
		<c:forEach items="${list}" var="u">
		<tr>
			<td width="20%"> ${u.username} </td> <td>${u.description}</td>
			<td>
				<c:forEach items="${u.role}" var="r">
					${r.name}, 
				</c:forEach>
	
			</td>
			<td> <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=updateUI&id=${u.id}">修改</a> </td>
		</tr>
		</c:forEach>
		
	</table>
    
  </body>
</html>
