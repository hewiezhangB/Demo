package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.OrderMain;

public interface IOrderMainDAO {
	public int save(OrderMain ordermain);

	public int update(OrderMain ordermain);

	public int delete(int id);

	public OrderMain findById(int id);

	public List<OrderMain> findAll();

}
