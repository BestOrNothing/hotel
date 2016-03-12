<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登记入住</title>
    
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
		<h2>登记入住</h2>
		<form action="checkIn.action" method="post">
		房号: <br><s:textfield style="width:200px; height:30px;" readonly="true" name="id" value="%{#request.id}"></s:textfield><br>
		<br>房间类型: <br><s:textfield style="width:200px; height:30px;" readonly="true" value="%{#request.type}"></s:textfield><br>
		<br>价格:<br> <s:textfield style="width:200px; height:30px;" readonly="true" value="%{#request.price}"></s:textfield><br>
		<br>入店时间:<br> <s:textfield style="width:200px; height:30px;" readonly="true" name="inTime" value="%{#request.inTime}" ></s:textfield><br>
		<br>离店时间:<br> <s:textfield style="width:200px; height:30px;" readonly="true" name="outTime" value="%{#request.outTime}" ></s:textfield><br>
		<br>入住人姓名1:<br> <s:textfield style="width:200px; height:30px;" name="customer1"></s:textfield><br>
		<br>入住人姓名2:<br> <s:textfield style="width:200px; height:30px;" name="customer2"></s:textfield>
		<s:hidden value="%{#request.username}" name="username"></s:hidden>
		<br><br><input class="purpleButton" type="submit" value="提交">
		</form>
	</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
