<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    <title>My JSP 'addresource.jsp' starting page</title>
    
  </head>
  
  <body>
	  <form action="${pageContext.request.contextPath}/servlet/ResourceServlet?method=add" method="post">
	         资源名称:<input name="uri"> <br/>
	         资源描述:<textarea cols="20" rows="2" name="description" ></textarea><br/>
	        所属权限: 
	  	<c:forEach items="${plist}" var="p">
	  		${p.name} <input type="radio" name="privilege" value="${p}" > &nbsp;&nbsp;
	  	</c:forEach>  
	    <input type="submit" value="提交" >
	  </form>  
  </body>
</html>
