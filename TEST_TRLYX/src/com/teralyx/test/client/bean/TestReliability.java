package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestReliability implements IsSerializable {



    private int reliabilityId;

    private int reliabilityValue;

    private String reliabilityRankDescription;

    /**
     * @return Returns the reliabilityId.
     */
    public int getReliabilityId() {
        return reliabilityId;
    }

    /**
     * @param reliabilityId The reliabilityId to set.
     */
    public void setReliabilityId(int reliabilityId) {
        this.reliabilityId = reliabilityId;
    }

    /**
     * @return Returns the reliabilityValue.
     */
    public int getReliabilityValue() {
        return reliabilityValue;
    }

    /**
     * @param reliabilityValue The reliabilityValue to set.
     */
    public void setReliabilityValue(int reliabilityValue) {
        this.reliabilityValue = reliabilityValue;
    }

    /**
     * @return Returns the reliabilityRankDescription.
     */
    public String getReliabilityRankDescription() {
        return reliabilityRankDescription;
    }

    /**
     * @param reliabilityRankDescription The reliabilityRankDescription to set.
     */
    public void setReliabilityRankDescription(String reliabilityRankDescription) {
        this.reliabilityRankDescription = reliabilityRankDescription;
    }

}
