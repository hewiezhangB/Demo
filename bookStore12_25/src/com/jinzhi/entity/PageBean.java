package com.jinzhi.entity;

import java.util.List;

public class PageBean<T> {

	private int nowPage;// ��ǰҳ����
	private int pageSize = 3;// ҳ��С
	private int sumRow;// ������
	private int sumPage;// ��ҳ��
	private List<T> pageData;// ��ʾ����

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
