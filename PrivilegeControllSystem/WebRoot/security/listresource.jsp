<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


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
  
	<table width="300px" align="center" border="1">
		<tr>
			<td width="40%"> 资源名称 </td> <td>资源描述</td> <td>所属权限</td>
		</tr>
		
		<c:forEach items="${list}" var="r">
		<tr>
			<td width="20%"> ${r.name} </td> <td>${r.description}</td> <td>${r.privilege.name}</td>
		</tr>
		</c:forEach>
		
	</table>
  </body>
</html>
