package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.Student;

public interface IStudentDAO {
	public int save(Student student);

	public int update(Student student);

	public int delete(int id);

	public Student findById(int id);

	public List<Student> findAll();

	public int getpageCount(int pageSize);

	public List<Student> getNowPageDate(int nPage, int pageSize);

}
