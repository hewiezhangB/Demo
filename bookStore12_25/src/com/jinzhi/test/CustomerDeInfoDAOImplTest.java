package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.ICustomerDeInfoDAO;
import com.jinzhi.dao.impl.CustomerDeInfoDAOImpl;
import com.jinzhi.entity.CustomerDeInfo;

public class CustomerDeInfoDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		//testUpdate() ;
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		CustomerDeInfo customer = new CustomerDeInfo(9, "13636858718", "±¦¼¦", "0", 36, "12306", 221016);
		ICustomerDeInfoDAO customerInfoDAO = new CustomerDeInfoDAOImpl();
		customerInfoDAO.save(customer);
	}
	
	public static void testUpdate(){
		ICustomerDeInfoDAO customerDeDAO = new CustomerDeInfoDAOImpl() ;
		CustomerDeInfo customerDe = customerDeDAO.findById(2);
		customerDe.setTel("13636758728");
		customerDeDAO.update(customerDe);
	}
	public static void testQuery(){
		ICustomerDeInfoDAO customerDeDAO = new CustomerDeInfoDAOImpl() ;
		List<CustomerDeInfo> customerDeList = customerDeDAO.findAll();
		for(CustomerDeInfo s:customerDeList){
			System.out.println(s);
		}
	}
	public static void testDelete() {
		ICustomerDeInfoDAO customerDeDAO = new CustomerDeInfoDAOImpl();
		customerDeDAO.delete(2);
	}

}
