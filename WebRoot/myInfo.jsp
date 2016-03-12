<%@page import="org.springframework.core.io.ClassPathResource"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的信息</title>
    
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
  	<%@include file="head.jsp" %>
  	<div id="content">
	  	<div id="login">
	  		<h2>我的信息</h2>
		  	用户名: <s:property value="#session.username"></s:property><br><br>
		  	邮箱: <s:property value="#request.user.mail"/><br><br>
		  	<a href="changePassword.jsp">修改密码</a><br><br>
			<a href="myBookingInfo.jsp">我的订房信息</a>
		</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
