package com.jinzhi.dao;

import java.util.List;

import com.jinzhi.entity.Admin;

public interface IAdminDAO {
	public int save(Admin admin);

	public int update(Admin admin);

	public int delete(int id);

	public Admin findById(int id);

	public List<Admin> findAll();

	public int getpageCount(int pageSize);

	public List<Admin> getNowPageDate(int nPage, int pageSize);
	
	/**
	 * 根据用户名与密码查找一个对象
	 * 
	 * @param name
	 * @param pwd
	 * @return 如果用户名密码正确,返回对象的详细信息,如果用户名密码错误返回null
	 */
	public Admin findNameAndPwd(String name, String pwd);

}
