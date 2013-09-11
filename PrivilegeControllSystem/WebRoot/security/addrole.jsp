<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'privilege.jsp' starting page</title>

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/servlet/RoleServlet?method=add" method="post">
          角色名称:<input name="name"> <br>
          角色描述:<textarea cols="20" rows="2" name="description" ></textarea><br>
          角色权限:
          <c:forEach items="${list}" var="p">
          	${p.name}<input type="checkbox" name="pid" value="${p.id}">
          </c:forEach>
    <input type="submit" value="提交" >
  </form>  
  </body>
</html>
