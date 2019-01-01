package com.jinzhi.entity;

public class DiscussView {
	private int disId; // 评论编号
	private int bookId; // 图书编号
	private int cusId; // 客户编号
	private String bookName; // 图书名称
	private String custName; // 客户名称
	private String context; // 评价内容
	private String states; // 评论状态

	public DiscussView() {
		super();
	}

	public DiscussView(int disId, int bookId, int cusId, String bookName,
			String custName, String context, String states) {
		super();
		this.disId = disId;
		this.bookId = bookId;
		this.cusId = cusId;
		this.bookName = bookName;
		this.custName = custName;
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

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

}
