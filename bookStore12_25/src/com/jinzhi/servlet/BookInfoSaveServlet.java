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

public class BookInfoSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String pbName = request.getParameter("pbName");
		Date pbDate = DateUtil.convertToDate(request.getParameter("pbdate"));
		Date sjDate = DateUtil.convertToDate(request.getParameter("sjdate"));
		int price = Integer.parseInt(request.getParameter("price"));
		int hyprice = Integer.parseInt(request.getParameter("hyprice"));
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		String context = request.getParameter("context");
		String smallImg = request.getParameter("smallImg");
		String bigImg = request.getParameter("bigImg");
		int bookStates = Integer.parseInt(request.getParameter("bookStates"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		IBookInfoDAO dao = new BookInfoDAOImpl();
		BookInfo bookInfo = new BookInfo(bookName, bookTypeId, author, pbName, context, smallImg, bigImg, price, pbDate, hyprice, bookStates, sjDate, num, 0);
		int count = dao.save(bookInfo);
		String message = "图书信息新增失败!!!";
		String returnUrl = "admin/bookType/bookInfoAdd.jsp";
		if(count >= 1){
			message = "图书信息新增成功!!!";
			returnUrl = "BookInfoListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
