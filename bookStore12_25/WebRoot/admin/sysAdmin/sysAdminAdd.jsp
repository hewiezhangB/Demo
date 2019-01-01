<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>新增管理员信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
新增管理员信息
<form action="<%=request.getContextPath()%>/sysAdminSaveServlet" method="post">
<table align="center">
	<tr>
		<td>管理员姓名:</td>
		<td><input type="text" name="adminName" placeholder="请输入名称" autofocus required> </td>
	</tr>
	<tr>
		<td>管理员密码:</td>
		<td><input type="number" name="pwd" placeholder="管理员密码" required> </td>
	</tr>
	<tr>
		<td>管理员级别:</td>
		<td><input type="text" name="adminType" placeholder="请输入管理员级别" required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
