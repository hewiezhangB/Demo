package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.config.Config;
import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.dao.impl.BookTypeDAOImpl;
import com.jinzhi.entity.BookType;

public class BookTypeListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		//List<BookType> bookTypeList = bookTypeDAO.findAll();
		String nowPage = request.getParameter("nowPage") ;
		int nPage =0;
		try {
			nPage=Integer.parseInt(nowPage) ;
		} catch (NumberFormatException e) {
			nPage=1 ;
		}
		int pageSize = Config.PAGE_SIZE ;
		int pageCount = bookTypeDAO.getpageCount(pageSize);
		List<BookType> bookTypeList= bookTypeDAO.getNowPageDate(nPage,pageSize);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nPage);
		request.setAttribute("bookTypeList", bookTypeList);
		//ÇëÇó×ª·¢
		request.getRequestDispatcher("admin/bookType/bookTypeList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
