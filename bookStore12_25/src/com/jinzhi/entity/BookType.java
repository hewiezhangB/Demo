package com.jinzhi.entity;

public class BookType implements Comparable<BookType> {
	private int bookTypeId;
	private int parentId;
	private String bookTypeName;
	private String context;
	private int isDelete;

	public BookType() {
		// TODO Auto-generated constructor stub
	}

	public BookType(int bookTypeId, int parentId, String bookTypeName,
			String context, int isDelete) {
		super();
		this.bookTypeId = bookTypeId;
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.context = context;
		this.isDelete = isDelete;
	}

	public BookType(int parentId, String bookTypeName, String context,
			int isDelete) {
		super();
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.context = context;
		this.isDelete = isDelete;
	}

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "BookType [bookTypeId=" + bookTypeId + ", bookTypeName="
				+ bookTypeName + ", context=" + context + ", isDelete="
				+ isDelete + ", parentId=" + parentId + "]";
	}

	@Override
	public int compareTo(BookType bookType) {
		return this.bookTypeId - bookType.getBookTypeId();
	}
}