package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.teralyx.test.client.section.TestSectionConstantsIF;

public class TestSession implements IsSerializable {
    
    private TestUser user;
    
    private String sectionMenu = TestSectionConstantsIF.SECTION_START;

    /**
     * @return Returns the user.
     */
    public TestUser getUser() {
        return user;
    }

    /**
     * @param user The user to set.
     */
    public void setUser(TestUser user) {
        this.user = user;
    }

    /**
     * @return Returns the sectionMenu.
     */
    public String getSectionMenu() {
        return sectionMenu;
    }

    /**
     * @param sectionMenu The sectionMenu to set.
     */
    public void setSectionMenu(String sectionMenu) {
        this.sectionMenu = sectionMenu;
    }

}
