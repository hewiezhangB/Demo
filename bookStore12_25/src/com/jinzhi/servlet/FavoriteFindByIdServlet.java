package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IFavoriteDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.FavoriteDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;
import com.jinzhi.entity.Favorite;
import com.jinzhi.entity.Student;

public class FavoriteFindByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		IFavoriteDAO favoriteDAO = new FavoriteDAOImpl();
		Favorite favorite = favoriteDAO.findById(id);
		request.setAttribute("favorite", favorite);
		//ÇëÇó×ª·¢
		request.getRequestDispatcher("admin/favorite/favoriteUpdate.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
