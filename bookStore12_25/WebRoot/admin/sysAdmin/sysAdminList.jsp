<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.Admin"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
int nowPage =Integer.parseInt(request.getAttribute("nowPage").toString());
List<Admin> adminList =(List<Admin>)request.getAttribute("adminList") ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员信息列表</title>
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
			location.href="<%=path%>/SysAdminListServlet?nowPage=" + nPage;
		}
	</script>
  </head>
  <body>
    	<table border=1>
    	<tr><td colspan = "8"><a href = "<%=request.getContextPath()%>/admin/sysAdmin/sysAdminAdd.jsp">新增</a></td></tr>
    		<caption>管理员信息列表</caption>
    		<tr>
    			<th>adminId</th>
    			<th>adminName </th>
    			<th>pwd</th>
    			<th>adminType</th>
    			<th>update</th>
    			<th>delete</th>
    		</tr>
    		<%
    		List<Admin> sysAdminList =(List<Admin>)request.getAttribute("adminList") ;
    		%>
    		<%
    		for(Admin sysAdmin:sysAdminList){%>
    			<tr>
  				<td ><%=sysAdmin.getAdminId() %></td>
				<td ><%=sysAdmin.getAdminName()%></td>
				<td ><%=sysAdmin.getPwd()%></td>
				<td ><%=sysAdmin.getAdminType()%></td>
				<td ><a href = "<%=request.getContextPath()%>/SysAdminFindByIdServlet?id=<%=sysAdmin.getAdminId()%>">更新</a></td>
				<td ><a href = "<%=request.getContextPath()%>/SysAdminDeleteServlet?id=<%=sysAdmin.getAdminId()%>" onclick="return confirm('您确定要删除<%=sysAdmin.getAdminName() %>吗？')">删除</a></td>
  			</tr>
    		<%}
    		%>
    		<tr>
			<td colspan="8">共<%=pageCount%>页 &nbsp 当前第<%=nowPage%>页 &nbsp
				<a href="<%=request.getContextPath()%>/SysAdminListServlet?nowPage=1">首页</a>&nbsp
				<%
				if (nowPage == 1) {
				%> 
				上一页 
				<%} else {%>
				<a href="<%=request.getContextPath()%>/SysAdminListServlet?nowPage=<%=nowPage - 1%>">
				上一页
				</a>&nbsp 
				<%}
				%> 
				<%if (nowPage >= pageCount) {%> 
				下一页 
				<%} else {%> 
				<a href="<%=request.getContextPath()%>/SysAdminListServlet?nowPage=<%=nowPage + 1%>">
				下一页</a> 
				&nbsp <% } %> 
				<a href="<%=request.getContextPath()%>/SysAdminListServlet?nowPage=<%=pageCount%>">
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
