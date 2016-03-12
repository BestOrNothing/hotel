<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增预定</title>
    
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
			if(inTime >= outTime){
				x.innerHTML = "离店时间应该大于入店时间";
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>
	<%@include file="head.jsp" %>
	<div id="content">
		<div id="login">
			房间号: <s:property value="#request.id"/><br><br>
			<form method="post" action="addBooking.action">
			<s:hidden value="%{#request.id}" name="id"></s:hidden>
			入店时间:<br> <input class="loginInput" onClick="WdatePicker()" name="inTime" id="inTime">
			<br><br>离店时间:<br> <input class="loginInput" onClick="WdatePicker()" name="outTime" id="outTime">
			<br><br>预定人姓名:<br> <input class="loginInput" name="username">	
			<br><br><input type="submit" value="提交" class="purpleButton">
			</form>
		</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
