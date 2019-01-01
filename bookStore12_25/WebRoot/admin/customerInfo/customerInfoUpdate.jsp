<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.CustomerInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>新增用户基本信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
更新用户基本信息
<%
CustomerInfo customerInfo =(CustomerInfo)request.getAttribute("customerInfo") ;
%>
<form action="<%=request.getContextPath()%>/CustomerUpdateServlet" method="post">
<input  type ="hidden" name ="customerId" value="<%=customerInfo.getCustId()%>" >

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


