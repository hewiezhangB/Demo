package com.jinzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.config.Config;
import com.jinzhi.dao.IBookDiscussDAO;
import com.jinzhi.dao.impl.BookDiscussDAOImpl;
import com.jinzhi.entity.BookDiscuss;

public class BookDiscussListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		//List<BookDiscuss> bookDiscussList = bookDiscussDAO.findAll();
		String nowPage = request.getParameter("nowPage") ;
		int nPage =0;
		try {
			nPage=Integer.parseInt(nowPage) ;
		} catch (NumberFormatException e) {
			nPage=1 ;
		}
		int pageSize = Config.PAGE_SIZE ;
		int pageCount = bookDiscussDAO.getpageCount(pageSize);
		List<BookDiscuss> bookDiscussList = bookDiscussDAO.getNowPageDate(nPage,pageSize);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nPage);
		request.setAttribute("bookDiscussList", bookDiscussList);
		request.getRequestDispatcher("admin/bookDiscuss/bookDiscussList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
