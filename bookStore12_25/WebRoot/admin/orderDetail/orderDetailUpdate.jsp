<%@page import="com.jinzhi.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.OrderDetail"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
	<title>新增订单明细信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
更新订单明细信息
<%
OrderDetail orderDetail = (OrderDetail)request.getAttribute("orderDetailList");
%>
<form action="<%=request.getContextPath()%>/StudentUpdateServlet" method="post">
<input  type ="hidden" name ="bookId" value="<%=orderDetail.getBookId() %>" >
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


