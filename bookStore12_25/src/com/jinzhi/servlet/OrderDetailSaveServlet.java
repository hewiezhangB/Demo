package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IOrderDetailDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.OrderDetailDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;
import com.jinzhi.entity.OrderDetail;
import com.jinzhi.entity.Student;
import com.jinzhi.util.DateUtil;

public class OrderDetailSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取表单元素
		String orderNum = request.getParameter("orderNum") ;
		int detail = Integer.parseInt(request.getParameter("detail")) ;
		int bookId = Integer.parseInt(request.getParameter("bookId")) ;
		int num = Integer.parseInt(request.getParameter("num"));
		//填充实体
		OrderDetail orderDetail = new OrderDetail(detail, orderNum, bookId, num);
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		int count = orderDetailDAO.save(orderDetail) ;
		String message = "订单明细新增失败";
		String returnUrl = "admin/orderDetail/orderDetailAdd.jsp";
		if(count>=1){
			message = "订单明细新增成功！";
			returnUrl = "OrderDetailListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
