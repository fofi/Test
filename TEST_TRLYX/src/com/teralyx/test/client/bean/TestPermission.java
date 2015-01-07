package com.teralyx.test.client.bean;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestPermission implements IsSerializable {

	private int permissionId;

    private boolean systemConfiguration;

    private boolean dataModification;

    private boolean dataVisulization;

    private boolean reportsGeneration;

    private ArrayList<TestRegion> regionsWithPermissions;
    
    /**
     * @return Returns the permissionId.
     */
    public int getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId The permissionId to set.
     */
    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return Returns the systemConfiguration.
     */
    public boolean isSystemConfiguration() {
        return systemConfiguration;
    }

    /**
     * @param systemConfiguration The systemConfiguration to set.
     */
    public void setSystemConfiguration(boolean systemConfiguration) {
        this.systemConfiguration = systemConfiguration;
    }

    /**
     * @return Returns the dataModification.
     */
    public boolean isDataModification() {
        return dataModification;
    }

    /**
     * @param dataModification The dataModification to set.
     */
    public void setDataModification(boolean dataModification) {
        this.dataModification = dataModification;
    }

    /**
     * @return Returns the dataVisulization.
     */
    public boolean isDataVisulization() {
        return dataVisulization;
    }

    /**
     * @param dataVisulization The dataVisulization to set.
     */
    public void setDataVisulization(boolean dataVisulization) {
        this.dataVisulization = dataVisulization;
    }

    /**
     * @return Returns the reportsGeneration.
     */
    public boolean isReportsGeneration() {
        return reportsGeneration;
    }

    /**
     * @param reportsGeneration The reportsGeneration to set.
     */
    public void setReportsGeneration(boolean reportsGeneration) {
        this.reportsGeneration = reportsGeneration;
    }

    /**
     * @return Returns the regionsWithPermissions.
     */
    public ArrayList<TestRegion> getRegionsWithPermissions() {
        return regionsWithPermissions;
    }

    /**
     * @param regionsWithPermissions The regionsWithPermissions to set.
     */
    public void setRegionsWithPermissions(ArrayList<TestRegion> regionsWithPermissions) {
        this.regionsWithPermissions = regionsWithPermissions;
    }
	
}
