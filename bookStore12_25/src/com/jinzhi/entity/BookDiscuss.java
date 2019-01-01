package com.jinzhi.entity;


public class BookDiscuss {
	private int disId;
	private int bookId;
	private int custId;
	private String context;
	private String states;
	
	public BookDiscuss() {
		// TODO Auto-generated constructor stub
	}

	public BookDiscuss(int bookId, int custId, String context, String states) {
		super();
		this.bookId = bookId;
		this.custId = custId;
		this.context = context;
		this.states = states;
	}

	public BookDiscuss(int disId, int bookId, int custId, String context,
			String states) {
		super();
		this.disId = disId;
		this.bookId = bookId;
		this.custId = custId;
		this.context = context;
		this.states = states;
	}

	public int getDisId() {
		return disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "BookDiscuss [bookId=" + bookId + ", context=" + context
				+ ", custId=" + custId + ", disId=" + disId + ", states="
				+ states + "]";
	}

}