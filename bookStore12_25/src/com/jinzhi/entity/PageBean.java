package com.jinzhi.entity;

import java.util.List;

public class PageBean<T> {

	private int nowPage;// 当前页码数
	private int pageSize = 3;// 页大小
	private int sumRow;// 总条数
	private int sumPage;// 总页数
	private List<T> pageData;// 显示数据

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSumRow() {
		return sumRow;
	}

	public void setSumRow(int sumRow) {
		this.sumRow = sumRow;
	}

	public int getSumPage() {
		return this.getSumRow() % this.getPageSize() == 0 ? this.getSumRow()
				/ this.getPageSize() : this.getSumRow() / this.getPageSize()
				+ 1;
	}

	public void setSumPage(int sumPage) {
		this.sumPage = sumPage;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
}
