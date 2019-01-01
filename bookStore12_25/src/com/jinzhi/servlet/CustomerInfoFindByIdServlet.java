package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.ICustomerInfoDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.CustomerInfoDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;
import com.jinzhi.entity.CustomerInfo;
import com.jinzhi.entity.Student;

public class CustomerInfoFindByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
		CustomerInfo customerInfo = customerInfoDAO.findById(id);
		request.setAttribute("customerInfo", customerInfo);
		//ÇëÇó×ª·¢
		request.getRequestDispatcher("admin/customerInfo/customerInfoUpdate.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
