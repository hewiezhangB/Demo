package com.jinzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.StudentDAOImpl;
import com.jinzhi.entity.Student;

public class StudentFindByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IStudentDAO studentDAO = new StudentDAOImpl();
		Student student = studentDAO.findById(id);
		request.setAttribute("student", student);
		// ����ת��
		request.getRequestDispatcher("admin/student/studentUpdate.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
