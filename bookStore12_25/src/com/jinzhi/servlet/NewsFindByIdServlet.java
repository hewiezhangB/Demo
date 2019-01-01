package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.INewDAO;
import com.jinzhi.dao.impl.NewsDAOImpl;
import com.jinzhi.entity.News;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class NewsFindByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		INewDAO newDAO = new NewsDAOImpl();
		News newsList = newDAO.findById(id);
		request.setAttribute("newsList",newsList);
		request.getRequestDispatcher("admin/news/newsUpdate.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
