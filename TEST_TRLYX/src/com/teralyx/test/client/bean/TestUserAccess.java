package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestUserAccess implements IsSerializable {

    private String login;

    private String password;

    /**
     * @return Returns the login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login The login to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
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
        TestUserAccess other = (TestUserAccess) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

	
}
