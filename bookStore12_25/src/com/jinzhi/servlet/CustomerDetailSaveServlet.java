package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.ICustomerDeInfoDAO;
import com.jinzhi.dao.impl.CustomerDeInfoDAOImpl;
import com.jinzhi.entity.CustomerDeInfo;

public class CustomerDetailSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ��Ԫ��

		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String countMoney = request.getParameter("countMoney");
		int qq =Integer.parseInt(request.getParameter("qq"));
		//���ʵ��
		CustomerDeInfo customerDeInfo = new CustomerDeInfo(tel, address, sex, age, countMoney, qq);
		ICustomerDeInfoDAO customerDeInfoDAO = new CustomerDeInfoDAOImpl();
		int count = customerDeInfoDAO.save(customerDeInfo) ;
		String message = "�����û���ϸ��Ϣʧ��";
		String returnUrl = "admin/customerDeInfo/customerDeInfoAdd.jsp";
		if(count>=1){
			message = "�����û���ϸ��Ϣ�ɹ���";
			returnUrl = "CustomerDeInfoListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	
		
	}

}
