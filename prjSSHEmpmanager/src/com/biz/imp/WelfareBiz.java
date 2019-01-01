package com.biz.imp;

import java.util.List;

import com.po.Welfare;
import com.service.DaoService;
import com.biz.IWelfareBiz;
import com.dao.*;

public class WelfareBiz implements IWelfareBiz {
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	
	public List<Welfare> findAll() {
		return daoService.getWelfareDAO().findAll();
	}
	public boolean save(Welfare welfare) {
		try {
			daoService.getWelfareDAO().save(welfare);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Welfare welfare) {
		try {
			daoService.getWelfareDAO().merge(welfare);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Welfare findById(Integer wid) {
		
		return daoService.getWelfareDAO().findById(wid);
	}

}
