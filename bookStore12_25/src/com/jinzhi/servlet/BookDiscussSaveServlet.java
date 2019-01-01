package com.jinzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookDiscussDAO;
import com.jinzhi.dao.impl.BookDiscussDAOImpl;
import com.jinzhi.entity.BookDiscuss;

public class BookDiscussSaveServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		//��ȡ��Ԫ��
		int id = Integer.parseInt(request.getParameter("disId"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int custId =Integer.parseInt(request.getParameter("custId"));
		String context = request.getParameter("context");
		String states =request.getParameter("states");
		//���ʵ��
		BookDiscuss bookDiscuss = new BookDiscuss(bookId, custId, context, states);
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		int count = bookDiscussDAO.save(bookDiscuss);
		String message = "��������ʧ��";
		String returnUrl = "admin/bookDiscuss/bookDiscussAdd.jsp";
		if(count>=1){
			message = "���������ɹ���";
			returnUrl = "BookDiscussListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
		
	}

}
