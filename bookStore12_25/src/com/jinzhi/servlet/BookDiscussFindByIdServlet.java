package com.jinzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookDiscussDAO;
import com.jinzhi.dao.impl.BookDiscussDAOImpl;
import com.jinzhi.entity.BookDiscuss;

public class BookDiscussFindByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id =Integer.parseInt(request.getParameter("id"));
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		BookDiscuss bookDiscuss = bookDiscussDAO.findById(id);
		request.setAttribute("bookDiscuss", bookDiscuss);
		//ÇëÇó×ª·¢
		request.getRequestDispatcher("admin/bookDiscuss/bookDiscussUpdate.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
