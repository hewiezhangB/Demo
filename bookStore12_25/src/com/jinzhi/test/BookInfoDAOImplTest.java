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
		BookInfo book = new BookInfo("Ұ�Եĺ���", 6, "Jack London", "����ʦ����ѧ������", "������һ����˵�Ĺ���", "1.png", "2.png", 50,new Date(), 25, 1, new Date(), 100, 0);
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		bookInfoDAO.save(book);
	}
	
	public static void testUpdate(){
		IBookInfoDAO bookDAO = new BookInfoDAOImpl() ;
		BookInfo book = bookDAO.findById(1);
		book.setBookName("��¹ԭ");
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
