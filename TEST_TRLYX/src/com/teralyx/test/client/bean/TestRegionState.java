package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestRegionState implements IsSerializable{

	private int regionStateId;

    private String regionStateName;
    
    private TestRegion region;
    
    private TestLocalization localization;
    
    /**
     * @return Returns the regionStateId.
     */
    public int getRegionStateId() {
        return regionStateId;
    }

    /**
     * @param regionStateId The regionStateId to set.
     */
    public void setRegionStateId(int regionStateId) {
        this.regionStateId = regionStateId;
    }

    /**
     * @return Returns the regionStateName.
     */
    public String getRegionStateName() {
        return regionStateName;
    }

    /**
     * @param regionStateName The regionStateName to set.
     */
    public void setRegionStateName(String regionStateName) {
        this.regionStateName = regionStateName;
    }

    /**
     * @return Returns the region.
     */
    public TestRegion getRegion() {
        return region;
    }

    /**
     * @param region The region to set.
     */
    public void setRegion(TestRegion region) {
        this.region = region;
    }

    /**
     * @return Returns the localization.
     */
    public TestLocalization getLocalization() {
        return localization;
    }

    /**
     * @param localization The localization to set.
     */
    public void setLocalization(TestLocalization localization) {
        this.localization = localization;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((localization == null) ? 0 : localization.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + regionStateId;
        result = prime * result + ((regionStateName == null) ? 0 : regionStateName.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TestRegionState other = (TestRegionState) obj;
        if (localization == null) {
            if (other.localization != null)
                return false;
        } else if (!localization.equals(other.localization))
            return false;
        if (region == null) {
            if (other.region != null)
                return false;
        } else if (!region.equals(other.region))
            return false;
        if (regionStateId != other.regionStateId)
            return false;
        if (regionStateName == null) {
            if (other.regionStateName != null)
                return false;
        } else if (!regionStateName.equals(other.regionStateName))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TestRegionState [regionStateId=" + regionStateId + ", regionStateName=" + regionStateName + "]";
    } 

	
	
}
