package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestUser implements IsSerializable {

    private int userId;

    private String userName;

    private String userLastName;

    private String email;

    private String phoneNumber;

    private TestUserType userType;

    private TestUserAccess userAccess;

    private TestPermission permission;

    private String imageUrl;

    /**
     * @return Returns the userId.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId The userId to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return Returns the userLastName.
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * @param userLastName The userLastName to set.
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Returns the phoneNumber.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber The phoneNumber to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return Returns the userType.
     */
    public TestUserType getUserType() {
        return userType;
    }

    /**
     * @param userType The userType to set.
     */
    public void setUserType(TestUserType userType) {
        this.userType = userType;
    }

    /**
     * @return Returns the userAccess.
     */
    public TestUserAccess getUserAccess() {
        return userAccess;
    }

    /**
     * @param userAccess The userAccess to set.
     */
    public void setUserAccess(TestUserAccess userAccess) {
        this.userAccess = userAccess;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((userAccess == null) ? 0 : userAccess.hashCode());
        result = prime * result + userId;
        result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((userType == null) ? 0 : userType.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
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
        TestUser other = (TestUser) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (userAccess == null) {
            if (other.userAccess != null)
                return false;
        } else if (!userAccess.equals(other.userAccess))
            return false;
        if (userId != other.userId)
            return false;
        if (userLastName == null) {
            if (other.userLastName != null)
                return false;
        } else if (!userLastName.equals(other.userLastName))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        if (userType == null) {
            if (other.userType != null)
                return false;
        } else if (!userType.equals(other.userType))
            return false;
        return true;
    }

    /**
     * @return Returns the permission.
     */
    public TestPermission getPermission() {
        return permission;
    }

    /**
     * @param permission The permission to set.
     */
    public void setPermission(TestPermission permission) {
        this.permission = permission;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
	
}
