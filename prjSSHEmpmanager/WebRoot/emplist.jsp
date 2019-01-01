<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pb==null }">
	<c:redirect url="findPageAll_Emp.action"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工列表</title>
<style>
	table{
		font:"宋体";
		font-size:14.5px;	
	}
</style>
<script>
	//更改每页记录数的事件方法
	function dochangeRows(){
		//获取每页记录数
		var rows=document.form1.rows.value;
		if(isNaN(rows)){
			alert('请输入正确的整数数字！');
			document.form1.rows.value=${pb.rows};
			return;
		}
		window.location="findPageAll_Emp.action?rows="+rows;
		
	}
	//更改页数的事件方法
	function dochangePage(){
		//获取当前页数
		var page=document.form1.page.value;
		if(isNaN(page)){
			alert('请输入正确的整数数字！');
			document.form1.page.value=${pb.page};
			return;
		}
		window.location="findPageAll_Emp.action?page="+page;
		
	}



</script>

</head>

<body>
<p align="center">员工列表</p>
<hr />
<table width="800" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr align="center" bgcolor="#FFFFCC">
    <td width="60">编号</td>
    <td width="108">姓名</td>
    <td width="60">性别</td>
    <td width="126">地址</td>
    <td width="121">生日</td>
    <td width="126">部门</td>
    <td width="169">操作</td>
  </tr>
  <s:iterator value="#session.pb.pagelist" var="emp">
  <tr align="center">
    <td>${emp.eid}</td>
    <td>${emp.ename}</td>
    <td>${emp.sex}</td>
    <td>${emp.address}</td>
    <td><s:date name="#emp.birthday" format="yyyy-MM-dd"/></td>
    <td>${emp.dep.depname}</td>
    <td><a href="delById_Emp.action?eid=${emp.eid}" onclick="return window.confirm('是否真的删除！')">删除</a> <a href="findById_Emp.action?eid=${emp.eid}">修改</a> <a href="findDetail_Emp.action?eid=${emp.eid}">详细</a></td>
  </tr>
  </s:iterator>
</table>
<form id="form1" name="form1" method="post" action="">
  <table width="800" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr align="center" bgcolor="#FFFFCC">
      <td>
      		<s:if test="#session.pb.page>1">
      			<a href="findPageAll_Emp.action?page=1">首页</a>
      		</s:if>
      		<s:else>
      			首页
      		</s:else>	
      </td>
      <td>
      	<s:if test="#session.pb.page>1">
      		<a href="findPageAll_Emp.action?page=${pb.page-1}">上页</a>
      	</s:if>
      		<s:else>
      			上页
      		</s:else>	
      	</td>
      <td>
      	<s:if test="#session.pb.page<#session.pb.maxpage">
      		<a href="findPageAll_Emp.action?page=${pb.page+1}">下页</a>
      	</s:if>	
      	<s:else>
      			下页
      	</s:else>
      </td>
      <td>
      	<s:if test="#session.pb.page<#session.pb.maxpage">
      		<a href="findPageAll_Emp.action?page=${pb.maxpage}">末页</a>
      	</s:if>
      	<s:else>
      			末页
      	</s:else>		
      </td>
      <td>每页
        <label for="rows"></label>
      <input name="rows" value="${pb.rows}" type="text" id="rows" size="2" />
      条记录
      <input type="button" name="button" id="button" value="确定" onclick="dochangeRows()" /></td>
      <td>跳转到第
        <label for="page"></label>
        <input name="page" value="${pb.page}" type="text" id="page" size="2" />
        页
<input type="button" name="button2" id="button2" value="确定" onclick="dochangePage()" /></td>
      <td>${pb.page}/${pb.maxpage}页</td>
    </tr>
  </table>
</form>
<hr />
<p align="center"><a href="empadd.jsp">返回添加</a></p>
</body>
</html>