package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_customerDetailInformation;

public class DBManager_customerDetailInformationTest {
	public static void main(String[] args) {
		DBManager_customerDetailInformation db = new DBManager_customerDetailInformation();
		System.out.println(db.getCon());
		//testUpdate() ;
		//testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into customerDetailInfo(custId,Tel,address,Sex,Age,countMoney,Qq) values(10,'15829091911','±±¾©','0',96,'123456','2210166')" ;
		DBManager_customerDetailInformation db = new DBManager_customerDetailInformation();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select custId,Tel,address,Sex,Age,countMoney,Qq from customerDetailInfo where custId = 2" ;
		DBManager_customerDetailInformation db = new DBManager_customerDetailInformation();
		ResultSet res =db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("Tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
