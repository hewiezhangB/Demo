package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.CustomerInfo;

public interface ICustomerInfoDAO {
	public int save(CustomerInfo customerinfo);

	public int update(CustomerInfo customerinfo);

	public int delete(int id);

	public CustomerInfo findById(int id);

	public List<CustomerInfo> findAll();

	boolean findByEmail(String email);

	CustomerInfo login(String name, String password);

	CustomerInfo findByNameAndPwd(String name, String pwd);

	boolean findByName(String name);

}
