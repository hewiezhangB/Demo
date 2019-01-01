package com.jinzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookDiscussDAO;
import com.jinzhi.dao.impl.BookDiscussDAOImpl;

public class BookDiscussDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		int count = bookDiscussDAO.delete(id);
		String message = " È∆¿…æ≥˝ ß∞‹";
		String returnUrl = "admin/bookDiscuss/bookDiscussAdd.jsp";
		if(count>=1){
			message = " È∆¿…æ≥˝≥…π¶£°";
			returnUrl = "bookDiscussListServlet";
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
