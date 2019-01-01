<%@page import="com.jinzhi.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.News"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
	<title>新增新闻信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css" rel="stylesheet" type="text/css">
</head>
<body>
更新新闻信息
<%
News news = (News)request.getAttribute("newsList");
%>
<form action="<%=request.getContextPath()%>/NewsUpdateServlet" method="post">
<input  type ="hidden" name ="newsId" value="<%=news.getNewsId() %>" >
<table align="center">
	<tr>
		<td>管理员编号:</td>
		<td><input type="number" name="adminId" placeholder="请输入管理员编号" min = 0 autofocus required> </td>
	</tr>
	<tr>
		<td>标题:</td>
		<td><input type="text" name="title" placeholder="请输入标题" > </td>
	</tr>
	<tr>
		<td>内容:</td>
		<td><input type="text" name="context" autofocus required> </td>
	</tr>
	<tr>
		<td>发布时间:</td>
		<td><input type="date" name="FbTime" autofocus required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



