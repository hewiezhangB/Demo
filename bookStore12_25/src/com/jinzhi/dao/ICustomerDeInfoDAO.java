package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.CustomerDeInfo;

public interface ICustomerDeInfoDAO {
	public int save(CustomerDeInfo customerinfo);

	public int update(CustomerDeInfo customerinfo);

	public int delete(int id);

	public CustomerDeInfo findById(int id);

	public List<CustomerDeInfo> findAll();

}
