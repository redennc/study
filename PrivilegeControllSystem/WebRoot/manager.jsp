<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    
    <title>My JSP 'manager.jsp' starting page</title>


  </head>
  

	<frameset rows="22%,*">
		<frame name="head" src="${pageContext.request.contextPath}/security/head.jsp" >
		<frameset cols="15%,*">
			<frame name="left" src="${pageContext.request.contextPath}/security/left.jsp" >
			<frame name="main" src="#">
		</frameset>
	</frameset>    

</html>

