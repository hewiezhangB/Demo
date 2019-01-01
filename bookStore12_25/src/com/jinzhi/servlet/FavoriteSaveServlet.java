package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IFavoriteDAO;
import com.jinzhi.dao.impl.FavoriteDAOImpl;
import com.jinzhi.entity.Favorite;
import com.jinzhi.util.DateUtil;

public class FavoriteSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ��Ԫ��
		int bookId = Integer.parseInt(request.getParameter("bookId")) ;
		Date dateDate = DateUtil.convertToDate(request.getParameter("date"));
		int custId = Integer.parseInt(request.getParameter("custId")) ;
		String context =request.getParameter("context") ;
		//���ʵ��
		Favorite favorite = new Favorite(bookId, custId, dateDate, context);
		IFavoriteDAO favoriteDAO = new FavoriteDAOImpl();
		int count = favoriteDAO.save(favorite) ;
		String message = "ѧ������ʧ��";
		String returnUrl = "admin/favorite/favoriteAdd.jsp";
		if(count>=1){
			message = "�ղؼ������ɹ���";
			returnUrl = "FavoriteListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
