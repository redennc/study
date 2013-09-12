<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
  <%-- pageContext.getResponse().getWriter() --%>
  <%-- 
  <jsp:useBean id="xxx" class=""></jsp:useBean>
  <jsp:setProperty property="*" name="xxx" />  
    
    <c:forEach items="xxx" ></c:forEach>
    <c:if test=""></c:if>
    <c:choose></c:choose>
    
    <c:remove var="xxx" />
    --%>
    <c:set var="a" value="aaa" />
    <c:set var="b" value="bbb" />
    <%request.setAttribute("abc", 55); %>
    ${abc==55 ? fn:contains("hggabcdefr","abcd") : "55555555555"  }
    -------------------
    ${a}${b}
    ${fn:contains("hggabcdefr","abcd") }
    <%pageContext.getOut().write("xxxx"); %>
    <c:out value="ccccccc"></c:out>
    This is my JSP page. <br>
  </body>
</html>
