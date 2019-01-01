package com.biz;
import com.po.*;

import java.util.*;

public interface IDepBiz {
	public List<Dep> findAll();	
	public boolean save(Dep dep);
	public boolean update(Dep dep);
	public Dep findById(Integer depid);

}
