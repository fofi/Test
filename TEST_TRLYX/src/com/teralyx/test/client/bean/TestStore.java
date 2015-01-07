package com.teralyx.test.client.bean;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestStore implements IsSerializable {
    
    private int storeId;
    
    private String storeName;
    
    private String storeDescription;
    
    private TestStoreType storeType;
    
    private String imageUrl;

    private TestLocalization localization;
    
    private TestRegionState regionState;
    
    private TestStoreInfo storeInfo;

    private ArrayList<TestComponent> componentList;
    
    
    
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	public TestStoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(TestStoreType storeType) {
		this.storeType = storeType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public TestLocalization getLocalization() {
		return localization;
	}

	public void setLocalization(TestLocalization localization) {
		this.localization = localization;
	}

	public TestRegionState getRegionState() {
		return regionState;
	}

	public void setRegionState(TestRegionState regionState) {
		this.regionState = regionState;
	}

	public TestStoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(TestStoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	 /**
     * @return Returns the componentList.
     */
    public ArrayList<TestComponent> getComponentList() {
        return componentList;
    }

    /**
     * @param componentList The webComponentList to set.
     */
    public void setComponentList(ArrayList<TestComponent> componentList) {
        this.componentList = componentList;
    }
	
	
}
