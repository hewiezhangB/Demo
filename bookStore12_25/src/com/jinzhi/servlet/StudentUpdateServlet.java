package com.jinzhi.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.StudentDAOImpl;
import com.jinzhi.entity.Student;
import com.jinzhi.util.DateUtil;

public class StudentUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 获取表单元素
		String stuName = request.getParameter("stuName");
		int id = Integer.parseInt(request.getParameter("stuId"));
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		String stuBtd = request.getParameter("stuBtd");
		Date stuBtdDate = DateUtil.convertToDate(stuBtd);
		int stuSex = Integer.parseInt(request.getParameter("stuSex"));
		String stuTel = request.getParameter("stuTel");
		// 填充实体
		Student student = new Student(id, stuName, stuAge, stuBtdDate, stuSex,
				stuTel, 1);
		IStudentDAO studentDAO = new StudentDAOImpl();
		int count = studentDAO.update(student);
		String message = "学生更新失败！";
		String returnUrl = "StudentFindByIdServlet?id =" + id;
		if (count >= 1) {
			message = "学生更新成功！";
			returnUrl = "StudentListServlet";
		}
		request.setAttribute("message", message);
		request.setAttribute("returnUrl", returnUrl);
		request.getRequestDispatcher("admin/message.jsp").forward(request,
				response);

		/*
		 * //重定向 response.sendRedirect("StudentListServlet") ;
		 */
	}
}
