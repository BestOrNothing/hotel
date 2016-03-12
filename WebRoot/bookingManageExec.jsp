<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客房预定管理</title>
    
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
	<div id='content'>
		<s:a href="goToAddBooking.action?id=%{#request.id}"><button class="purpleButton">新增预定</button></s:a>
		<br><br>
		<table class="resultTable">
			<tr class="resultItem">
				<th>用户名</th>
				<th>入店时间</th>
				<th>离店时间</th>
				<th>操作</th>
			</tr>
			<s:iterator value="#request.list" id="booking">
			<tr class='resultItem'>
			<s:form theme="simple" method="post" action="deleteBooking">
				<td><s:property value="#booking.id.username"/><s:hidden value="%{#booking.id.id}" name="id"/><s:hidden value="%{id}"/></td>
				<td><s:date format="yyyy-MM-dd" name="#booking.id.inTime"/><s:hidden value="%{#booking.id.username}" name="username"/>
				<input type="hidden" name="inTime" value="<s:date name="#booking.id.inTime" format="yyyy-MM-dd"/>"></td>
				<td><s:date format="yyyy-MM-dd" name="outTime"/><input type="hidden" name="outTime" value="<s:date format="yyyy-MM-dd" name="outTime"/>" > </td>
				<td><input class="purpleButton" type="submit" value="取消该预定"></td>
			</s:form>
			</tr>
			</s:iterator>
		</table>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
