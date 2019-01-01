package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IOrderMainDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.OrderMainDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;

public class OrderMainDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IOrderMainDAO orderMainDAO = new OrderMainDAOImpl();
		int count = orderMainDAO.delete(id);
		String message = "��������ɾ��ʧ��";
		String returnUrl = "admin/orderMain/orderMainAdd.jsp";
		if(count>=1){
			message = "��������ɾ���ɹ���";
			returnUrl = "OrderMainListServlet";
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
