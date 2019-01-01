package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.ICustomerInfoDAO;
import com.jinzhi.dao.impl.CustomerInfoDAOImpl;
import com.jinzhi.entity.CustomerInfo;

public class CustomerInfoUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取表单元素
		String custName = request.getParameter("custName") ;
		String pwd = request.getParameter("pwd") ;
		String email =request.getParameter("email") ;
		//填充实体
		CustomerInfo customerInfo = new CustomerInfo(custName, pwd, email);
		ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
		int count = customerInfoDAO.update(customerInfo);
		String message = "用户基本信息删除失败";
		String returnUrl = "admin/customerInfo/customerInfoAdd.jsp";
		if(count>=1){
			message = "用户基本信息删除成功！";
			returnUrl = "CustomerInfoListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
