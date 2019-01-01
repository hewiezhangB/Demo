<%@page import="com.jinzhi.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.OrderMain"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>新增订单信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
更新订单信息
<%
OrderMain orderMain = (OrderMain)request.getAttribute("orderMainList");
%>
<form action="<%=request.getContextPath()%>/OrderMainUpdateServlet" method="post">
<input  type ="hidden" name ="customerId" value="<%=orderMain.getCustomerId() %>" >
<table align="center">
	<tr>
		<td>订单编号:</td>
		<td><input type="number" name="orderNum" value="<%=orderMain.getOrderNum() %>"  placeholder="请输入订单编号" required> </td>
	</tr>
	<tr>
		<td>客户编号:</td>
		<td><input type="number" name="customerId" value="<%=orderMain.getCustomerId() %>"  placeholder="请输入客户编号" required> </td>
	</tr>
	<tr>
		<td>收货人姓名:</td>
		<td><input type="text" name="customerName" value="<%=orderMain.getCustomerName() %>" placeholder="请输入姓名" autofocus required> </td>
	</tr>
	<tr>
		<td>收货人电话:</td>
		<td><input type="number" name="Tel" value="<%=orderMain.getTel() %>"  placeholder="请输入收货人电话" required> </td>
	</tr>
	<tr>
		<td>收货地址:</td>
		<td><input type="text" name="address"  value="<%=orderMain.getAddress() %>" required> </td>
	</tr>
	<%--<tr>
		<td>销售单状态:</td>
		<td>
			<input type="radio" name="status" value="0" <%if(orderMain.getStatus()==0){out.print("checked");} %>>未处理
			<input type="radio" name="status" value="1" <%if(orderMain.getStatus()==1){out.print("checked");} %>>已处理 
			<input type="radio" name="status" value="2" <%if(orderMain.getStatus()==2){out.print("checked");} %>>以发货
			<input type="radio" name="status" value="3" <%if(orderMain.getStatus()==3){out.print("checked");} %>>已收货 
		</td>
	</tr>
	--%><tr>
		<td>处理人编号:</td>
		<td><input type="number" name="adminId" value="<%=orderMain.getAdminId() %>"  required> </td>
	</tr>
	<tr>
		<td>备注:</td>
		<td><input type="text" name="Context" value="<%=orderMain.getContext() %>"  required> </td>
	</tr>
	<tr>
		<td>总价:</td>
		<td><input type="number" name="Sumprice" value="<%=orderMain.getSumprice() %>"  required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


