package com.jinzhi.entity;

import java.util.Date;

public class Student {

	private int stuId;
	private String stuName;
	private int stuAge;
	private Date stuBtd;
	private int stuSex;
	private String stuTel;
	private int isDelete;
	
	private String stuSexView;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int stuId, String stuName, int stuAge, Date stuBtd,
			int stuSex, String stuTel, int isDelete) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuBtd = stuBtd;
		this.stuSex = stuSex;
		this.stuTel = stuTel;
		this.isDelete = isDelete;
	}

	public Student(String stuName, int stuAge, Date stuBtd, int stuSex,
			String stuTel, int isDelete) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuBtd = stuBtd;
		this.stuSex = stuSex;
		this.stuTel = stuTel;
		this.isDelete = isDelete;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public Date getStuBtd() {
		return stuBtd;
	}

	public void setStuBtd(Date stuBtd) {
		this.stuBtd = stuBtd;
	}

	public int getStuSex() {
		return stuSex;
	}

	public void setStuSex(int stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAge="
				+ stuAge + ", stuBtd=" + stuBtd + ", stuSex=" + stuSex
				+ ", stuTel=" + stuTel + ", isDelete=" + isDelete + "]";
	}

	public String getStuSexView() {
		return stuSexView;
	}

	public void setStuSexView(String stuSexView) {
		this.stuSexView = stuSexView;
	}
}
