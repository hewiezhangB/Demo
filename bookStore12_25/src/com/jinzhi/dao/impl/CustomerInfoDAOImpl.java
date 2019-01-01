package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinzhi.dao.ICustomerInfoDAO;
import com.jinzhi.db.DBManager;
import com.jinzhi.db.DBManager_customerInformation;
import com.jinzhi.entity.CustomerInfo;

public class CustomerInfoDAOImpl implements ICustomerInfoDAO {
	DBManager_customerInformation db = new DBManager_customerInformation();
	private ResultSet res;

	public int delete(int id) {
		int count = 0;
		String sql = "update customerInfo set pwd = 654321 where custId = "
				+ id;
		count = db.update(sql);
		return count;
	}

	public List<CustomerInfo> findAll() {
		List<CustomerInfo> customerList = new ArrayList<CustomerInfo>();
		String sql = "select custId, custName, pwd, email from customerInfo where custId = 1";
		res = db.query(sql);
		try {
			while (res.next()) {
				/*
				 * CustomerInfo book = new
				 * CustomerInfo(res.getString("custName"), res.getString("pwd"),
				 * res.getString("email"));
				 */
				CustomerInfo customerInfo = new CustomerInfo(res
						.getInt("custId"), res.getString("custName"), res
						.getString("pwd"), res.getString("email"));
				customerList.add(customerInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;
	}

	public CustomerInfo findById(int id) {
		CustomerInfo customer = null;
		String sql = "select custId, custName, pwd, email from customerInfo where pwd = 123456 and custId = "
				+ id;
		res = db.query(sql);
		try {
			if (res.next()) {
				/*
				 * customer = new CustomerInfo(res.getString("custName"),
				 * res.getString("pwd"), res.getString("pwd"));
				 */
				customer = new CustomerInfo(res.getInt("custId"), res
						.getString("custName"), res.getString("pwd"), res
						.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	public int save(CustomerInfo customerinfo) {
		int count = 0;
		String sql = "insert into customerInfo(custName,pwd,email) values('"
				+ customerinfo.getCustName() + "','" + customerinfo.getPwd()
				+ "','" + customerinfo.getEmail() + "')";
		count = db.update(sql);
		return count;
	}

	public int update(CustomerInfo customerinfo) {
		int count = 0;
		String sql = "update customerInfo set custName = '"
				+ customerinfo.getCustName() + "',pwd = '"
				+ customerinfo.getPwd() + "',email = '"
				+ customerinfo.getEmail() + "' where custId = "
				+ customerinfo.getCustId();
		count = db.update(sql);
		return count;
	}

	@Override
	public boolean findByName(String name) {
		String sql = "select * from customerInfo where custName = '" + name
				+ "' and states = 1";
		boolean flag = false;
		res = db.query(sql);
		System.out.println(sql);
		try {
			if (res.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return flag;
	}

	@Override
	public boolean findByEmail(String email) {
		String sql = "select * from customerInfo where email = '" + email
				+ "' and states = 1";
		boolean flag = false;
		DBManager dbManager = new DBManager();
		res = db.query(sql);
		System.out.println(sql);
		try {
			if (res.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return flag;
	}

	@Override
	public CustomerInfo login(String name, String password) {
		CustomerInfo customerInfo = null;
		String sql = "select * from customerInfo where custName= '" + name
				+ "' and pwd = '" + password + "'";
		res = db.query(sql);
		try {
			if (res.next()) {
				customerInfo = new CustomerInfo();
				customerInfo.setCustId(res.getInt(1));
				customerInfo.setCustName(res.getString(2));
				customerInfo.setPwd(res.getString(3));
				customerInfo.setEmail(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return customerInfo;
	}

	/**
	 * 判断用户名密码是否正确,如果正确返回该用户的详细信息,如果错误返回null
	 */
	@Override
	public CustomerInfo findByNameAndPwd(String name, String pwd) {
		CustomerInfo customerInfo = null;
		String sql = "select custId,custName,pwd,email from CustomerInfo where custName = '"
				+ name + "' and pwd = '" + pwd + "'";
		res = db.query(sql);
		try {
			if (res.next()) {
				customerInfo = new CustomerInfo(res.getInt("custId"), res
						.getString("custName"), res.getString("pwd"), res
						.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return customerInfo;
	}
}
