package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IOrderDetailDAO;
import com.jinzhi.dao.impl.OrderDetailDAOImpl;
import com.jinzhi.entity.OrderDetail;

public class OrderDetailUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ��Ԫ��
		String orderNum = request.getParameter("orderNum") ;
		int id = Integer.parseInt(request.getParameter("detail")) ;
		int bookId = Integer.parseInt(request.getParameter("bookId")) ;
		int num = Integer.parseInt(request.getParameter("num"));
		//���ʵ��
		OrderDetail orderDetail = new OrderDetail(orderNum, bookId, num);
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		int count = orderDetailDAO.save(orderDetail) ;
		String message = "������ϸ����ʧ��";
		String returnUrl = "OrderDetailFindByIdServlet?id ="+ id ;
		if(count>=1){
			message = "������ϸ�����ɹ���";
			returnUrl = "OrderDetailListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
