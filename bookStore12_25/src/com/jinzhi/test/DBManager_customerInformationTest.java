package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_customerInformation;

public class DBManager_customerInformationTest {
	public static void main(String[] args) {
		DBManager_customerInformation db = new DBManager_customerInformation();
		System.out.println(db.getCon());
		//testUpdate() ;
		testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into customerInfo(custName,pwd,email) values('ÄãºÃ','123456','2210166254@qq.com')" ;
		DBManager_customerInformation db = new DBManager_customerInformation();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select custId,custName,pwd,email from customerInfo where custId = 1" ;
		DBManager_customerInformation db = new DBManager_customerInformation();
		ResultSet res =db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("custName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
