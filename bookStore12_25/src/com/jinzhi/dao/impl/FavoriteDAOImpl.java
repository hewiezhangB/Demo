package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinzhi.dao.IFavoriteDAO;
import com.jinzhi.db.DBManager_favorite;
import com.jinzhi.entity.Favorite;
import com.jinzhi.util.DateUtil;

public class FavoriteDAOImpl implements IFavoriteDAO {
	DBManager_favorite db = new DBManager_favorite();
	private ResultSet res ;
	public int delete(int id) {
		int count = 0;
		String sql = "update favorite set bookId = 7 where custId = " + id;
		count = db.update(sql);
		return count;
	}
	public List<Favorite> findAll() {
		List<Favorite> favoriteList = new ArrayList<Favorite>();
		String sql ="select favoriteId, bookId, custId, date,context from favorite where favoriteId = 1" ;
		res =db.query(sql);
		try {
			while(res.next()){
				/*Favorite favorite = new Favorite(res.getInt("bookId"), res.getInt("custId"), res.getDate("date"), res.getString("context"));*/
				Favorite favorite = new Favorite(res.getInt("favoriteId"), res.getInt("bookId"), res.getInt("custId"), res.getDate("date"), res.getString("context"));
				favoriteList.add(favorite);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return favoriteList;
	}
	public Favorite findById(int id) {
		Favorite favorite = null ;
		String sql = "select favoriteId, bookId, custId, date,context from favorite where bookId = 16 and favoriteId = " + id;
		res =db.query(sql);
		try {
			if(res.next()){
				/*favorite = new Favorite(res.getInt("bookId"), res.getInt("custId"), res.getDate("date"), res.getString("context"));*/
				favorite = new Favorite(res.getInt("farivateId"), res.getInt("bookId"), res.getInt("custId"), res.getDate("date"), res.getString("context"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return favorite;
	}
	public int save(Favorite favorite) {
		int count = 0;
		String sql = "insert into favorite(bookId,custId,date,context) values('"+favorite.getBookId()+"','"+favorite.getCustId()+"','"+ DateUtil.convertToString(favorite.getDate()) +"','"+favorite.getContext()+"')";
		count = db.update(sql);
		return count;
	}
	public int update(Favorite favorite) {
		int count = 0;
		String sql = "update favorite set bookId = '"+favorite.getBookId()+"',custId = '"+favorite.getCustId()+"',date = '"+ DateUtil.convertToString(favorite.getDate()) +"',context = '"+favorite.getContext()+"' where custId = " + favorite.getCustId();
		count = db.update(sql);
		return count;
	}
}
