<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>新增用户基本信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
新增用户基本信息
<form action="<%=request.getContextPath()%>/CustomerInfoSaveServlet" method="post">
<table align="center">
	<tr>
		<td>客户名称:</td>
		<td><input type="text" name="custName" placeholder="请输入客户名称" autofocus required> </td>
	</tr>
	<tr>
		<td>用户密码:</td>
		<td><input type="text" name="pwd" autofocus required> </td>
	</tr>
	<tr>
		<td>邮箱:</td>
		<td><input type="text" name="email" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
