package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_OrderMain;

public class DBManager_OrderMainTest {
	public static void main(String[] args) {
		DBManager_OrderMain db = new DBManager_OrderMain();
		System.out.println(db.getCon());
		testUpdate() ;
		//testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into OrderMain(orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice) values('1213453','3','ÕÅ»Ô','18829031922','Î÷°²',0,'3','kuaidain','163312332')";
		DBManager_OrderMain db = new DBManager_OrderMain();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice from OrderMain where customerId = 1" ;
		DBManager_OrderMain db = new DBManager_OrderMain();
		ResultSet res =db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("context"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
