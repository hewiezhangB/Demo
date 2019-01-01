package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IOrderMainDAO;
import com.jinzhi.dao.impl.OrderMainDAOImpl;
import com.jinzhi.entity.OrderMain;

public class OrderMainUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ��Ԫ��
		String id = request.getParameter("orderNum") ;
		int customerId =Integer.parseInt(request.getParameter("customerId")) ;
		String customerName = request.getParameter("customerName") ;
		String Tel = request.getParameter("Tel") ;
		String address = request.getParameter("address") ;
		String status = request.getParameter("status") ;
		String context = request.getParameter("context") ;
		String sumprice = request.getParameter("sumprice") ;
		String adminId = request.getParameter("adminId");
		//���ʵ��
		OrderMain orderMain = new OrderMain(customerId, customerName, Tel, address, status, adminId, context, sumprice);
		IOrderMainDAO orderMainDAO = new OrderMainDAOImpl();
		int count = orderMainDAO.save(orderMain) ;
		String message = "������������ʧ��";
		String returnUrl = "OrderMainFindByIdServlet?id ="+ id;
		if(count>=1){
			message = "�������������ɹ���";
			returnUrl = "OrderMainListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
