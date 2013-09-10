<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'privilege.jsp' starting page</title>

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/servlet/PrivilegeServlet?method=add" method="post">
    权限名称:<input name="name"> <br>
    权限描述:<textarea cols="20" rows="2" name="description" ></textarea><br>
    <input type="submit" value="提交" >
  </form>  
  </body>
</html>
