package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.BookType;

public interface IBookTypeDAO {
	public int save(BookType bookType);

	public int update(BookType bookType);

	public int delete(int id);

	public BookType findById(int id);

	public List<BookType> findAll();

	public int getpageCount(int pageSize);

	public List<BookType> getNowPageDate(int nPage, int pageSize);
	
	public List<BookType> findByParentId(int i);
	
}
