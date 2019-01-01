package com.jinzhi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jinzhi.dao.IBookInfoDAO;
import com.jinzhi.db.DBManager_bookInformation;
import com.jinzhi.entity.BookInfo;
import com.jinzhi.entity.SearchBook;
import com.jinzhi.util.DateUtil;

public class BookInfoDAOImpl implements IBookInfoDAO {
	DBManager_bookInformation db = new DBManager_bookInformation();
	private ResultSet res ;
	public int delete(int id) {
		int count = 0;
		String sql = " update bookInfo set bookStates=1 where bookid = " + id;
		count = db.update(sql);
		return count;
	}
	public List<BookInfo> findAll() {
		List<BookInfo> bookList = new ArrayList<BookInfo>();
		String sql ="select bookId,bookName,booktypeId,author,pbName,context,smallImg,bigImg,price,pbdate,hyprice,bookStates,sjdate,num,saleCount,bookStates from bookInfo where 1=1 " ;
		res =db.query(sql);
		try {
			while(res.next()){
				/*BookInfo book = new BookInfo(res.getString("bookName"), res.getInt("booktypeId"), res.getString("author"), res.getString("pbName"), res.getString("context"), res.getString("smallImg"), res.getString("bigImg"), res.getInt("price"), res.getDate("pbdate"), res.getInt("hyprice"), res.getInt("bookStates"), res.getDate("sjdate"), res.getInt("num"), res.getInt("saleCount"));*/
				BookInfo bookInfo = new BookInfo(res.getInt("bookId"), res.getString("bookName"), res.getInt("booktypeId"), res.getString("author"), res.getString("pbName"), res.getString("context"), res.getString("smallImg"), res.getString("bigImg"), res.getInt("price"), res.getDate("pbdate"), res.getInt("hyprice"), res.getInt("bookStates"), res.getDate("sjdate"), res.getInt("num"), res.getInt("saleCount"));
				bookList.add(bookInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}
	public BookInfo findById(int id) {
		BookInfo bookInfo = null ;
		String sql ="select bookId,bookName,bookTypeId,Author,pbName,Context,smallImg,bigImg,Price,Pbdate,Hyprice,bookStates,Sjdate,Num,saleCount,bookStates from bookInfo where bookId = " + id;
		res =db.query(sql);
		try {
			if(res.next()){
				/*book = new BookInfo(res.getString("bookName"), res.getInt("booktypeId"), res.getString("author"), res.getString("pbName"), res.getString("context"), res.getString("smallImg"), res.getString("bigImg"), res.getInt("price"), res.getDate("pbdate"), res.getInt("hyprice"), res.getInt("bookStates"), res.getDate("sjdate"), res.getInt("num"), res.getInt("saleCount"));*/
				bookInfo = new BookInfo(res.getInt("bookId"), res.getString("bookName"), res.getInt("booktypeId"), res.getString("author"), res.getString("pbName"), res.getString("context"), res.getString("smallImg"), res.getString("bigImg"), res.getInt("price"), res.getDate("pbdate"), res.getInt("hyprice"), res.getInt("bookStates"), res.getDate("sjdate"), res.getInt("num"), res.getInt("saleCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookInfo;
	}
	public int save(BookInfo bookinfo) {
		int count = 0;
		String sql = " insert into bookinfo(bookName,bookTypeId,author,pbName,Context,smallImg,bigImg,Price,Pbdate,Hyprice,bookStates,Sjdate,Num,saleCount) values('"+ bookinfo.getBookName()+ "','"
			+ bookinfo.getBooktypeId() + "','"+bookinfo.getAuthor()+"'" +
			", '" + bookinfo.getPbName()+ "','"+bookinfo.getContext()+"','"+bookinfo.getSmallImg()+"'," +
			"'"+bookinfo.getBigImg()+"','"+bookinfo.getPrice()+"','"+ DateUtil.convertToString(bookinfo.getPbdate()) +"'," +
			"'"+bookinfo.getHyprice()+"','"+bookinfo.getBookStates()+"','"+ DateUtil.convertToString(bookinfo.getSjdate()) +"','"+bookinfo.getNum()+"','"+bookinfo.getSaleCount()+"')";
		count = db.update(sql);
		return count;
	}
	public int update(BookInfo bookinfo) {
		int count = 0;
		String sql = "update  bookInfo set bookName='" + bookinfo.getBookName()
		+ "', bookTypeId =" + bookinfo.getBooktypeId() + ", author ='"
		+ bookinfo.getAuthor() + "', pbName =" + DateUtil.convertToString(bookinfo.getPbdate())
		+ ", Context = '"+ bookinfo.getContext()+"',smallImg = '"+ 
		bookinfo.getSmallImg()+"', bigImg = '"+ bookinfo.getBigImg()+"', price = '"+ 
		bookinfo.getPrice()+"', Pbdate = '"+ bookinfo.getPbName() +"', Hyprice = '"+ 
		bookinfo.getHyprice()+"', bookStates = '"+ bookinfo.getBookStates()+"', Sjdate = '"+ 
		DateUtil.convertToString(bookinfo.getSjdate())+"', Num = '"+ bookinfo.getNum() +"', saleCount = '"+ bookinfo.getSaleCount()
		+"' where bookId=" + bookinfo.getBookId();
		count = db.update(sql);
		return count;
	}
	public List<BookInfo> getNowPageDate(int nPage, int pageSize) {
		List<BookInfo> BookInfoList = new ArrayList<BookInfo>();
		String sql = "select top "+ pageSize+" bookId, bookName, booktypeId, author, pbName, context, smallImg, bigImg, price, pbdate, hyprice, bookStates, sjdate, num, saleCount from bookInfo where bookStates =1 and bookId not in (select top "
				+ (nPage - 1) * pageSize
				+ " bookId from bookInfo where bookStates = 1 )";
		res = db.query(sql);
		try {
			while (res.next()) {
				BookInfo bookInfo = new BookInfo(res.getInt("bookId"), res.getString("bookName"), res.getInt("booktypeId"), res.getString("author"), res.getString("pbName"), res.getString("context"), res.getString("smallImg"), res.getString("bigImg"), res.getInt("price"), res.getDate("pbdate"), res.getInt("hyprice"), res.getInt("bookStates"), res.getDate("sjdate"), res.getInt("num"), res.getInt("saleCount"));
				BookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BookInfoList;
	}
	public int getpageCount(int pageSize) {
		int rowCount = this.getrowCount();
		return rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
	}
	private int getrowCount() {
		String sql = "select count(*) from bookInfo where bookStates = 1";
		res = db.query(sql);
		int count = 0;
		try {
			if (res.next()) {
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public List<BookInfo> findByLike(SearchBook bookInfo) {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String bookName = bookInfo.getBookName();
		int bookTypeId = bookInfo.getBookTypeId();
		String author = bookInfo.getAuthor();
		String context = bookInfo.getContext();
		double lprice = bookInfo.getLprice();
		double hprice = bookInfo.getHprice();
		String pbName = bookInfo.getPbName();
		StringBuffer sb = new StringBuffer("select * from bookInfo where 1 = 1");
		if(bookName != null) {
			sb.append(" and bookName like '%" + bookName + "%'");
		}
		if(bookTypeId > 0) {
			sb.append(" and bookTypeId = " + bookTypeId + "");
		}
		if(author != null) {
			sb.append(" and author like '%" + author + "%'");
		}
		if(pbName != null) {
			sb.append(" and pbName like '%" + pbName + "%'");
		}
		if(hprice > 0) {
			sb.append(" and hyprice between " + lprice +  " and " + hprice + "");
		}
		if(context != null) {
			sb.append(" and context like '%" + context + "%'");
		}
		sb.append(" and bookStates != 0");
		String sql = sb.toString();
		System.out.println(sql);
		 res = db.query(sql);
		try {
			while(res.next()) {
				BookInfo bookInfo1 = new BookInfo();
				bookInfo1.setBookId(res.getInt(1));
				bookInfo1.setBookName(res.getString(2));
				bookInfo1.setBooktypeId(res.getInt(3));
				bookInfo1.setAuthor(res.getString(4));
				bookInfo1.setPbName(res.getString(5));
				bookInfo1.setContext(res.getString(6));
				bookInfo1.setSmallImg(res.getString(7));
				bookInfo1.setBigImg(res.getString(8));
				bookInfo1.setPrice(res.getDouble(9));
				bookInfo1.setPbdate(res.getDate(10));
				bookInfo1.setHyprice(res.getDouble(11));
				bookInfo1.setBookStates(res.getInt(12));
				bookInfo1.setSjdate(res.getDate(13));
				bookInfo1.setNum(res.getInt(14));
				bookInfo1.setSaleCount(res.getInt(15));
				list.add(bookInfo1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}



	@Override
	public List<BookInfo> findBySaleCount(int rows) {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = 
			"select top " + rows + " " +
			"	* " +
			"from " +
			"	bookInfo " +
			"where bookStates = 2 " +
			"	order by saleCount desc";
		System.out.println(sql);
		 res = db.query(sql);
		try {
			while(res.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setBookId(res.getInt(1));
				bookInfo.setBookName(res.getString(2));
				bookInfo.setBooktypeId(res.getInt(3));
				bookInfo.setAuthor(res.getString(4));
				bookInfo.setPbName(res.getString(5));
				bookInfo.setContext(res.getString(6));
				bookInfo.setSmallImg(res.getString(7));
				bookInfo.setBigImg(res.getString(8));
				bookInfo.setPrice(res.getDouble(9));
				bookInfo.setPbdate(res.getDate(10));
				bookInfo.setHyprice(res.getDouble(11));
				bookInfo.setBookStates(res.getInt(12));
				bookInfo.setSjdate(res.getDate(13));
				bookInfo.setNum(res.getInt(14));
				bookInfo.setSaleCount(res.getInt(15));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}

	@Override
	public List<BookInfo> findBySjDate(int rows) {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = 
			"select top " + rows + " * " +
			" from " +
			"	bookInfo " +
			"where " +
			"	bookStates = 2 " +
			"order by sjdate desc";
		
		 res = db.query(sql);
		try {
			while(res.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setBookId(res.getInt(1));
				bookInfo.setBookName(res.getString(2));
				bookInfo.setBooktypeId(res.getInt(3));
				bookInfo.setAuthor(res.getString(4));
				bookInfo.setPbName(res.getString(5));
				bookInfo.setContext(res.getString(6));
				bookInfo.setSmallImg(res.getString(7));
				bookInfo.setBigImg(res.getString(8));
				bookInfo.setPrice(res.getDouble(9));
				bookInfo.setPbdate(res.getDate(10));
				bookInfo.setHyprice(res.getDouble(11));
				bookInfo.setBookStates(res.getInt(12));
				bookInfo.setSjdate(res.getDate(13));
				bookInfo.setNum(res.getInt(14));
				bookInfo.setSaleCount(res.getInt(15));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}
	
	@Override
	public List<BookInfo> findByBookTypeId(int id) {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select * from bookInfo where bookStates != 0 and bookTypeId = " + id;
		System.out.println(sql);
		 res = db.query(sql);
		try {
			while(res.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setBookId(res.getInt(1));
				bookInfo.setBookName(res.getString(2));
				bookInfo.setBooktypeId(res.getInt(3));
				bookInfo.setAuthor(res.getString(4));
				bookInfo.setPbName(res.getString(5));
				bookInfo.setContext(res.getString(6));
				bookInfo.setSmallImg(res.getString(7));
				bookInfo.setBigImg(res.getString(8));
				bookInfo.setPrice(res.getDouble(9));
				bookInfo.setPbdate(res.getDate(10));
				bookInfo.setHyprice(res.getDouble(11));
				bookInfo.setBookStates(res.getInt(12));
				bookInfo.setSjdate(res.getDate(13));
				bookInfo.setNum(res.getInt(14));
				bookInfo.setSaleCount(res.getInt(15));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;

	}

	@Override
	public List<BookInfo> findByParentId(int id) {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select * from bookInfo where bookTypeId in (select bookTypeId from bookType where parentId = " + id + ")";
		System.out.println(sql);
		 res = db.query(sql);
		try {
			while(res.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setBookId(res.getInt(1));
				bookInfo.setBookName(res.getString(2));
				bookInfo.setBooktypeId(res.getInt(3));
				bookInfo.setAuthor(res.getString(4));
				bookInfo.setPbName(res.getString(5));
				bookInfo.setContext(res.getString(6));
				bookInfo.setSmallImg(res.getString(7));
				bookInfo.setBigImg(res.getString(8));
				bookInfo.setPrice(res.getDouble(9));
				bookInfo.setPbdate(res.getDate(10));
				bookInfo.setHyprice(res.getDouble(11));
				bookInfo.setBookStates(res.getInt(12));
				bookInfo.setSjdate(res.getDate(13));
				bookInfo.setNum(res.getInt(14));
				bookInfo.setSaleCount(res.getInt(15));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}



	@Override
	public List<BookInfo> findByBookTypeId(int bookTypeId, int nPage,
			int pageSize) {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select top "+pageSize+" * from bookInfo where bookStates != 0 and bookid not in (select top "+(nPage-1)*pageSize+" bookid from bookinfo where bookStates != 0 and bookTypeId ="+bookTypeId+") and bookTypeid ="+bookTypeId+"  " ;
		System.out.println(sql);
		 res = db.query(sql);
		try {
			while(res.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setBookId(res.getInt(1));
				bookInfo.setBookName(res.getString(2));
				bookInfo.setBooktypeId(res.getInt(3));
				bookInfo.setAuthor(res.getString(4));
				bookInfo.setPbName(res.getString(5));
				bookInfo.setContext(res.getString(6));
				bookInfo.setSmallImg(res.getString(7));
				bookInfo.setBigImg(res.getString(8));
				bookInfo.setPrice(res.getDouble(9));
				bookInfo.setPbdate(res.getDate(10));
				bookInfo.setHyprice(res.getDouble(11));
				bookInfo.setBookStates(res.getInt(12));
				bookInfo.setSjdate(res.getDate(13));
				bookInfo.setNum(res.getInt(14));
				bookInfo.setSaleCount(res.getInt(15));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;

	}

	@Override
	public int findByBookTypeIdSumPage(int bookTypeId, int pageSize) {

		int count =0;
		String sql ="select count(*) from bookinfo  where bookStates != 0 and booktypeid ="+bookTypeId+"" ;
		res = db.query(sql);
		try {
			if(res.next()){
				count=res.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	
	}

	@Override
	public List<BookInfo> findByLike(BookInfo bookInfos, int nPage, int pageSize) {

		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select top "+pageSize+" * from bookInfo where bookStates != 0 and bookid not in (select top "+(nPage-1)*pageSize+" bookid from bookinfo where bookStates != 0 ) " ;
		if(bookInfos.getBookName()!=null && !"".equals(bookInfos.getBookName())){
			sql+=" and bookname like '%"+bookInfos.getBookName()+"%'" ;
			
		}
		if(bookInfos.getAuthor()!=null && !"".equals(bookInfos.getAuthor())){
			sql+=" and author like '%"+bookInfos.getAuthor()+"%'" ;
			
		}
		System.out.println(sql);
		 res = db.query(sql);
		try {
			while(res.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setBookId(res.getInt(1));
				bookInfo.setBookName(res.getString(2));
				bookInfo.setBooktypeId(res.getInt(3));
				bookInfo.setAuthor(res.getString(4));
				bookInfo.setPbName(res.getString(5));
				bookInfo.setContext(res.getString(6));
				bookInfo.setSmallImg(res.getString(7));
				bookInfo.setBigImg(res.getString(8));
				bookInfo.setPrice(res.getDouble(9));
				bookInfo.setPbdate(res.getDate(10));
				bookInfo.setHyprice(res.getDouble(11));
				bookInfo.setBookStates(res.getInt(12));
				bookInfo.setSjdate(res.getDate(13));
				bookInfo.setNum(res.getInt(14));
				bookInfo.setSaleCount(res.getInt(15));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}

	@Override
	public int findByLikeSumPage(BookInfo bookInfo, int pageSize) {
		int count =0;
		String sql ="select count(*) from bookinfo  where bookStates != 0 " ;
		if(bookInfo.getBookName()!=null && !"".equals(bookInfo.getBookName())){
			sql+=" and bookname like '%"+bookInfo.getBookName()+"%'" ;
			
		}
		if(bookInfo.getAuthor()!=null && !"".equals(bookInfo.getAuthor())){
			sql+=" and author like '%"+bookInfo.getAuthor()+"%'" ;
			
		}
		res = db.query(sql);
		try {
			if(res.next()){
				count=res.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}
}
