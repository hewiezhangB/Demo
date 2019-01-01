package com.jinzhi.servlet.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.dao.INewDAO;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.dao.impl.BookTypeDAOImpl;
import com.jinzhi.dao.impl.NewsDAOImpl;
import com.jinzhi.entity.BookInfo;
import com.jinzhi.entity.BookType;
import com.jinzhi.entity.News;

public class InitIndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//请求数据库，显示首页任务
		//Map<BookType, List<BookType>> bookTypes = new HashMap<BookType, List<BookType>>();//图书类别
		//为了解决排序问题用TreeMap
		TreeMap<BookType, List<BookType>> bookTypes = new TreeMap<BookType, List<BookType>>();//图书类别
		List<News> news = null;//新闻数据
		INewDAO newsDao = new NewsDAOImpl();
		List<BookInfo> zxBooks = null;//最新商品
		List<BookInfo> rxBooks = null;//热销商品5，10
		List<BookInfo> tjBooks = null;//推荐商品
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		zxBooks = bookInfoDAO.findBySjDate(5);
		rxBooks = bookInfoDAO.findBySaleCount(10);
		tjBooks = bookInfoDAO.findAll();
		List<BookType> parents = bookTypeDAO.findByParentId(0);
		for (BookType bookType2 : parents) {
			List<BookType> sons = bookTypeDAO.findByParentId(bookType2.getBookTypeId());
			bookTypes.put(bookType2, sons);
		}
		request.setAttribute("zxBooks", zxBooks);
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("tjBooks", tjBooks);
		request.setAttribute("bookTypes", bookTypes);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
