package com.jinzhi.entity;

import java.util.Date;


public class News {
	private int newsId;
	private int adminId;
	private String title;
	private String context;
	private Date FbTime;
	private int isDelete;
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(int newsId, int adminId, String title, String context,
			Date fbTime, int isDelete) {
		super();
		this.newsId = newsId;
		this.adminId = adminId;
		this.title = title;
		this.context = context;
		FbTime = fbTime;
		this.isDelete = isDelete;
	}

	public News(int adminId, String title, String context, Date fbTime,
			int isDelete) {
		super();
		this.adminId = adminId;
		this.title = title;
		this.context = context;
		FbTime = fbTime;
		this.isDelete = isDelete;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getFbTime() {
		return FbTime;
	}

	public void setFbTime(Date fbTime) {
		FbTime = fbTime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "News [FbTime=" + FbTime + ", adminId=" + adminId + ", context="
				+ context + ", isDelete=" + isDelete + ", newsId=" + newsId
				+ ", title=" + title + "]";
	}
}