package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.Favorite;

public interface IFavoriteDAO {
	public int save(Favorite favorite);

	public int update(Favorite favorite);

	public int delete(int id);

	public Favorite findById(int id);

	public List<Favorite> findAll();

}
