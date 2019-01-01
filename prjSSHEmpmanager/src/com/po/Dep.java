package com.po;

import java.util.HashSet;
import java.util.Set;
import java.io.*;

/**
 * Dep entity. @author MyEclipse Persistence Tools
 */

public class Dep implements java.io.Serializable {

	// Fields

	private Integer depid;
	private String depname;
	private Set emps = new HashSet(0);
	
	/****与界面关联的属性**************/
	//与薪资关联的属性，用于界面
	private float emoney;
	
	//与福利关联的属性
	private Integer[] wids;
	//与照片上传关联的属性
	private File pic;
	private String picContentType;
	private String picFileName;
	// Constructors

	/** default constructor */
	public Dep() {
	}

	/** minimal constructor */
	public Dep(String depname) {
		this.depname = depname;
	}

	/** full constructor */
	public Dep(String depname, Set emps) {
		this.depname = depname;
		this.emps = emps;
	}

	// Property accessors

	public Integer getDepid() {
		return this.depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

	public String getDepname() {
		return this.depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public Set getEmps() {
		return this.emps;
	}

	public void setEmps(Set emps) {
		this.emps = emps;
	}

	public float getEmoney() {
		return emoney;
	}

	public void setEmoney(float emoney) {
		this.emoney = emoney;
	}

	public Integer[] getWids() {
		return wids;
	}

	public void setWids(Integer[] wids) {
		this.wids = wids;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

}