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
		/********����н��****************************/
		Set<Salary> ss=new HashSet<Salary>();
		Salary sa=new Salary(emp, emp.getEmoney());
		ss.add(sa);
		emp.setSalaries(ss);
		/*******************************************/
		
		/**********���ø�������*************************/
		Set<Empwelfare> ews=new HashSet<Empwelfare>();
		//��ȡ�ӽ��洫�ݵĸ����������
		Integer[] wids=emp.getWids();
		if(wids!=null&&wids.length>0){
			for (int i = 0; i < wids.length; i++) {
				//��ȡ��������
				Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
				Empwelfare ewf=new Empwelfare(emp, wf);
				//����Ա����������Set����
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
		//��ȡԭ����Ա������
		Emp oldemp=daoService.getEmpDAO().findById(emp.getEid());
		
		/*************�����޸ĵ�н��*************************/
		//��ȡԭ����Ա��н��
		Set<Salary> oldss=oldemp.getSalaries();
		if(oldss!=null&&oldss.size()>0){//�ж���ǰ�Ƿ����н��
			//��ȡԭ����Ա��н��
			for (Salary oldsa : oldss) {
				oldsa.setEmoney(emp.getEmoney());
				oldsa.setEmp(emp);
			}
			emp.setSalaries(oldss);//���þɵ�н�ʵ��µ�Ա������
		}else{
			Set<Salary> ss=new HashSet<Salary>();
			Salary sa=new Salary(emp, emp.getEmoney());
			ss.add(sa);
			emp.setSalaries(ss);
		}
		/*************************************************/
		
		/*********�޸�Ա������******************************/
		//��ȡԭ����Ա����������
		Set<Empwelfare> oldews=oldemp.getEmpwelfares();
		//�жϹ�ϵ�����Ƿ��������
		if(oldews!=null&&oldews.size()>0){
			//ɾ��ԭ����Ա��������ϵ������
			for (Empwelfare oldewf : oldews) {
				daoService.getEmpwelfareDAO().delete(oldewf);
			}
		}
		//����µ�Ա������
		Set<Empwelfare> ews=new HashSet<Empwelfare>();
		//��ȡ�ӽ��洫�ݵĸ����������
		Integer[] wids=emp.getWids();
		if(wids!=null&&wids.length>0){
			for (int i = 0; i < wids.length; i++) {
				//��ȡ��������
				Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
				Empwelfare ewf=new Empwelfare(emp, wf);
				//����Ա����������Set����
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
		
		/*******��ȡн��Ϊ�޸�ҳ��׼��н��ֵ********/
		Set<Salary> ss=emp.getSalaries();
		for (Salary sa : ss) {
			emp.setEmoney(sa.getEmoney());
		}
		/*************************************/
		
		/*******Ϊ�޸Ľ���ĸ�ѡ��ѡ��׼������*********/
		Set<Empwelfare> ews=emp.getEmpwelfares();
		if(ews!=null&&ews.size()>0){
			Integer[] wids=new Integer[ews.size()];
			int i=0;//�����±�����
			for(Empwelfare ewf:ews){
				wids[i]=ewf.getWelfare().getWid();//��ȡ�����������Ԫ��
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
