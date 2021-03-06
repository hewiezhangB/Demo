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
import com.jinzhi.util.DateUtil;

public class SysAdminSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取表单元素
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		String adminName = request.getParameter("adminName");
		String pwd = request.getParameter("pwd");
		int adminType = Integer.parseInt(request.getParameter("adminType"));
		// 填充实体
		Admin admin = new Admin(adminId, adminName, pwd, adminType);
		IAdminDAO adminDAO = new AdminDAOImpl();
		int count = adminDAO.save(admin);
		String message = "管理员新增失败";
		String returnUrl = "admin/admin/adminAdd.jsp";
		if (count >= 1) {
			message = "管理员新增成功！";
			returnUrl = "AdminListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request,
				response);
	}

}
