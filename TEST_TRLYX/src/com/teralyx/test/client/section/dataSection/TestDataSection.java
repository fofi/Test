package com.teralyx.test.client.section.dataSection;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionIF;
import com.teralyx.test.client.section.dataSection.widgets.panels.TestDataLeftPanel;
import com.teralyx.test.client.section.dataSection.widgets.panels.TestDataRigthPanel;

public class TestDataSection extends Composite implements TestSectionIF {

    private HorizontalPanel dataSectionPanel;

    private TestDataLeftPanel panelIzquierdo;

    private TestDataRigthPanel chart;

    public TestDataSection(TestSectionController sectionController) {

        initialize(sectionController);
    }

    public void initialize(TestSectionController sectionController) {

    	dataSectionPanel = new HorizontalPanel();

        initWidget(dataSectionPanel);

        dataSectionPanel.setSize("100%", "610");

        AbsolutePanel leftMargin = new AbsolutePanel();
        leftMargin.setWidth("6");
        leftMargin.setHeight("100%");
        leftMargin.addStyleName("backgroundPanel");

        dataSectionPanel.add(leftMargin);
        panelIzquierdo = new TestDataLeftPanel(sectionController);
        dataSectionPanel.add(panelIzquierdo);

        dataSectionPanel.setCellVerticalAlignment(panelIzquierdo, HasVerticalAlignment.ALIGN_MIDDLE);
        dataSectionPanel.setCellHorizontalAlignment(panelIzquierdo, HasHorizontalAlignment.ALIGN_LEFT);

        AbsolutePanel centerMargin = new AbsolutePanel();
        centerMargin.setWidth("3");
        centerMargin.setHeight("100%");
        centerMargin.addStyleName("backgroundPanel");

        dataSectionPanel.add(centerMargin);

        chart = new TestDataRigthPanel(sectionController);
        dataSectionPanel.add(chart);

        dataSectionPanel.setCellVerticalAlignment(getChart(), HasVerticalAlignment.ALIGN_MIDDLE);
        dataSectionPanel.setCellHorizontalAlignment(getChart(), HasHorizontalAlignment.ALIGN_LEFT);

        AbsolutePanel rigthMargin = new AbsolutePanel();
        rigthMargin.setWidth("6");
        rigthMargin.setHeight("100%");
        rigthMargin.addStyleName("backgroundPanel");
        dataSectionPanel.add(rigthMargin);

        dataSectionPanel.setCellWidth(leftMargin, "6");
        dataSectionPanel.setCellWidth(panelIzquierdo, "280");
        dataSectionPanel.setCellWidth(centerMargin, "3");
        dataSectionPanel.setCellWidth(chart, "100%");
        dataSectionPanel.setCellWidth(rigthMargin, "6");

    }

    public TestDataRigthPanel getChart() {
        return chart;
    }

    public TestDataLeftPanel getLeftPanel() {
        return panelIzquierdo;
    }

    public void onChangeIn() {
        // TODO Auto-generated method stub
        
    }

    public void onChangeOut() {
        // TODO Auto-generated method stub
        
    }

    public void onLogoutApp() {
        
    }

}
