package com.action;
import com.biz.IWelfareBiz;
import com.biz.imp.WelfareBiz;
import com.po.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
public class WelfareAction implements IAction{
	private Welfare welfare;
	private Integer welfareid;
	private IWelfareBiz welfarebiz=new WelfareBiz();
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	

	public Welfare getWelfare() {
		return welfare;
	}

	public void setWelfare(Welfare welfare) {
		this.welfare = welfare;
	}

	public Integer getWelfareid() {
		return welfareid;
	}

	public void setWelfareid(Integer welfareid) {
		this.welfareid = welfareid;
	}

	public IWelfareBiz getWelfarebiz() {
		return welfarebiz;
	}

	public void setWelfarebiz(IWelfareBiz welfarebiz) {
		this.welfarebiz = welfarebiz;
	}

	public String save() {
		boolean flag=welfarebiz.save(welfare);
		if(flag){
			path="findAll_Welfare";
			return "ok";
		}
		return "fail";
	}

	public String update() {
		boolean flag=welfarebiz.update(welfare);
		if(flag){
			path="findAll_Welfare";
			return "ok";
		}
		return null;
	}

	public String delById() {
		// TODO Auto-generated method stub
		return null;
	}

	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Welfare oldwelfare=welfarebiz.findById(welfareid);
		session.setAttribute("oldwelfare", oldwelfare);
		path="welfare.jsp";
		return "ok";
	}

	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Welfare> lswelfare=welfarebiz.findAll();
		session.setAttribute("lswf", lswelfare);
		path="welfare.jsp";
		return "ok";
	}

	public String findPageAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
