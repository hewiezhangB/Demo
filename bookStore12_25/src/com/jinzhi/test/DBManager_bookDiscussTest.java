package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_bookDiscuss;

public class DBManager_bookDiscussTest {
	public static void main(String[] args) {
		DBManager_bookDiscuss db = new DBManager_bookDiscuss();
		System.out.println(db.getCon());
		//testUpdate() ;
		testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into bookDiscuss( bookId, custId, context, states) values( 6, 10,'不喜欢，一点都不喜欢','1')";
		DBManager_bookDiscuss db = new DBManager_bookDiscuss();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select disId, bookId, custId, context, states from bookDiscuss where custId = 2" ;
		DBManager_bookDiscuss db = new DBManager_bookDiscuss();
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
