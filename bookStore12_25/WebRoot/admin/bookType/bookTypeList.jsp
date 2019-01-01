<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookType"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
int nowPage =Integer.parseInt(request.getAttribute("nowPage").toString());
List<BookType> studentList =(List<BookType>)request.getAttribute("bookTypeList") ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书类别列表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet"
			type="text/css">
    <style type="text/css">
		
	</style>
	<script type="text/javascript">
	function goToNowPage(nowPage){
			if(isNaN(nowPage)){
				alert("请输入数字！");
				return ;
			}
			var nPage =parseInt(nowPage) ;
			if(nPage<1||nPage><%=pageCount%> ){
				alert("请输入1至<%=pageCount%>之间！");
				return ;
			}
			location.href="<%=path%>/BookDiscussListServlet?nowPage=" + nPage;
		}
	</script>
  </head>
  <body>
    	<table border=1>
    		<caption>图书类别列表</caption>
    		<tr onmouseover="this.bgColor='pink'" onmouseout="this.bgColor='white'">
    		<td colspan = "8"><a href = "<%=request.getContextPath()%>/BookTypeAddServlet">新增</a></td></tr>
    		<tr>
    			<th>bookTypeId</th>
    			<th>parentId</th>
    			<th>bookTypeName</th>
    			<th>context</th>
    			<th>isDelete</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<BookType> bookType = (List<BookType>)request.getAttribute("bookTypeList") ;
    		%>
    		<%for(BookType bookType2:bookType){%>
    			<tr onmouseover="this.bgColor='yellow'" onmouseout="this.bgColor='white'">
  				<td ><%=bookType2.getBookTypeId() %></td>
				<td ><%=bookType2.getParentId()%></td>
				<td ><%=bookType2.getBookTypeName() %></td>
				<td ><%=bookType2.getContext() %></td>
				<td ><%=bookType2.getIsDelete() %></td>
				<td ><a href = "<%=request.getContextPath()%>/BookTypeFindByIdServlet?id=<%=bookType2.getBookTypeId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/BookTypeDeleteServlet?id=<%=bookType2.getBookTypeId()%>" onclick="return confirm('您确定要删除<%=bookType2.getBookTypeName() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
    		<tr>
			<td colspan="8">共<%=pageCount%>页 &nbsp 当前第<%=nowPage%>页 &nbsp
				<a href="<%=request.getContextPath()%>/BookTypeListServlet?nowPage=1">首页</a>
				&nbsp<%
				if (nowPage == 1) {%> 
				上一页 
				<%} else {%>
				<a href="<%=request.getContextPath()%>/BookTypeListServlet?nowPage=<%=nowPage - 1%>">
				上一页
				</a>&nbsp 
				<%}
				%> 
				<%if (nowPage >= pageCount) {%> 
				下一页 
				<%} else {%> 
				<a href="<%=request.getContextPath()%>/BookTypeListServlet?nowPage=<%=nowPage + 1%>">
				下一页</a> 
				&nbsp <% } %> 
				<a href="<%=request.getContextPath()%>/BookTypeListServlet?nowPage=<%=pageCount%>">
				尾页</a>
				<select style="width:90px;" onchange="goToNowPage(this.value)" >
					<%
						for (int i = 1; i <= pageCount; i++) {
					%>
					<option value="<%=i%>" <% if(i == nowPage) {out.print("selected");}%>>
					当前第<%=i%>页
					</option>
					<%
						}
					%>
			</select> <input size="18" onchange="goToNowPage(this.value)" placeholder="请输入要阅读的页数"></td>
		</tr>
    	</table>
  </body>
</html>