<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
<table width="150" border="1" cellspacing="5" cellpadding="1">
  <tr align="center" bgcolor="#FFFF99">
    <td bgcolor="#FFFF99"><a href="findPageAll_Dep.action" target="mainFrame">部门管理</a></td>
  </tr>
  <tr align="center" bgcolor="#FFFF99">
    <td><a href="findPageAll_Welfare.action" target="mainFrame">福利管理</a></td>
  </tr>
  <tr align="center" bgcolor="#FFFF99">
    <td><a href="empadd.jsp" target="mainFrame">员工管理</a></td>
  </tr>
  <tr align="center" bgcolor="#FFFF99">
    <td><a href="findPageAll_Users.action" target="mainFrame">用户管理</a></td>
  </tr>
  <tr align="center" bgcolor="#FFFF99">
    <td bgcolor="#FFFF99"><a href="logout.jsp" target="_parent">退出登录</a></td>
  </tr>
</table>
</body>
</html>