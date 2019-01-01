<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.servlet.front.gwc.Gwc"%>
<%@page import="com.jinzhi.servlet.front.gwc.GwcItem"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=1024" />
<title>我的购物袋</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<script type="text/javascript">
	function updateGwc(id,num){
		if(isNaN(num)){
			alert("请输入数字！");
			return ;
		}
		var nums = parseInt(num) ;
		
		if(nums<1){
			alert("请输入有效数据！");
			return ;
		}
		location.href="<%=path%>/GwcUpdateServlet?id="+id+"&num="+nums;
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
            	<li><a href="<%=request.getContextPath() %>/InitIndexServlet">首页</a></li>
                <li><a href="prolist.html">畅销</a></li>
                <li><a href="pro_show.html">文学</a></li>
                <li><a href="#">旺旺书系</a></li>
                <li><a href="#">文化</a></li>
                <li><a href="#">经营</a></li>
            </ul>
        </div>
	</div>
</div>
<div class="content">
    	  <div class="title1"></div>
        <!-- 购物袋 -->
        <dl id="myCartTitle">
        	<dt>我挑选的商品</dt>
        	<dd>现在 <a href="#">登录</a>，商品将永久保存到“我的购物袋”</dd>        </dl>
			<div class="clear"><img src="#" width="1" height="1"></div>
			<div id="myCartTable">
		<table width="100%" border="0" cellspacing="" cellpadding="5">
		  <tr>
			<th>商品名称</th>
			<th>单价（元）</th>
			<th>数量</th>
			<th>优惠</th>
			<th>小计（元）</th>
			<th>赠送积分</th>
			<th>操作</th>
		  </tr>
		  <%
		  Gwc gwc = (Gwc)session.getAttribute("gwc");
		  Collection<GwcItem> gwcItems = gwc.getAllItems();
		  if(gwcItems.isEmpty()){%>
			  <div align="center"><font size="5">您的购物袋是空的，请点击<a href="<%=request.getContextPath()%>/InitIndexServlet"><font color="yellow">这里</font></a>,进行购买</font></div>
		  <%}
		  for(GwcItem gwcItem : gwcItems){%>
		  <tr>
			<td align="left" width="400"><div class="shpic"><img src="images/imgsx/<%=gwcItem.getSmallImg() %>" /></div><span class="shname"><a href="#"><%=gwcItem.getBookName() %></a><br />
		   <span class="fccc"> 颜色：极乐绿 尺码：170/</span>92A</span></td>
			<td align="center" width="100">售 价 ：<%=gwcItem.getHyprice() %><span class="fccc"><del> <br />
		    市场价：
          <%=gwcItem.getPrice() %> </del></span></td>
			<td align="center" width="70"><a onclick="updateGwc(<%=gwcItem.getBookId()%>,<%=gwcItem.getNum()-1 %>)" title="减-" style="cursor:pointer" class="btn_minus_s">-</a>  <input name="text" type="text" class="text_num"id="num_2073165120748" onchange="updateGwc(<%=gwcItem.getBookId() %>,this.value)" value="<%=gwcItem.getNum() %>" size="2" maxlength="2" autocomplete="off" now_data2073165120748="1"/>
			<a href="<%=request.getContextPath() %>/GwcUpdateServlet?id=<%=gwcItem.getBookId() %>&num=<%=gwcItem.getNum()+1 %>" title="加+" style="cursor:pointer" class="btn_plus_s">+</a></td>
			<td align="center" width="50"><%=(gwcItem.getPrice()-gwcItem.getHyprice())*gwcItem.getNum() %></td>
			<td align="center" width="60"><%=gwcItem.getHyprice()*gwcItem.getNum() %></td>
			<td align="center" width="50"><span class="cols col-6"><span>0 </span></span></td>
			<td align="center" width="100"><span class="cols col-7"><a href = "<%=request.getContextPath() %>/FavoriteAddServlet?id=<%=gwcItem.getBookId() %>" style="cursor:pointer">加入收藏</a> |  <a href="<%=request.getContextPath() %>/GwcDeleteServlet?id=<%=gwcItem.getBookId() %>" onclick="return confirm('您确定要删除[<%=gwcItem.getBookName()%>]')">删除</a></span></td>
		  </tr> 
		  <%}
		  %>
		  <tr><td colspan="7" align="right" class="zongj">总价：¥<%=gwc.getOldPrices() %>元 -
                        优惠：¥<%=gwc.getYhPrices() %>元
                        <input type="hidden" name="packagehidden" id="packagehidden" value=""> 
                      = 商品总计(不含运费)：<span class="fred">¥<%=gwc.getHyPrices() %>元</span>  获得：0 积分点</td>
		  </tr>
		  <tr><td colspan="7"><div class="left">
					 <a class="btn_clear_cart" href = "<%=request.getContextPath() %>/InitIndexServlet"><img src="images/jxgw.png"></a>
                    <a href = "<%=request.getContextPath() %>/GwcClearServlet" class="btn_clear_cart"><img src="images/qkgw.png"></a>
                    </div>
					 <div class="right" >
					<a href="<%=request.getContextPath() %>/InitOrderServlet" class="bg_cart btn_check_order" ><img src="images/tjdd.png"></a>
					</div>
         </td></tr>
		</table>
		</div>
		<div id="interested">
			<h3>您可能感兴趣的宝贝&hellip;</h3>
				<a href="#" class="J_ClearBrowse clear" style="display: none;">清空</a>
			<div class="con">
				<ul class="tabs" id="menu3">
					<li onmouseOver="settab(3,0)"  class="current "><a href="#"><span>最近收藏的</span></a></li>
					<li onmouseOver="settab(3,1)"><a href="#"><span>最近浏览过的</span></a></li>
					<li onmouseOver="settab(3,2)"><a href="#"><span>猜你喜欢的</span></a></li>
				</ul>
						<div id="main3">
							<ul class="pannel">
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋琅</span> <span  class="fred">￥299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
							</ul>
						
						<ul class="pannel" style="display:none; ">
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养恤</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养 </span> <span  class="fred">￥299</span></a></li></ul>
						<ul class="pannel"  style="display:none; ">
									<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养 </span> <span  class="fred">￥299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">M琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">琅琅上口的百年老课本曾经滋养</span> <span  class="fred">￥299</span></a></li>
						</ul>         
			  </div></div>
		</div>
		
		<div class="clear"><img src="#" width="1" height="1"></div>  	
</div>
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
<script language="javascript"><!-- 
function settab(m,n){ 
var tli=document.getElementById("menu"+m).getElementsByTagName("li"); 
var mli=document.getElementById("main"+m).getElementsByTagName("ul"); 
for(i=0;i<tli.length;i++){ 
tli[i].className=i==n?"current":""; 
mli[i].style.display=i==n?"block":"none"; 
} 
} 
// --></script>

</html>


