<%@page import="com.jinzhi.dao.impl.StudentDAOImpl"%>
<%@page import="com.jinzhi.dao.IStudentDAO"%>
<%@page import="com.jinzhi.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    int pageCount =Integer.parseInt(request.getAttribute("pageCount").toString());
    int nowPage =Integer.parseInt(request.getAttribute("nowPage").toString());
    List<Student> studentList =(List<Student>)request.getAttribute("studentList") ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生信息列表</title>

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
			location.href="<%=path%>/StudentListServlet?nowPage=" + nPage;
	}
</script>
</head>
<body>
	<table border=1>
		<tr onmouseover="this.bgColor='pink'" onmouseout="this.bgColor='white'">
			<td colspan="8"><a href="<%=request.getContextPath()%>/admin/student/studentAdd.jsp">新增</a>
			</td>
		</tr>
		<caption>学生信息列表</caption>
		<tr>
			<th>stuId</th>
			<th>stuName</th>
			<th>stuAge</th>
			<th>stuBtd</th>
			<th>stuSex</th>
			<th>stuTel</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<%
			for (Student student : studentList) {
		%>
		<tr onmouseover="this.bgColor='yellow'" onmouseout="this.bgColor='white'">
			<td><%=student.getStuId()%></td>
			<td><%=student.getStuName()%></td>
			<td><%=student.getStuAge()%></td>
			<td><%=student.getStuBtd()%></td>
			<td><%=student.getStuSexView()%></td>
			<td><%=student.getStuTel()%></td>
			<td><a
				href="<%=request.getContextPath()%>/StudentFindByIdServlet?id=<%=student.getStuId()%>">更新</a>
			</td>
			<td><a
				href="<%=request.getContextPath()%>/StudentDeleteServlet?id=<%=student.getStuId()%>"
				onclick="return confirm('您确定要删除<%=student.getStuName()%>')">删除</a>
			</td>

		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="8">共<%=pageCount%>页 &nbsp 当前第<%=nowPage%>页 &nbsp
				<a href="<%=request.getContextPath()%>/StudentListServlet?nowPage=1">首页</a>&nbsp
				<%
				if (nowPage == 1) {
				%> 
				上一页 
				<%} else {%>
				<a href="<%=request.getContextPath()%>/StudentListServlet?nowPage=<%=nowPage - 1%>">
				上一页
				</a>&nbsp 
				<%}
				%> 
				<%if (nowPage >= pageCount) {%> 
				下一页 
				<%} else {%> 
				<a href="<%=request.getContextPath()%>/StudentListServlet?nowPage=<%=nowPage + 1%>">
				下一页</a> 
				&nbsp <% } %> 
				<a href="<%=request.getContextPath()%>/StudentListServlet?nowPage=<%=pageCount%>">
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


