package com.action;

import com.po.*;
import java.util.*;
import com.service.*;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
public class DepAction implements IAction{
	private Dep dep;
	private Integer depid;

	private String path;
	
	private BIzService bIzService;
	
	
	public BIzService getbIzService() {
		return bIzService;
	}

	public void setbIzService(BIzService bIzService) {
		this.bIzService = bIzService;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public Integer getDepid() {
		return depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

	public String save() {
		boolean flag=bIzService.getDepBiz().save(dep);
		if(flag){
			path="findAll_Dep";
			return "ok";
		}
		return "fail";
	}

	public String update() {
		boolean flag=bIzService.getDepBiz().update(dep);
		if(flag){
			path="findAll_Dep";
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
		Dep olddep=bIzService.getDepBiz().findById(depid);
		session.setAttribute("olddep", olddep);
		path="dep.jsp";
		return "ok";
	}

	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Dep> lsdep=bIzService.getDepBiz().findAll();
		session.setAttribute("lsdep", lsdep);
		path="dep.jsp";
		return "ok";
	}

	public String findPageAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
