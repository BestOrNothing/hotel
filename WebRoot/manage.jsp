<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>酒店管理</title>
    
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
		<h2>酒店管理</h2><br>
		<a href="goToRoomManage.action" style="color:white;margin-right:3%" type="text" ><button class="purpleButton">客房管理</button></a>
		添加或删除客房。<br><br>
		<a href="goToCustomerManage.action" style="color:white;margin-right:3%" type="text"><button class="purpleButton">住客管理</button></a>
		查看所有的住客。<br><br>
		<a href="frontManage.jsp" style="color:white;margin-right:3%" type="text"><button class="purpleButton" style="width:120px;">前台登记管理</button></a>
		为顾客办理登记或退房。<br><br>
		<a href="goToBookingManage.action" style="color:white;margin-right:3%" type="text"><button class="purpleButton" style="width:120px;">客房预定管理</button></a>
		查看所有房间的预定情况。<br><br>
	</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
