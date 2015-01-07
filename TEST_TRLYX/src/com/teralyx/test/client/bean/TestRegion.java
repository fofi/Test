package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestRegion implements IsSerializable {

	
	private int regionId;
    
    private String regionDescription;
    
    private int countryId;
    
    private String countryName;
    
    private TestLocalization localization;
    
    /**
     * @return Returns the countryId.
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * @param countryId The countryId to set.
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * @return Returns the countryName.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName The countryName to set.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return Returns the regionId.
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * @param regionId The regionId to set.
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * @return Returns the regionDescription.
     */
    public String getRegionDescription() {
        return regionDescription;
    }

    /**
     * @param regionDescription The regionDescription to set.
     */
    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
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
        result = prime * result + countryId;
        result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
        result = prime * result + ((localization == null) ? 0 : localization.hashCode());
        result = prime * result + ((regionDescription == null) ? 0 : regionDescription.hashCode());
        result = prime * result + regionId;
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
        TestRegion other = (TestRegion) obj;
        if (countryId != other.countryId)
            return false;
        if (countryName == null) {
            if (other.countryName != null)
                return false;
        } else if (!countryName.equals(other.countryName))
            return false;
        if (localization == null) {
            if (other.localization != null)
                return false;
        } else if (!localization.equals(other.localization))
            return false;
        if (regionDescription == null) {
            if (other.regionDescription != null)
                return false;
        } else if (!regionDescription.equals(other.regionDescription))
            return false;
        if (regionId != other.regionId)
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TestRegion [regionDescription=" + regionDescription + ", regionId=" + regionId + "]";
    }

	
}
