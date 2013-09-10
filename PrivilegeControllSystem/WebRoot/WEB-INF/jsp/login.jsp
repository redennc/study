<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>login page</title>


  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/LoginServlet">
    	用户名:<input name="username"><br>
    	密码:<input name="username"><br>
    	<input type="submit" value="提交">
    </form> 
  </body>
</html>
