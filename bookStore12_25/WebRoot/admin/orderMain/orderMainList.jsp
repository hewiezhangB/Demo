<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.Student"%>
<%@page import="com.jinzhi.entity.OrderMain"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单主表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet"
			type="text/css">
    <style type="text/css">
		
	</style>
	<script type="text/javascript">
	
	</script>
  </head>
  <body>
    	<table border=1>
    		<caption>订单主表</caption>
    		<tr> 		
    			<th>orderNum</th>
    			<th>customerId</th>
    			<th>customerName</th>
    			<th>address</th>
    			<th>Status</th>
    			<th>adminId</th>
    			<th>Context</th>
    			<th>Sumprice</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<OrderMain> orderMainList =(List<OrderMain>)request.getAttribute("orderMainList") ;
    		%>
    		<%
    		for(OrderMain orderMain:orderMainList){%>
    			<tr>
  				<td ><%=orderMain.getOrderNum() %></td>
				<td ><%=orderMain.getCustomerId()%></td>
				<td ><%=orderMain.getCustomerName() %></td>
				<td ><%=orderMain.getAddress() %></td>
				<td ><%=orderMain.getStatus() %></td>
				<td ><%=orderMain.getAdminId() %></td>
				<td ><%=orderMain.getContext() %></td>
				<td ><%=orderMain.getSumprice() %></td>
				<td ><a href = "<%=request.getContextPath()%>/OrderMainFindByIdServlet?id=<%=orderMain.getCustomerId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/OrderMainDeleteServlet?id=<%=orderMain.getCustomerId()%>" onclick="return confirm('您确定要删除<%=orderMain.getCustomerName() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
				<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/orderMain/orderMainAdd.jsp">新增</a></td></tr>
  			
    	</table>
  </body>
</html>
