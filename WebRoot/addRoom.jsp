<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加房间</title>
    
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
			<h2>增加房间</h2>
			<form action="addRoom.action" method="post">
			房间号:<br> <input class="loginInput" type="text" name="id"><br>
			房间号必须是3位且不能和已有的房间号重复。<br><br>
			价格:<br> <input class="loginInput" type="text" name="price"><br><br>
			房间类型: 
			<select name="type">
				<option>商务大床房</option>
				<option>大床房</option>
				<option>双人标准间</option>
			</select><br><br>
			<input class="purpleButton" type="submit" value="提交">
			</form>
		</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
