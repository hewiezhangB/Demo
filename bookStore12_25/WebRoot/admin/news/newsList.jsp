<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.News"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻列表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet"
			type="text/css">
    <style type="text/css">
		
	</style>
	<script type="text/javascript">
	
	</script>
  </head>
  <body>
    	<table border=1>
    		<caption>新闻列表</caption>
    		<tr>	
    			<th>newsId</th>
    			<th>adminId</th>
    			<th>title</th>
    			<th>context</th>
    			<th>FbTime</th>
    			<th>isDelete</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<News> newsList =(List<News>)request.getAttribute("newsList") ;
    		%>
    		<%
    		for(News news:newsList){%>
    			<tr>
  				<td ><%=news.getNewsId() %></td>
				<td ><%=news.getAdminId() %></td>
				<td ><%=news.getTitle() %></td>
				<td ><%=news.getContext() %></td>
				<td ><%=news.getFbTime() %></td>
				<td ><%=news.getIsDelete() %></td>
				<td ><a href = "<%=request.getContextPath()%>/NewsFindByIdServlet?id=<%=news.getNewsId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/NewsDeleteServlet?id=<%=news.getNewsId()%>" onclick="return confirm('您确定要删除<%=news.getNewsId()%>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
				<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/news/newsAdd.jsp">新增</a></td></tr>
  			
    	</table>
  </body>
</html>
