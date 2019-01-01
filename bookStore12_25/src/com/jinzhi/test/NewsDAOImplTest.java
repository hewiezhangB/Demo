package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.INewDAO;
import com.jinzhi.dao.impl.NewsDAOImpl;
import com.jinzhi.entity.News;

public class NewsDAOImplTest {
	public static void main(String[] args) {
		testSave();
		//testUpdate() ;
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		News news = new News(6,15, "nihao", "Ò»°ã°ã", new Date(), 1);
		INewDAO newsDAO = new NewsDAOImpl();
		newsDAO.save(news);
	}
	
	public static void testUpdate(){
		INewDAO newsDAO = new NewsDAOImpl() ;
		News news = newsDAO.findById(2);
		news.setNewsId(3);
		newsDAO.update(news);
	}
	public static void testQuery(){
		INewDAO newsDAO = new NewsDAOImpl() ;
		List<News> newsList = newsDAO.findAll();
		for(News s:newsList){
			System.out.println(s);
		}
	}
	public static void testDelete() {
		INewDAO newsDAO = new NewsDAOImpl();
		newsDAO.delete(4);
	}

}
