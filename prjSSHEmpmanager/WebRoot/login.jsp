<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<style>
	.bgclass{
		background:url(images/bg.jpg);
		width:auto;
		height:auto;
		}
#apDiv1 {
	position: absolute;
	width: 500px;
	height: 239px;
	z-index: 1;
	left: 190px;
	top: 136px;
	background-color: #002673;
}
</style>
</head>

<body class="bgclass">
<div id="apDiv1">
  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td align="center" bgcolor="#FFFFCC"><h1>人力资源管理--员工管理</h1></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <form id="form1" name="form1" method="post" action="check_Users.action">
    <table width="450" border="1" align="center" cellpadding="1" cellspacing="0">
      <tr>
        <td colspan="2" align="center" bgcolor="#FFFFCC">用户登录</td>
      </tr>
      <tr>
        <td width="49" bgcolor="#96A8C0">账号</td>
        <td width="391" bgcolor="#96A8C0"><label for="users.uname"></label>
        <input type="text" name="users.uname" id="users.uname" /></td>
      </tr>
      <tr>
        <td bgcolor="#96A8C0">密码</td>
        <td bgcolor="#96A8C0"><label for="users.passwd"></label>
        <input type="password" name="users.passwd" id="users.passwd" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center" bgcolor="#FFFFCC"><input type="submit" name="button" id="button" value="提交" />
        <input type="reset" name="button2" id="button2" value="重置" /></td>
      </tr>
    </table>
    <br />
    <table width="450" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
        <%
        String error=request.getParameter("error");
        if(error!=null&&error.equals("1")){
      
        %>
        	<font color="red">登录失败</font>
        <%
        }
        %>
        </td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </form>
  <p>&nbsp;</p>
</div>
</body>
</html>