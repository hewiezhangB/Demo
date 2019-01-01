package com.jinzhi.entity;

import java.util.Date;

public class BookInfo {

	private int bookId;
	private String bookName;
	private int booktypeId;
	private String author;
	private String pbName;
	private String context;
	private String smallImg;
	private String bigImg;
	private int price;
	private Date pbdate;
	private int hyprice;
	private int bookStates;
	private Date sjdate;
	private int num;
	private int saleCount;
	
	public BookInfo() {
		// TODO Auto-generated constructor stub
	}

	public BookInfo(String bookName, int booktypeId, String author,
			String pbName, String context, String smallImg, String bigImg,
			int price, Date pbdate, int hyprice, int bookStates, Date sjdate,
			int num, int saleCount) {
		super();
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.sjdate = sjdate;
		this.num = num;
		this.saleCount = saleCount;
	}

	public BookInfo(int bookId, String bookName, int booktypeId, String author,
			String pbName, String context, String smallImg, String bigImg,
			int price, Date pbdate, int hyprice, int bookStates, Date sjdate,
			int num, int saleCount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.sjdate = sjdate;
		this.num = num;
		this.saleCount = saleCount;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBooktypeId() {
		return booktypeId;
	}

	public void setBooktypeId(int booktypeId) {
		this.booktypeId = booktypeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPbName() {
		return pbName;
	}

	public void setPbName(String pbName) {
		this.pbName = pbName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setPrice(double price) {
		int d = 0;
		this.price = d;
	}

	public Date getPbdate() {
		return pbdate;
	}

	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}

	public int getHyprice() {
		return hyprice;
	}

	public void setHyprice(int hyprice) {
		this.hyprice = hyprice;
	}
	
	public void setHyprice(double hyprice) {
		int d = 0;
		this.hyprice = d;
	}

	public int getBookStates() {
		return bookStates;
	}

	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}

	public Date getSjdate() {
		return sjdate;
	}

	public void setSjdate(Date sjdate) {
		this.sjdate = sjdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	@Override
	public String toString() {
		return "BookInfo [author=" + author + ", bigImg=" + bigImg
				+ ", bookId=" + bookId + ", bookName=" + bookName
				+ ", bookStates=" + bookStates + ", booktypeId=" + booktypeId
				+ ", context=" + context + ", hyprice=" + hyprice + ", num="
				+ num + ", pbName=" + pbName + ", pbdate=" + pbdate
				+ ", price=" + price + ", saleCount=" + saleCount + ", sjdate="
				+ sjdate + ", smallImg=" + smallImg + "]";
	}
}