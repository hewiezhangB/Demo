package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.News;

public interface INewDAO {
	public int save(News news);

	public int update(News news);

	public int delete(int id);

	public News findById(int id);

	public List<News> findAll();

}
