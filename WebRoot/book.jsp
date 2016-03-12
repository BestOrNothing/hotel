<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订房</title>
    
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
	</script>
  </head>
  
  <body>
	<%@include file="head.jsp" %>
	<div id="content">
		<h1>订房</h1>
		<div class="searchDiv">
			<form action="search.action?res=book" method="post" onsubmit="return f();">
				入店时间: <input value="<s:property value="#request.inTime"/>" class="searchInput" id="inTime" type="text" onClick="WdatePicker()" name="inTime"/>
				离店时间: <input value="<s:property value="#request.outTime"/>" class="searchInput" id="outTime" type="text" onClick="WdatePicker()" name="outTime">
				<label style="margin-left:50px;"><input type="checkbox" name="type" value="商务大床房">商务大床房</label>
				<label><input type="checkbox" name="type" value="大床房">大床房</label>
				<label><input type="checkbox" name="type" value="双人标准间">双人标准间</label>
				<input style="margin-left: 50px;" type="submit" value="搜索" class="purpleButton">
			</form>
			<p id="alert" style="color:red;"></p>
		</div>
		
		<div class="resultDiv">
			<table class="resultTable">
				<tr>
					<th>房号</th>
					<th>类型</th>
					<th>价格</th> 
					<th>操作</th>
				</tr>
				<s:iterator value="#request.list" id="room">
				<s:form action="book.action" method="post" theme="simple">
					<tr class="resultItem">
						<td><s:property value="id"/><s:hidden value="%{id}" name="id"></s:hidden></td>
						<td><s:property value="type"/><s:hidden value="%{type}" name="type"></s:hidden></td>
						<td><s:property value="price"/><s:hidden value="%{price}" name="price"></s:hidden></td>
						<s:hidden value="%{#session.username}" name="username"></s:hidden>
						<s:hidden value="%{#request.inTime}" name="inTime"></s:hidden>
						<s:hidden value="%{#request.outTime}" name="outTime"></s:hidden>
						<td><input type="submit" value="预定" class="purpleButton"></td>
					</tr>
				</s:form>
				</s:iterator>
			</table>
		</div>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
