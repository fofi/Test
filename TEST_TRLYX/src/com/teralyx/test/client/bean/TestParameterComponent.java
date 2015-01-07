package com.teralyx.test.client.bean;


public class TestParameterComponent extends TestComponent {

    private String descriptionName;
    
    private boolean addValue;
    
    private TestParameterType parameterType;

    /**
     * @return Returns the descriptionName.
     */
    public String getDescriptionName() {
        return descriptionName;
    }

    /**
     * @param descriptionName The descriptionName to set.
     */
    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    /**
     * @return Returns the addValue.
     */
    public boolean isAddValue() {
        return addValue;
    }

    /**
     * @param addValue The addValue to set.
     */
    public void setAddValue(boolean addValue) {
        this.addValue = addValue;
    }

    /**
     * @return Returns the parameterType.
     */
    public TestParameterType getParameterType() {
        return parameterType;
    }

    /**
     * @param parameterType The parameterType to set.
     */
    public void setParameterType(TestParameterType parameterType) {
        this.parameterType = parameterType;
    }
	
}
