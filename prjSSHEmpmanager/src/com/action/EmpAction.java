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

	private int page;// 当前页数
	private int rows;// 每页记录数

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
		// 获取服务器物理路径
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/");
		// 判断是否存在上传的文件
		if (emp.getPic() != null && emp.getPic().length() > 0) {
			// 获取上传文件的名称
			String fname = emp.getPicFileName();

			// 获取上传文件的后缀
			if (fname.lastIndexOf(".") != -1) {
				String ext = fname.substring(fname.lastIndexOf("."));

				// 判断上传文件的后缀是不是jpg或者png
				if (ext.equalsIgnoreCase(".jpg")
						|| ext.equalsIgnoreCase(".png")) {
					// 对上传文件更名
					String newfname = new Date().getTime() + ext;

					// 创建文件对象,指定上传文件的存放位置
					File destFile = new File(realpath + "/uppic/" + newfname);

					// 开始上传
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
		// 获取服务器物理路径
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/");

		// 获取原来员工的旧照片
		String oldphoto = bIzService.getEmpBiz().findById(emp.getEid()).getPhoto();

		// 判断是否存在上传的文件
		if (emp.getPic() != null && emp.getPic().length() > 0) {
			// 获取上传文件的名称
			String fname = emp.getPicFileName();

			// 获取上传文件的后缀
			if (fname.lastIndexOf(".") != -1) {
				String ext = fname.substring(fname.lastIndexOf("."));

				// 判断上传文件的后缀是不是jpg或者png
				if (ext.equalsIgnoreCase(".jpg")
						|| ext.equalsIgnoreCase(".png")) {
					// 对上传文件更名
					String newfname = new Date().getTime() + ext;

					// 创建文件对象,指定上传文件的存放位置
					File destFile = new File(realpath + "/uppic/" + newfname);

					// 开始上传
					try {
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(newfname);

						// 删除原来的员工照片
						File oldfile = new File(realpath + "/uppic/" + oldphoto);
						if (oldfile.exists() && !oldphoto.equals("default.jpg")) {
							oldfile.delete();// 删除旧照片
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		} else {
			emp.setPhoto(oldphoto);// 无照片更新，则设置旧照片到新员工对象
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
		// 获取服务器物理路径
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/");

		// 获取原来员工的旧照片
		String oldphoto = bIzService.getEmpBiz().findById(eid).getPhoto();

		boolean flag = bIzService.getEmpBiz().delById(eid);
		if (flag) {
			// 删除员工照片
			File oldfile = new File(realpath + "/uppic/" + oldphoto);
			if (oldfile.exists() && !oldphoto.equals("default.jpg")) {
				oldfile.delete();// 删除旧照片
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
		//初始化==================================
		List<Dep> lsdep=bIzService.getDepBiz().findAll();//下拉列表数据集合
		List<Welfare> lswf=bIzService.getWelfareBiz().findAll();//复选框数据集合
		session.setAttribute("lsdep", lsdep);
		session.setAttribute("lswf", lswf);
		//==============================================
		
		//从session中获取分页的实体对象
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		page=page<1?pb.getPage():page;
		rows=rows<1?pb.getRows():rows;
		
		//获取总页数
		int maxpage=bIzService.getEmpBiz().findMaxPage(rows);
		if(page>maxpage)page=maxpage;//限制当前页数的值大于总页数的值
		
		//获取当前页记录集合
		List<Emp> lsemp=bIzService.getEmpBiz().findPageAll(page, rows);
		
		//将分页的数据封装到分页的实体对象中
		pb.setPage(page);
		pb.setRows(rows);
		pb.setMaxpage(maxpage);
		pb.setPagelist(lsemp);		
		session.setAttribute("pb", pb);
		
		path="emplist.jsp";
		return "ok";
	}

	/**
	 * 初始化，获取部门的下拉列表和福利的复选框数据
	 * */
	public String doinit() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		List<Dep> lsdep=bIzService.getDepBiz().findAll();//下拉列表数据集合
		List<Welfare> lswf=bIzService.getWelfareBiz().findAll();//复选框数据集合
		session.setAttribute("lsdep", lsdep);
		session.setAttribute("lswf", lswf);
		path="empadd.jsp";
		return "ok";
	}

}
