package com.biz.imp;

import java.util.List;
import com.service.*;
import com.po.Dep;
import com.biz.IDepBiz;
import com.dao.*;

public class DepBiz implements IDepBiz {
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public List<Dep> findAll() {
		return daoService.getDepdao().findAll();
	}

	public boolean save(Dep dep) {
		try {
			daoService.getDepdao().save(dep);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Dep dep) {
		try {
			daoService.getDepdao().merge(dep);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Dep findById(Integer depid) {
		Dep dep = daoService.getDepdao().findById(depid);
		return dep;
	}

}
