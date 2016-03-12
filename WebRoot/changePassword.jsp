<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
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
			newPw = document.getElementById("newPassword");
			reNewPw = document.getElementById("reNewPassword");
			x = document.getElementById("alert");
			if(newPw.value != reNewPw.value){
				x.innerHTML = "新密码和重复新密码不同。";
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
			<h2>修改密码</h2>
			<s:form metod="post" action="changePassword.action?username=%{#session.username}" onsubmit="return f();">
			原密码:<br> <input class="loginInput" type="password" name="oldPassword" id="oldPassword"><br><br>
			新密码:<br> <input class="loginInput" type="password" name="newPassword" id="newPassword"><br><br>
			重复新密码:<br> <input class="loginInput" type="password" name="reNewPassword" id="reNewPassword"><br><br>
			<input type="submit" value="提交" class="purpleButton">
			</s:form>
			<p id="alert" style="color:red"></p>
		</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
