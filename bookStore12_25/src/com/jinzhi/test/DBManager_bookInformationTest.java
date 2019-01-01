package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinzhi.db.DBManager_bookInformation;

public class DBManager_bookInformationTest {
	public static void main(String[] args) {
		DBManager_bookInformation db = new DBManager_bookInformation();
		System.out.println(db.getCon());
		//testUpdate();
		//testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into BookInfo(bookName,booktypeId,author,pbName,context,smallImg,bigImg,price,pbdate,hyprice,bookStates,sjdate,num,saleCount,bookStates) values('nisnbug', '6', 'Jack London', '陕西师范大学出版社', '讲述了一个传说的故事', '1.png', '2.png', 50,'2017-5-1', 25, 1, '2016-10-1', 100, 0)";
		DBManager_bookInformation db = new DBManager_bookInformation();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select stuName, stuAge, stuBtd, stuSex, stuTel from student where isDelete=1" ;
		DBManager_bookInformation db = new DBManager_bookInformation();
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
