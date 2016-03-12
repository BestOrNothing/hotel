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
  	<div id="content">
  		<h1>客房预定管理</h1>
		<table class="resultTable">
			<tr class="resultItem">
				<th>房号</th>
				<th>房间类型</th>
				<th>房间价格</th>
				<th>操作</th>
			</tr>
			<s:iterator value="#request.list">
			<tr class="resultItem">
			<s:form theme="simple" method="post" action="bookingManageExec">
				<td><s:property value="id"/><s:hidden value="%{id}" name="id"/></td>
				<td><s:property value="type"/></td>
				<td><s:property value="price"/></td>
				<td><input style="width:200px;" class="purpleButton" type="submit" value="查看该房间的所有预定"></td>
			</s:form>
			</tr>
			</s:iterator>
		</table>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
