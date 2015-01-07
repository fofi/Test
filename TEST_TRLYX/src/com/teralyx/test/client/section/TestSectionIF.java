package com.teralyx.test.client.section;

public interface TestSectionIF {

    /**
     * Executed when user logout
     */
    public void onLogoutApp();
    
    /**
     * Executed when user change to this section
     */
    public void onChangeIn();
    
    /**
     * Executed when user change to other section
     */
    public void onChangeOut();
	
}
