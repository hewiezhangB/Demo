package com.jinzhi.entity;

public class SearchBook {
	private int bookId;
	private String bookName;
	private int bookTypeId;
	private String author;
	private String context;
	private double lprice;
	private double hprice;
	private String pbName;
	
	public SearchBook() {
	}

	public SearchBook(String bookName, int bookTypeId, String author,
			String context, double lprice, double hprice, String pbName) {
		super();
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.author = author;
		this.context = context;
		this.lprice = lprice;
		this.hprice = hprice;
		this.pbName = pbName;
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

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public double getLprice() {
		return lprice;
	}

	public void setLprice(double lprice) {
		this.lprice = lprice;
	}

	public double getHprice() {
		return hprice;
	}

	public void setHprice(double hprice) {
		this.hprice = hprice;
	}

	public String getPbName() {
		return pbName;
	}

	public void setPbName(String pbName) {
		this.pbName = pbName;
	}
	
}
