package com.jinzhi.servlet.front;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.config.Config;
import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.dao.impl.BookTypeDAOImpl;
import com.jinzhi.entity.BookInfo;
import com.jinzhi.entity.BookType;

public class BookListByBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		////////////初始化首页的数据start/////////////
		List<BookInfo> rxBooks = null;//热销商品5，10
		TreeMap<BookType, List<BookType>> bookTypes = new TreeMap<BookType, List<BookType>>();//图书类别
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		rxBooks = bookInfoDAO.findBySaleCount(10);
		request.setAttribute("rxBooks", rxBooks);
		List<BookType> parents = bookTypeDAO.findByParentId(0);
		for (BookType bookType2 : parents) {
			List<BookType> sons = bookTypeDAO.findByParentId(bookType2.getBookTypeId());
			bookTypes.put(bookType2, sons);
		}
		request.setAttribute("bookTypes", bookTypes);
		////////////初始化首页的数据end/////////////
		int nPage = 0;
		int pageSize = Config.PAGE_SIZE;
		try {
			nPage = Integer.parseInt(request.getParameter("nowPage"));
		} catch (NumberFormatException e) {
			nPage = 1;
		}
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		List<BookInfo> bookInfoList = bookInfoDAO.findByBookTypeId(bookTypeId, nPage, pageSize);
		int pageCount = bookInfoDAO.findByBookTypeIdSumPage(bookTypeId, pageSize);
		request.setAttribute("bookInfoList", bookInfoList);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("bookTypeId", bookTypeId);
		request.setAttribute("nowPage", nPage);
		
		request.getRequestDispatcher("proList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
