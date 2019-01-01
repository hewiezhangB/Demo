package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IAdminDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.AdminDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;

public class SysAdminDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IAdminDAO adminDAO = new AdminDAOImpl();
		int count = adminDAO.delete(id);
		String message = "管理员删除失败";
		String returnUrl = "admin/admin/adminAdd.jsp";
		if (count >= 1) {
			message = "管理员删除成功！";
			returnUrl = "SysAdminListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
