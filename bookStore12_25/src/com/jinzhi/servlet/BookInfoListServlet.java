package com.jinzhi.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.config.Config;
import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.entity.BookInfo;


public class BookInfoListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		//List<BookInfo> bookInfos = bookInfoDAO.findAll();
		String nowPage = request.getParameter("nowPage") ;
		int nPage =0;
		try {
			nPage=Integer.parseInt(nowPage) ;
		} catch (NumberFormatException e) {
			nPage=1 ;
		}
		int pageSize = Config.PAGE_SIZE ;
		int pageCount = bookInfoDAO.getpageCount(pageSize);
		List<BookInfo> bookInfoList= bookInfoDAO.getNowPageDate(nPage,pageSize);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nPage);
		request.setAttribute("bookInfoList", bookInfoList);
		//ÇëÇó×ª·¢
		request.getRequestDispatcher("admin/bookInfo/bookInfoList.jsp").forward(request, response) ;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response) ;
	}

}
