<%@page import="com.jinzhi.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>新增学生信息</title>
	<link href="<%=request.getContextPath()%>/admin/css/addUpdate.css"
	rel="stylesheet" type="text/css">
</head>
<body>
更新学生信息
<%
Student student =(Student)request.getAttribute("student") ;
%>
<form action="<%=request.getContextPath()%>/StudentUpdateServlet" method="post">
<input  type ="hidden" name ="stuId" value="<%=student.getStuId() %>" >

<table align="center">
	<tr>
		<td>学生姓名:</td>
		<td><input type="text" name="stuName" value="<%=student.getStuName() %>" placeholder="请输入姓名" autofocus required> </td>
	</tr>
	<tr>
		<td>学生年龄:</td>
		<td><input type="number" name="stuAge" value="<%=student.getStuAge() %>"  placeholder="请输入年龄"   required 
		min="18" max="36"> </td>
	</tr>
	<tr>
		<td>学生生日:</td>
		<td><input type="date" name="stuBtd"  value="<%=student.getStuBtd() %>" required> </td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
			<input type="radio" name="stuSex" value="0" <%if(student.getStuSex()==0){out.print("checked");} %>>女
			<input type="radio" name="stuSex" value="1" <%if(student.getStuSex()==1){out.print("checked");} %>>男 
		</td>
	</tr>
	<tr>
		<td>学生电话:</td>
		<td><input type="text" name="stuTel" value="<%=student.getStuTel() %>"  required> </td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"> </td>
		<td><input type="reset" value="重置"> </td>
	</tr>
</table>
</form>
</body>
</html>


