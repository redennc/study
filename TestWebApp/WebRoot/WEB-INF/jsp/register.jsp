<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>register page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post"> 
    	用户名:<input name="username" value="${requestScope.form.username}"> <span>${requestScope.form.errors.username}</span><br/>
    	密码:<input name="password" type="password" value="${requestScope.form.password }"><span>${requestScope.form.errors.password}</span><br/>
    	爱好:<input name="hobby" value="${requestScope.form.hobby }"><span>${requestScope.form.errors.hobby}</span><br/>
    	昵称:<input name="nikename" value="${requestScope.form.nikename }"><span>${requestScope.form.errors.nikename}</span><br/>
    	<input type="submit" name="sub" value="提交">
    </form>
  </body>
</html>
