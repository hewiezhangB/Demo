package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.IFavoriteDAO;
import com.jinzhi.dao.impl.FavoriteDAOImpl;
import com.jinzhi.entity.Favorite;

public class FavoriteDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		testUpdate() ;
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		Favorite favorite = new Favorite(11, 8, new Date(), "ÏëÂòµÎ");
		IFavoriteDAO favoriteDAO = new FavoriteDAOImpl();
		favoriteDAO.save(favorite);
	}
	
	public static void testUpdate(){
		IFavoriteDAO favoriteDAO = new FavoriteDAOImpl() ;
		Favorite favorite = favoriteDAO.findById(1);
		favorite.setCustId(6);
		favoriteDAO.update(favorite);
	}
	public static void testQuery(){
		IFavoriteDAO favoriteDAO = new FavoriteDAOImpl() ;
		List<Favorite> favoriteList = favoriteDAO.findAll();
		for(Favorite s:favoriteList){
			System.out.println(s);
		}
	}
	public static void testDelete() {
		IFavoriteDAO bookDAO = new FavoriteDAOImpl();
		bookDAO.delete(0);
	}

}
