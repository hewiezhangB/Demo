package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_orderDetail;

public class DBManager_orderDetailTest {
	public static void main(String[] args) {
		DBManager_orderDetail db = new DBManager_orderDetail();
		System.out.println(db.getCon());
		testUpdate() ;
		//testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into orderDetail(orderNum, bookId, num) values('½ðÃ«',2,1)";
		DBManager_orderDetail db = new DBManager_orderDetail();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select newsId, adminId, title, context, FbTime, isDelete from news where newsId = 2" ;
		DBManager_orderDetail db = new DBManager_orderDetail();
		ResultSet res =db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
