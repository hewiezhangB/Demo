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
	 * �����û������������һ������
	 * 
	 * @param name
	 * @param pwd
	 * @return ����û���������ȷ,���ض������ϸ��Ϣ,����û���������󷵻�null
	 */
	public Admin findNameAndPwd(String name, String pwd);

}
