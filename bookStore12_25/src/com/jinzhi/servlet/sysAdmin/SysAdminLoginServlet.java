package com.jinzhi.servlet.sysAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinzhi.dao.IAdminDAO;
import com.jinzhi.dao.impl.AdminDAOImpl;
import com.jinzhi.entity.Admin;

public class SysAdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		IAdminDAO adminDAO = new AdminDAOImpl();
		Admin admin = adminDAO.findNameAndPwd(name, pwd);
		HttpSession session = request.getSession();
		if(admin != null){
			session.setAttribute("admin", admin);
			response.sendRedirect("admin/index.jsp");
		} else {
			String message = "fail";
			request.setAttribute("message", message);
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			//response.sendRedirect("admin/login.jsp");
		}
	}

}
