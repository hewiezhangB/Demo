package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.ICustomerDeInfoDAO;
import com.jinzhi.dao.ICustomerInfoDAO;
import com.jinzhi.dao.impl.CustomerDeInfoDAOImpl;
import com.jinzhi.dao.impl.CustomerInfoDAOImpl;

public class CustomerInfoDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
		int count = customerInfoDAO.delete(id);
		String message = "�û�������Ϣɾ��ʧ��";
		String returnUrl = "admin/customerInfo/customerInfoAdd.jsp";
		if(count>=1){
			message = "�û�������Ϣɾ���ɹ���";
			returnUrl = "CustomerInfoListServlet";
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
