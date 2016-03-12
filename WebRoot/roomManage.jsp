<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客房管理</title>
    
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
		<div class="searchDiv">
		<h1>客房管理</h1>
		<s:form action="goToRoomManage.action" method="post" theme="simple">
			房号: <input name="id">
			<input style="margin-left:60px" type="submit" value="搜索" class="purpleButton">
			</s:form>
		</div>
		<a href="addRoom.jsp"><button class="purpleButton">添加房间</button></a>
		<a style="margin-left: 50px;" href="addMultiRoom.jsp"><button class="purpleButton">批量添加</button></a>
		<a style="margin-left: 50px;" href="deleteMultiRoom.jsp"><button class="purpleButton">批量删除</button></a>
		
		<table class="resultTable">
			<tr class="resultItem">
				<th>房号</th>
				<th>房间类型</th>
				<th>价格</th>
				<th>入住人1</th>
				<th>入住人2</th>
				<th>操作</th>
			</tr>
			<s:iterator value="#request.list" id="strings">
			<s:form theme="simple" action="deleteRoom.action" method="post">
			<tr class="resultItem">
				<s:iterator value="strings" var="s">
					<td><s:property value="s"/><s:hidden name="strings" value="%{s}"></s:hidden></td>
				</s:iterator>
				<td><input class="purpleButton" type="submit" value="删除该房间"></td>
			</tr>
			</s:form>
			</s:iterator>
			<s:iterator value="#request.list1" id="strings1">
			<s:form theme="simple" action="deleteRoom.action" method="post">
			<tr class="resultItem">
				<s:iterator value="strings1" var="s1">
					<td><s:property value="s1"/><s:hidden name="strings" value="%{s1}"></s:hidden></td>
				</s:iterator>
				<td><input class="purpleButton" type="submit" value="删除该房间"></td>
			</tr>
			</s:form>
			</s:iterator>
			<s:iterator value="#request.list2" id="strings2">
			<s:form theme="simple" action="deleteRoom.action" method="post">
			<tr class="resultItem">
				<s:iterator value="strings2" var="s2">
					<td><s:property value="s2"/><s:hidden name="strings" value="%{s2}"></s:hidden></td>
				</s:iterator>
				<td><input class="purpleButton" type="submit" value="删除该房间"></td>
			</tr>
			</s:form>
			</s:iterator>
		</table>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
