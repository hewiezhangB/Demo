<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookDiscuss"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>新增书评信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
更新图书基本信息
<%
BookDiscuss bookDiscuss = (BookDiscuss)request.getAttribute("bookDiscuss") ;
%>
<form action="<%=request.getContextPath()%>/BookDiscussUpdateServlet" method="post">
<input  type ="hidden" name ="BookId" value="<%=bookDiscuss.getDisId()%>" >
<table align="center">
	<tr>
		<td>图书编号:</td>
		<td><input type="number" name="bookId" value="<%=bookDiscuss.getBookId() %>" placeholder="请输入图书编号" autofocus required> </td>
	</tr>
	<tr>
		<td>用户编号:</td>
		<td><input type="number" name="custId" value="<%=bookDiscuss.getCustId() %>" placeholder="请输入用户编号" > </td>
	</tr>
	<tr>
		<td>书评内容:</td>
		<td><input type="text" name="context" value="<%=bookDiscuss.getContext() %>" autofocus required> </td>
	</tr>
	<tr>
		<td>书评状态:</td>
		<td>
			<input type="radio" name="states" value="0">未审核
			<input type="radio" name="states" value="1" checked="checked">审核通过
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
