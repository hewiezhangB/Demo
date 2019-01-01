package com.jinzhi.entity;

import java.util.Date;


public class Admin {
	private int adminId;
	private String adminName;
	private String pwd;
	private int adminType;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminName, String pwd, int adminType) {
		super();
		this.adminName = adminName;
		this.pwd = pwd;
		this.adminType = adminType;
	}

	public Admin(int adminId, String adminName, String pwd, int adminType) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.pwd = pwd;
		this.adminType = adminType;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAdminType() {
		return adminType;
	}

	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName
				+ ", adminType=" + adminType + ", pwd=" + pwd + "]";
	}
	
}