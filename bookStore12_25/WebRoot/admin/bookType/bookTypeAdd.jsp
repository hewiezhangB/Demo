<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.jinzhi.entity.BookType"%>
<%@page import="com.jinzhi.dao.impl.BookTypeDAOImpl"%>


<html>
  <head>
  	<title>添加图书类别</title>
  	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
  </head>
  
  <body>
	<form action="<%=request.getContextPath()%>/BookTypeSaveServlet" method="post">
		<table>
			<caption>图书类别添加</caption>
			<tr>
			  <td>图书类别名称：</td>
			  <td><input type="text" name="bookTypeName" id="bookTypeName"></td>
			</tr>
<%
     List<BookType> bookTypeList =(List<BookType>)request.getAttribute("bookTypes");
%>
			<tr>
			  <td>父编号：</td>
			  <td>
			  <select id="parentId" name ="parentId">
			  <%
			  for(BookType bookType : bookTypeList){%>
				    <option value="<%=bookType.getBookTypeId() %>"><%=bookType.getBookTypeName() %></option>
			  <% }
			  %>
			  </select>
			  </td>
			  
			</tr>
			<tr>
			  <td>备注：</td>
			  <td><input type="text" name="context" id="context"></td>
			</tr>
			<tr>
			  <td>是否可用：</td>
			  <td>
			    <input type="radio" name="isDelete" value="1" id="yes" checked>是
			    <input type="radio" name="isDelete" value="0" id="no">否
			  </td>
			</tr>
			<tr>
			  <td><input type="submit" name="submit" value="提交" id="submit" onclick="return valid();"></td>
			  <td><input type="reset" name="reset" value="重置" id="reset"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
			function tishi(message) {
					if(message == "success") {
						alert("客户添加成功！ ");
					} else if(message == "fail") {
						alert("客户添加失败！");
					}
				}
			
			tishi("<%=request.getAttribute("message")%>");
			
			function valid() {
				var bookTypeName = document.getElementById("bookTypeName").value;
		  		var parentId = document.getElementById("parentId").value;
		  		var context = document.getElementById("context").value;
				if(bookTypeName == "") {
					alert("图书类别名称不能为空!");
					return false;
				} else if(parentId == "") {
					alert("父编号不能为空!");
					return false;
				} else if(context == "") {
					alert("备注不能为空！");
					return false;
				} else if(isNaN(Number(parentId))) {
					alert("父编号里面的内容必须为数字!");
					return false;
				} else {
					return true;
				}
			} 	
  	</script>
  </body>
</html>