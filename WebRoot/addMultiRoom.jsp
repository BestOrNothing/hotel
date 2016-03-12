<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>批量添加房间</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function add(){
			form = document.getElementById("f");
			submit = document.getElementById("submit")
			br = document.createElement("br");
			var input1=document.createElement("input");//创建input
			span1 = document.createElement("span");
			
			span1.innerHTML = "房间号:";
    			input1.setAttribute("type","text");//设置type属性
    			input1.setAttribute("name","id");//设置name属性
    			form.insertBefore(span1, submit);
    			form.insertBefore(input1, submit);
    			
    			input2=document.createElement("input");//创建input
			span2 = document.createElement("span");
    			span2.innerHTML = "价格:";
    			input2.setAttribute("type","text");//设置type属性
    			input2.setAttribute("name","price");//设置name属性
    			form.insertBefore(span2, submit);
    			form.insertBefore(input2, submit);
    			
    			select3=document.createElement("select");//创建input
			span3 = document.createElement("span");
    			span3.innerHTML = "房间类型:";
    			select3.setAttribute("name","type");//设置name属性
    			o1 = document.createElement("option");
    			o1.innerHTML = "商务大床房";
    			o2 = document.createElement("option");
    			o2.innerHTML = "大床房";
    			o3 = document.createElement("option");
    			o3.innerHTML = "双人标准间";
    			select3.appendChild(o1);
    			form.insertBefore(span3, submit);
    			form.insertBefore(select3, submit);
    			
    			form.insertBefore(br, submit);
    			form.insertBefore(document.createElement("br"), submit);
		}
	</script>
  </head>
  
  <body>
  	<%@include file="head.jsp" %>
	<div id="content">
		<h1>批量添加房间</h1>
		<button onclick="add();" class="purpleButton">添加表单</button><br>
		<br><form id="f" action="addMultiRoom.action" method="post">
			房间号:<input type="text" name="id">
			价格:<input type="text" name="price">
			房间类型: 
			<select name="type" id="type">
				<option>商务大床房</option>
				<option>大床房</option>
				<option>双人标准间</option>
			</select><br><br>
			<input class="purpleButton" type="submit" value="提交" id="submit">
		</form>
	</div>
	<%@include file="tail.jsp" %>
  </body>
</html>
