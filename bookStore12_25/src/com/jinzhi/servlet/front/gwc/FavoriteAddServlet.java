package com.jinzhi.servlet.front.gwc;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinzhi.dao.IFavoriteDAO;
import com.jinzhi.dao.impl.FavoriteDAOImpl;
import com.jinzhi.entity.CustomerInfo;
import com.jinzhi.entity.Favorite;

public class FavoriteAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id =Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		CustomerInfo customerInfo   = (CustomerInfo)session.getAttribute("customerInfo");
		if(customerInfo==null){
			response.sendRedirect("qtlogin.jsp");
		}else{
			//÷¥–– ’≤ÿ±£¥Ê
			Favorite favorite = new Favorite(id, customerInfo.getCustId(), new Date(), "");
			IFavoriteDAO favoriteDAO = new FavoriteDAOImpl();
			favoriteDAO.save(favorite);
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response) ;
	}

}
