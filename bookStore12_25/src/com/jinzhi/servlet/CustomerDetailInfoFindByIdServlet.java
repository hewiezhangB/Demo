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
import com.jinzhi.entity.CustomerDeInfo;
import com.jinzhi.entity.Student;

public class CustomerDetailInfoFindByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICustomerDeInfoDAO customerDeInfoDAO = new CustomerDeInfoDAOImpl();
		CustomerDeInfo customerDeInfo = customerDeInfoDAO.findById(id);
		request.setAttribute("customerDeInfo", customerDeInfo);
		//����ת��
		request.getRequestDispatcher("admin/customerDeInfo/customerDeInfoUpdate.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
