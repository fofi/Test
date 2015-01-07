package com.teralyx.test.client.bean;

import java.io.Serializable;

public class TestStoreType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int storeTypeId;
    
    private String storeTypeDescription;
    
    

    public int getStoreTypeId() {
		return storeTypeId;
	}

	public void setStoreTypeId(int storeTypeId) {
		this.storeTypeId = storeTypeId;
	}

	public String getStoreTypeDescription() {
		return storeTypeDescription;
	}

	public void setStoreTypeDescription(String storeTypeDescription) {
		this.storeTypeDescription = storeTypeDescription;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((storeTypeDescription == null) ? 0 : storeTypeDescription.hashCode());
        result = prime * result + storeTypeId;
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
        TestStoreType other = (TestStoreType) obj;
        if (storeTypeDescription == null) {
            if (other.storeTypeDescription != null)
                return false;
        } else if (!storeTypeDescription.equals(other.storeTypeDescription))
            return false;
        if (storeTypeId != other.storeTypeId)
            return false;
        return true;
    }
	
	
}
