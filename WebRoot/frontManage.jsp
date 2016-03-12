<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>前台登记管理</title>
    
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
			<h2>前台登记管理</h2>
			<h3>入住</h3>
			<a href="listBookingWhenCheckIn.action"><button class="purpleButton">有预定</button></a>
			为有预定的顾客办理登记。<br><br>
			<a href="checkInWithoutBooking.jsp"><button class="purpleButton">没有预定</button></a>
			为没有预定的顾客办理登记。<br><br>
			<h3>退房</h3>
			<a href="checkOut.jsp"><button class="purpleButton">退房</button></a>
			为顾客进行退房。
		</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
