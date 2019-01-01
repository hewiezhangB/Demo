package com.jinzhi.entity;

public class OrderView {
	private String orderNum;// 订单编号
	private int custId;// 用户名编号
	private String custName;// 收件人名称
	private String tel;// 收件人电话
	private String address;// 收件人地址
	private String status;// 订单状态
	private int adminId;// 管理员编号
	private String context;// 订单备注
	private double sumprice;// 订单总价
	private int bookId;// 图书编号
	private int num;// 图书数量
	private String bookName;// 图书名称
	private double hyprice;// 图书价格

	public OrderView() {
		super();
	}

	public OrderView(String orderNum, int custId, String custName, String tel,
			String address, String status, int adminId, String context,
			double sumprice, int bookId, int num, String bookName,
			double hyprice) {
		super();
		this.orderNum = orderNum;
		this.custId = custId;
		this.custName = custName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		this.sumprice = sumprice;
		this.bookId = bookId;
		this.num = num;
		this.bookName = bookName;
		this.hyprice = hyprice;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public double getSumprice() {
		return sumprice;
	}

	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getHyprice() {
		return hyprice;
	}

	public void setHyprice(double hyprice) {
		this.hyprice = hyprice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + adminId;
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + custId;
		result = prime * result
				+ ((custName == null) ? 0 : custName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(hyprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + num;
		result = prime * result
				+ ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(sumprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderView other = (OrderView) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (adminId != other.adminId)
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (Double.doubleToLongBits(hyprice) != Double
				.doubleToLongBits(other.hyprice))
			return false;
		if (num != other.num)
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(sumprice) != Double
				.doubleToLongBits(other.sumprice))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

}
