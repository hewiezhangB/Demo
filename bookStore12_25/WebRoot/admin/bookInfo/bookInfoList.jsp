<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
int nowPage =Integer.parseInt(request.getAttribute("nowPage").toString());
List<BookInfo> studentList =(List<BookInfo>)request.getAttribute("bookInfoList") ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书基本信息列表</title>
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
			location.href="<%=path%>/BookInfoListServlet?nowPage=" + nPage;
		}
	</script>
  </head>
  <body>
    	<table border=1>
   			<tr onmouseover="this.bgColor='pink'" onmouseout="this.bgColor='white'"><td colspan = "18"><a href = "<%=request.getContextPath()%>/admin/bookInfo/bookInfoAdd.jsp">新增</a></td></tr>
    		<caption>图书基本信息列表</caption>
    		<tr>
    			<th>bookId</th>
    			<th>bookName</th>
				<th>bookTypeId</th>
				<th>Author</th>
    			<th>pbName</th>
    			<th>Context</th>
    			<th>smallImg</th>
    			<th>bigImg</th>
    			<th>Price</th>
    			<th>Pbdate</th>
    			<th>Hyprice</th>
    			<th>bookStates</th>
    			<th>Sjdate</th>
    			<th>Num</th>
    			<th>saleCount</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<BookInfo> bookInfoList =(List<BookInfo>)request.getAttribute("bookInfoList") ;
    		%>
    		<%
    		for(BookInfo bookInfo:bookInfoList){%>
    			<tr onmouseover="this.bgColor='yellow'" onmouseout="this.bgColor='white'">
  				<td ><%=bookInfo.getBookId() %></td>
				<td ><%=bookInfo.getBookName() %></td>
				<td ><%=bookInfo.getBooktypeId() %></td>
				<td ><%=bookInfo.getAuthor() %></td>
				<td ><%=bookInfo.getPbName() %></td>
				<td ><%=bookInfo.getContext() %></td>
				<td ><%=bookInfo.getSmallImg()%></td>
				<td ><%=bookInfo.getBigImg() %></td>
				<td ><%=bookInfo.getPrice() %></td>
				<td ><%=bookInfo.getPbdate() %></td>
				<td ><%=bookInfo.getHyprice() %></td>
				<td ><%=bookInfo.getBookStates() %></td>
				<td ><%=bookInfo.getSjdate() %></td>
				<td ><%=bookInfo.getNum() %></td>
				<td ><%=bookInfo.getSaleCount()%></td>
				<td ><a href = "<%=request.getContextPath()%>/BookInfoFindByIdServlet?id=<%=bookInfo.getBookId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/BookInfoDeleteServlet?id=<%=bookInfo.getBookId()%>" onclick="return confirm('您确定要删除<%=bookInfo.getBookName() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
			<tr>
			<td colspan="18">共<%=pageCount%>页 &nbsp 当前第<%=nowPage%>页 &nbsp
				<a href="<%=request.getContextPath()%>/BookInfoListServlet?nowPage=1">首页</a>&nbsp
				<%
				if (nowPage == 1) {
				%> 
				上一页 
				<%} else {%>
				<a href="<%=request.getContextPath()%>/BookInfoListServlet?nowPage=<%=nowPage - 1%>">
				上一页
				</a>&nbsp 
				<%}
				%> 
				<%if (nowPage >= pageCount) {%> 
				下一页 
				<%} else {%> 
				<a href="<%=request.getContextPath()%>/BookInfoListServlet?nowPage=<%=nowPage + 1%>">
				下一页</a> 
				&nbsp <% } %> 
				<a href="<%=request.getContextPath()%>/BookInfoListServlet?nowPage=<%=pageCount%>">
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
			</select><input size="18" onchange="goToNowPage(this.value)" placeholder="请输入要阅读的页数"></td>
		</tr>
    	</table>
  </body>
</html>
