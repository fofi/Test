package com.teralyx.test.client.bean;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestStoreInfo implements IsSerializable {

	private int storeId;

    public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Date getInstalationDate() {
		return instalationDate;
	}

	public void setInstalationDate(Date instalationDate) {
		this.instalationDate = instalationDate;
	}

	public Date getEliminationDate() {
		return eliminationDate;
	}

	public void setEliminationDate(Date eliminationDate) {
		this.eliminationDate = eliminationDate;
	}

	public String getTownCouncil() {
		return townCouncil;
	}

	public void setTownCouncil(String townCouncil) {
		this.townCouncil = townCouncil;
	}

	public String getNearVillage() {
		return nearVillage;
	}

	public void setNearVillage(String nearVillage) {
		this.nearVillage = nearVillage;
	}

	public boolean isGpsUsedToLocate() {
		return gpsUsedToLocate;
	}

	public void setGpsUsedToLocate(boolean gpsUsedToLocate) {
		this.gpsUsedToLocate = gpsUsedToLocate;
	}

	public int getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}

	private Date instalationDate;

    private Date eliminationDate;
    
    private String townCouncil;

    private String nearVillage;

    private boolean gpsUsedToLocate;

    private int totalArea;


	
	
}
