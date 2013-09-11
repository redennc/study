<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'privilege.jsp' starting page</title>

  </head>
  
  <body>
	  <form action="${pageContext.request.contextPath}/servlet/UserServlet?method=update" method="post">
		用户名称: ${user.username} <br/>
		用户描述: ${user.description }<br/>
		原先角色: 
			<c:forEach items="${user.role}" var="r">
				${r.name} ,
			</c:forEach>
	              修改角色: 
	        <c:forEach items="${rlist}" var="role">
	        	${role.name} <input type="checkbox" name="rid" value="${role.id}" >
	        </c:forEach>  <br/>
	    <input type="hidden" name="id" value="${user.id}">    
	    <input type="submit" value="修改">        
	  </form>      
  </body>
</html>
