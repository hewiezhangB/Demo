package com.biz;
import com.po.*;
import java.util.*;
public interface IUsersBiz {
	public boolean save(Users us);
	public boolean update(Users us);
	public Users findById(Integer uid);
	public List<Users> findAll();
	public boolean delById(Integer uid);
	public Users check(Users us);
}
