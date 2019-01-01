package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IOrderDetailDAO;
import com.jinzhi.dao.impl.OrderDetailDAOImpl;
import com.jinzhi.entity.OrderDetail;

public class OrderDetailListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		List<OrderDetail> orderDetailList = orderDetailDAO.findAll();
		request.setAttribute("orderDetailList", orderDetailList);
		request.getRequestDispatcher("admin/orderDetail/orderDetailList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
