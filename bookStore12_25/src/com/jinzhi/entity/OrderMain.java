package com.jinzhi.entity;

import java.util.Date;


public class OrderMain {
	private String orderNum;
	private int customerId;
	private String customerName;
	private String Tel;
	private String address;
	private String status;
	private String adminId;
	private String context;
	private String Sumprice;
	
	public OrderMain() {
		// TODO Auto-generated constructor stub
	}

	public OrderMain(String orderNum, int customerId, String customerName,
			String tel, String address, String status, String adminId,
			String context, String sumprice) {
		super();
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		Tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		Sumprice = sumprice;
	}

	public OrderMain(int customerId, String customerName, String tel,
			String address, String status, String adminId, String context,
			String sumprice) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		Tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		Sumprice = sumprice;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getSumprice() {
		return Sumprice;
	}

	public void setSumprice(String sumprice) {
		Sumprice = sumprice;
	}
	
	public String getSumprice1() {
		return Sumprice;
	}
	
	public void setSumprice1(float sumprice) {
		Sumprice = getSumprice1();
	}

	@Override
	public String toString() {
		return "OrderMain [Sumprice=" + Sumprice + ", Tel=" + Tel
				+ ", address=" + address + ", adminId=" + adminId
				+ ", context=" + context + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", orderNum=" + orderNum
				+ ", status=" + status + "]";
	}
}