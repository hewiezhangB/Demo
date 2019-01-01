package com.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.biz.IUsersBiz;
import com.biz.imp.UsersBiz;
import com.po.Users;
import com.service.BIzService;
import com.service.DaoService;

public class UsersAction implements IAction {

	private Users users;
	private Integer usersid;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getUsersid() {
		return usersid;
	}

	public void setUsersid(Integer usersid) {
		this.usersid = usersid;
	}

	public String save() {
		boolean flag = bIzService.getUsersBiz().save(users);
		if (flag) {
			path = "findAll_Users";
			return "ok";
		}
		return "fail";
	}

	public String update() {
		boolean flag = bIzService.getUsersBiz().update(users);
		if (flag) {
			path = "findAll_Users";
			return "ok";
		}
		return null;
	}

	public String delById() {
		// TODO Auto-generated method stub
		return null;
	}

	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users oldusers = bIzService.getUsersBiz().findById(usersid);
		session.setAttribute("oldusers", oldusers);
		path = "users.jsp";
		return "ok";
	}

	public String findAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Users> lsusers = bIzService.getUsersBiz().findAll();
		session.setAttribute("lsusers", lsusers);
		path = "users.jsp";
		return "ok";
	}

	public String findPageAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String check() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users nus = bIzService.getUsersBiz().check(users);
		if (nus != null) {
			session.setAttribute("nus", nus);
			path = "main.jsp";
			return "ok";
		}
		path = "login.jsp?error=1";

		return "ok";
	}

}
