<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.jinzhi.entity.BookType"%>
<%BookType bookType = (BookType)request.getAttribute("bookType"); %>
<html>
  <head>
  	<title>更新图书类别</title>
  	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
  </head>
  
  <body>
	<form action="<%=request.getContextPath()%>/BookTypeUpdateServlet" method="post">
	<input type ="hidden" name = "bookTypeId" value="<%=bookType.getBookTypeId()%>"/>
		<table>
			<caption>图书类别添加</caption>
			<tr>
			  <td>图书类别名称：</td>
			  <td><input type="text" name="bookTypeName" id="bookTypeName" value="<%=bookType.getBookTypeName() %>"></td>
			</tr>
			<tr>
			  <td>父编号：</td>
			  <td>
			  <input type="text" id="parentId" name ="parentId" value="<%=bookType.getParentId() %>">
			  </td>
			  <td></td>
			</tr>
			<tr>
			  <td>备注：</td>
			  <td><input type="text" name="context" id="context" value="<%=bookType.getContext() %>"></td>
			</tr>
			<tr>
			  <td>是否可用：</td>
			  <td>
			    <input type="radio" name="isDelete" value="1" <%if(bookType.getIsDelete()== 1){out.print("checked");} %> id="yes" >是
			    <input type="radio" name="isDelete" value="0" <%if(bookType.getIsDelete()== 0){out.print("checked");} %> id="no">否
			  </td>
			</tr>
			<tr>
			  <td><input type="submit" name="submit" value="提交" id="submit"></td>
			  <td><input type="reset" name="reset" value="重置" id="reset"></td>
			</tr>
		</table>
	</form>
  </body>
</html>