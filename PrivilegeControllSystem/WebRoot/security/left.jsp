<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <a href="${pageContext.request.contextPath }/servlet/PrivilegeServlet?method=getAll" target="main">权限管理</a>
    <br/><br/>
    
    <a href="${pageContext.request.contextPath }/servlet/ResourceServlet?method=getAll" target="main">资源管理</a>
    <br/><br/>
    
    <a href="${pageContext.request.contextPath }/servlet/RoleServlet?method=getAll" target="main">角色管理</a>
    <br/><br/>
    
    <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=getAll" target="main">用户管理</a>
    <br/><br/>
  </body>
</html>
