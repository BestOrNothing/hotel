<%@page import="model.BookingInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的订房信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function f(){
			queryType = document.getElementById("queryType");
			idx = queryType.selectedIndex;
			s = queryType.options[idx].text;
			inTimeL = document.getElementById("inTimeL");
			outTimeL = document.getElementById("outTimeL");
			if(s == "查询我的所有住房情况"){
				inTimeL.style.display = "none";
				outTimeL.style.display = "none";
			}
			else if(s == "按入店时间查询"){
				inTimeL.style.display = "";
				outTimeL.style.display = "none";
			}
			else{
				inTimeL.style.display = "none";
				outTimeL.style.display = "";
			}
		}
	</script>
  </head>
  
  <body>
	<%@include file="head.jsp" %>
	<div id="content">
		<h1>我的订房信息</h1>
		<div class="searchDiv">
		<form action="queryMyBookingInfo.action" method="post">
			<select id="queryType" name="queryType" onchange="f();">
				<option>查询我的所有住房情况</option>
				<option>按入店时间查询</option>
				<option>按离店时间查询</option>
			</select>
			<label id="inTimeL">入店时间: <input name="inTime" onclick="WdatePicker()"></label>
			<label id="outTimeL">离店时间: <input name="outTime" onclick="WdatePicker()"></label>
			<br><br><input type="submit" value="查询" class="purpleButton">
		</form>
		</div>
		<script type="text/javascript">f();</script>
		<table class="resultTable">
			<tr>
				<th>房间号</th>
				<th>入店时间</th>
				<th>离店时间</th>
				<th>房间价格</th>
				<th></th>
			</tr>
			<s:iterator value="#request.list" id="room">
			<tr class="resultItem">
				<td><s:property value="id"/></td>
				<td><s:property value="inTime"/></td>
				<td><s:property value="outTime"/></td>
				<td><s:property value="price"/></td>
				<td>
				<s:if test="%{#room.inTime >= #request.thisDay}">
					<s:a href="cancelBook.action?id=%{id}&inTime=%{inTime}&outTime=%{outTime}&price=%{price}"><button style="width:90px;" class="purpleButton">取消预定</button></s:a>
				</s:if>
				</td>
			</tr>
			</s:iterator>
		</table>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
