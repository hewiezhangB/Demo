package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IOrderMainDAO;
import com.jinzhi.dao.impl.OrderMainDAOImpl;
import com.jinzhi.entity.OrderMain;

public class OrderMainListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IOrderMainDAO orderMainDAO = new OrderMainDAOImpl();
		List<OrderMain> orderMainList = orderMainDAO.findAll();
		request.setAttribute("orderMainList", orderMainList);
		request.getRequestDispatcher("admin/orderMain/orderMainList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
