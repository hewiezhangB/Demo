package com.jinzhi.entity;


public class CustomerDeInfo {
	private int custId;
	private String Tel;
	private String address;
	private String Sex;
	private int Age;
	private String countMoney;
	private int Qq;
	
	public CustomerDeInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDeInfo(int custId, String tel, String address, String sex,
			int age, String countMoney, int qq) {
		super();
		this.custId = custId;
		Tel = tel;
		this.address = address;
		Sex = sex;
		Age = age;
		this.countMoney = countMoney;
		Qq = qq;
	}
	
	public CustomerDeInfo(String tel, String address, String sex, int age,
			String countMoney, int qq) {
		super();
		Tel = tel;
		this.address = address;
		Sex = sex;
		Age = age;
		this.countMoney = countMoney;
		Qq = qq;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getCountMoney() {
		return countMoney;
	}

	public void setCountMoney(String countMoney) {
		this.countMoney = countMoney;
	}

	public int getQq() {
		return Qq;
	}

	public void setQq(int qq) {
		Qq = qq;
	}

	@Override
	public String toString() {
		return "CustomerDeInfo [Age=" + Age + ", Qq=" + Qq + ", Sex=" + Sex
				+ ", Tel=" + Tel + ", address=" + address + ", countMoney="
				+ countMoney + ", custId=" + custId + "]";
	}
	
}