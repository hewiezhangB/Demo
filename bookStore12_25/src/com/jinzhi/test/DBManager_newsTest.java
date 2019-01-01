package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_news;

public class DBManager_newsTest {
	public static void main(String[] args) {
		DBManager_news db = new DBManager_news();
		System.out.println(db.getCon());
		testUpdate() ;
		//testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into news( newsId, adminId, title, context, FbTime, isDelete) values( 4, 2, '½ðÃ«', 'ÇïÌïÈ®', 2016-2-2, 1)";
		DBManager_news db = new DBManager_news();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select newsId, adminId, title, context, FbTime, isDelete from news where newsId = 2" ;
		DBManager_news db = new DBManager_news();
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
