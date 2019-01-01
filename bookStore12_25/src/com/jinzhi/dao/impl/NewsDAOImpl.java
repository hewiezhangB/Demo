package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinzhi.dao.INewDAO;
import com.jinzhi.db.DBManager_news;
import com.jinzhi.entity.News;
import com.jinzhi.util.DateUtil;

public class NewsDAOImpl implements INewDAO {
	DBManager_news db = new DBManager_news();
	private ResultSet res ;
	public int delete(int id) {
		int count = 0;
		String sql = "update news set isDelete = 0 where newsId = " + id;
		count = db.update(sql);
		return count;
	}
	public List<News> findAll() {
		List<News> news = new ArrayList<News>();
		String sql ="select newsId, adminId, title, context, FbTime, isDelete from news where newsId = 1" ;
		res =db.query(sql);
		try {
			while(res.next()){
				/*News newsp = new News(res.getInt("adminId"), res.getString("title"), res.getString("context"), res.getDate("fbTime"), res.getInt("isDelete"));*/
				News newsp = new News(res.getInt("newsId"), res.getInt("adminId"), res.getString("title"), res.getString("context"), res.getDate("fbTime"), res.getInt("isDelete"));
				news.add(newsp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}
	public News findById(int id) {
		News news = null ;
		String sql = "select newsId, adminId, title, context, FbTime, isDelete from news where adminId = 6 and newsId = " + id;
		res =db.query(sql);
		try {
			if(res.next()){
				/*news = new News(res.getInt("adminId"), res.getString("title"), res.getString("context"), res.getDate("fbTime"), res.getInt("isDelete"));*/
				news = new News(res.getInt("newsId"), res.getInt("adminId"), res.getString("title"), res.getString("context"), res.getDate("fbTime"), res.getInt("isDelete"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}
	public int save(News news) {
		int count = 0;
		String sql = "insert into news( newsId, adminId, title, context, FbTime, isDelete) values ("+news.getNewsId()+",'"+news.getAdminId()+"','"+news.getTitle()+"','"+news.getContext()+"','"+ DateUtil.convertToString(news.getFbTime()) +"','"+news.getIsDelete()+"')";
		count = db.update(sql);
		return count;
	}
	public int update(News news) {
		int count = 0;
		String sql = "update news set adminId = '"+news.getAdminId()+"',title = '"+news.getTitle()+"',context = '"+news.getContext()+"',FbTime = '"+ DateUtil.convertToString(news.getFbTime()) +"' where newsId = " + news.getNewsId();
		count = db.update(sql);
		return count;
	}
}
