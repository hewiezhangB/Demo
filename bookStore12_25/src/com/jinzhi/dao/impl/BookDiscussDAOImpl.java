package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jinzhi.dao.IBookDiscussDAO;
import com.jinzhi.db.DBManager_bookDiscuss;
import com.jinzhi.entity.BookDiscuss;


public class BookDiscussDAOImpl implements IBookDiscussDAO {
	DBManager_bookDiscuss db = new DBManager_bookDiscuss();
	private ResultSet res;
	public int delete(int id) {
		int count = 0;
		String sql = "update bookDiscuss set bookId = 10 where disId = " + id;
		count = db.update(sql);
		return count;
	}
	
	public List<BookDiscuss> findAll() {
		List<BookDiscuss> bookList = new ArrayList<BookDiscuss>();
		String sql ="select disId, bookId, custId, context, states from bookDiscuss where disId = 2" ;
		res =db.query(sql);
		try {
			while(res.next()){
				/*BookDiscuss bookDiscuss = new BookDiscuss(res.getInt("bookId"), res.getInt("custId"), res.getString("context"), res.getString("states"));*/
				BookDiscuss bookDiscuss = new BookDiscuss(res.getInt("disId"), res.getInt("bookId"), res.getInt("custId"), res.getString("context"), res.getString("states"));
				bookList.add(bookDiscuss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

	public BookDiscuss findById(int id) {
		BookDiscuss bookDiscuss = null;
		String sql = "select disId, bookId, custId, context, states from bookDiscuss where bookId = 1 and disId = " + id;
		res = db.query(sql);
		try {
			if(res.next()){
				/*bookDiscuss = new BookDiscuss(res.getInt("bookId"), res.getInt("custId"), res.getString("context"), res.getString("states"));*/
				bookDiscuss = new BookDiscuss(res.getInt("disId"), res.getInt("bookId"), res.getInt("custId"), res.getString("context"), res.getString("states"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookDiscuss;
	}

	public int save(BookDiscuss bookDiscuss) {
		int count = 0;
		String sql = "insert into bookDiscuss(bookId,custId,context,states) values("+bookDiscuss.getBookId()+","+bookDiscuss.getCustId()+",'"+bookDiscuss.getContext()+"','"+bookDiscuss.getStates()+"')";
		count = db.update(sql);
		return count;
	}
	
	public int update(BookDiscuss bookDiscuss) {
		int count = 0;
		String sql = "update bookDiscuss set bookId = '"+bookDiscuss.getBookId()+"'where disId = " + bookDiscuss.getDisId();
		count = db.update(sql);
		return count;
	}

	public List<BookDiscuss> getNowPageDate(int nPage, int pageSize) {
		List<BookDiscuss> BookDiscussList = new ArrayList<BookDiscuss>();
		String sql = "select top "
				+ pageSize
				+ " disId ,bookId, custId, context, states =1 from BookDiscuss where disId not in (select top "
				+ (nPage - 1) * pageSize
				+ " disId from BookDiscuss where states =1 )";
		res = db.query(sql);
		try {
			while (res.next()) {
				BookDiscuss BookDiscuss = new BookDiscuss(res.getInt("disId"), res.getInt("bookId"), res.getInt("custId"), res.getString("context"), res.getString("states"));
				BookDiscussList.add(BookDiscuss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BookDiscussList;
	}

	public int getpageCount(int pageSize) {
		int rowCount = this.getrowCount();
		return rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
	}

	private int getrowCount() {
		String sql = "select count(*) from bookDiscuss where states = 1";
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
	
	
	
	public List<BookDiscuss> findByLike(BookDiscuss bookDiscuss) {
		List<BookDiscuss> list = new ArrayList<BookDiscuss>();
		int bookId = bookDiscuss.getBookId();
		int custId = bookDiscuss.getCustId();
		String context = bookDiscuss.getContext();
		String states = bookDiscuss.getStates();
		StringBuffer sb = new StringBuffer(
				"select * from bookDiscuss where 1 = 1");
		if (bookId > 0) {
			sb.append(" and bookId = " + bookId + "");
		}
		if (custId > 0) {
			sb.append(" and custId = " + custId + "");
		}
		if (context != null) {
			sb.append(" and context like '%" + context + "%'");
		}
		if (states != null) {
			sb.append(" and states = '" + states + "'");
		}
		String sql = sb.toString();
		System.out.println(sql);
		res = db.query(sql);
		try {
			while (res.next()) {
				BookDiscuss bookDiscuss1 = new BookDiscuss();
				bookDiscuss1.setDisId(res.getInt(1));
				bookDiscuss1.setBookId(res.getInt(2));
				bookDiscuss1.setCustId(res.getInt(3));
				bookDiscuss1.setContext(res.getString(4));
				bookDiscuss1.setStates(res.getString(5));
				list.add(bookDiscuss1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}

	public List<BookDiscuss> findByBookId(int BookId) {
		List<BookDiscuss> list = new ArrayList<BookDiscuss>();
		String sql = "select * from bookDiscuss where bookId = " + BookId
				+ " and states !=0";
		System.out.println(sql);
		res = db.query(sql);
		try {
			while (res.next()) {
				BookDiscuss bookDiscuss = new BookDiscuss();
				bookDiscuss.setDisId(res.getInt(1));
				bookDiscuss.setBookId(res.getInt(2));
				bookDiscuss.setCustId(res.getInt(3));
				bookDiscuss.setContext(res.getString(4));
				bookDiscuss.setStates(res.getString(5));
				list.add(bookDiscuss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}
}
