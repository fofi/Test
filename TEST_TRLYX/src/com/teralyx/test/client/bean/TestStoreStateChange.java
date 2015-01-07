package com.teralyx.test.client.bean;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestStoreStateChange implements IsSerializable {

private int storeId;
    
    private int storeState;
    
    private Date dateTime;

    /**
     * @return Returns the stationId.
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * @param stationId The stationId to set.
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * @return Returns the stationState.
     */
    public int getStoreState() {
        return storeState;
    }

    /**
     * @param stationState The stationState to set.
     */
    public void setStoreState(int storeState) {
        this.storeState = storeState;
    }

    /**
     * @return Returns the dateTime.
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime The dateTime to set.
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
	
}
