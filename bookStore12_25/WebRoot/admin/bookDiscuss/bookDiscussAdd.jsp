<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>新增书评信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
新增书评信息
<form action="<%=request.getContextPath()%>/bookDiscussSaveServlet" method="post">
<table align="center">
	<tr>
		<td>图书编号:</td>
		<td><input type="number" name="bookId" placeholder="请输入图书编号" autofocus required> </td>
	</tr>
	<tr>
		<td>用户编号:</td>
		<td><input type="number" name="custId" placeholder="请输入用户编号" > </td>
	</tr>
	<tr>
		<td>书评内容:</td>
		<td><input type="text" name="context" autofocus required> </td>
	</tr>
	<tr>
		<td>书评状态:</td>
		<td>
			<input type="radio" name="states" value="0">存在
			<input type="radio" name="states" value="1" checked="checked">不存在 
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
