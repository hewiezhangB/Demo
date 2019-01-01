package com.biz;
import com.po.*;
import java.util.*;
public interface IEmpBiz {
	public boolean save(Emp emp);
	public boolean update(Emp emp);
	public boolean delById(Integer eid);
	public Emp findById(Integer eid);
	/**
	 * ��ҳ��ѯ
	 * @param page ��ʾ��ǰҳ�������洫��
	 * @param rows ��ʾÿҳ��¼��,���洫��
	 * */
	public List<Emp> findPageAll(int page,int rows);
	
	/**
	 * ��ȡ��ҳ��
	 * ����ÿҳ��¼����������ҳ��
	 * */
	public int findMaxPage(int rows);	
}
