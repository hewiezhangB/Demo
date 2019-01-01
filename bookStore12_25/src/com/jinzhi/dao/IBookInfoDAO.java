package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.BookInfo;

public interface IBookInfoDAO {
	public int save(BookInfo bookinfo);

	public int update(BookInfo bookinfo);

	public int delete(int id);

	public BookInfo findById(int id);

	public List<BookInfo> findAll();

	public int getpageCount(int pageSize);

	public List<BookInfo> getNowPageDate(int nPage, int pageSize);

	int findByBookTypeIdSumPage(int bookTypeId, int pageSize);

	int findByLikeSumPage(BookInfo bookInfo, int pageSize);

	List<BookInfo> findByLike(BookInfo bookInfos, int nPage, int pageSize);

	List<BookInfo> findByBookTypeId(int bookTypeId, int nPage, int pageSize);

	List<BookInfo> findByParentId(int id);

	List<BookInfo> findByBookTypeId(int id);

	List<BookInfo> findBySaleCount(int rows);

	List<BookInfo> findBySjDate(int rows);

}
