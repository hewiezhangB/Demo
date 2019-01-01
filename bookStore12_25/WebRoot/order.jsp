<%@page import="com.jinzhi.servlet.front.gwc.GwcItem"%>
<%@page import="com.jinzhi.servlet.front.gwc.Gwc"%>
<%@page import="com.jinzhi.entity.CustomerInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jinzhi.entity.CustomerDeInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XhTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta name="viewport" content="width=1024" />
		<title>我的购物袋</title>
		<link rel="stylesheet" type="text/css" href="style/style.css" />
		<link rel="stylesheet" type="text/css" href="style/orderInfo.css" />
		<link rel="stylesheet" href="style/public.css" type="text/css" />

	</head>
	<body>
		<!-- top1 -->
		<div class="top1">
			<div class="top1_1">
				欢迎您登云起点网上商城！用户名：
				<input type="text" name="name" class="inputsty">
				密码：
				<input type="text" name="password" class="inputsty">
				<a href="#">忘记密码?</a>
				<input type="button" value="登录" class="btn1">
				<input type="button" value="注册" class="btn1">
			</div>
			<div class="top1_2">
				<div class="top1_2_l">
					<ul class="yudingCon">
						<li>
							书名:
							<input type="text" name="" class="kuang" />
						</li>
						<li>
							作者:
							<input type="text" name="" class="kuang" />
						</li>
						<li class="ribtn">
							<input type="image" src="images/btn.gif" class="btn" />
						</li>
					</ul>
				</div>
				<div class="top1_2_r">
					<ul class="other">
						<li>
							<a href="#"><img src="images/car.gif"> <br />购物车</a>
						</li>
						<li>
							<a href="#"><img src="images/car.gif"> <br />订单查询 </a>
						</li>
						<li>
							<a href="#"><img src="images/car.gif"> <br />我的空间</a>
						</li>
						<li>
							<a href="#"><img src="images/car.gif"> <br />购书服务 </a>
						</li>
					</ul>
					<ul class="menu">
						<li>
							<a href="index.html">首页</a>
						</li>
						<li>
							<a href="prolist.html">畅销</a>
						</li>
						<li>
							<a href="pro_show.html">文学</a>
						</li>
						<li>
							<a href="#">旺旺书系</a>
						</li>
						<li>
							<a href="#">文化</a>
						</li>
						<li>
							<a href="#">经营</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="title2"></div>
			<!-- 购物袋 -->
			<dl id="myCartTitle">
				<dt>
					确认订单信息
				</dt>
				<dd>
					<a href="#">管理收货地址</a>
				</dd>
			</dl>
			<div class="clear">
				<img src="#" width="1" height="1">
			</div>
			<div class="address">
				<!--收货人地址开始-->
				<div id=part_consignee>
					<div class=o_write>
						<h1>
							收货人信息&nbsp;
							<a id=lbtnConsigneeWrite onclick=close_consignee(this)
								href="javascript:void(0)">[关闭]</a>
							<span style="DISPLAY: none"><a style="COLOR: #ff6600"
								onclick=addNewAddress(this); href="javascript:void(0)">[创建一个新地址]</a>
							</span>
						</h1>
						<div class=middle>
							<div id=addressListPanel></div>
							<div id=consignee_addr>
								<TABLE border=0 cellSpacing=0 width="100%">
									<form action="<%=request.getContextPath()%>/MakeOrderServlet"
										method="post">
										<TBODY>
											<TR>
												<%
													CustomerInfo customerInfo = (CustomerInfo) session
															.getAttribute("customerInfo");
													CustomerDeInfo customerDeInfo = (CustomerDeInfo) session
															.getAttribute("customerDeInfo");
												%>
												<TD vAlign=center width=85 align=right>
													<FONT color=red>*</FONT>收货人姓名：
												</TD>
												<TD vAlign=center align=left>
													<INPUT value="<%=customerInfo.getCustName()%>"
														name="custName" onblur=check_addressName()
														id=consignee_addressName class=txt maxLength=20 type=text>
													&nbsp;
												</TD>
											</TR>
											<TR>
												<TD vAlign=center align=right>
													<FONT color=red>*</FONT>地 址：
												</TD>
												<TD vAlign=center align=left>
													<SPAN id=consigneeShow_addressName></SPAN>
													<INPUT onblur=check_address() name="address"
														style="WIDTh: 327px; MARGIN-LEFT: 2px"
														value="<%=customerDeInfo.getAddress()%>"
														id=consignee_address class=txt maxLength=50 type=text>
													&nbsp;
												</TD>
											</TR>
											<TR>
												<TD vAlign=center align=right>
													<FONT color=red>*</FONT>手机号码：
												</TD>
												<TD vAlign=center align=left>
													<INPUT onblur=check_message() id=consignee_message
														class=txt name="tel" value="<%=customerDeInfo.getTel()%>"
														type=text>
													&nbsp;或者 固定电话：
													<INPUT onblur=check_phone() id=consignee_phone class=txt
														type=text>
													&nbsp;
													<FONT color=#000000>用于接收发货通知短信及送货前确认</FONT>
												</TD>
											</TR>
											<TR>
												<TR>
													<TD vAlign=center align=right>
														备注：
													</TD>
													<TD vAlign=center align=left>
														<INPUT value="" name="context" id=consignee_message
															class=txt name="tel">
													</TD>
												</TR>
												<TD vAlign=center align=right>
													电子邮件：
												</TD>
												<TD vAlign=center align=left>
													<INPUT onblur=check_email() id=consignee_email class=txt
														name="email" value="<%=customerInfo.getEmail()%>"
														type=text>
													&nbsp;
													<FONT color=#000000>用来接收订单提醒邮件，便于您及时了解订单状态</FONT>
												</TD>
											</TR>
											<TR>
												<TD vAlign=center align=right>
													邮政编码：
												</TD>
												<TD vAlign=center align=left>
													<INPUT onblur=check_postcode() style="WIDTh: 77px"
														id=consignee_postcode class=txt type=text>
													&nbsp;
													<FONT style="MARGIN-LEFT: 53px" color=#000000>有助于快速确定送货地址</FONT>
												</TD>
											</TR>
										</TBODY>
								</TABLE>
							</div>
						</div>
						<div
							style="PADDING-BOTTOM: 20px; PADDING-LEFT: 45px; PADDING-RIGhT: 0px; PADDING-TOP: 10px">
							<A onclick=addNewAddress(this); href="#">[添加到常用地址]</A>
						</div>
						<div class="footstyfooter">
							<INPUT class="btn0" onclick=savePart_consignee(this)
								value=保存收货人信息 type=button>
						</div>
					</div>
				</div>
				<!--收货人地址结束-->
				<!--支付方式及配送方式开始-->
				<div id=part_payTypeAndShipType>
					<div class=o_show>
						<h1>
							支付及配送方式&nbsp;
							<A id=linkPayTypeShipType
								onclick=showForm_payTypeAndShipType(this);
								href="javascript:void(0)"
								clstag="checkout|keycount|jiesuan|linkpayshiptype">[修改]</A>
						</h1>
						<div id=updateInfo_payType></div>
						<div class=middle>
							<TABLE style="WIDTh: 100%">
								<TBODY>
									<TR>
										<TD style="TEXT-ALIGN: right; WIDTh: 80px">
											支付方式：
										</TD>
										<TD>
											在线支付
										</TD>
									</TR>
									<TR>
										<TD style="TEXT-ALIGN: right">
											配送方式：
										</TD>
										<TD>
											快递运输
										</TD>
									</TR>
									<TR>
										<TD style="TEXT-ALIGN: right">
											运 费：
										</TD>
										<TD>
											0.00元
											<SPAN style="COLOR: red">(免运费)</SPAN>
										</TD>
									</TR>
									<TR style="DISPLAY: none">
										<TD style="TEXT-ALIGN: right">
											送货日期：
										</TD>
										<TD style="COLOR: red">
											{CodTime}
										</TD>
									</TR>
									<TR style="DISPLAY: none">
										<TD style="TEXT-ALIGN: right">
											自提时间：
										</TD>
										<TD style="COLOR: red">
											{PickTime}
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</div>
						<div class=footsty></div>
					</div>
				</div>
				<!--支付方式及配送方式结束-->
				<!--发票信息开始-->
				<div id=part_invoice>
					<div class=o_show>
						<h1>
							发票信息&nbsp;
							<A onclick=showForm_invoice(this) href="javascript:void(0)"
								clstag="checkout|keycount|jiesuan|xiugaifapiao">[修改]</A>
						</h1>
						<div class=middle>
							<TABLE style="WIDTh: 100%; DISPLAY: none">
								<TBODY>
									<TR>
										<TD style="TEXT-ALIGN: left; PADDING-LEFT: 22px">
											开取类型：&nbsp;默认开取
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<TABLE style="WIDTh: 100%">
								<TBODY>
									<TR>
										<TD style="TEXT-ALIGN: right; WIDTh: 82px">
											发票类型：
										</TD>
										<TD>
											普通发票
										</TD>
									</TR>
									<TR>
										<TD style="TEXT-ALIGN: right">
											发票抬头：
										</TD>
										<TD>
											个人
										</TD>
									</TR>
									<TR>
										<TD style="TEXT-ALIGN: right">
											发票内容：
										</TD>
										<TD>
											<div>
												<SPAN style="DISPLAY: none">非图书商品：</SPAN><SPAN>明细</SPAN>
											</div>
											<div>
												<SPAN style="DISPLAY: none">图书商品：</SPAN><SPAN
													style="DISPLAY: none">不开发票</SPAN>
											</div>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<TABLE style="WIDTh: 100%; DISPLAY: none">
								<TBODY>
									<TR>
										<TD style="TEXT-ALIGN: left; PADDING-LEFT: 22px">
											不开发票
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</div>
						<div class=footsty></div>
					</div>
				</div>
				<!--发票信息结束-->
				<!--Cart信息开始-->
				<div id=part_cart></div>
				<!--Cart信息开始-->
				<!--有货先发开始-->
				<div
					style="PADDING-BOTTOM: 8px; PADDING-LEFT: 30px; PADDING-RIGhT: 0px; COLOR: red; PADDING-TOP: 8px"
					id=part_FirstInstockShip>
					<INPUT id=chk_FirstInstockShip onclick=SetTag_FirstInstockShip()
						type=checkbox>
					&nbsp;
					<LABEL for=chk_FirstInstockShip>
						先发有货商品（如果订单部分商品缺货，优先配送有货商品）
					</LABEL>
				</div>
				<!--有货先发结束-->


			</div>



			<dl id="myCartTitle">
				<dt>
					确认挑选的商品
				</dt>
				<dd>
					”
				</dd>
			</dl>
			<div class="clear">
				<img src="#" width="1" height="1">
			</div>
			<div id="myCartTable">
				<table width="100%" border="0" cellspacing="" cellpadding="5">
					<tr>
						<th>
							商品名称
						</th>
						<th>
							单价（元）
						</th>
						<th>
							数量
						</th>
						<th>
							优惠
						</th>
						<th>
							小计（元）
						</th>
						<th>
							赠送积分
						</th>
						<th>
							操作
						</th>
					</tr>
					<%
						Gwc gwc = (Gwc) session.getAttribute("gwc");
						Collection<GwcItem> gecItems = gwc.getAllItems();
						if (gecItems.isEmpty()) {
					%>
					<div align="center">
						<font size="5">您的购物袋是空的，请点击<a
							href="<%=request.getContextPath()%>/InitIndexServlet"><font
								color="red">这里</font> </a>，进行购买。</font>
					</div>
					<%
						}

						for (GwcItem gwcItem : gecItems) {
					%>
					<tr>
						<td align="left" width="400">
							<div class="shpic">
								<img src="images/imgsx/<%=gwcItem.getSmallImg()%>" />
							</div>
							<span class="shname"><a href="#"><%=gwcItem.getBookName()%>。</a>
								<br />

								<td align="center" width="100">
									售 价 ：<%=gwcItem.getHyprice()%><span class="fccc"><del>
											<br />
											市场价：
											<%=gwcItem.getPrice()%>
										</del> </span>
								</td>
								<td align="center" width="70">
									<a
										onclick="updateGwc(<%=gwcItem.getBookId()%>,<%=gwcItem.getNum() - 1%>)"
										title="减-" style="cursor: pointer" class="btn_minus_s">-</a>
									<input name="text" type="text" class="text_num"
										id="num_2073165120748"
										onchange="updateGwc(<%=gwcItem.getBookId()%>,this.value)"
										value="<%=gwcItem.getNum()%>" size="2" maxlength="2"
										autocomplete="off" now_data2073165120748="1" />
									<a
										href="<%=request.getContextPath()%>/GwcUpdateServelt?id=<%=gwcItem.getBookId()%>&num=<%=gwcItem.getNum() + 1%>"
										title="加+" style="cursor: pointer" class="btn_plus_s">+</a>
								</td>
								<td align="center" width="50"><%=(int) (gwcItem.getPrice() - gwcItem.getHyprice())
						* gwcItem.getNum()%></td>
								<td align="center" width="60"><%=gwcItem.getHyprice() * gwcItem.getNum()%></td>
								<td align="center" width="50">
									<span class="cols col-6"><span>0 </span> </span>
								</td>
								<td align="center" width="100">
									<span class="cols col-7"><a
										href="<%=request.getContextPath()%>/FavoriteAddServlet?id=<%=gwcItem.getBookId()%>"
										style="cursor: pointer">加入收藏</a> | <a
										href="<%=request.getContextPath()%>/GwcDeleteServlet?id=<%=gwcItem.getBookId()%>"
										onclick="return confirm('您确定要删除[<%=gwcItem.getBookName()%>]')">删除</a>
									</span>
								</td>
					</tr>
					<%
						}
					%>

					<tr>
						<td colspan="7" align="right" class="zongj">
							总价：¥<%=gwc.getOldPrices()%>元 - 优惠：¥<%=gwc.getYhPrices()%>元
							<input type="hidden" name="packagehidden" id="packagehidden"
								value="">
							= 商品总计(不含运费)：
							<span class="fred">¥<%=gwc.getHyPrices()%>元</span> 获得：0 积分点
						</td>
					</tr>
					<tr>
						<td colspan="7">
							<div class="left">
							</div>
							<div class="right">

								<input type="image" src="images/tjdd.png">
							</div>
						</td>
					</tr>
				</table>
				</form>
			</div>



		</div>
		<!-- footer -->
		<div class="footer">
			<ul class="lbox">
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">订单的几种状态</a>
				</li>
				<li>
					<a href="#">会员等级折扣</a>
				</li>
				<li>
					<a href="#">积分奖励计划</a>
				</li>
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">商品退货保证</a>
				</li>
			</ul>
			<ul class="lbox">
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">订单的几种状态</a>
				</li>
				<li>
					<a href="#">会员等级折扣</a>
				</li>
				<li>
					<a href="#">积分奖励计划</a>
				</li>
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">商品退货保证</a>
				</li>
			</ul>
			<ul class="lbox">
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">订单的几种状态</a>
				</li>
				<li>
					<a href="#">会员等级折扣</a>
				</li>
				<li>
					<a href="#">积分奖励计划</a>
				</li>
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">商品退货保证</a>
				</li>
			</ul>
			<ul class="lbox nolbox">
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">订单的几种状态</a>
				</li>
				<li>
					<a href="#">会员等级折扣</a>
				</li>
				<li>
					<a href="#">积分奖励计划</a>
				</li>
				<li>
					<a href="#">顾客必读</a>
				</li>
				<li>
					<a href="#">商品退货保证</a>
				</li>
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
			版权所有：www.xubangyiliao.com
			<br />
			电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号
		</div>
	</body>
</html>

