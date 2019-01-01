package com.jinzhi.servlet.front.gwc;

/**
 * 表示购物车中的一种商品
 * 
 */
public class GwcItem {

	private int bookId;// 图书编号
	private String bookName;// 图书名称
	private String smallImg;// 图书图片
	private double price;// 价格
	private double hyprice;// 会员价
	private int num;// 购买数量

	public GwcItem() {
		super();
	}

	public GwcItem(int bookId, String bookName, String smallImg, double price,
			double hyprice, int num) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.smallImg = smallImg;
		this.price = price;
		this.hyprice = hyprice;
		this.num = num;
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

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public void setHyprice(float hyprice) {
		this.hyprice = hyprice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getHyprice() {
		return hyprice;
	}

	public void setHyprice(double hyprice) {
		this.hyprice = hyprice;
	}
}
