<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>新增图书基本信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
更新图书基本信息
<%
BookInfo bookInfo = (BookInfo)request.getAttribute("bookInfo") ;
%>
<form action="<%=request.getContextPath()%>/BookInfoUpdateServlet" method="post">
<input  type ="hidden" name ="BookId" value="<%=bookInfo.getBookId() %>" >
<table align="center">
	<tr>
		<td>图书名称:</td>
		<td><input type="text" name="bookName" value = "<%=bookInfo.getBookName() %>"placeholder="请输入名称" autofocus required> </td>
	</tr>
	<tr>
		<td>图书类别编号:</td>
		<td><input type="number" name="bookTypeId" value = "<%=bookInfo.getBooktypeId() %>" placeholder="类别编号" required> </td>
	</tr>
	<tr>
		<td>作者:</td>
		<td><input type="text" name="Author" value = "<%=bookInfo.getAuthor() %>" placeholder="请输入名称" required> </td>
	</tr>
	<tr>
		<td>出版社名称:</td>
		<td><input type="text" name="pbName" value = "<%=bookInfo.getPbName() %>" placeholder="请输入名称"  required> </td>
	</tr>
	<tr>
		<td>图书介绍:</td>
		<td><input type="text" name="Context" value = "<%=bookInfo.getContext() %>" placeholder="请输入介绍" required> </td>
	</tr>
	<tr>
		<td>图书图片:</td>
		<td><input type="text" name="smallImg" value = "<%=bookInfo.getSmallImg() %>" placeholder="请输入图书图片路径" required> </td>
	</tr>
	<tr>
		<td>图书图片:</td>
		<td><input type="text" name="bigImg" value = "<%=bookInfo.getBigImg() %>" placeholder="请输入图书图片路径" required> </td>
	</tr>
	<tr>
		<td>价格:</td>
		<td><input type="text" name="Price" value = "<%=bookInfo.getPrice() %>" placeholder="请输入价格" required> </td>
	</tr>	
	<tr>
		<td>出版日期:</td>
		<td><input type="date" name="Pbdate" value = "<%=bookInfo.getPbdate() %>"autofocus required> </td>
	</tr>
	<tr>
		<td>会员价:</td>
		<td><input type="text" name="Hyprice" value = "<%=bookInfo.getHyprice() %>" placeholder="请输入会员价格" required> </td>
	</tr>
	<tr>
		<td>图书状态:</td>
		<td>
			<input type="radio" name="bookStates" value="0">不可用
			<input type="radio" name="bookStates" value="1" checked="checked">未上架
			<input type="radio" name="bookStates" value="2">上架
			<input type="radio" name="bookStates" value="3" checked="checked">缺货
		</td>
	</tr>
	<tr>
		<td>上架日期:</td>
		<td><input type="date" name="Sjdate" value="<%=bookInfo.getSjdate() %>" required> </td>
	</tr>
	<tr>
		<td>库存量:</td>
		<td><input type="text" name="Num" value="<%=bookInfo.getNum() %>" required> </td>
	</tr>
	<tr>
		<td>累积销售量:</td>
		<td><input type="text" name="SaleCount" value="<%=bookInfo.getSaleCount() %>" required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>



