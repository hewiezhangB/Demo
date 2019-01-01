package com.biz.imp;

import java.util.*;
import com.po.*;
import com.service.DaoService;
import com.biz.IEmpBiz;
import com.dao.*;

public class EmpBiz implements IEmpBiz {
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	
	public boolean save(Emp emp) {
		/********设置薪资****************************/
		Set<Salary> ss=new HashSet<Salary>();
		Salary sa=new Salary(emp, emp.getEmoney());
		ss.add(sa);
		emp.setSalaries(ss);
		/*******************************************/
		
		/**********设置福利数据*************************/
		Set<Empwelfare> ews=new HashSet<Empwelfare>();
		//获取从界面传递的福利编号数组
		Integer[] wids=emp.getWids();
		if(wids!=null&&wids.length>0){
			for (int i = 0; i < wids.length; i++) {
				//获取福利对象
				Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
				Empwelfare ewf=new Empwelfare(emp, wf);
				//设置员工福利对象到Set集合
				ews.add(ewf);
			}
		}
		emp.setEmpwelfares(ews);
		/*********************************************/
		
		try {
			daoService.getEmpDAO().save(emp);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		
		return false;
	}

	public boolean update(Emp emp) {
		//获取原来的员工对象
		Emp oldemp=daoService.getEmpDAO().findById(emp.getEid());
		
		/*************设置修改的薪资*************************/
		//获取原来的员工薪资
		Set<Salary> oldss=oldemp.getSalaries();
		if(oldss!=null&&oldss.size()>0){//判断以前是否存在薪资
			//获取原来的员工薪资
			for (Salary oldsa : oldss) {
				oldsa.setEmoney(emp.getEmoney());
				oldsa.setEmp(emp);
			}
			emp.setSalaries(oldss);//设置旧的薪资到新的员工对象
		}else{
			Set<Salary> ss=new HashSet<Salary>();
			Salary sa=new Salary(emp, emp.getEmoney());
			ss.add(sa);
			emp.setSalaries(ss);
		}
		/*************************************************/
		
		/*********修改员工福利******************************/
		//获取原来的员工福利集合
		Set<Empwelfare> oldews=oldemp.getEmpwelfares();
		//判断关系表中是否存在数据
		if(oldews!=null&&oldews.size()>0){
			//删除原来的员工福利关系表数据
			for (Empwelfare oldewf : oldews) {
				daoService.getEmpwelfareDAO().delete(oldewf);
			}
		}
		//添加新的员工福利
		Set<Empwelfare> ews=new HashSet<Empwelfare>();
		//获取从界面传递的福利编号数组
		Integer[] wids=emp.getWids();
		if(wids!=null&&wids.length>0){
			for (int i = 0; i < wids.length; i++) {
				//获取福利对象
				Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
				Empwelfare ewf=new Empwelfare(emp, wf);
				//设置员工福利对象到Set集合
				ews.add(ewf);
			}
		}
		emp.setEmpwelfares(ews);
		
		/*************************************************/
		
		try {
			daoService.getEmpDAO().merge(emp);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		
		return false;
	}

	public boolean delById(Integer eid) {
		Emp emp=daoService.getEmpDAO().findById(eid);
		try {
			daoService.getEmpDAO().delete(emp);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Emp findById(Integer eid) {
		Emp emp=daoService.getEmpDAO().findById(eid);
		
		/*******获取薪资为修改页面准备薪资值********/
		Set<Salary> ss=emp.getSalaries();
		for (Salary sa : ss) {
			emp.setEmoney(sa.getEmoney());
		}
		/*************************************/
		
		/*******为修改界面的复选框选中准备数据*********/
		Set<Empwelfare> ews=emp.getEmpwelfares();
		if(ews!=null&&ews.size()>0){
			Integer[] wids=new Integer[ews.size()];
			int i=0;//数组下标索引
			for(Empwelfare ewf:ews){
				wids[i]=ewf.getWelfare().getWid();//获取福利编号数组元素
				i++;
			}
			emp.setWids(wids);
		}
		/****************************************/
		
		return emp;
	}

	public List<Emp> findPageAll(int page, int rows) {
		if(page<1)page=1;
		if(rows<1)rows=5;
		return daoService.getEmpDAO().findPageAll(page, rows);
	}

	public int findMaxPage(int rows) {
		if(rows<1)rows=5;
		return daoService.getEmpDAO().findMaxPage(rows);
	}

}
