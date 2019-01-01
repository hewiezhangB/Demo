package com.jinzhi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.dao.impl.BookTypeDAOImpl;
import com.jinzhi.entity.BookType;

public class BookTypeUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		//��ȡ��Ԫ��
		String bookTypeName =request.getParameter("bookTypeName") ;
		int bookTypeId =Integer.parseInt(request.getParameter("bookTypeId")) ;
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String context = request.getParameter("context");
		//���ʵ��
		BookType bookType = new BookType(bookTypeId, parentId, bookTypeName, context, 1);
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		int count = bookTypeDAO.update(bookType);
		String message = "ͼ��������ʧ�ܣ�";
		String returnUrl = "BookTypeFindByIdServlet?id ="+ bookTypeId ;
		if(count>=1){
			message = "ͼ�������³ɹ���";
			returnUrl = "BookTypeListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
