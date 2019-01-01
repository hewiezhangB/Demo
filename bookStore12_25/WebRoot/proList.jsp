<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int nowPage = Integer.parseInt(request.getAttribute("nowPage") + "");
int pageCount = Integer.parseInt(request.getAttribute("pageCount") + "");
int bookTypeId = Integer.parseInt(request.getAttribute("bookTypeId")+ "");
List<BookInfo> bookInfoList = (List<BookInfo>)request.getAttribute("bookInfoList");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云起点</title>
<meta name="keywords" content="关键字" />
<meta name="description" content="页面描述" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
</head>
<body>
<!-- top1 -->
<div class="top1">
	<div class="top1_1">
   	欢迎您登云起点网上商城！用户名：<input type="text" name="name" class="inputsty"> 密码：<input type="text" name="password" class="inputsty"> <a href="#">忘记密码?</a> 
   	<input type="button" value="登录" class="btn1">  <input type="button" value="注册" class="btn1"> 
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>书名:<input type="text" name="" class="kuang" />  </li>
            	<li>作者:<input type="text" name="" class="kuang" />  </li>
            	<li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li><a href="#"><img src="images/car.gif"><br />购物车</a></li>
				<li><a href="#"><img src="images/car.gif"><br />订单查询  </a></li>
				<li><a href="#"><img src="images/car.gif"><br />我的空间</a></li>
				<li><a href="#"><img src="images/car.gif"><br />购书服务 </a></li>
            </ul>
            <ul class="menu">
            	<li><a href="index.html">首页</a></li>
                <li><a href="prolist.html">畅销</a></li>
                <li><a href="pro_show.html">文学</a></li>
                <li><a href="#">旺旺书系</a></li>
                <li><a href="#">文化</a></li>
                <li><a href="#">经营</a></li>
            </ul>
        </div>
	</div>
</div>
<!-- middle -->
<div class="middle">
	<%@include file = "left.jsp" %>
    <div class="middle_right">
    	<div class="middle_right6tit">
        	您当前的位置：网站首页 > 产品列表页</div>
      <div class="middle_right6con">
      <%for(BookInfo bookInfo : bookInfoList){%>
    	  <div class="warpbor">
          <div class="leftshop"><a href="<%=request.getContextPath() %>/BookInfoFindByIdServlet1?id=<%=bookInfo.getBookId() %>"><img src="images/imgsx/<%=bookInfo.getSmallImg() %>" /></a></div>
          <div class="righttext"><h3><%=bookInfo.getBookName() %></h3><p> 
 				 <span class="fontcc">(50629条评论)</span><br />
   <%=bookInfo.getAuthor() %> 著/<%=bookInfo.getPbdate() %><br />
  <%=bookInfo.getContext() %>
			   <span class="xiangx"> <%=bookInfo.getHyprice() %> <span class="textde"><%=bookInfo.getPrice() %></span> 折扣：75折 <a href="#"><img src="images/btn_buy.gif"></a><a href="collect.html"><img src="images/btn_keep.gif"></a></span></div>
      </div>
      <% } %>
      
             
  </div>
  	<div class="scott">
  	<a href="<%=request.getContextPath() %>/BookListByBookTypeServlet?nowPage=1&bookTypeId=<%=bookTypeId %>">首   页 </a>
  	<%
  	if(nowPage == 1){%>
  		<span class="disabled"> 上一页 </span>
  	<%} else {%>
  		<a href="<%=request.getContextPath()%>/BookListByBookTypeServlet?nowPage=<%=nowPage - 1%>&bookTypeId=<%=bookTypeId%>"> 上一页</a>
  	<%}%>
  	<%
  	if(nowPage >=pageCount){%>
  		<span class="disabled">下一页 </span>
  	<%} else {%>
		<a href="<%=request.getContextPath()%>/BookListByBookTypeServlet?nowPage=<%=nowPage + 1%>&bookTypeId=<%=bookTypeId%>">下一页 </a>
	<%}%>
  	<a href="<%=request.getContextPath()%>/BookListByBookTypeServlet?nowPage=<%=pageCount%>&bookTypeId=<%=bookTypeId%>">尾页</a>
  	</div>	   
	</div>


</div>
<!-- footer2 -->
<div class="footer3">
	<div class="footer3_in">
	<a href="#">公司简介</a><span>|</span><a href="#">免责条款</a><span>|</span><a href="#">隐私保护</a><span>|</span><a href="#">咨询热点</a><span>|</span><a href="#">合作招募</a><span>|</span><a href="#">配送方式</a><span>|</span><a href="#">联系我们</a>
    </div>
    <div class="footer2">
    @ 2011-2012 旭邦医疗商城 版权所有，并保留所有权利。<br />
    电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号 技术支持：<a href="#">徽韵网络</a>

    </div>
</div>
</body>
</html>
