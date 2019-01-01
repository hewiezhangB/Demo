package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IOrderDetailDAO;
import com.jinzhi.dao.impl.OrderDetailDAOImpl;


public class OrderDetailDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		int count = orderDetailDAO.delete(id);
		String message = "¶©µ¥Ã÷Ï¸É¾³ýÊ§°Ü";
		String returnUrl = "admin/orderDetail/orderDetailAdd.jsp";
		if(count>=1){
			message = "¶©µ¥Ã÷Ï¸É¾³ý³É¹¦£¡";
			returnUrl = "OrderDetailListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
