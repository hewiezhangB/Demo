package com.biz.imp;

import java.util.*;

import com.biz.*;
import com.po.*;
import com.service.DaoService;
import com.dao.*;
public class UsersBiz implements IUsersBiz {
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	
	public boolean save(Users us) {
		try {
			daoService.getUsersDAO().save(us);
			return  true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Users us) {
		try {
			daoService.getUsersDAO().merge(us);
			return  true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Users findById(Integer uid) {
		// TODO Auto-generated method stub
		return daoService.getUsersDAO().findById(uid);
	}

	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return daoService.getUsersDAO().findAll();
	}

	public boolean delById(Integer uid) {
		Users us=daoService.getUsersDAO().findById(uid);
		try {
			daoService.getUsersDAO().delete(us);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Users check(Users us) {
		
		return daoService.getUsersDAO().check(us);
	}

}
