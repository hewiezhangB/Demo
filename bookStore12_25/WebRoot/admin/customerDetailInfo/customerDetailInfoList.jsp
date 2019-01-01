<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.Student"%>
<%@page import="com.jinzhi.entity.CustomerDeInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户详细信息列表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet"
			type="text/css">
    <style type="text/css">
		
	</style>
	<script type="text/javascript">
	
	</script>
  </head>
  <body>
    	<table border=1>
    		<caption>用户详细信息列表</caption>
    		<tr>
    			<th>custId</th>
    			<th>Tel</th>
    			<th>address</th>
    			<th>Sex</th>
    			<th>Age</th>
    			<th>countMoney</th>
    			<th>Qq</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<CustomerDeInfo> customerDeInfoList = (List<CustomerDeInfo>)request.getAttribute("customerDeInfoList");
    		%>
    		<%
    		for(CustomerDeInfo customerDeInfo:customerDeInfoList){%>
    			<tr>
  				<td ><%=customerDeInfo.getCustId()%></td>
				<td ><%=customerDeInfo.getTel() %></td>
				<td ><%=customerDeInfo.getAddress() %></td>
				<td ><%=customerDeInfo.getSex() %></td>
				<td ><%=customerDeInfo.getAge()%></td>
				<td ><%=customerDeInfo.getCountMoney() %></td>
				<td ><%=customerDeInfo.getQq()%></td>
				<td ><a href = "<%=request.getContextPath()%>/CustomerDeInfoFindByIdServlet?id=<%=customerDeInfo.getCustId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/CustomerDeInfoDeleteServlet?id=<%=customerDeInfo.getCustId()%>" onclick="return confirm('您确定要删除<%=customerDeInfo.getCustId()%>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
    		<%--
				<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/customerDeInfo/customerDeInfoAdd.jsp">新增</a></td></tr>
  			--%>
  			</table>
  </body>
</html>
