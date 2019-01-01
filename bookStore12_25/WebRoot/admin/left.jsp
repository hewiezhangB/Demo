<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.Admin"%>
<%
	Admin admin = (Admin)session.getAttribute("admin");
	if(admin == null){
		response.sendRedirect("/login.jsp");
		return;
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 200%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 12px; LINE-HEIGHT: 150%}
// -->
</style>
<title>云工厂网上书店后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFDB" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="12">&nbsp;欢迎您:<%=admin.getAdminName() %></td>
  </tr>
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div align="center">用 户 管 理</div>
    </td>
    <td width="12"><img src="images/ht03.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
	<%
	if(admin.getAdminType() == 2){%>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/StudentListServlet" target="mainFrame">学生管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/NewsListServlet" target="mainFrame">新闻管理</a></td>
  </tr>
	<%}%>
	<%
	if(admin.getAdminType() == 1){%>
	  <tr> 
	    <td width="40">&nbsp;</td>
	    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/SysAdminListServlet"  target="mainFrame">系统用户管理</a></td>
	  </tr>
	  <tr> 
	    <td width="40">&nbsp;</td>
	    <td class="wr4" width="120"><a href="CustomerInformationList.htm" target="mainFrame">客户管理</a></td>
	  </tr>
	  <tr> 
	    <td width="40">&nbsp;</td>
	    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/CustomerInfoListServlet" target="mainFrame">客户基本信息管理</a></td>
	  </tr>
	<%}%>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/CustomerDetailInfoListServlet" target="mainFrame">客户详细信息管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">个人信息</td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht06.jpg" class="wr4"> 
      <div align="center">图 书 信 息</div>
    </td>
    <td width="12"><img src="images/ht05.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/BookTypeListServlet" target="mainFrame">图书类别</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/BookInfoListServlet" target="mainFrame">图书信息管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="OrderFormList.htm" target="mainFrame">销售管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/OrderMainListServlet" target="mainFrame">订单管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/OrderDetailListServlet" target="mainFrame">订单明细管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/FavoriteListServlet" target="mainFrame">商品库存信息</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht08.jpg" class="wr4"> 
      <div align="center">交 互 管 理</div>
    </td>
    <td width="12"><img src="images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="2">
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="saloonTypeModify.htm" target="mainFrame">栏目管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="bookSloon.htm" target="mainFrame">图书上架</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="OOSMangae.htm" target="mainFrame">缺货管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">邮件列表发送</td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="<%=request.getContextPath()%>/BookDiscussListServlet" target="mainFrame">评论管理</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120"><a href="accessingAnalysis.htm" target="mainFrame">访问分析</a></td>
  </tr>
  <tr> 
    <td width="40">&nbsp;</td>
    <td class="wr4" width="120">&nbsp;</td>
  </tr>
</table>
<table width="160" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td background="images/ht04.jpg" class="wr4"> 
      <div align="center"><a href="systemSet.htm" target="mainFrame">系 统 设 置</a></div>
    </td>
    <td width="12"><img src="images/ht03.jpg" width="12" height="20"></td>
  </tr>
  <tr>
    <td class="wr4">&nbsp;</td>
    <td width="12">&nbsp;</td>
  </tr>
  <tr>
    <td background="images/ht08.jpg" class="wr4"> 
      <div align="center"><a href="<%=request.getContextPath()%>/SysAdminLoginOutServlet" target="_parent">退 出 系 统</a></div>
    </td>
    <td width="12"><img src="images/ht07.jpg" width="12" height="20"></td>
  </tr>
</table>
</body>
</html>
<script ></script>