<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  </head>
  
  <body>
	<div class="header">
		<div class="logo">
			<a href="index.jsp" style="color:white;text-decoration:none;font-size:60">Holiday Inn</a>
		</div>
		<div class="nav">
			<ul style="font-size:28;">
				<li class="inline"><a href="index.jsp" style="color:white;text-decoration:none">首页</a></li>
				<s:if test="%{#session.username != 'admin'}">
				<li class="inline"><a href="book.jsp" style="color:white;text-decoration:none">订房</a></li>
				</s:if>
				<s:else>
				<li class="inline"><a href="manage.jsp" style="color:white;text-decoration:none">酒店管理</a></li>
				</s:else>
				<% if(session.getAttribute("username") == null){ %>
				<li class="inline"><a href="login.jsp" style="color:white;text-decoration:none">登录</a></li>
				<li class="inline"><a href="register.jsp" style="color:white;text-decoration:none">注册</a></li>
				<%} %>
				<% if(session.getAttribute("username") != null){ %>
				<li class="inline"><a href="logout.action" style="color:white;text-decoration:none">注销</a></li>
				<li class="inline"><s:a href="queryMyInfo.action?username=%{#session.username}" style="color:white;text-decoration:none">我的信息</s:a></li>
				<%} %>
			</ul>
		</div>
	</div>
  </body>
</html>
