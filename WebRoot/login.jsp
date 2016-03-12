<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
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
	<%
	if(request.getAttribute("error") != null)
		out.println(request.getAttribute("error"));
	 %>
	<div id="login">
		<h2>登录</h2><br>
		<form action="login.action" method="post">
		用户名: <br> <input type="text" name="username" class="loginInput"><br><br><br>
		密码: <br> <input type="password" name="password" class="loginInput"><br><br><br>
		<input type="submit" value="登录" class="purpleButton">
		<a href="register.jsp" style="text-decoration: none;color: gray;">没有帐号？注册新用户。</a>
		</form>
	</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
