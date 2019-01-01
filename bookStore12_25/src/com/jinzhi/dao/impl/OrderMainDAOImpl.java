package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinzhi.dao.IOrderMainDAO;
import com.jinzhi.db.DBManager_OrderMain;
import com.jinzhi.entity.OrderMain;

public class OrderMainDAOImpl implements IOrderMainDAO {
	DBManager_OrderMain db = new DBManager_OrderMain();
	private ResultSet res ;
	public int delete(int id) {
		int count = 0;
		String sql = "update OrderMain set orderNum = 6 where customerId = " + id;
		count = db.update(sql);
		return count;
	}
	public List<OrderMain> findAll() {
		List<OrderMain> ordermainList = new ArrayList<OrderMain>();
		String sql ="select orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice from OrderMain where customerId = 1" ;
		res =db.query(sql);
		try {
			while(res.next()){
				OrderMain ordermain = new OrderMain(res.getString("orderNum"), res.getInt("customerId"), res.getString("customerName"), res.getString("tel"), res.getString("address"), res.getString("status"), res.getString("adminId"), res.getString("context"), res.getString("sumprice"));
				ordermainList.add(ordermain);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordermainList;
	}
	public OrderMain findById(int id) {
		OrderMain ordermain = null ;
		String sql = "select orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice from OrderMain where orderNum = 1123654 and customerId = " + id;
		res =db.query(sql);
		try {
			if(res.next()){
				ordermain = new OrderMain(res.getString("orderNum"), res.getInt("customerId"), res.getString("customerName"), res.getString("tel"), res.getString("address"), res.getString("status"), res.getString("adminId"), res.getString("context"), res.getString("sumprice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordermain;
	}
	public int save(OrderMain ordermain) {
		int count = 0;
		String sql = "insert into OrderMain(orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice) values('"+ordermain.getOrderNum()+"','"+ordermain.getCustomerId()+"','"+ ordermain.getCustomerName() +"','"+ordermain.getTel()+"','"+ordermain.getAddress()+"','"+ordermain.getStatus()+"','"+ordermain.getAdminId()+"','"+ordermain.getContext()+"','"+ordermain.getSumprice()+"')";
		count = db.update(sql);
		return count;
	}
	public int update(OrderMain ordermain) {
		int count = 0;
		String sql = "update OrderMain set orderNum = '"+ordermain.getOrderNum()+"',Tel = '"+ ordermain.getTel() +"',address = '"+ordermain.getAddress()+"'," +
				"Status = '"+ordermain.getStatus()+"',AdminId = '"+ordermain.getAdminId()+"',context = '"+ordermain.getContext()+"',Sumprice = '"+ordermain.getSumprice()+"' where customerId = " + ordermain.getCustomerId();
		count = db.update(sql);
		return count;
	}
}
