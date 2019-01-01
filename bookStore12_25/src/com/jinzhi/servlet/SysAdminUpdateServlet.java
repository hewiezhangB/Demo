package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IAdminDAO;
import com.jinzhi.dao.impl.AdminDAOImpl;
import com.jinzhi.entity.Admin;

public class SysAdminUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// ��ȡ��Ԫ��
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		String adminName = request.getParameter("adminName");
		String pwd = request.getParameter("pwd");
		int adminType = Integer.parseInt(request.getParameter("adminType"));
		// ���ʵ��
		Admin admin = new Admin(adminId, adminName, pwd, adminType);
		IAdminDAO adminDAO = new AdminDAOImpl();
		int count = adminDAO.save(admin);
		String message = "����Ա����ʧ��";
		String returnUrl = "SysAdminFindByIdServlet?id =" + adminId;
		if (count >= 1) {
			message = "����Ա���³ɹ���";
			returnUrl = "SysAdminListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request,
				response);
	}

}
