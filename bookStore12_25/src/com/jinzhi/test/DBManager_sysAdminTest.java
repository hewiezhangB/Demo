package com.jinzhi.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinzhi.db.DBManager_sysAdmin;

public class DBManager_sysAdminTest {
	public static void main(String[] args) {
		DBManager_sysAdmin db = new DBManager_sysAdmin();
		System.out.println(db.getCon());
		//testUpdate() ;
		testQuery();
	}

	public static  void testUpdate(){
		String sql="insert into sysAdmin(adminName,pwd,adminType) values('empoy','nihao',6)";
		DBManager_sysAdmin db = new DBManager_sysAdmin();
		int count =db.update(sql);
		System.out.println(count);
	}
	
	public static  void testQuery(){
		String sql="select adminId,adminName,pwd,adminType from sysadmin where adminId = 1" ;
		DBManager_sysAdmin db = new DBManager_sysAdmin();
		ResultSet res =db.query(sql);
		try {
			while(res.next()){
				System.out.println(res.getString("adminName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
