package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IFavoriteDAO;
import com.jinzhi.dao.impl.FavoriteDAOImpl;
import com.jinzhi.entity.Favorite;

public class FavoriteListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IFavoriteDAO favoriteDAO = new FavoriteDAOImpl();
		List<Favorite> favoriteList = favoriteDAO.findAll();
		request.setAttribute("favoriteList", favoriteList);
		request.getRequestDispatcher("admin/favorite/favoriteList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
