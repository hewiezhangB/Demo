<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.Favorite"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>收藏夹信息列表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet"
			type="text/css">
    <style type="text/css">
		
	</style>
	<script type="text/javascript">
	
	</script>
  </head>
  <body>
    	<table border=1>
    		<caption>收藏夹列表</caption>
    		<tr>
    			<th>favoriteId </th>
    			<th>bookId</th>
    			<th>custId</th>
    			<th>date </th>
    			<th>context</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<Favorite> favoriteList =(List<Favorite>)request.getAttribute("favoriteList") ;
    		%>
    		<%
    		for(Favorite favorite:favoriteList){%>
    			<tr>
  				<td ><%=favorite.getFarivateId() %></td>
				<td ><%=favorite.getBookId() %></td>
				<td ><%=favorite.getCustId() %></td>
				<td ><%=favorite.getDate() %></td>
				<td ><%=favorite.getContext() %></td>
				<td ><a href = "<%=request.getContextPath()%>/favoriteFindByIdServlet?id=<%=favorite.getFarivateId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/favoriteDeleteServlet?id=<%=favorite.getFarivateId()%>" onclick="return confirm('您确定要删除<%=favorite.getBookId() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
				<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/favorite/favoriteAdd.jsp">新增</a></td></tr>
  			
    	</table>
  </body>
</html>
