<%@page import="com.jinzhi.entity.BookDiscuss"%>
<%@page import="com.jinzhi.entity.BookInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
BookInfo bookInfo = (BookInfo)request.getAttribute("bookInfo") ;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>云起点</title>
<meta name="keywords" content="关键字" />
<meta name="description" content="页面描述" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
<SCRIPT src="js/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="js/base.js" type=text/javascript></SCRIPT>

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
            <div class="middle_left1con">
                <div class="l2">
                    <img src="images/icon.jpg" />畅销：


                </div>
                <div class="l3">
                    <a href="#">流行小说</a>|<a href="#">励志</a><br />
                    <a href="#">传记</a>|<a href="#">历史</a><br />
                    <a href="#">经管</a>|<a href="#">漫画</a><br />
                    <a href="#">魔幻</a>|<a href="#">笑话</a><br />
                </div>
                <div class="l2">
                    <img src="images/icon.jpg" />文学：
                </div>
                <div class="l3">
                    <a href="#">古典文学</a>|<a href="#">现当代小说</a><br />
                    <a href="#">外国小说</a>|<a href="#">散文随笔</a><br />
                    <a href="#">诗歌</a>|
                </div>
                <div class="l2">
                    <img src="images/icon.jpg" />文化：

                </div>
                <div class="l3">
                    <a href="#">社科</a>|<a href="#">历史</a><br />
                    <a href="#">学术</a>|<a href="#">美术</a><br />
                    <a href="#">影视音乐</a>|<a href="#">饮食文化</a><br />
                </div>
                <div class="l2">
                    <img src="images/icon.jpg" />经管：
                </div>
                <div class="l3">
                    <a href="#">企业管理</a>|<a href="#">营销</a><br />
                    <a href="#">广告</a>|<a href="#">经济学</a><br />
                    <a href="#">金融</a>|<a href="#">投资</a><br />
                </div>
                <div class="l2">
                    <img src="images/icon.jpg" />少儿：

                </div>
                <div class="l3">
                    <a href="#">启蒙</a>|<a href="#">儿童读物</a><br />
                    <a href="#">青少年读物</a>|<a href="#">父母必读</a>
                </div>
                <div class="l2">
                    <img src="images/icon.jpg" />云工厂书系：
                </div>
                <div class="l3">
                    <a href="#">小说</a>|<a href="#">色相集</a><br />
                </div>
            </div>
            <div class="zzzz">
            
            </div>
        </div>
        <div class="middle_left3">
        	<h3 class="paihtit">最新排行</h3>
			<a href="#">琅琅上口的百年老课本曾经滋</a>
            <a href="#">琅琅上口的百年老课本曾经</a>
            <a href="#">琅琅上口的百年老课本曾经滋</a>
            <a href="#">琅琅上口的百年老课本曾经滋</a>
            <a href="#">琅琅上口的百年老课本曾经滋</a>
            <a href="#">琅琅上口的百年老课本曾经滋</a>
            <a href="#">琅琅上口的百年老课本曾经滋</a>
            <a href="#">琅琅上口的百年老课本曾</a>
            <a href="#">琅琅上口的百年老课本</a>
            <a href="#">琅琅上口的百年老课本曾经</a>
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
    	<div class="middle_right6tit">
        	您当前的位置：网站首页 > 产品类别 > 
        </div>
        <div class="middle_right6con">
    <div id=preview>
            <div class=jqzoom id=spec-n1 onClick="window.open('http://www.lanrentuku.com/')"><IMG height=350
            src="images/imgsd/<%=bookInfo.getBigImg() %>" jqimg="images/imgsd/<%=bookInfo.getBigImg() %>" width=350>
            </div>
            <div id=spec-n5>
                <div class=control id=spec-left>
                    <img src="images/left.gif" />
                </div>
                <div id=spec-list>
                    <ul class=list-h>
                        <li><img src="images/imgsd/<%=bookInfo.getBigImg() %>"> </li>
                        <li><img src="images/imgsd/<%=bookInfo.getBigImg() %>"> </li>
                        <li><img src="images/imgsd/<%=bookInfo.getBigImg() %>"> </li>
                        <li><img src="images/imgsd/<%=bookInfo.getBigImg() %>"> </li>
                        <li><img src="images/imgsd/<%=bookInfo.getBigImg() %>"> </li>
                        <li><img src="images/img02.jpg"> </li>
                        <li><img src="images/img03.jpg"> </li>
                        <li><img src="images/img04.jpg"> </li>
                        <li><img src="images/img01.jpg"> </li>
                        <li><img src="images/img02.jpg"> </li>
                        <li><img src="images/img03.jpg"> </li>
                        <li><img src="images/img04.jpg"> </li>
                    </ul>
                </div>
                <div class=control id=spec-right>
                    <img src="images/right.gif" />
                </div>
                
            </div>
        </div>
        <SCRIPT type=text/javascript>
            $(function(){			
               $(".jqzoom").jqueryzoom({
                    xzoom:400,
                    yzoom:400,
                    offset:10,
                    position:"right",
                    preload:1,
                    lens:1
                });
                $("#spec-list").jdMarquee({
                    deriction:"left",
                    width:350,
                    height:56,
                    step:2,
                    speed:4,
                    delay:10,
                    control:true,
                    _front:"#spec-right",
                    _back:"#spec-left"
                });
                $("#spec-list img").bind("mouseover",function(){
                    var src=$(this).attr("src");
                    $("#spec-n1 img").eq(0).attr({
                        src:src.replace("\/n5\/","\/n1\/"),
                        jqimg:src.replace("\/n5\/","\/n0\/")
                    });
                    $(this).css({
                        "border":"2px solid #ff6600",
                        "padding":"1px"
                    });
                }).bind("mouseout",function(){
                    $(this).css({
                        "border":"1px solid #ccc",
                        "padding":"2px"
                    });
                });				
            })
            </SCRIPT>
        
        <SCRIPT src="js/lib.js" type=text/javascript></SCRIPT>
        <SCRIPT src="js/163css.js" type=text/javascript></SCRIPT>

         <div class="middle_rightR">
        <table width="100%" border="0">
          <tr>
            <td>商品名称:<%=bookInfo.getBookName()%></td>
            <td>市场价：<%=bookInfo.getPrice()  %>元</td>
          </tr>
          <tr>
            <td>会员价：<%=bookInfo.getHyprice()  %>元</td>
            <td>库存情况：<%=bookInfo.getNum()  %>件</td>
          </tr>
          <tr>
            <td>上架日期：<%=bookInfo.getSjdate() %></td>
            <td>销售量：<%=bookInfo.getSaleCount() %></td>
          </tr>
          <tr>
            <td>市场价：379元</td>
            <td>商品货:om1234567</td>
          </tr>
          <tr>
            <td>会员价：379元</td>
            <td>库存情况：355件</td>
          </tr>
          <tr>
            <td>所属品牌：阿依莲</td>
            <td>点击次数：123456</td>
          </tr>
          <tr>
            <td>市场价：379元</td>
            <td>商品货:om1234567</td>
          </tr>
          <tr>
            <td>会员价：379元</td>
            <td>库存情况：355件</td>
          </tr>
          <tr>
            <td colspan="2">商品评论： <img src="images/icon3.jpg" /> (已有0人评论)</td>
          </tr>
        </table>
        <div class="middle_rightRC" style="height: 120px;"> 我 要 买
            <input type="text" name="input" class="kwid" value="2"/>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;购买此商品可使用：2200 积分<br />
          已 选 择：   2 件    总价 <span class="STYLE1">10000</span> 元<br />
         <a href="<%=request.getContextPath()%>/GwcAddServlet?id=<%=bookInfo.getBookId()%>"><img src="images/jr.jpg"/></a>
         </div>
      </div>
        
        
        
        </div> 	
        <div class="middle8">
        	<div class="middle8tit">
            	<a href="#"><span>产品信息</span></a>
                <a href="#">书 评</a>
            </div>
            <div class="middle8con" >             
<%=bookInfo.getContext() %>

        </div>
        
         <div class="middle9">
        	<div class="middle9tit">图书评论</div>
            <div class="middle_right9con">
            
            <%
            List<BookDiscuss> bookDiscusses =( List<BookDiscuss>)request.getAttribute("bookDiscusses") ;
            for(BookDiscuss bookDiscuss:bookDiscusses){%>
            	<div><%=bookDiscuss.getContext() %></div>
            	 <% }
            %>
            </div>
            </div>
        
        
        
        <div class="middle9">
        	<div class="middle9tit">用户评论</div>
            <div class="middle_right9con">
            	<div>用户名：匿名用户</div>
                <div>E-mail:<input type="text" name="text" size="25" ></div>
            	<div>评论等级：<input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"></div>
            	<div>评论内容：<textarea name="" cols="" rows=""></textarea></div>
                <div>验证码：<input type="text"  size="15"><img src="images/yz.gif"></div>
                <div><input type="button"  class="btn4" value=" " ></div>
            </div>
            </div>        
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
