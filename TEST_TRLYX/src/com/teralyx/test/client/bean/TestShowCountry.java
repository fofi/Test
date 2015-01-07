package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestShowCountry implements IsSerializable {

	private int countryId = 0;

    private String description = "Todas las regiones";

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

	
}
