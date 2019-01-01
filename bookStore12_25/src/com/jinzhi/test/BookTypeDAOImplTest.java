package com.jinzhi.test;

import java.util.Date;
import java.util.List;

import com.jinzhi.dao.IBookTypeDAO;
import com.jinzhi.dao.impl.BookTypeDAOImpl;
import com.jinzhi.entity.BookType;

public class BookTypeDAOImplTest {
	public static void main(String[] args) {
		testSave();
	    //testUpdate();
	    //testQuery();
		//testDelete();
	}
	public static void testSave(){
		BookType bookType = new BookType(92, 555, "g", "dhj", 1);
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		bookTypeDAO.save(bookType);
	}

	public static void testUpdate(){
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		BookType bookType = bookTypeDAO.findById(4);
		bookType.setBookTypeName("66");
		bookTypeDAO.update(bookType);
	}

	public static void testQuery(){
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		List<BookType> bookTypeList = bookTypeDAO.findAll();
		for(BookType b:bookTypeList){
			System.out.println(b);
		}
	}
	
	public static void testDelete() {
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		bookTypeDAO.delete(3);
	}
}
