<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.CustomerInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户基本信息列表</title>
    <link href="<%=path%>/admin/css/body.css" rel="stylesheet"
			type="text/css">
    <style type="text/css">
		
	</style>
	<script type="text/javascript">
	
	</script>
  </head>
  <body>
    	<table border=1>
    		<caption>用户基本信息列表</caption>
    		<tr>
    			<th>custId</th>
    			<th>custName</th>
    			<th>pwd</th>
    			<th>email</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<CustomerInfo> customerInfoList =(List<CustomerInfo>)request.getAttribute("customerInfosList") ;
    		%>
    		<%
    		for(CustomerInfo customerInfo:customerInfoList){%>
    			<tr>
  				<td ><%=customerInfo.getCustId() %></td>
				<td ><%=customerInfo.getCustName() %></td>
				<td ><%=customerInfo.getPwd() %></td>
				<td ><%=customerInfo.getEmail() %></td>
				<td ><a href = "<%=request.getContextPath()%>/CustomerInfoFindByIdServlet?id=<%=customerInfo.getCustId()%>">更新</a></td>.
				<%--<td ><a href="<%=request.getContextPath() %>/CustomerDetailInfoFindServlet?id=<%=customerInfo.getCustId() %>">查看</a></td>
				--%><td ><a href = "<%=request.getContextPath()%>/CustomerInfoDeleteServlet?id=<%=customerInfo.getCustId()%>" onclick="return confirm('您确定要删除<%=customerInfo.getCustName() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
				<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/customerInfo/customerInfoAdd.jsp">新增</a></td></tr>
  			
    	</table>
  </body>
</html>
