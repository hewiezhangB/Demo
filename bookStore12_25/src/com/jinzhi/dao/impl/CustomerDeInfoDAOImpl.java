package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinzhi.dao.ICustomerDeInfoDAO;
import com.jinzhi.db.DBManager;
import com.jinzhi.entity.CustomerDeInfo;

public class CustomerDeInfoDAOImpl implements ICustomerDeInfoDAO {
	DBManager db = new DBManager();
	private ResultSet res ;
	public int delete(int id) {
		int count = 0;
		String sql = "update customerDetailInfo set Tel = 15829031911 where custId = " + id;
		count = db.update(sql);
		return count;
	}
	public List<CustomerDeInfo> findAll() {
		List<CustomerDeInfo> customerDeList = new ArrayList<CustomerDeInfo>();
		String sql ="select custId, Tel, address, Sex, Age, countMoney, Qq from customerDetailInfo where custId = 2" ;
		res =db.query(sql);
		try {
			while(res.next()){					
				CustomerDeInfo customerDeInfo = new CustomerDeInfo(res.getInt("custId"), res.getString("tel"), res.getString("address"), res.getString("sex"), res.getInt("age"), res.getString("countMoney"), res.getInt("qq"));
				customerDeList.add(customerDeInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerDeList;
	}
	public CustomerDeInfo findById(int id) {
		CustomerDeInfo customerDe = null ;
		String sql = "select custId, Tel, address, sex, age, countMoney, qq from customerDetailInfo where 1=1 and custId = " + id;
		res =db.query(sql);
		try {
			if(res.next()){   
				customerDe = new CustomerDeInfo(res.getInt("custId"), res.getString("tel"), res.getString("address"), res.getString("sex"), res.getInt("age"), res.getString("countMoney"), res.getInt("qq"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerDe;
	}
	public int save(CustomerDeInfo customerinfo) {
		int count = 0;
		String sql = "insert into customerDetailInfo(custId,tel,address,Sex,Age,countMoney,Qq) values("+customerinfo.getCustId()+",'"+customerinfo.getTel()+"','"+customerinfo.getAddress()+"','"+customerinfo.getSex()+"','"+customerinfo.getAge()+"','"+customerinfo.getCountMoney()+"','"+customerinfo.getQq()+"')";
		count = db.update(sql);
		return count;
	}
	public int update(CustomerDeInfo customerinfo) {
		int count = 0;
		String sql = "update customerDetailInfo set tel = '"+ customerinfo.getTel()+"',address = '"+customerinfo.getAddress()+"',sex = '"+customerinfo.getSex()+"',Age = '"+customerinfo.getAge()+"',countMoney = '"+customerinfo.getCountMoney()+"',Qq = '"+customerinfo.getQq()+"' where custId = " + customerinfo.getCustId();
		count = db.update(sql);
		return count;
	}
}
