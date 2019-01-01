package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.config.Config;
import com.jinzhi.dao.IAdminDAO;
import com.jinzhi.dao.impl.AdminDAOImpl;
import com.jinzhi.entity.Admin;

public class SysAdminListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IAdminDAO adminDAO = new AdminDAOImpl();
		// List<Admin> adminList = adminDAO.findAll();
		String nowPage = request.getParameter("nowPage");
		int nPage = 0;
		try {
			nPage = Integer.parseInt(nowPage);
		} catch (NumberFormatException e) {
			nPage = 1;
		}
		int pageSize = Config.PAGE_SIZE;
		int pageCount = adminDAO.getpageCount(pageSize);
		List<Admin> adminList = adminDAO.getNowPageDate(nPage, pageSize);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nPage);
		request.setAttribute("adminList", adminList);
		request.getRequestDispatcher("admin/sysAdmin/sysAdminList.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
