<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<title>新增图书基本信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
新增图书基本信息
<form action="<%=request.getContextPath()%>/BookInfoSaveServlet" method="post">
<table align="center">
	<tr>
		<td>图书名称:</td>
		<td><input type="text" name="bookName" placeholder="请输入名称" autofocus required> </td>
	</tr>
	<tr>
		<td>图书类别编号:</td>
		<td><input type="number" name="bookTypeId" placeholder="类别编号" required> </td>
	</tr>
	<tr>
		<td>作者:</td>
		<td><input type="text" name="Author" placeholder="请输入名称" required> </td>
	</tr>
	<tr>
		<td>出版社名称:</td>
		<td><input type="text" name="pbName" placeholder="请输入名称" required> </td>
	</tr>
	<tr>
		<td>图书介绍:</td>
		<td><input type="text" name="Context" placeholder="请输入介绍" required> </td>
	</tr>
	<tr>
		<td>图书图片:</td>
		<td><input type="text" name="smallImg" placeholder="请输入图书图片" required> </td>
	</tr>
	<tr>
		<td>图书图片:</td>
		<td><input type="text" name="bigImg" placeholder="请输入图书图片" required> </td>
	</tr>
	<tr>
		<td>价格:</td>
		<td><input type="text" name="Price" placeholder="请输入价格" required> </td>
	</tr>	
	<tr>
		<td>出版日期:</td>
		<td><input type="date" name="Pbdate" autofocus required> </td>
	</tr>
	<tr>
		<td>会员价:</td>
		<td><input type="text" name="Hyprice" placeholder="请输入会员价格" required> </td>
	</tr>
	<tr>
		<td>图书状态:</td>
		<td>
			<input type="radio" name="bookStates" value="0">未上架 
			<input type="radio" name="bookStates" value="1" checked="checked">在架
		</td>
	</tr>
	<tr>
		<td>上架日期:</td>
		<td><input type="date" name="Sjdate" autofocus required> </td>
	</tr>
	<tr>
		<td>库存量:</td>
		<td><input type="text" name="Num" autofocus required> </td>
	</tr>
	<tr>
		<td>累积销售量:</td>
		<td><input type="text" name="SaleCount" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>
