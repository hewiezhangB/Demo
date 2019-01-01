package com.jinzhi.dao.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jinzhi.dao.IOrderDetailDAO;
import com.jinzhi.db.DBManager_orderDetail;
import com.jinzhi.entity.OrderDetail;
import com.jinzhi.entity.OrderMain;

public class OrderDetailDAOImpl implements IOrderDetailDAO {
	DBManager_orderDetail db = new DBManager_orderDetail();
	private ResultSet res ;
	public int delete(int id) {
		int count = 0;
		String sql = "update orderDetail set orderNum = 1223453 where bookId = " + id;
		count = db.update(sql);
		return count;
	}
	public List<OrderDetail> findAll() {
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		String sql ="select detail, orderNum, bookId, num from orderDetail where bookId = 1" ;
		res =db.query(sql);
		try {
			while(res.next()){
				OrderDetail orderdetail = new OrderDetail(res.getInt("detail"), res.getString("orderNum"), res.getInt("bookId"), res.getInt("num"));
				orderDetail.add(orderdetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderDetail;
	}

	public OrderDetail findById(int id) {
		OrderDetail orderdetail = null ;
		String sql = "select detail, orderNum, bookId, Num from orderDetail where detail = 1005 and bookId = " + id;
		res =db.query(sql);
		try {
			if(res.next()){
				orderdetail = new OrderDetail(res.getInt("detail"), res.getString("orderNum"), res.getInt("bookId"), res.getInt("num")); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderdetail;
	}
	public int save(OrderDetail orderDetail) {
		int count = 0;
		String sql = "insert into orderDetail(orderNum, bookId, num) values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
		count = db.update(sql);
		return count;
	}
	public int update(OrderDetail orderDetail) {
		int count = 0;
		String sql = "update orderDetail set orderNum = '"+ orderDetail.getOrderNum() +"',bookId = '"+ orderDetail.getBookId() +"',Num = '"+ orderDetail.getNum() +"' where detail = " + orderDetail.getDetail();
		count = db.update(sql);
		return count;
	}
	@Override
	public List<OrderDetail> findByOrderNum(String orderNum) {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		String sql = "select * from orderDetail where  orderNum = '" + orderNum + "'";
		System.out.println(sql);
		 res = db.query(sql);
		try {
			while(res.next()) {
				OrderDetail	orderDetail = new OrderDetail(
						res.getInt("detailId"),
						res.getString("orderNum"),
						res.getInt("bookId"),
						res.getInt("num")
						);
				list.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}
	@Override
	public boolean save(List<OrderDetail> details) {
		try {
			for (OrderDetail detail : details) {
				String orderNum = detail.getOrderNum();
				int bookId = detail.getBookId();
				int num = detail.getNum();	
				String sql = "insert into orderDetail (orderNum, bookId, num) values " +
							 "('" + orderNum + "', " + bookId + ", " + num + ")";
				System.out.println(sql);		
				db.update(sql);
			}	
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			db.close();	
		}
	}
	@Override
	public boolean save(Connection con, OrderMain orderMain) {
		// TODO Auto-generated method stub
		return false;
	}
}
