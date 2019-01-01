package com.jinzhi.servlet.front.gwc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinzhi.dao.IOrderDetailDAO;
import com.jinzhi.dao.IOrderMainDAO;
import com.jinzhi.dao.impl.OrderDetailDAOImpl;
import com.jinzhi.dao.impl.OrderMainDAOImpl;
import com.jinzhi.entity.CustomerInfo;
import com.jinzhi.entity.OrderDetail;
import com.jinzhi.entity.OrderMain;

public class MakeOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// from 表单获取数据
		request.setCharacterEncoding("utf-8");
		String custName = request.getParameter("custName");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String context = request.getParameter("context");
		// 向订单主表添加一条数据
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session
				.getAttribute("customerInfo");
		Gwc gwc = (Gwc) session.getAttribute("gwc");

		// orderNum 17位自动生成
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String orderNum = sdf.format(new Date());
		OrderMain orderMain = new OrderMain();
		orderMain.setOrderNum(orderNum);
		orderMain.setCustomerId(customerInfo.getCustId());
		orderMain.setAddress(address);
		orderMain.setStatus("0");
		orderMain.setTel(tel);
		orderMain.setSumprice1(gwc.getYhPrices());
		orderMain.setCustomerName(custName);
		orderMain.setContext(context);
		IOrderMainDAO orderMainDao = new OrderMainDAOImpl();
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		orderMainDao.save(orderMain);
		// 向订单明细表至少添加一条数据
		
		
		Collection<GwcItem> gwcItems = gwc.getAllItems();
		List<OrderDetail> orderDetaillist = new ArrayList<OrderDetail>();
		for (GwcItem gwcItem : gwcItems) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBookId(gwcItem.getBookId());
			orderDetail.setNum(gwcItem.getNum());
			orderDetail.setOrderNum(orderNum);
			orderDetaillist.add(orderDetail);
			// orderDetailDao.save(orderDetail);
		}

		boolean flag = orderDetailDAO.save(orderDetaillist);
		// gwc.clear();
		String msg = "下订单失败请稍后再试！";
		String returnPath = "InitIndexServlet";
		if (flag) {
			msg = "下订单成功,您的订单编号是:" + orderNum + ";请等待管理员处理！";
			session.removeAttribute("gwc");
			// gwc.clear();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		request.getRequestDispatcher("msg.jsp").forward(request, response);
	}

}
