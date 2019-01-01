package com.jinzhi.servlet.front.gwc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.entity.BookInfo;

public class GwcAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		BookInfo bookInfo = bookInfoDAO.findById(id);
		GwcItem gwcItem = new GwcItem(id, bookInfo.getBookName(), bookInfo
				.getSmallImg(), bookInfo.getPrice(), bookInfo.getHyprice(), 1);
		HttpSession session = request.getSession();
		Gwc gwc = null;
		if (session.getAttribute("gwc") != null) {
			// 如果session 里面有gwc ，获取
			gwc = (Gwc) session.getAttribute("gwc");
		} else {
			// 没有，创建
			gwc = new Gwc();
		}
		gwc.addItem(gwcItem);
		session.setAttribute("gwc", gwc);
		response.sendRedirect("gwc.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
