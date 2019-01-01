package com.jinzhi.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.entity.BookInfo;
import com.jinzhi.util.DateUtil;

public class BookInfoUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		String author = request.getParameter("author");
		String pbName = request.getParameter("pbName");
		String context = request.getParameter("context");
		String smallImg = request.getParameter("smallImg");
		String bigImg = request.getParameter("bigImg");
		int price = Integer.parseInt(request.getParameter("price"));
		Date pbDate = DateUtil.convertToDate(request.getParameter("pbdate"));
		int hyprice = Integer.parseInt(request.getParameter("hyprice"));
		int bookStates = Integer.parseInt(request.getParameter("bookStates"));
		Date sjDate = DateUtil.convertToDate(request.getParameter("sjdate"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		IBookInfoDAO dao = new BookInfoDAOImpl();
	 	BookInfo bookInfo = new BookInfo(id, bookName, bookTypeId, author, pbName, context, smallImg, bigImg, price, pbDate, hyprice, bookStates, sjDate, num, 0);
		int count = dao.update(bookInfo);
		String message = "图书信息更新失败!";
		String returnUrl = "BookInfoFindByIdServlet?id="+ id;
		if(count >= 1){
			message = "图书信息更新成功!";
			returnUrl = "BookInfoListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}
}
