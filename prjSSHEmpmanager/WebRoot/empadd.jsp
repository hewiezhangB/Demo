<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${lsdep==null||lswf==null}">
	<c:redirect url="doinit_Emp.action"></c:redirect>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工添加</title>
<style>
	table{
		font:"宋体";
		font-size:14.5px;	
	}
</style>
</head>

<body>
<form action="save_Emp.action" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <table width="400" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="3" align="center" bgcolor="#FFFF99">员工添加</td>
    </tr>
    <tr>
      <td width="72">姓名</td>
      <td width="205"><s:textfield name="emp.ename"/></td>
      <td width="109" rowspan="7"><img src="uppic/default.jpg" width="109" height="160" /></td>
    </tr>
    <tr>
      <td>性别</td>
      <td><s:radio name="emp.sex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" value="'男'"/></td>
    </tr>
    <tr>
      <td>地址</td>
      <td><s:textfield name="emp.address"/></td>
    </tr>
    <tr>
      <td>生日</td>
      <td><input type="date" name="emp.birthday" value="1990-01-01"/></td>
    </tr>
    <tr>
      <td>选择照片</td>
      <td><s:file name="emp.pic"/></td>
    </tr>
    <tr>
      <td>部门</td>
      <td><s:select name="emp.dep.depid" list="#session.lsdep" listKey="depid" listValue="depname"/></td>
    </tr>
    <tr>
      <td>薪资</td>
      <td><s:textfield name="emp.emoney" value="2000"/></td>
    </tr>
    <tr>
      <td>福利</td>
      <td colspan="2"><s:checkboxlist name="emp.wids" list="#session.lswf" listKey="wid" listValue="wname"/></td>
    </tr>
    <tr>
      <td colspan="3" align="center" bgcolor="#FFFF99"><s:submit value="确定"/>&nbsp;<s:reset value="重置"/></td>
    </tr>
  </table>
  <p align="center"><a href="findPageAll_Emp.action">查看列表</a></p>
</form>
</body>
</html>