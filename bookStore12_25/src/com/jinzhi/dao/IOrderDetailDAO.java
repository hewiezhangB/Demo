package com.jinzhi.dao;

import java.util.List;
import com.jinzhi.entity.OrderMain;
import java.sql.Connection;
import com.jinzhi.entity.OrderDetail;

public interface IOrderDetailDAO {
	public int save(OrderDetail orderDetail);

	public int update(OrderDetail orderDetail);

	public int delete(int id);

	public OrderDetail findById(int id);

	public List<OrderDetail> findAll();

	List<OrderDetail> findByOrderNum(String orderNum);

	boolean save(List<OrderDetail> details);

	public boolean save(Connection con, OrderMain orderMain);

}
