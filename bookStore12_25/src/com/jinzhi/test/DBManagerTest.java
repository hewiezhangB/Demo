package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager;

public class DBManagerTest {
	public static void main(String[] args) {
		DBManager db = new DBManager();
		//System.out.println(db.getCon());
		//testUpdate() ;
		testQuery();
	}
	
	public static  void testUpdate(){
		String sql="insert into student(stuName, stuAge, stuBtd, stuSex, stuTel) values('zhangsan',22,'1999-9-9',1, '8888888')" ;
		DBManager db = new DBManager();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select stuName, stuAge, stuBtd, stuSex, stuTel from student where isDelete=1" ;
		DBManager db = new DBManager();
		ResultSet res =db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("stuName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
