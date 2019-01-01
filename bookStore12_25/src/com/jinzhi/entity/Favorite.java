package com.jinzhi.entity;

import java.util.Date;


public class Favorite {
	private int farivateId;
	private int bookId;
	private int custId;
	private Date date;
	private String context;
	
	public Favorite() {
		// TODO Auto-generated constructor stub
	}

	public Favorite(int bookId, int custId, Date date, String context) {
		super();
		this.bookId = bookId;
		this.custId = custId;
		this.date = date;
		this.context = context;
	}
	
	public Favorite(int farivateId, int bookId, int custId, Date date,
			String context) {
		super();
		this.farivateId = farivateId;
		this.bookId = bookId;
		this.custId = custId;
		this.date = date;
		this.context = context;
	}

	public int getFarivateId() {
		return farivateId;
	}

	public void setFarivateId(int farivateId) {
		this.farivateId = farivateId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Favorite [bookId=" + bookId + ", context=" + context
				+ ", custId=" + custId + ", date=" + date + ", farivateId="
				+ farivateId + "]";
	}
}