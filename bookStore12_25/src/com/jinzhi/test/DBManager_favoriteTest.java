package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_favorite;

public class DBManager_favoriteTest {
	public static void main(String[] args) {
		DBManager_favorite db = new DBManager_favorite();
		System.out.println(db.getCon());
		testUpdate() ;
		//testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into favorite(bookId,custId,date,context) values(6,3,'2012-3-1','想买的书是')";
		DBManager_favorite db = new DBManager_favorite();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select favoriteId,bookId,custId,date,context from favorite where favoriteId = 1" ;
		DBManager_favorite db = new DBManager_favorite();
		ResultSet res =db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
