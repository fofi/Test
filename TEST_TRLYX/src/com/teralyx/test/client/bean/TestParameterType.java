package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestParameterType implements IsSerializable {

    private int parameterTypeId;
    
    private String parameterTypeName;
    
    private String technicDescription;
    
    private TestUnit unit;
    
    private float minimumDetectableValue;

    private float maximumDetectableValue;

    /**
     * @return Returns the parameterTypeId.
     */
    public int getParameterTypeId() {
        return parameterTypeId;
    }

    /**
     * @param parameterTypeId The parameterTypeId to set.
     */
    public void setParameterTypeId(int parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    /**
     * @return Returns the parameterTypeName.
     */
    public String getParameterTypeName() {
        return parameterTypeName;
    }

    /**
     * @param parameterTypeName The parameterTypeName to set.
     */
    public void setParameterTypeName(String parameterTypeName) {
        this.parameterTypeName = parameterTypeName;
    }

    /**
     * @return Returns the technicDescription.
     */
    public String getTechnicDescription() {
        return technicDescription;
    }

    /**
     * @param technicDescription The technicDescription to set.
     */
    public void setTechnicDescription(String technicDescription) {
        this.technicDescription = technicDescription;
    }

    /**
     * @return Returns the unit.
     */
    public TestUnit getUnit() {
        return unit;
    }

    /**
     * @param unit The unit to set.
     */
    public void setUnit(TestUnit unit) {
        this.unit = unit;
    }

    /**
     * @return Returns the minimumDetectableValue.
     */
    public float getMinimumDetectableValue() {
        return minimumDetectableValue;
    }

    /**
     * @param minimumDetectableValue The minimumDetectableValue to set.
     */
    public void setMinimumDetectableValue(float minimumDetectableValue) {
        this.minimumDetectableValue = minimumDetectableValue;
    }

    /**
     * @return Returns the maximumDetectableValue.
     */
    public float getMaximumDetectableValue() {
        return maximumDetectableValue;
    }

    /**
     * @param maximumDetectableValue The maximumDetectableValue to set.
     */
    public void setMaximumDetectableValue(float maximumDetectableValue) {
        this.maximumDetectableValue = maximumDetectableValue;
    }
    
}
