<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选择房间</title>
    
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
			inTime = document.getElementById("inTime").value;
			outTime = document.getElementById("outTime").value;
			x = document.getElementById("alert");
			if(inTime == "" || outTime == ""){
				x.innerHTML = "入店时间或离店时间不能为空";
				return false;
			}
			type = document.getElementsByName("type");
			flag = false;
			for(i=0; i<type.length; i++){
				if(type[i].checked == true){
					flag = true;
				}
			}
			if(!flag){
				x.innerHTML = "房间类型不能为空";
				return false;
			}
			if(inTime >= outTime){
				x.innerHTML = "离店时间应该大于入店时间";
				return false;
			}
			return true;
		}
		function solveDate(){
			date = new Date();
			inTime = document.getElementById("inTime");
			m = date.getMonth()+1;
			if(m<10) m = "0" + m;
			d = date.getDate();
			if(d<10) d = "0" + d;
			inTime.value = date.getFullYear() + "-" + m + "-" + d;
			//inTime.value = date.toLocaleDateString();
		}
	</script>
  </head>
  
  <body>
	<%@include file="head.jsp" %>
	<div id="content">
	<div class="searchDiv">
		<form action="search.action?res=check" method="post" onsubmit="return f();">
			入店时间: <input id="inTime" type="text" readonly="true" name="inTime"/>
			离店时间: <input value="<s:property value="#request.outTime"/>" id="outTime" type="text" onClick="WdatePicker()" name="outTime">
			<label><input type="checkbox" name="type" value="商务大床房">商务大床房</label>
			<label><input type="checkbox" name="type" value="大床房">大床房</label>
			<label><input type="checkbox" name="type" value="双人标准间">双人标准间</label>
			<input class="purpleButton" type="submit" value="搜索">
		</form>
		<p id="alert" style="color:red;"></p>
		<script type="text/javascript">solveDate();</script>
	</div><br><br>
		<table class="resultTable">
			<tr class="resultItem">
				<th>房号</th>
				<th>类型</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
			<s:iterator value="#request.list" id="room">
				<s:form theme="simple" method="post" action="goToCheckIn.action?inTime=%{#request.inTime}&outTime=%{#request.outTime}">
				<tr class="resultItem">
					<td><s:property value="id"/><s:hidden name="id" value="%{id}"></s:hidden></td>
					<td><s:property value="type"/><s:hidden name="type" value="%{type}"></s:hidden></td>
					<td><s:property value="price"/><s:hidden name="price" value="%{price}"></s:hidden></td>
					<td><input class="purpleButton" type="submit" value="登记入住"></td>
				</tr>
				</s:form>
			</s:iterator>
		</table>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
