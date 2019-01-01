<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.Admin"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>更新管理员信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css" rel="stylesheet" type="text/css">
</head>
<body>
更新管理员基本信息
<%
Admin admin = (Admin)request.getAttribute("admin") ;
%>
<form action="<%=request.getContextPath()%>/SysAdminUpdateServlet" method="post">
<input  type ="hidden" name ="adminId" value="<%=admin.getAdminId() %>" >
<table align="center">
	<tr>
		<td>管理员姓名:</td>
		<td><input type="text" name="adminName"  value="<%=admin.getAdminName() %>"  autofocus required> </td>
	</tr>
	<tr>
		<td>管理员密码:</td>
		<td><input type="password" name="pwd" value="<%=admin.getPwd() %>"  required> </td>
	</tr>
	<tr>
		<td>管理员级别:</td>
		<td><input type="text" name="adminType" value="<%=admin.getAdminType() %>"  required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
