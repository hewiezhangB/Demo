package com.jinzhi.test;

import java.util.Date;
import java.util.List;
import com.jinzhi.dao.IBookDiscussDAO;
import com.jinzhi.dao.impl.BookDiscussDAOImpl;
import com.jinzhi.entity.BookDiscuss;

public class BookDiscussDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		//testUpdate() ;
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		BookDiscuss IBookDiscuss = new BookDiscuss(20, 2, "ºÃµÄ", "1");
		IBookDiscussDAO IBookDiscussDAO = new BookDiscussDAOImpl();
		IBookDiscussDAO.save(IBookDiscuss);
	}
	
	public static void testUpdate(){
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		BookDiscuss bookDiscuss = bookDiscussDAO.findById(1);
		bookDiscuss.setBookId(9);
		bookDiscussDAO.update(bookDiscuss);
	}
	public static void testQuery(){
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		List<BookDiscuss> bookDiscussList = bookDiscussDAO.findAll();
		for (BookDiscuss bookDiscuss : bookDiscussList) {
			System.out.println(bookDiscuss);
		}
	}
	public static void testDelete() {
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		bookDiscussDAO.delete(2);
	}

}
