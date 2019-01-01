package com.action;

import com.po.*;
import com.service.BIzService;
import com.bean.*;
import com.biz.*;
import com.biz.imp.*;
import java.util.*;
import java.io.*;

import javax.servlet.http.HttpSession;

import ognl.Ognl;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class EmpAction implements IAction {
	private Emp emp;
	private int eid;

	private String path;

	private int page;// ��ǰҳ��
	private int rows;// ÿҳ��¼��

	private BIzService bIzService;
	
	
	public BIzService getbIzService() {
		return bIzService;
	}

	public void setbIzService(BIzService bIzService) {
		this.bIzService = bIzService;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String save() {
		// ��ȡ����������·��
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/");
		// �ж��Ƿ�����ϴ����ļ�
		if (emp.getPic() != null && emp.getPic().length() > 0) {
			// ��ȡ�ϴ��ļ�������
			String fname = emp.getPicFileName();

			// ��ȡ�ϴ��ļ��ĺ�׺
			if (fname.lastIndexOf(".") != -1) {
				String ext = fname.substring(fname.lastIndexOf("."));

				// �ж��ϴ��ļ��ĺ�׺�ǲ���jpg����png
				if (ext.equalsIgnoreCase(".jpg")
						|| ext.equalsIgnoreCase(".png")) {
					// ���ϴ��ļ�����
					String newfname = new Date().getTime() + ext;

					// �����ļ�����,ָ���ϴ��ļ��Ĵ��λ��
					File destFile = new File(realpath + "/uppic/" + newfname);

					// ��ʼ�ϴ�
					try {
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(newfname);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}

		boolean flag = bIzService.getEmpBiz().save(emp);
		if (flag) {
			path = "findPageAll_Emp";
			return "ok";
		}
		path = "fail.jsp";
		return "fail";
	}

	public String update() {
		// ��ȡ����������·��
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/");

		// ��ȡԭ��Ա���ľ���Ƭ
		String oldphoto = bIzService.getEmpBiz().findById(emp.getEid()).getPhoto();

		// �ж��Ƿ�����ϴ����ļ�
		if (emp.getPic() != null && emp.getPic().length() > 0) {
			// ��ȡ�ϴ��ļ�������
			String fname = emp.getPicFileName();

			// ��ȡ�ϴ��ļ��ĺ�׺
			if (fname.lastIndexOf(".") != -1) {
				String ext = fname.substring(fname.lastIndexOf("."));

				// �ж��ϴ��ļ��ĺ�׺�ǲ���jpg����png
				if (ext.equalsIgnoreCase(".jpg")
						|| ext.equalsIgnoreCase(".png")) {
					// ���ϴ��ļ�����
					String newfname = new Date().getTime() + ext;

					// �����ļ�����,ָ���ϴ��ļ��Ĵ��λ��
					File destFile = new File(realpath + "/uppic/" + newfname);

					// ��ʼ�ϴ�
					try {
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(newfname);

						// ɾ��ԭ����Ա����Ƭ
						File oldfile = new File(realpath + "/uppic/" + oldphoto);
						if (oldfile.exists() && !oldphoto.equals("default.jpg")) {
							oldfile.delete();// ɾ������Ƭ
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		} else {
			emp.setPhoto(oldphoto);// ����Ƭ���£������þ���Ƭ����Ա������
		}

		boolean flag = bIzService.getEmpBiz().update(emp);
		if (flag) {
			path = "findPageAll_Emp";
			return "ok";
		}
		path = "fail.jsp";
		return "fail";
	}

	public String delById() {
		// ��ȡ����������·��
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/");

		// ��ȡԭ��Ա���ľ���Ƭ
		String oldphoto = bIzService.getEmpBiz().findById(eid).getPhoto();

		boolean flag = bIzService.getEmpBiz().delById(eid);
		if (flag) {
			// ɾ��Ա����Ƭ
			File oldfile = new File(realpath + "/uppic/" + oldphoto);
			if (oldfile.exists() && !oldphoto.equals("default.jpg")) {
				oldfile.delete();// ɾ������Ƭ
			}
			path = "findPageAll_Emp";
			return "ok";
		}
		path = "fail.jsp";
		return "fail";
	}

	public String findById() {
		Emp oldemp = bIzService.getEmpBiz().findById(eid);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("oldemp", oldemp);
		path = "empupdate.jsp";
		return "ok";
	}

	public String findDetailById() {
		Emp demp = bIzService.getEmpBiz().findById(eid);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("demp", demp);
		path = "empdetail.jsp";
		return "ok";
	}

	public String findAll() {
		
		
		return null;
	}

	public String findPageAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		//��ʼ��==================================
		List<Dep> lsdep=bIzService.getDepBiz().findAll();//�����б����ݼ���
		List<Welfare> lswf=bIzService.getWelfareBiz().findAll();//��ѡ�����ݼ���
		session.setAttribute("lsdep", lsdep);
		session.setAttribute("lswf", lswf);
		//==============================================
		
		//��session�л�ȡ��ҳ��ʵ�����
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		page=page<1?pb.getPage():page;
		rows=rows<1?pb.getRows():rows;
		
		//��ȡ��ҳ��
		int maxpage=bIzService.getEmpBiz().findMaxPage(rows);
		if(page>maxpage)page=maxpage;//���Ƶ�ǰҳ����ֵ������ҳ����ֵ
		
		//��ȡ��ǰҳ��¼����
		List<Emp> lsemp=bIzService.getEmpBiz().findPageAll(page, rows);
		
		//����ҳ�����ݷ�װ����ҳ��ʵ�������
		pb.setPage(page);
		pb.setRows(rows);
		pb.setMaxpage(maxpage);
		pb.setPagelist(lsemp);		
		session.setAttribute("pb", pb);
		
		path="emplist.jsp";
		return "ok";
	}

	/**
	 * ��ʼ������ȡ���ŵ������б�͸����ĸ�ѡ������
	 * */
	public String doinit() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		List<Dep> lsdep=bIzService.getDepBiz().findAll();//�����б����ݼ���
		List<Welfare> lswf=bIzService.getWelfareBiz().findAll();//��ѡ�����ݼ���
		session.setAttribute("lsdep", lsdep);
		session.setAttribute("lswf", lswf);
		path="empadd.jsp";
		return "ok";
	}

}
