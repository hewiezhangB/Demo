package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;

public class BookInfoDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		int count = bookInfoDAO.delete(id);
		String message = "图书信息删除失败";
		String returnUrl = "admin/bookInfo/bookInfoAdd.jsp";
		if(count>=1){
			message = "图书信息删除成功！";
			returnUrl = "BookInfoListServlet";
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
