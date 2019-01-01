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
<p align="center">部门列表</p>
<hr />
<table width="450" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr align="center" bgcolor="#FFFF99">
    <td>编号</td>
    <td>名称</td>
    <td>操作 </td>
  </tr>
  <s:iterator value="#session.lsdep" var="dep">
  <tr align="center">
    <td>${dep.depid}</td>
    <td>${dep.depname}</td>
    <td><a href="delById_Dep.action?id=${dep.depid}">删除</a></td>
  </tr>
  </s:iterator>
</table>
<hr />
<form id="form1" name="form1" method="post" action="save_Dep.action">
  <table width="450" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr bgcolor="#FFFF99">
      <td width="89">输入部门</td>
      <td width="208"><label for="dep.depname"></label>
      <input type="text" name="dep.depname" id="dep.depname" /></td>
      <td width="139"><input type="submit" name="button" id="button" value="提交" /></td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>