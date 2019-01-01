package com.jinzhi.servlet.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookDiscussDAO;
import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.impl.BookDiscussDAOImpl;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.entity.BookDiscuss;
import com.jinzhi.entity.BookInfo;

public class BookInfoFindByIdServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		BookInfo bookInfo = bookInfoDAO.findById(id);
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		List<BookDiscuss> bookDiscusses = bookDiscussDAO.findByBookId(id);
		request.setAttribute("bookInfo", bookInfo);
		request.setAttribute("bookDiscusses", bookDiscusses);
		request.getRequestDispatcher("bookInfoShow.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
