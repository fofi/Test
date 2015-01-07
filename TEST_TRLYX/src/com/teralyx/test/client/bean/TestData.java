package com.teralyx.test.client.bean;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestData implements IsSerializable, Comparable<TestData> {

    private Date dateTime;
    
    private String value;
    
    private int parameterId;
    
    private int reliability;

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

    /**
     * @return Returns the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Returns the parameterId.
     */
    public int getParameterId() {
        return parameterId;
    }

    /**
     * @param parameterId The parameterId to set.
     */
    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    /**
     * @return Returns the reliability.
     */
    public int getReliability() {
        return reliability;
    }

    /**
     * @param reliability The reliability to set.
     */
    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public int compareTo(TestData otherData) {
        if (Float.parseFloat(otherData.getValue()) > Float.parseFloat(getValue())){
            return 1;
        }else {
            return -1;
        }
    }
}
