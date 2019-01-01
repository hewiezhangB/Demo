package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.BookDiscuss;

public interface IBookDiscussDAO {
	public int save(BookDiscuss bookDiscuss);

	public int update(BookDiscuss bookDiscuss);

	public int delete(int id);

	public BookDiscuss findById(int id);

	public List<BookDiscuss> findAll();

	public int getpageCount(int pageSize);

	public List<BookDiscuss> getNowPageDate(int nPage, int pageSize);
	
	public List<BookDiscuss> findByBookId(int BookId);
	
	public List<BookDiscuss> findByLike(BookDiscuss bookDiscuss);

}
