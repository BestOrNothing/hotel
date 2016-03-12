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
    
    <title>预定成功</title>
    
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
	<p>预定成功。房间信息如下。</p>
	
	<table class="resultTable">
		<tr class="resultItem">
			<th>房间号</th>
			<th>预定用户</th>
			<th>入店时间</th>
			<th>离店时间</th>
			<th>房间价格</th>
		</tr>
		<tr class="resultItem">
			<td><s:property value="#request.id"/></td>
			<td><s:property value="#request.username"/></td>
			<td><s:property value="#request.inTime"/></td>
			<td><s:property value="#request.outTime"/></td>
			<td><s:property value="#request.price"/></td>
		</tr>
	</table>
	<s:a href="cancelBook.action?id=%{#request.id}&username=%{#request.username}&inTime=%{#request.inTime}&outTime=%{#request.outTime}">取消预定</s:a>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
