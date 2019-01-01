package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.ICustomerDeInfoDAO;
import com.jinzhi.dao.impl.CustomerDeInfoDAOImpl;
import com.jinzhi.entity.CustomerDeInfo;

public class CustomerDetailUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//获取表单元素
		int id = Integer.parseInt(request.getParameter("custId"));
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String countMoney = request.getParameter("countMoney");
		int qq =Integer.parseInt(request.getParameter("qq"));
		//填充实体
		CustomerDeInfo customerDeInfo = new CustomerDeInfo(tel, address, sex, age, countMoney, qq);
		ICustomerDeInfoDAO customerDeInfoDAO = new CustomerDeInfoDAOImpl();
		int count = customerDeInfoDAO.update(customerDeInfo) ;
		String message = "新增用户详细信息失败";
		String returnUrl = "CustomerDeInfoFindByIdServlet?id = "+id;
		if(count>=1){
			message = "新增用户详细信息成功！";
			returnUrl = "CustomerDeInfoListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	
	}

}
