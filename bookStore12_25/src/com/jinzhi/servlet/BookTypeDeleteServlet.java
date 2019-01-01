package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.dao.impl.BookTypeDAOImpl;

public class BookTypeDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		int count = bookTypeDAO.delete(id);
		String message = "图书类别删除失败";
		String returnUrl = "admin/bookType/bookTypeAdd.jsp";
		if(count>=1){
			message = "图书类别删除成功！";
			returnUrl = "BookTypeListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
