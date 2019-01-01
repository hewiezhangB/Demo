package com.jinzhi.test;

import java.util.Date;
import java.util.List;

import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.dao.impl.BookInfoDAOImpl;
import com.jinzhi.entity.BookInfo;

public class BookInfoDAOImplTest {
	public static void main(String[] args) {
		//testSave();
		testUpdate();
		//testQuery() ;
		//testDelete();
		
	}
	public static void testSave(){
		BookInfo book = new BookInfo("野性的呼唤", 6, "Jack London", "陕西师范大学出版社", "讲述了一个传说的故事", "1.png", "2.png", 50,new Date(), 25, 1, new Date(), 100, 0);
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		bookInfoDAO.save(book);
	}
	
	public static void testUpdate(){
		IBookInfoDAO bookDAO = new BookInfoDAOImpl() ;
		BookInfo book = bookDAO.findById(1);
		book.setBookName("白鹿原");
		book.setPbdate(new Date());
		book.setSjdate(new Date());
		bookDAO.update(book);
	}
	public static void testQuery(){
		IBookInfoDAO bookDAO = new BookInfoDAOImpl() ;
		List<BookInfo> bookList = bookDAO.findAll();
		for(BookInfo s:bookList){
			System.out.println(s);
		}
	}
	public static void testDelete() {
		IBookInfoDAO bookDAO = new BookInfoDAOImpl();
		bookDAO.delete(99);
	}

}
