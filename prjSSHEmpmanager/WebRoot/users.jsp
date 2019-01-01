<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
<p align="center">用户列表</p>
<hr />
<table width="450" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr align="center" bgcolor="#FFFF99">
    <td>编号</td>
    <td>名称</td>
    <td>密码</td>
    <td>操作</td>
  </tr>
  <s:iterator value="#session.lsus" var="us">
  <tr align="center">
    <td>${us.uid}</td>
    <td>${us.uname}</td>
    <td>${us.passwd}</td>
    <td><a href="delById_Users.action?id=${us.uid}">删除</a>  <a href="findById_Users.action?id=${us.uid}">修改</a></td>
  </tr>
  </s:iterator>
</table>
<hr />
<form id="form1" name="form1" method="post" action="save_Users.action">
  <table width="450" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr bgcolor="#FFFF99">
      <td colspan="2" align="center" bgcolor="#FFFF99">用户增加</td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td width="57">账号</td>
      <td width="383"><label for="us.uname"></label>
      <input type="text" name="us.uname" id="us.uname" /></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td>密码</td>
      <td><label for="us.passwd"></label>
      <input type="text" name="us.passwd" id="us.passwd" /></td>
    </tr>
    <tr bgcolor="#FFFF99">
      <td colspan="2" align="center" bgcolor="#FFFF99"><input type="submit" name="button" id="button" value="提交" />
      <input type="reset" name="button2" id="button2" value="重置" /></td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>