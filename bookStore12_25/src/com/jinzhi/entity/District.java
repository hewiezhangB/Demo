package com.jinzhi.entity;

import java.util.Date;

public class District {
	private int districtID;
	private String districtName;
	private int cityID;
	private Date dateCreated;
	private Date dateUpdate;

	public District() {
		super();
	}

	public District(int districtID, String districtName) {
		super();
		this.districtID = districtID;
		this.districtName = districtName;
	}

	public District(int districtID, String districtName, int cityID) {
		super();
		this.districtID = districtID;
		this.districtName = districtName;
		this.cityID = cityID;
	}

	public int getDistrictID() {
		return districtID;
	}

	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

}
