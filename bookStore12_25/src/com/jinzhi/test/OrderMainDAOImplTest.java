package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.IOrderMainDAO;
import com.jinzhi.dao.impl.OrderMainDAOImpl;
import com.jinzhi.entity.OrderMain;

public class OrderMainDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		//testUpdate() ;
		//testQuery() ;
		testDelete();
		
	}
	
	public static void testSave(){
		OrderMain ordermain = new OrderMain("1213615", 2, "kldm", "12345678912", "±±¾©", "0", "2", "²»´í", "123456");
		IOrderMainDAO ordermainDAO = new OrderMainDAOImpl();
		ordermainDAO.save(ordermain);
	}
	
	public static void testUpdate(){
		IOrderMainDAO ordermainDAO = new OrderMainDAOImpl() ;
		OrderMain ordermain = ordermainDAO.findById(1);
		ordermain.setCustomerId(6);
		ordermainDAO.update(ordermain);
	}
	public static void testQuery(){
		IOrderMainDAO ordermainDAO = new OrderMainDAOImpl() ;
		List<OrderMain> ordermainList = ordermainDAO.findAll();
		for(OrderMain s:ordermainList){
			System.out.println(s);
		}
	}
	public static void testDelete() {
		IOrderMainDAO ordermainDAO = new OrderMainDAOImpl();
		ordermainDAO.delete(0);
	}

}
