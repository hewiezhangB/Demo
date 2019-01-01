<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookDiscuss"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
int nowPage =Integer.parseInt(request.getAttribute("nowPage").toString());
List<BookDiscuss> studentList =(List<BookDiscuss>)request.getAttribute("bookDiscussList") ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>书评信息列表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet" type="text/css">
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
    	<tr onmouseover="this.bgColor='pink'" onmouseout="this.bgColor='white'">
    	<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/bookDiscuss/bookDiscussAdd.jsp">新增</a></td></tr>
    		<caption>书评信息列表</caption>
    		<tr>
    			<th>disId </th>
    			<th>bookId </th>
    			<th>custId</th>
    			<th>context </th>
    			<th>states</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<BookDiscuss> bookDiscussList =(List<BookDiscuss>)request.getAttribute("bookDiscussList") ;
    		%>
    		<%
    		for(BookDiscuss bookDiscuss:bookDiscussList){%>
    			<tr>
  				<td ><%=bookDiscuss.getDisId() %></td>
				<td ><%=bookDiscuss.getBookId() %></td>
				<td ><%=bookDiscuss.getCustId() %></td>
				<td ><%=bookDiscuss.getContext() %></td>
				<td ><%=bookDiscuss.getStates() %></td>
				<td ><a href = "<%=request.getContextPath()%>/BookDiscussFindByIdServlet?id=<%=bookDiscuss.getDisId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/BookDiscussDeleteServlet?id=<%=bookDiscuss.getDisId()%>" onclick="return confirm('您确定要删除<%=bookDiscuss.getBookId() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
    		<tr>
			<td colspan="8">共<%=pageCount%>页 &nbsp 当前第<%=nowPage%>页 &nbsp
				<a href="<%=request.getContextPath()%>/BookDiscussListServlet?nowPage=1">首页</a>&nbsp
				<%
				if (nowPage == 1) {
				%> 
				上一页 
				<%} else {%>
				<a href="<%=request.getContextPath()%>/BookDiscussListServlet?nowPage=<%=nowPage - 1%>">
				上一页
				</a>&nbsp 
				<%}
				%> 
				<%if (nowPage >= pageCount) {%> 
				下一页 
				<%} else {%> 
				<a href="<%=request.getContextPath()%>/BookDiscussListServlet?nowPage=<%=nowPage + 1%>">
				下一页</a> 
				&nbsp <% } %> 
				<a href="<%=request.getContextPath()%>/BookDiscussListServlet?nowPage=<%=pageCount%>">
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
