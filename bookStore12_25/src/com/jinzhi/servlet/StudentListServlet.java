package com.jinzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.config.Config;
import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.StudentDAOImpl;
import com.jinzhi.entity.Student;

public class StudentListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nowPage = request.getParameter("nowPage");
		IStudentDAO studentDAO = new StudentDAOImpl();
		int nPage = 0;
		try {
			nPage = Integer.parseInt(nowPage);
		} catch (NumberFormatException e) {
			nPage = 1;
		}
		int pageSize = Config.PAGE_SIZE;
		int pageCount = studentDAO.getpageCount(pageSize);
		List<Student> studentList = studentDAO.getNowPageDate(nPage, pageSize);
		// List<Student> studentList =studentDAO.findAll() ;
		for (Student student : studentList) {
			int sex = student.getStuSex();
			String stuSexView = "男";
			if (sex == 0) {
				stuSexView = "女";
			}
			student.setStuSexView(stuSexView);
		}
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nPage);
		request.setAttribute("studentList", studentList);
		// 请求转发
		request.getRequestDispatcher("admin/student/studentList.jsp").forward(
				request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
