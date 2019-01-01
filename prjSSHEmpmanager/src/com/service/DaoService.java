package com.service;
import com.dao.*;
public class DaoService {
	private DepDAO depdao;
	private EmpDAO empDAO;
	private SalaryDAO salaryDAO;
	private WelfareDAO welfareDAO;
	private EmpwelfareDAO empwelfareDAO;
	private UsersDAO usersDAO;
	
	public DepDAO getDepdao() {
		return depdao;
	}
	public void setDepdao(DepDAO depdao) {
		this.depdao = depdao;
	}
	public EmpDAO getEmpDAO() {
		return empDAO;
	}
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	public SalaryDAO getSalaryDAO() {
		return salaryDAO;
	}
	public void setSalaryDAO(SalaryDAO salaryDAO) {
		this.salaryDAO = salaryDAO;
	}
	public WelfareDAO getWelfareDAO() {
		return welfareDAO;
	}
	public void setWelfareDAO(WelfareDAO welfareDAO) {
		this.welfareDAO = welfareDAO;
	}
	public EmpwelfareDAO getEmpwelfareDAO() {
		return empwelfareDAO;
	}
	public void setEmpwelfareDAO(EmpwelfareDAO empwelfareDAO) {
		this.empwelfareDAO = empwelfareDAO;
	}
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
}
