package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestComponent implements IsSerializable {

    private int componentId;
    
    private String componentName;
    
    private String componentShortName;
    
    private int storeId;
    
    private TestComponentType componentType;

    /**
     * @return Returns the componentId.
     */
    public int getComponentId() {
        return componentId;
    }

    /**
     * @param componentId The componentId to set.
     */
    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    /**
     * @return Returns the componentName.
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * @param componentName The componentName to set.
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * @return Returns the storeId.
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * @param storeId The storeId to set.
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * @return Returns the componentType.
     */
    public TestComponentType getComponentType() {
        return componentType;
    }

    /**
     * @param componentType The componentType to set.
     */
    public void setComponentType(TestComponentType componentType) {
        this.componentType = componentType;
    }

    public void setComponentShortName(String componentShortName) {
        this.componentShortName = componentShortName;
    }

    public String getComponentShortName() {
        return componentShortName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + componentId;
        result = prime * result + ((componentName == null) ? 0 : componentName.hashCode());
        result = prime * result + ((componentShortName == null) ? 0 : componentShortName.hashCode());
        result = prime * result + ((componentType == null) ? 0 : componentType.hashCode());
        result = prime * result + storeId;
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
        TestComponent other = (TestComponent) obj;
        if (componentId != other.componentId)
            return false;
        if (componentName == null) {
            if (other.componentName != null)
                return false;
        } else if (!componentName.equals(other.componentName))
            return false;
        if (componentShortName == null) {
            if (other.componentShortName != null)
                return false;
        } else if (!componentShortName.equals(other.componentShortName))
            return false;
        if (componentType == null) {
            if (other.componentType != null)
                return false;
        } else if (!componentType.equals(other.componentType))
            return false;
        if (storeId != other.storeId)
            return false;
        return true;
    }
    
}
