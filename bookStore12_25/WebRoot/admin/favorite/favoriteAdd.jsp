<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>新增收藏夹信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
新增收藏夹信息
<form action="<%=request.getContextPath()%>/favoriteSaveServlet" method="post">
<table align="center">
	<tr>
		<td>图书编号:</td>
		<td><input type="number" name="bookId" placeholder="请输入图书编号" autofocus required> </td>
	</tr>
	<tr>
		<td>用户编号:</td>
		<td><input type="number" name="custId" placeholder="请输入用户编号" required> </td>
	</tr>
	<tr>
		<td>收藏时间:</td>
		<td><input type="date" name="date" autofocus required> </td>
	</tr>
	<tr>
		<td>备注:</td>
		<td><input type="text" name="context" placeholder="请输入备注" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
