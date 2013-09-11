<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <%@include file="MyHtml.html" %>
  <%
  //pageContext.s
   %>
   <%--
 <jsp:forward page=""></jsp:forward>
 <c:forEach ></c:forEach>
   --%>
   <c:if test=""></c:if>
   <c:forTokens var="xx" items="aa,bb,cc" delims=",">qqqq ${xx }</c:forTokens>
   <a href="http://localhost:8080/FristWebPro/index.jsp?test=我&test1=11"> 我</a>
   <jsp:useBean id="person" class="cn.domain.Person" scope="page"></jsp:useBean>
   <jsp:setProperty property="name" name="person" value="xxxxxx"/>
   <jsp:setProperty property="name" name="person" param="test"/>
   <jsp:setProperty property="age" name="person" param="test1"/>
   
   <jsp:getProperty property="name" name="person"/>
   <%=new String(person.getName().getBytes("ISO-8859-1"),"utf-8") +"  "+person.getAge() %>
    This is my JSP page. <br>
    
    ${pageScope.aa }
    ${pageContext.request.parameterNames }
    
  </body>
</html>
