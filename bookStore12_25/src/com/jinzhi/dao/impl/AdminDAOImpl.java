package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jinzhi.dao.IAdminDAO;
import com.jinzhi.db.DBManager_sysAdmin;
import com.jinzhi.entity.Admin;

public class AdminDAOImpl implements IAdminDAO {
	DBManager_sysAdmin db = new DBManager_sysAdmin();
	private ResultSet res ;
	public int delete(int id) {
		int count = 0;
		String sql = "update sysAdmin set adminType = 6 where adminId = " + id;
		count = db.update(sql);
		return count;
	}
	public List<Admin> findAll() {
		List<Admin> AdminList = new ArrayList<Admin>();
		String sql ="select adminId, adminName, pwd, adminType from sysAdmin where adminId = 1" ;
		res =db.query(sql);
		try {
			while(res.next()){
				/*Admin admin = new Admin(res.getString("adminName"), res.getString("pwd"), res.getInt("adminType"));*/
				Admin admin = new Admin(res.getInt("adminId"), res.getString("adminName"), res.getString("pwd"), res.getInt("adminType"));
				AdminList.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AdminList;
	}
	public Admin findById(int id) {
		Admin admin = null ;
		String sql = "select adminId, adminName, pwd, adminType from sysAdmin where adminId = " + id;
		res =db.query(sql);
		try {
			if(res.next()){
				/*admin = new Admin(res.getString("adminName"), res.getString("pwd"), res.getInt("adminType"));*/
				admin = new Admin(res.getInt("adminId"), res.getString("adminName"), res.getString("pwd"), res.getInt("adminType"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	public int save(Admin admin) {
		int count = 0;
		String sql = "insert into sysAdmin(adminName,pwd,adminType) values('"+admin.getAdminName()+"','"+admin.getPwd()+"','"+ admin.getAdminType() +"')";
		count = db.update(sql);
		return count;
	}
	public int update(Admin admin) {
		int count = 0;
		String sql = "update sysAdmin set adminName = '"+admin.getAdminName()+"',pwd = '"+ admin.getPwd() +"',adminType = '"+admin.getAdminType()+"' where adminId = " + admin.getAdminId();
		count = db.update(sql);
		return count;
	}
	
	public Admin findNameAndPwd(String name, String pwd) {

		Admin sysAdmin = null;
		String sql = "select " + "	adminId,adminName,pwd,adminType " + "from "
				+ "	sysAdmin " + "where adminName='" + name + "' and pwd='"
				+ pwd + "'";
		res = db.query(sql);
		try {
			if (res.next()) {
				sysAdmin = new Admin(res.getInt("adminId"), res
						.getString("adminName"), res.getString("pwd"), res
						.getShort("adminType"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.close();
		}
		return sysAdmin;

	}
	
	public List<Admin> getNowPageDate(int nPage, int pageSize) {
		List<Admin> AdminList = new ArrayList<Admin>();
		String sql = "select top "
				+ pageSize
				+ " adminId, adminName, pwd, adminType from sysAdmin where adminId not in (select top "
				+ (nPage - 1) * pageSize
				+ " adminId from sysAdmin)";
		res = db.query(sql);
		try {
			while (res.next()) {
				Admin admin = new Admin(res.getInt("adminId"), res.getString("adminName"), res.getString("pwd"), res.getInt("adminType"));
				AdminList.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AdminList;
	}
	public int getpageCount(int pageSize) {
		int rowCount = this.getrowCount();
		return rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
	}
	private int getrowCount() {
		String sql = "select count(*) from sysAdmin";
		res = db.query(sql);
		int count = 0;
		try {
			if (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
