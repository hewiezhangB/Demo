package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.db.DBManager_bookType;
import com.jinzhi.entity.BookType;

public class BookTypeDAOImpl implements IBookTypeDAO {
	DBManager_bookType db = new DBManager_bookType();
	private ResultSet res;

	public int delete(int id) {
		int count = 0;
		String sql = "update bookType set isDelete=0 where bookTypeId=" + id;
		count = db.update(sql);
		return count;
	}

	public List<BookType> findAll() {
		List<BookType> bookTypeList = new ArrayList<BookType>();
		String sql = "select bookTypeId, parentId, bookTypeName, context, isDelete from bookType where isDelete = 1 ";
		res = db.query(sql);
		try {
			while (res.next()) {
				BookType bookType = new BookType(res.getInt("bookTypeId"), res
						.getInt("parentId"), res.getString("bookTypeName"), res
						.getString("context"), res.getInt("isDelete"));
				bookTypeList.add(bookType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookTypeList;
	}

	public BookType findById(int id) {
		BookType bookType = null;
		String sql = "select bookTypeId, parentId, bookTypeName, context, isDelete from bookType where isDelete=1 and bookTypeId="
				+ id;
		res = db.query(sql);
		try {
			if (res.next()) {
				bookType = new BookType(res.getInt("bookTypeId"), res
						.getInt("parentId"), res.getString("bookTypeName"), res
						.getString("context"), res.getInt("isDelete"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookType;
	}

	public int save(BookType bookType) {
		int count = 0;
		String sql = "insert into bookType(parentId, bookTypeName, context, isDelete) values("
				+ bookType.getParentId()
				+ ",'"
				+ bookType.getBookTypeName()
				+ "','" + bookType.getContext() + "',1)";
		count = db.update(sql);
		return count;
	}

	public int update(BookType bookType) {
		int count = 0;
		String sql = "update bookType set parentId=" + bookType.getParentId()
				+ ",bookTypeName='" + bookType.getBookTypeName()
				+ "',context='" + bookType.getContext() + "'where bookTypeId="
				+ bookType.getBookTypeId();
		count = db.update(sql);
		return count;
	}

	public List<BookType> getNowPageDate(int nPage, int pageSize) {
		List<BookType> bookTypeList = new ArrayList<BookType>();
		String sql = "select top "
				+ pageSize
				+ " bookTypeId ,parentId, bookTypeName, context, isDelete from bookType where isDelete =1 and bookTypeId not in (select top "
				+ (nPage - 1) * pageSize
				+ " bookTypeId from bookType where isDelete =1 )";
		res = db.query(sql);
		try {
			while (res.next()) {
				BookType bookType = new BookType(res.getInt("bookTypeId"), res
						.getInt("parentId"), res.getString("bookTypeName"), res
						.getString("context"), res.getInt("isDelete"));
				bookTypeList.add(bookType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookTypeList;
	}

	public int getpageCount(int pageSize) {
		int rowCount = this.getrowCount();
		return rowCount % pageSize == 0 ? rowCount / pageSize : rowCount
				/ pageSize + 1;
	}

	private int getrowCount() {
		String sql = "select count(*) from bookType where isDelete=1";
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

	@Override
	public List<BookType> findByParentId(int parentId) {
		List<BookType> bookTypes = new ArrayList<BookType>();
		String sql = "select bookTypeId,parentId,bookTypeName,context,isDelete from bookType  where isDelete = 1 and parentId = "
				+ parentId;
		res = db.query(sql);
		try {
			while (res.next()) {
				BookType bookType = new BookType(res.getInt("bookTypeId"), res
						.getInt("parentId"), res.getString("bookTypeName"), res
						.getString("context"), 1);
				bookTypes.add(bookType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}
		return bookTypes;
	}
}
