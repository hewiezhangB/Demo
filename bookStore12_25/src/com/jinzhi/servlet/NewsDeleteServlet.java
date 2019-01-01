package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.INewDAO;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.NewsDAOImpl;
import com.jinzhi.dao.impl.StudentDAOImpl;

public class NewsDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		INewDAO newDAO = new NewsDAOImpl();
		int count = newDAO.delete(id);
		String message = "新闻删除失败";
		String returnUrl = "admin/new/newAdd.jsp";
		if(count>=1){
			message = "学生删除成功！";
			returnUrl = "NewListServlet";
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
