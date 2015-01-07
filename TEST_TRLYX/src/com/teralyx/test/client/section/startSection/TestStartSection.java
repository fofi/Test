package com.teralyx.test.client.section.startSection;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionIF;
import com.teralyx.test.client.section.startSection.widgets.panels.TestStartLeftPanel;
import com.teralyx.test.client.section.startSection.widgets.panels.TestStartRigthPanel;

public class TestStartSection extends Composite implements TestSectionIF {

	private HorizontalPanel startSectionPanel;

    private TestSectionController sectionController;
    
    private TestStartLeftPanel panelIzquierdo;

    private TestStartRigthPanel mapPanel;

    public TestStartSection(TestSectionController sectionController) {
        this.sectionController = sectionController;

        initialize();
    }

    public void initialize() {

        startSectionPanel = new HorizontalPanel();

        initWidget(startSectionPanel);

        startSectionPanel.setSize("100%", "610");

        AbsolutePanel leftMargin = new AbsolutePanel();
        leftMargin.setWidth("6");
        leftMargin.setHeight("100%");
        leftMargin.addStyleName("backgroundPanel");

        startSectionPanel.add(leftMargin);
        panelIzquierdo = new TestStartLeftPanel(getSectionController());
        startSectionPanel.add(panelIzquierdo);
        startSectionPanel.setCellVerticalAlignment(panelIzquierdo, HasVerticalAlignment.ALIGN_MIDDLE);
        startSectionPanel.setCellHorizontalAlignment(panelIzquierdo, HasHorizontalAlignment.ALIGN_LEFT);

        AbsolutePanel centerMargin = new AbsolutePanel();
        centerMargin.setWidth("3");
        centerMargin.setHeight("100%");
        centerMargin.addStyleName("backgroundPanel");

        startSectionPanel.add(centerMargin);

        mapPanel = new TestStartRigthPanel(getSectionController());
        
        startSectionPanel.add(mapPanel);
        startSectionPanel.setCellVerticalAlignment(mapPanel, HasVerticalAlignment.ALIGN_MIDDLE);
        startSectionPanel.setCellHorizontalAlignment(mapPanel, HasHorizontalAlignment.ALIGN_LEFT);

        AbsolutePanel rigthMargin = new AbsolutePanel();
        rigthMargin.setWidth("6");
        rigthMargin.setHeight("100%");
        rigthMargin.addStyleName("backgroundPanel");
        startSectionPanel.add(rigthMargin);

        startSectionPanel.setCellWidth(leftMargin, "6");
        startSectionPanel.setCellWidth(panelIzquierdo, "280");
        startSectionPanel.setCellWidth(centerMargin, "3");
        startSectionPanel.setCellWidth(mapPanel, "100%");
        startSectionPanel.setCellWidth(rigthMargin, "6");
        
        
        
        
    }

    public TestStartLeftPanel getLeftPanel() {
        return panelIzquierdo;
    }

    public void setPanelIzquierdo(TestStartLeftPanel panelIzquierdo) {
        this.panelIzquierdo = panelIzquierdo;
    }

    public TestStartRigthPanel getMapPanel() {
        return mapPanel;
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    public void onChangeIn() {
        getMapPanel().showMapWidget();
    }

    public void onChangeOut() {
        getMapPanel().viewHidden();
    }

    public void onLogoutApp() {
        getMapPanel().viewHidden();
//        getLeftPanel().getStateBarPanel().removeViewFromModel(); 
    }
	
}
