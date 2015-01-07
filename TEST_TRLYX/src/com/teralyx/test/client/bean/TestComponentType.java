package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestComponentType implements IsSerializable {

    private int componentTypeId;
    
    private String componentTypeDescription;

    /**
     * @return Returns the componentTypeId.
     */
    public int getComponentTypeId() {
        return componentTypeId;
    }

    /**
     * @param componentTypeId The componentTypeId to set.
     */
    public void setComponentTypeId(int componentTypeId) {
        this.componentTypeId = componentTypeId;
    }

    /**
     * @return Returns the componentTypeDescription.
     */
    public String getComponentTypeDescription() {
        return componentTypeDescription;
    }

    /**
     * @param componentTypeDescription The componentTypeDescription to set.
     */
    public void setComponentTypeDescription(String componentTypeDescription) {
        this.componentTypeDescription = componentTypeDescription;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((componentTypeDescription == null) ? 0 : componentTypeDescription.hashCode());
        result = prime * result + componentTypeId;
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
        TestComponentType other = (TestComponentType) obj;
        if (componentTypeDescription == null) {
            if (other.componentTypeDescription != null)
                return false;
        } else if (!componentTypeDescription.equals(other.componentTypeDescription))
            return false;
        if (componentTypeId != other.componentTypeId)
            return false;
        return true;
    }
    
}
