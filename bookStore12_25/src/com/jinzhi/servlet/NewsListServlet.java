package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.INewDAO;
import com.jinzhi.dao.impl.NewsDAOImpl;
import com.jinzhi.entity.News;

public class NewsListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		INewDAO newDao = new NewsDAOImpl();
		List<News> newsList = newDao.findAll();
		request.setAttribute("newsList", newsList);
		request.getRequestDispatcher("admin/news/newsList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
