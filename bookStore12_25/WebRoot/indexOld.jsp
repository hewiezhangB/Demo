<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.BookInfo"%>
<%@page import="com.jinzhi.entity.BookType"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<BookInfo> zxBooks = (List<BookInfo>)request.getAttribute("zxBooks");
List<BookInfo> rxBooks = (List<BookInfo>)request.getAttribute("rxBooks");
List<BookInfo> tjBooks = (List<BookInfo>)request.getAttribute("tjBooks");
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
<script type="text/javascript">
	function goToBookDetail(id){
		location.href = '<%=request.getContextPath()%>/BookInfoFindByIdServlet1?id='+ id;		
	}
</script>
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
	<div class="middle_left">
  		<div class="middle_left1">
        	<div class="middle_left1title">
            	所有商品分类
            </div>
            <%
            TreeMap<BookType,List<BookType>>  bookTypes =(TreeMap<BookType,List<BookType>>)request.getAttribute("bookTypes");
            Set<BookType> parents = bookTypes.keySet();
            for(BookType bookType : parents){
            	List<BookType> son = bookTypes.get(bookType);%>
            <div class="middle_left1con">
                <div class="l2">
                    <img src="images/icon.jpg" /><%=bookType.getBookTypeName() %>
                </div>
                <%
                for(BookType sons : son){%>
                	<div class="l3">
                   &nbsp;&nbsp;<a href="<%=request.getContextPath()%>/BookListByBookTypeServlet?bookTypeId=<%=sons.getBookTypeId()%>"><%=sons.getBookTypeName() %></a><br />
                </div>
                <%}%>
            </div>
            <%}
            %>
            <div class="zzzz">
            
            </div>
        </div>
        <div class="middle_left3">
        	<h3 class="paihtit">最新排行</h3>
        	<%for(BookInfo bookInfo : rxBooks){%>
        	<a href="<%=request.getContextPath() %>/BookInfoFindByIdServlet1?id=<%=bookInfo.getBookId() %>"><%=bookInfo.getBookName() %></a>	
        	<%} %>
        </div> 
        <div class="middle_left2">
        	<img src="images/1.jpg">
        </div>
        <div class="middle_left2">
            <img src="images/2.jpg">
        </div>
         <div class="middle_left2">
            <img src="images/3.jpg">
         </div>
        
        
              
    </div>
    <div class="middle_right">
        	<div class="middle_right1L">
            	<DIV id=idContainer2 class=container>
<TABLE id=idSlider2 border=0 cellSpacing=0 cellPadding=0>
  <TBODY>
  <TR>
    <TD class=td_f><A href="#"><IMG src="images/01.jpg"></A></TD>
	<TD class=td_f><A href="#"><IMG src="images/02.jpg"></A></TD>
	<TD class=td_f><A href="#"><IMG src="images/03.jpg"></A></TD>
	<TD class=td_f><A href="#"><IMG src="images/04.jpg"></A></TD>
	<TD class=td_f><A href="#"><IMG src="images/05.jpg"></A></TD>
   </TR></TBODY></TABLE>
<UL id=idNum class=num></UL>
</DIV>

<SCRIPT>
	var forEach = function(array, callback, thisObject){
		if(array.forEach){
			array.forEach(callback, thisObject);
		}else{
			for (var i = 0, len = array.length; i < len; i++) { callback.call(thisObject, array[i], i, array); }
		}
	}
	
	var st = new SlideTrans("idContainer2", "idSlider2", 5, { Vertical: false });
	
	var nums = [];
	//插入数字
	for(var i = 0, n = st._count - 1; i <= n;){
		(nums[i] = $("idNum").appendChild(document.createElement("li"))).innerHTML = ++i;
	}
	
	forEach(nums, function(o, i){
		o.onmouseover = function(){ o.className = "on"; st.Auto = false; st.Run(i); }
		o.onmouseout = function(){ o.className = ""; st.Auto = true; st.Run(); }
	})
	
	//设置按钮样式
	st.onStart = function(){
		forEach(nums, function(o, i){ o.className = st.Index == i ? "on" : ""; })
	}
	st.Run();
</SCRIPT>
            </div>
         	<div class="middle_right1R">
            	<div class="middle_right1Rtitle"> </div>
                <div class="middle_right1Rcon">
                	<ul>
                    	<li><a href="#">喝茶儿女到江湖</a></li>
                    	<li><a href="#">纯粹·局部接触</a></li>
                    	<li><a href="#">食相报告</a></li>
                    	<li><a href="#">金庸传</a></li>
                    	<li><a href="#">我爱你，妈妈</a></li>
                    	<li><a href="#">一生必读的60本书</a></li>
                    	<li><a href="#">失落的历史</a></li>
                    	<li><a href="#">中国性史图鉴</a></li>
                    	<li><a href="#">老照片</a></li>
   				   </ul>
            </div>
            <div class="middle_right1Rimg">
            	<img src="images/middle_right1Rimg.jpg" />
            </div>           
        </div>
        <div class="middle_right2">
            	<div class="middle_right2Rtitle">最新商品 <i>New book</i></div>
                <div class="middle_right2Rcon">
					<ul>
					<% 
					for(BookInfo bookInfo : zxBooks){%>
						 <%--<li><a href="<%=request.getContextPath() %>/BookInfoFindByIdServlet1?id = <%=bookInfo.getBookId() %>"><img src="<%=request.getContextPath() %>/images/imgsx/<%=bookInfo.getSmallImg() %>"/><br /><%=bookInfo.getBookName() %></a><br /><span class="borline"><%=bookInfo.getPrice() %></span><br /><span><%=bookInfo.getHyprice() %></span><input type="button" onclick="goToBookDetail(<%=bookInfo.getBookId() %>)" class="btn3" value=" "/></li>
					--%>
						<li><a href="<%=request.getContextPath()%>/BookInfoFindByIdServlet1?id=<%=bookInfo.getBookId()%>"><img src="images/imgsx/<%=bookInfo.getSmallImg()%>"/><br /><%=bookInfo.getBookName() %></a><br /><span class="borline">市场价：￥<%=bookInfo.getPrice() %></span><br /><span>会员价：￥<%=bookInfo.getHyprice() %></span><input type="button" onclick="goToBookDetail(<%=bookInfo.getBookId() %>)" class="btn3" value=" "/></li>
					<%}
					%>
                    </ul>                
            </div>           
        </div>
         <div class="middle_right2">
            	<div class="middle_right2Rtitle title2">热销商品  <i>hot book</i></div>
                <div class="middle_right2Rcon">
					<ul>
					<%
					for(int i = 0;i < 5;i++){
						BookInfo bookInfo = rxBooks.get(i);
						%>
						<li><a href="<%=request.getContextPath()%>/BookInfoFindByIdServlet1?id=<%=bookInfo.getBookId()%>"><img src="images/imgsx/<%=bookInfo.getSmallImg()%>"/><br /><%=bookInfo.getBookName() %></a><br /><span class="borline">市场价：￥<%=bookInfo.getPrice() %></span><br /><span>会员价：￥<%=bookInfo.getHyprice() %></span><input type="button"  class="btn3" value=" "/></li>
					<%} 
					%>	
                </ul>                
            </div>           
        </div>
         <div class="middle_right3">
            	<div class="middle_right3Rtitle"></div>
                <div class="middle_right3Rcon">
				 <ul>
				 <%for(int i = 0;i < 18;i ++){
				 	BookInfo bookInfo = tjBooks.get(i);%>
					 <li><a href="<%=request.getContextPath()%>/BookInfoFindByIdServlet1?id=<%=bookInfo.getBookId()%>"><img src="images/imgsx/<%=bookInfo.getSmallImg()%>"/><br /><%=bookInfo.getBookName() %></a><br /><span class="borline">市场价：￥<%=bookInfo.getPrice() %></span><br /><span>会员价：￥<%=bookInfo.getHyprice() %></span><input type="button"  class="btn3" value=" "/></li>
				 <%} %>
                    </ul>                
            </div>           
        </div>
     
    </div>    
</div>
<div class="clear"><img src="#" width="1" height="1"></div>
<!-- footer -->
<div class="footer">
	<ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
    <ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
   	<ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
   	<ul class="lbox nolbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>




</div>
<!-- footer1 -->
<div class="footer1">
	<img src="images/footer1img.jpg" />
	<img src="images/footer2img.jpg" /> 
	<img src="images/footer3img.jpg" />
	<img src="images/footer4img.jpg" />
  	<img src="images/footer5img.jpg" />
	<img src="images/footer6img.jpg" />           
</div>
<!-- footer2 -->
<div class="footer2">
版权所有：www.xubangyiliao.com<br />
电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号
</div>
</body>
</html>
