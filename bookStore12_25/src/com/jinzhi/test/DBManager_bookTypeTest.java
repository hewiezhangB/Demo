package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_bookType;

public class DBManager_bookTypeTest {
	public static void main(String[] args) {
		DBManager_bookType db = new DBManager_bookType();
		System.out.println(db.getCon());
		//testUpdate();
		//testQuery();
	}
	public static void testUpdate(){
		String sql = "insert into customerInfo(custName,pwd,email) values('—Ó√Œ','123','1262383039@qq.com')";
		DBManager_bookType db = new DBManager_bookType();
		int count = db.update(sql);
		System.out.println(count);
	}
	public static void testQuery(){
		String sql = "select bookTypeId, parentId, bookTypeName, context from bookType where isDelete=1";
		DBManager_bookType db = new DBManager_bookType();
		ResultSet res = db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("bookTypeName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
