<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>新增订单信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
新增订单信息
<form action="<%=request.getContextPath()%>/OrderMainUpdateServlet" method="post">
<table align="center">
	<tr>
		<td>订单编号:</td>
		<td><input type="number" name="orderNum" placeholder="请输入订单编号" required> </td>
	</tr>
	<tr>
		<td>客户编号:</td>
		<td><input type="number" name="customerId"  placeholder="请输入客户编号" required> </td>
	</tr>
	<tr>
		<td>收货人姓名:</td>
		<td><input type="text" name="customerName" placeholder="请输入姓名" autofocus required> </td>
	</tr>
	<tr>
		<td>收货人电话:</td>
		<td><input type="number" name="Tel" placeholder="请输入收货人电话" required> </td>
	</tr>
	<tr>
		<td>收货地址:</td>
		<td><input type="text" name="address"  required> </td>
	</tr>
	<tr>
		<td>销售单状态:</td>
		<td>
			<input type="radio" name="status" value="0" >未处理
			<input type="radio" name="status" value="1" >已处理 
			<input type="radio" name="status" value="2" >以发货
			<input type="radio" name="status" value="3" >已收货 
		</td>
	</tr>
	<tr>
		<td>处理人编号:</td>
		<td><input type="number" name="adminId" required> </td>
	</tr>
	<tr>
		<td>备注:</td>
		<td><input type="text" name="Context" required> </td>
	</tr>
	<tr>
		<td>总价:</td>
		<td><input type="number" name="Sumprice" required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
