package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestUserType implements IsSerializable {

	
	private int userTypeId;

    private String userTypeDescription;

    /**
     * @return Returns the userTypeId.
     */
    public int getUserTypeId() {
        return userTypeId;
    }

    /**
     * @param userTypeId The userTypeId to set.
     */
    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    /**
     * @return Returns the userTypeDescription.
     */
    public String getUserTypeDescription() {
        return userTypeDescription;
    }

    /**
     * @param userTypeDesciption The userTypeDesciption to set.
     */
    public void setUserTypeDescription(String userTypeDescription) {
        this.userTypeDescription = userTypeDescription;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userTypeDescription == null) ? 0 : userTypeDescription.hashCode());
        result = prime * result + userTypeId;
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
        TestUserType other = (TestUserType) obj;
        if (userTypeDescription == null) {
            if (other.userTypeDescription != null)
                return false;
        } else if (!userTypeDescription.equals(other.userTypeDescription))
            return false;
        if (userTypeId != other.userTypeId)
            return false;
        return true;
    }
    
    
}
