<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
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
			if(inTime >= outTime){
				x.innerHTML = "离店时间应该大于入店时间";
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body style="margin:0px">
	<%@ include file="head.jsp" %>
	<img src="images/6.jpg" width="100%"/>
	<div class="book">
		<s:if test="%{#session.username != 'admin'}">
		<form onsubmit="return f();" action="search.action?res=book" method="post" style="margin-top: 55px;margin-left: 20px;">
			入店时间: <input onClick="WdatePicker()" style="margin-right:3%" type="text" style="color: gray;" name="inTime" id="inTime">
			离店时间: <input onClick="WdatePicker()" style="margin-right:3%" type="text" style="color: gray;" name="outTime" id="outTime">
			房间类型: <select style="margin-right:3%" name="type">
				<option>双人标准间</option>
				<option>大床房</option>
				<option>商务大床房</option>
			</select>
			<input type="submit" value="搜索" style="margin-left:10%; background: #553a99;border: 0;width: 150;height: 40px;color: white;">
		</form>
		<p id="alert" style="color:red"></p>
		</s:if>
		<s:else>	
		<div style="text-align:center; margin-top: 55px;">
			<a href="manage.jsp"><button class="purpleButton">酒店管理</button></a>	
		</div>
		</s:else>
	</div>
	<%@ include file="tail.jsp" %>
  </body>
</html>
