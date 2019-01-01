package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.ICustomerDeInfoDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.CustomerDeInfoDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;

public class CustomerDetailDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICustomerDeInfoDAO customerDeInfoDAO = new CustomerDeInfoDAOImpl();
		int count = customerDeInfoDAO.delete(id);
		String message = "�ͻ���ϸɾ��ʧ��";
		String returnUrl = "admin/customerDeInfo/customerDeInfoAdd.jsp";
		if(count>=1){
			message = "�ͻ���ϸɾ���ɹ���";
			returnUrl = "CustomerDeInfoListServlet";
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
