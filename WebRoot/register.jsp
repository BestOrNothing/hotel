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
    
    <title>注册</title>
    
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
	<%@ include file="head.jsp" %>
	<div id="content">
	<div id="login">
		<h2>注册</h2>
	  	<form action="register.action" method="post">
	  	<%if(request.getAttribute("error") != null){ %>
	  	<s:property value="#request.error"/><br>
	  	<%} %>
	  	用户名:<br> <input type="text" name="username" class="loginInput"><br><br><br>
	  	密码:<br> <input type="password" name="password" class="loginInput"><br><br><br>
	  	邮箱:<br> <input type="text" name="mail" class="loginInput"><br><br><br>
	  	<input type="submit" value="注册" class="purpleButton">
	  	<input type="reset" value="重置" class="purpleButton">
	  </div>
  	</div>
  	</form>
  	
  	<%@ include file="tail.jsp" %>
  	
  </body>
</html>
