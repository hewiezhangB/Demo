<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.Student"%>
<%@page import="com.jinzhi.entity.OrderDetail"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单明细列表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet"
			type="text/css">
    <style type="text/css">
		
	</style>
	<script type="text/javascript">
	
	</script>
  </head>
  <body>
    	<table border=1>
    		<caption>订单明细列表</caption>
    		<tr>		
    			<th>detail</th>
    			<th>orderNum</th>
    			<th>bookId</th>
    			<th>num</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<OrderDetail> orderDetailList =(List<OrderDetail>)request.getAttribute("orderDetailList") ;
    		%>
    		<%
    		for(OrderDetail orderDetail:orderDetailList){%>
    			<tr>
  				<td ><%=orderDetail.getDetail() %></td>
				<td ><%=orderDetail.getOrderNum() %></td>
				<td ><%=orderDetail.getBookId() %></td>
				<td ><%=orderDetail.getNum() %></td>
				<td ><a href = "<%=request.getContextPath()%>/OrderDetailFindByIdServlet?id=<%=orderDetail.getBookId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/OrderDetailDeleteServlet?id=<%=orderDetail.getBookId()%>" onclick="return confirm('您确定要删除<%=orderDetail.getBookId() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
				<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/orderDetail/orderDetailAdd.jsp">新增</a></td></tr>
  			
    	</table>
  </body>
</html>
