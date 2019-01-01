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

public class NewsUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取表单元素
		int id = Integer.parseInt(request.getParameter("newsId")) ;
		int adminId = Integer.parseInt(request.getParameter("adminId")) ;
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		String FbTime = request.getParameter("FbTime");
		Date FbTimeDate = DateUtil.convertToDate(FbTime);
		int isDelete = Integer.parseInt(request.getParameter("isDelete")) ;
		//填充实体
		News news = new News(adminId, title, context,FbTimeDate, isDelete);
		INewDAO newDAO = new NewsDAOImpl();
		int count = newDAO.save(news) ;
		String message = "新闻新增失败";
		String returnUrl = "NewFindByIdServlet?id ="+ id;
		if(count>=1){
			message = "新闻新增成功！";
			returnUrl = "NewListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}
