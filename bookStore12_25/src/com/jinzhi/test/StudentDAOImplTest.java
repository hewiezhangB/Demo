package com.jinzhi.test;

import java.util.Date;
import java.util.List;

import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.dao.impl.StudentDAOImpl;
import com.jinzhi.entity.Student;

public class StudentDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		testUpdate() ;
		//testQuery() ;
		
	}
	public static void testSave(){
		Student student = new Student("wangWu", 20, new Date(), 1, "13823456789", 1);
		IStudentDAO studentDAO = new StudentDAOImpl() ;
		studentDAO.save(student);
	}
	
	public static void testUpdate(){
		IStudentDAO studentDAO = new StudentDAOImpl() ;
		Student student = studentDAO.findById(1);
		student.setStuName("lisir");
		student.setStuBtd(new Date());
		studentDAO.update(student);
	}
	public static void testQuery(){
		IStudentDAO studentDAO = new StudentDAOImpl() ;
		List<Student> studentList = studentDAO.findAll();
		for(Student s:studentList){
			System.out.println(s);
		}
	}

}
