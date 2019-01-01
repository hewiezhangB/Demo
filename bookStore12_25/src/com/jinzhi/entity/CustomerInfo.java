package com.jinzhi.entity;


public class CustomerInfo {
	private int custId;
	private String custName;
	private String pwd;
	private String email;
	
	public CustomerInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerInfo(String custName, String pwd, String email) {
		super();
		this.custName = custName;
		this.pwd = pwd;
		this.email = email;
	}
	
	public CustomerInfo(int custId, String custName, String pwd, String email) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.pwd = pwd;
		this.email = email;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "customerInfo [custId=" + custId + ", custName=" + custName
				+ ", email=" + email + ", pwd=" + pwd + "]";
	}
}