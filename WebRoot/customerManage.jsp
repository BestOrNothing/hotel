<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>住客管理</title>
    
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
		<h1>住客管理</h1>
		<table class="resultTable">
			<tr class="resultItem">
				<th>住客</th>
				<th>入住房号</th>
				<th>入店时间</th>
				<th>离店时间</th>
			</tr>
			<s:iterator value="#request.list" id="strings">
			<tr class="resultItem">
			<s:iterator value="strings" var="s">
				<td><s:property value="s"/></td>
			</s:iterator>
			</tr>
			</s:iterator>
		</table>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
