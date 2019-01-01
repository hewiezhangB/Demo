package com.jinzhi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.dao.impl.BookTypeDAOImpl;
import com.jinzhi.entity.BookType;

public class BookTypeSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ��Ԫ��
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String bookTypeName =request.getParameter("bookTypeName") ;
		String context = request.getParameter("context");
		int isDelete = Integer.parseInt(request.getParameter("isDelete"));
		//���ʵ��
		BookType bookType = new BookType(parentId, bookTypeName, context, isDelete);
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		int count = bookTypeDAO.save(bookType);
		String message = "ͼ���������ʧ��";
		String returnUrl = "admin/bookType/bookTypeAdd.jsp";
		if(count>=1){
			message = "ͼ����������ɹ���";
			returnUrl = "BookTypeListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}
}
