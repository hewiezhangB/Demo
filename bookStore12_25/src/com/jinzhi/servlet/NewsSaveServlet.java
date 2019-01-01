package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.INewDAO;
import com.jinzhi.dao.impl.NewsDAOImpl;
import com.jinzhi.entity.News;
import com.jinzhi.util.DateUtil;

public class NewsSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ��Ԫ��
		int adminId = Integer.parseInt(request.getParameter("adminId")) ;
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		Date FbTimeDate = DateUtil.convertToDate(request.getParameter("FbTime"));
		int isDelete = Integer.parseInt(request.getParameter("isDelete")) ;
		//���ʵ��
		News news = new News(adminId, title, context, FbTimeDate, 1);
		INewDAO newDAO = new NewsDAOImpl();
		int count = newDAO.save(news) ;
		String message = "��������ʧ��";
		String returnUrl = "admin/new/newAdd.jsp";
		if(count>=1){
			message = "���������ɹ���";
			returnUrl = "NewListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
