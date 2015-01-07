package com.teralyx.test.client.widgets.split;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.controller.TestSectionController;

public class TestSplitContainer extends Composite {
    
    private TestSectionController sectionController;
    
    private TestSplitMenu splitMenu;
    
    private VerticalPanel backgroundVerticalPanel;
    
    public TestSplitContainer(TestSectionController sectionController){
        this.sectionController = sectionController;
        initialize();
    }

    public void initialize() {
        
      backgroundVerticalPanel = new VerticalPanel();
      initWidget(backgroundVerticalPanel);
      backgroundVerticalPanel.setSize("264", "100%");
      backgroundVerticalPanel.addStyleName("backgroundLeftPanel");
      
      splitMenu = new TestSplitMenu(getSectionController(), null);

      AbsolutePanel topMargin = new AbsolutePanel();
      topMargin.setSize("100%", "7");

      ScrollPanel sp = new ScrollPanel();
      sp.setSize("100%", "393");
      sp.add(splitMenu);
      
      backgroundVerticalPanel.add(topMargin);
      backgroundVerticalPanel.add(sp);

  }

    /**
     * @return Returns the sectionController.
     */
    public TestSectionController getSectionController() {
        return sectionController;
    }

    /**
     * @return Returns the splitMenu.
     */
    public TestSplitMenu getSplitMenu() {
        return splitMenu;
    }
}
