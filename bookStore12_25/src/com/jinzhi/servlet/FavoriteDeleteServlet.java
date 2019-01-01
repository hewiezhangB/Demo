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

public class FavoriteDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IFavoriteDAO favoriteDAO = new FavoriteDAOImpl();
		int count = favoriteDAO.delete(id);
		String message = "ÊÕ²Ø¼ÐÉ¾³ýÊ§°Ü";
		String returnUrl = "admin/favorite/favoriteAdd.jsp";
		if(count>=1){
			message = "ÊÕ²Ø¼ÐÉ¾³ý³É¹¦£¡";
			returnUrl = "FavoriteListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
