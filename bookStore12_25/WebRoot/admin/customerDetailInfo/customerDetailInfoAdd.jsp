<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>用户详细信息列表</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
用户详细信息列表
<form action="<%=request.getContextPath()%>/StudentSaveServlet" method="post">
<table align="center">
	<tr>
		<td>联系电话:</td>
		<td><input type="number" name="Tel" placeholder="请输入联系电话" required > </td>
	</tr>
	<tr>
		<td>地址:</td>
		<td><input type="text" name="address" placeholder="请输入地址" autofocus required> </td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
			<input type="radio" name="Sex" value="0">女
			<input type="radio" name="Sex" value="1" checked="checked">男 
		</td>
	</tr>
	<tr>
		<td>年龄:</td>
		<td><input type="number" name="Age" autofocus required> </td>
	</tr>
	<tr>
		<td>累计消费金额:</td>
		<td><input type="text" name="countMoney" autofocus required> </td>
	</tr>
	<tr>
		<td>QQ号码:</td>
		<td><input type="text" name="Qq" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
