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
		<div class="searchDiv">
			<form action="listBookingWhenCheckIn.action" method="post">
			用户名: <input type="text" name="username" class='loginInput'>
			<input type="submit" value="搜索" class="purpleButton">
			</form>
		</div>
			<table class="resultTable">
				<tr class="resultItem">
					<th>预定用户</th>
					<th>房号</th>
					<th>房间类型</th>
					<th>价格</th>
					<th>入店时间</th>
					<th>离店时间</th>
					<th>操作</th>
				</tr>
				<s:iterator value="#request.list" id="strings">
					<s:form theme="simple" action="goToCheckIn.action" method="post">
					<tr class="resultItem">
						<s:iterator value="strings" var="s">
							<td><s:property value="s"/><s:hidden name="strings" value="%{s}"/></td>
						</s:iterator>
						<td><input class="purpleButton" type="submit" value="登记入住"></td>
					</tr>
					</s:form>
				</s:iterator>
			</table>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
