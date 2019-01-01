package com.biz;
import com.po.*;

import java.util.*;
public interface IWelfareBiz {
	public List<Welfare> findAll();	
	public boolean save(Welfare welfare);
	public boolean update(Welfare welfare);
	public Welfare findById(Integer wid);
}
