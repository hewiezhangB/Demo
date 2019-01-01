package com.biz;
import com.po.*;
import java.util.*;
public interface IEmpBiz {
	public boolean save(Emp emp);
	public boolean update(Emp emp);
	public boolean delById(Integer eid);
	public Emp findById(Integer eid);
	/**
	 * 分页查询
	 * @param page 表示当前页数，界面传递
	 * @param rows 表示每页记录数,界面传递
	 * */
	public List<Emp> findPageAll(int page,int rows);
	
	/**
	 * 获取总页数
	 * 根据每页记录数，计算总页数
	 * */
	public int findMaxPage(int rows);	
}
