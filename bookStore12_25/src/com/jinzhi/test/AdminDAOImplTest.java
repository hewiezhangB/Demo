package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.IAdminDAO;
import com.jinzhi.dao.impl.AdminDAOImpl;
import com.jinzhi.entity.Admin;

public class AdminDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		//testUpdate() ;
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		Admin admin = new Admin("nihao", "123456", 9);
		IAdminDAO adminDAO = new AdminDAOImpl();
		adminDAO.save(admin);
	}
	
	public static void testUpdate(){
		IAdminDAO adminDAO = new AdminDAOImpl() ;
		Admin admin = adminDAO.findById(1);
		admin.setAdminType(6);
		adminDAO.update(admin);
	}
	public static void testQuery(){
		IAdminDAO adminDAO = new AdminDAOImpl() ;
		List<Admin> adminList = adminDAO.findAll();
		for(Admin s:adminList){
			System.out.println(s);
		}
	}
	public static void testDelete() {
		IAdminDAO adminDAO = new AdminDAOImpl();
		adminDAO.delete(0);
	}

}
