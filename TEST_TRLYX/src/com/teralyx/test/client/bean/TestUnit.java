package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestUnit implements IsSerializable {

	private int unitId;
    
    private String unitName;
    
    private String smiUnit;

    /**
     * @return Returns the unitId.
     */
    public int getUnitId() {
        return unitId;
    }

    /**
     * @param unitId The unitId to set.
     */
    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    /**
     * @return Returns the unitName.
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * @param unitName The unitName to set.
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * @return Returns the smiUnit.
     */
    public String getSmiUnit() {
        return smiUnit;
    }

    /**
     * @param smiUnit The smiUnit to set.
     */
    public void setSmiUnit(String smiUnit) {
        this.smiUnit = smiUnit;
    }
    
	
}
