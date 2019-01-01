package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.ICustomerInfoDAO;
import com.jinzhi.dao.impl.CustomerInfoDAOImpl;
import com.jinzhi.entity.CustomerInfo;

public class CustomerInfoDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		//testUpdate() ;
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		CustomerInfo customer = new CustomerInfo("’≈ª‘", "654321", "2210166254@qq.com");
		ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
		customerInfoDAO.save(customer);
	}
	
	public static void testUpdate(){
		ICustomerInfoDAO bookDAO = new CustomerInfoDAOImpl() ;
		CustomerInfo book = bookDAO.findById(1);
		book.setCustName("ª‘");
		bookDAO.update(book);
	}
	public static void testQuery(){
		ICustomerInfoDAO customerDAO = new CustomerInfoDAOImpl() ;
		List<CustomerInfo> customerList = customerDAO.findAll();
		for(CustomerInfo s:customerList){
			System.out.println(s);
		}
	}
	public static void testDelete() {
		ICustomerInfoDAO bookDAO = new CustomerInfoDAOImpl();
		bookDAO.delete(9);
	}

}
