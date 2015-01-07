package com.teralyx.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.teralyx.test.client.controller.TestSectionController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class TestIndex implements EntryPoint {

    private TestSectionController sectionController = null;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        sectionController = new TestSectionController(this);
    }

    /**
     * @return Returns the sectionController.
     */
    public TestSectionController getSectionController() {
        return sectionController;
    }
}
