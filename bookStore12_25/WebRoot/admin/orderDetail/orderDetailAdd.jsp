<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>新增订单明细信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
新增订单明细信息
<form action="<%=request.getContextPath()%>/OrderDetailSaveServlet" method="post">
<table align="center">	
	<tr>
		<td>明细编号:</td>
		<td><input type="number" name="detail" placeholder="请输入明细编号" autofocus required> </td>
	</tr>
	<tr>
		<td>主表ID:</td>
		<td><input type="number" name="orderNum" placeholder="请输入主表ID" required min="18" max="36"> </td>
	</tr>
	<tr>
		<td>商品编号:</td>
		<td><input type="number" name="bookId" autofocus required> </td>
	</tr>
	<tr>
		<td>订购数量:</td>
		<td><input type="number" name="num" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
