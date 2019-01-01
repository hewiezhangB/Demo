package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinzhi.dao.IStudentDAO;
import com.jinzhi.db.DBManager;
import com.jinzhi.entity.Student;
import com.jinzhi.util.DateUtil;

public class StudentDAOImpl implements IStudentDAO {
	DBManager db = new DBManager();
	private ResultSet res ;

	public int save(Student student) {
		int count = 0;
		String sql = " insert into student(stuName, stuAge, stuBtd, stuSex, stuTel) values('"
				+ student.getStuName()
				+ "',"
				+ student.getStuAge()
				+ ",'"
				+ DateUtil.convertToString(student.getStuBtd()) + "',1, '" + student.getStuTel() + "')";
		count = db.update(sql);
		return count;
	}

	public int update(Student student) {
		int count = 0;
		String sql = " update  student set stuName='" + student.getStuName()
				+ "', stuAge=" + student.getStuAge() + ", stuBtd='"
				+ DateUtil.convertToString(student.getStuBtd()) + "', stuSex=" + student.getStuSex()
				+ ", stuTel='" + student.getStuTel() + "' where stuId="+student.getStuId();
		count = db.update(sql);
		return count;
	}

	public int delete(int id) {
		int count = 0;
		String sql = " update student set isDelete=0 where stuid=" + id;
		count = db.update(sql);
		return count;
	}

	public Student findById(int id) {
		Student student = null ;
		String sql ="select stuid ,stuName, stuAge, stuBtd, stuSex, stuTel,isDelete from student where isDelete=1 and stuid= "+id ;
		res =db.query(sql);
		try {
			if(res.next()){
				student = new Student(res.getInt("stuId"), res.getString("stuName"), res.getInt("stuAge"), res.getDate("stuBtd"), res.getInt("stuSex"), res.getString("stuTel"), res.getInt("isDelete"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	
	}

	public List<Student> findAll() {
		List<Student> studentList = new ArrayList<Student>() ;
		String sql ="select stuid ,stuName, stuAge, stuBtd, stuSex, stuTel,isDelete from student where isDelete=1 " ;
		res =db.query(sql);
		try {
			while(res.next()){
				Student student = new  Student(res.getInt("stuId"), res.getString("stuName"), res.getInt("stuAge"), res.getDate("stuBtd"), res.getInt("stuSex"), res.getString("stuTel"), res.getInt("isDelete"));
				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	public List<Student> getNowPageDate(int nPage, int pageSize) {
		List<Student> studentList = new ArrayList<Student>();

		String sql = "select top "
				+ pageSize
				+ " stuid ,stuName, stuAge, stuBtd, stuSex, stuTel,isDelete from student where isDelete =1  and stuid not in (select top "
				+ (nPage - 1) * pageSize
				+ " stuid from student where isDelete =1 )";
		res = db.query(sql);
		try {
			while (res.next()) {
				Student student = new Student(res.getInt("stuId"),
						res.getString("stuName"), res.getInt("stuAge"),
						res.getDate("stuBtd"), res.getInt("stuSex"),
						res.getString("stuTel"), res.getInt("isDelete"));
				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	public int getpageCount(int pageSize) {
		int rowCount = this.getrowCount();
		return rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
	}

	private int getrowCount() {
		String sql = "select count(*) from student where isDelete=1";
		res = db.query(sql);
		int count = 0;
		try {
			if (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
