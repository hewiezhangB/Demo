package com.jinzhi.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinzhi.dao.ICustomerDeInfoDAO;
import com.jinzhi.dao.ICustomerInfoDAO;
import com.jinzhi.dao.impl.CustomerDeInfoDAOImpl;
import com.jinzhi.dao.impl.CustomerInfoDAOImpl;
import com.jinzhi.entity.CustomerDeInfo;
import com.jinzhi.entity.CustomerInfo;

public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String randNum = request.getParameter("randNum");
		//从session里获取验证码
		String check = request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY).toString();
		if(!check.trim().equals(randNum)){
			response.sendRedirect("qtlogin.jsp");
		} else {
			ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
			ICustomerDeInfoDAO customerDeInfoDAO = new CustomerDeInfoDAOImpl();
			CustomerInfo customerInfo = customerInfoDAO.findByNameAndPwd(username,password);
			if(customerInfo==null){
				response.sendRedirect("qtlogin.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("customerInfo", customerInfo);
				CustomerDeInfo customerDeInfo = customerDeInfoDAO.findById(customerInfo.getCustId());
				session.setAttribute("customerDeInfo", customerDeInfo);
				response.sendRedirect("InitIndexServlet");
			}

		}
		
	}

}
