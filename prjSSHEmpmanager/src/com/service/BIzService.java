package com.service;
import com.biz.*;
public class BIzService {
	private IDepBiz depBiz;
	private IEmpBiz empBiz;
	private IUsersBiz usersBiz;
	private IWelfareBiz welfareBiz;
	public IDepBiz getDepBiz() {
		return depBiz;
	}
	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
	}
	public IEmpBiz getEmpBiz() {
		return empBiz;
	}
	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
	}
	public IUsersBiz getUsersBiz() {
		return usersBiz;
	}
	public void setUsersBiz(IUsersBiz usersBiz) {
		this.usersBiz = usersBiz;
	}
	public IWelfareBiz getWelfareBiz() {
		return welfareBiz;
	}
	public void setWelfareBiz(IWelfareBiz welfareBiz) {
		this.welfareBiz = welfareBiz;
	}
	
}
