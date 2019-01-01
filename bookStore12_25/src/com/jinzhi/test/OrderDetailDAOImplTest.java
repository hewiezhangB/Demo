package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.IOrderDetailDAO;
import com.jinzhi.dao.impl.OrderDetailDAOImpl;
import com.jinzhi.entity.OrderDetail;

public class OrderDetailDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		testUpdate() ;
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		OrderDetail orderDetail = new OrderDetail("1123654", 6, 6000);
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		orderDetailDAO.save(orderDetail);
	}
	
	public static void testUpdate(){
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl() ;
		OrderDetail orderDetail = orderDetailDAO.findById(6);
		orderDetail.setOrderNum("1223453");
		orderDetailDAO.update(orderDetail);
	}
	public static void testQuery(){
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl() ;
		List<OrderDetail> orderDetailsList = orderDetailDAO.findAll();
		for (OrderDetail orderDetail : orderDetailsList) {
			System.out.println(orderDetail);
		}
	}
	public static void testDelete() {
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		orderDetailDAO.delete(6);
	}

}
