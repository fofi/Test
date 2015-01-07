package com.teralyx.test.client.section.startSection.widgets.panels;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestStoreType;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionConstantsIF;
import com.teralyx.test.client.widgets.combo.TestCombo;
import com.teralyx.test.client.widgets.split.TestSplitContainer;

public class TestStartLeftPanel extends Composite implements TestSectionConstantsIF{

	private TestSectionController sectionController = null;

    private VerticalPanel startLeftPanel;

    private TestCombo regionsCombo;

    private TestCombo statesCombo;

    private TestCombo storeTypeCombo;

    private TestSplitContainer splitContainer;

//    private TestStateBar stateBarPanel;

    private VerticalPanel startLeftUpPanel;

    private VerticalPanel selectorStationPanel;

    private HorizontalPanel titlePanel;

    public TestStartLeftPanel(TestSectionController sectionController) {
        this.sectionController = sectionController;
        initialize();
    }

    public void initialize() {
        startLeftPanel = new VerticalPanel();
        initWidget(startLeftPanel);
        startLeftPanel.setSize("280", "610");
        startLeftPanel.addStyleName("backgroundChartLeftPanel");
        startLeftUpPanel = new VerticalPanel();
        startLeftUpPanel.addStyleName("backgroundStateBarPanel");

//        stateBarPanel = new TestStateBar(getSectionController());
//        startLeftUpPanel.add(stateBarPanel);
//        startLeftUpPanel.setCellVerticalAlignment(stateBarPanel, HasVerticalAlignment.ALIGN_MIDDLE);
//        startLeftUpPanel.setCellHorizontalAlignment(stateBarPanel, HasHorizontalAlignment.ALIGN_CENTER);

        startLeftPanel.add(startLeftUpPanel);
        startLeftUpPanel.setSize("100%", "72");

        AbsolutePanel rigthMargin = new AbsolutePanel();
        rigthMargin.setWidth("100%");
        rigthMargin.setHeight("3");
        rigthMargin.addStyleName("backgroundPanel");
        startLeftPanel.add(rigthMargin);

        selectorStationPanel = new VerticalPanel();
        selectorStationPanel.setSize("100%", "535");
        selectorStationPanel.addStyleName("backgroundStateBarPanel");

        titlePanel = new HorizontalPanel();
        selectorStationPanel.add(titlePanel);
        titlePanel.setSize("100%", "35");
        titlePanel.setSpacing(4);
        titlePanel.setStyleName("simpleContainerTitle");
        titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        Label opcionsLabel = new Label("Selector Estación Meteorológica");
        titlePanel.add(opcionsLabel);
        opcionsLabel.setWidth("100%");
        titlePanel.setCellWidth(opcionsLabel, "100%");
        opcionsLabel.setStyleName("simpleContainerText");

        Grid stationSelectorGrid = new Grid(2, 1);

        VerticalPanel stationDataPanel = new VerticalPanel();
        stationDataPanel.setSize("100%", "90");

        FlexTable stationDataFlexTable = new FlexTable();
        stationDataFlexTable.setCellSpacing(1);
        stationDataFlexTable.setCellPadding(2);
        
        
        Label stationTypeComboLabel = new Label("Tipo:");
        stationTypeComboLabel.setWidth("47");
        stationTypeComboLabel.addStyleName("formText");
        stationDataFlexTable.setWidget(0, 0, stationTypeComboLabel);
        storeTypeCombo = new TestCombo(getSectionController(), SECTION_START);
        storeTypeCombo.setWidth("213");
        stationDataFlexTable.setWidget(0, 1, storeTypeCombo);
        
        
        Label regionsComboLabel = new Label("Regi�n:");
        regionsComboLabel.setWidth("47");
        regionsComboLabel.addStyleName("formText");
        stationDataFlexTable.setWidget(1, 0, regionsComboLabel);
        regionsCombo = new TestCombo(getSectionController(), SECTION_START);
        regionsCombo.setWidth("213");
        stationDataFlexTable.setWidget(1, 1, regionsCombo);

        Label statesComboLabel = new Label("Estado:");
        statesComboLabel.setWidth("47");
        statesComboLabel.addStyleName("formText");
        stationDataFlexTable.setWidget(2, 0, statesComboLabel);
        statesCombo = new TestCombo(getSectionController(), SECTION_START);
        statesCombo.setWidth("213");
        stationDataFlexTable.setWidget(2, 1, statesCombo);

     

        stationDataPanel.add(stationDataFlexTable);
        stationSelectorGrid.setWidget(0, 0, stationDataPanel);

        VerticalPanel treeStationsPanel = new VerticalPanel();
        treeStationsPanel.setSize("100%", "393");

        //treePanel = new SigreWebTree(getWebSectionController(), SECTION_START);
        //treeStationsPanel.add(treePanel);

//        splitMenu = new SigreWebSplitMenu(getWebSectionController());
//        
//        VerticalPanel backgroundVerticalPanel;
//        backgroundVerticalPanel = new VerticalPanel();
//        backgroundVerticalPanel.setSize("264", "100%");
//        backgroundVerticalPanel.addStyleName("backgroundLeftPanel");
//        
//        ScrollPanel sp = new ScrollPanel();
//        sp.setSize("100%", "393");
//        sp.add(splitMenu);
//        
//        backgroundVerticalPanel.add(sp);
//        treeStationsPanel.add(backgroundVerticalPanel);
//        
//        
//        treeStationsPanel.setCellVerticalAlignment(splitMenu, HasVerticalAlignment.ALIGN_MIDDLE);
//        treeStationsPanel.setCellHorizontalAlignment(splitMenu, HasHorizontalAlignment.ALIGN_CENTER);
        
        splitContainer = new TestSplitContainer(getSectionController());
        treeStationsPanel.add(splitContainer);

        treeStationsPanel.setCellVerticalAlignment(splitContainer, HasVerticalAlignment.ALIGN_MIDDLE);
        treeStationsPanel.setCellHorizontalAlignment(splitContainer, HasHorizontalAlignment.ALIGN_CENTER);
        
        
//        treeStationsPanel.setCellVerticalAlignment(treePanel, HasVerticalAlignment.ALIGN_MIDDLE);
//        treeStationsPanel.setCellHorizontalAlignment(treePanel, HasHorizontalAlignment.ALIGN_CENTER);
        


        
        stationSelectorGrid.setWidget(1, 0, treeStationsPanel);
        selectorStationPanel.add(stationSelectorGrid);

        startLeftPanel.add(selectorStationPanel);

    }

    private TestSectionController getSectionController() {
        return sectionController;
    }

//    public SigreWebTree getTreePanel() {
//        return treePanel;
//    }

    public void fillCombo() {

        if (isComboEmpty()) {
            ArrayList<TestRegion> regionsList = getSectionController().getRegionsList();

            if (regionsList != null) {
                regionsCombo.addItem("Ninguno", new TestRegion());

                for (int i = 0; i < regionsList.size(); i++) {
                    TestRegion region = regionsList.get(i);
                    regionsCombo.addItem(region.getRegionDescription(), region);
                }
            }
            ArrayList<TestRegionState> statesList = getSectionController().getRegionStateList();

            if (statesList != null) {
                statesCombo.addItem("Ninguno", new TestRegionState());

                for (int z = 0; z < statesList.size(); z++) {
                    TestRegionState state = statesList.get(z);
                    statesCombo.addItem(state.getRegionStateName(), state);
                }
            }

            ArrayList<TestStoreType> wStoreTypeList = getSectionController().getStoreTypeList();

            if (wStoreTypeList != null) {
                storeTypeCombo.addItem("Todos", new TestStoreType());

                for (int z = 0; z < wStoreTypeList.size(); z++) {
                	TestStoreType wStationType = wStoreTypeList.get(z);
                    storeTypeCombo.addItem(wStationType.getStoreTypeDescription(), wStationType);
                }
            }

        }
    }

    public boolean isComboEmpty() {
        boolean is = false;

        if (regionsCombo.getPopupPanel().getItemsMap().size() == 0 && statesCombo.getPopupPanel().getItemsMap().size() == 0) {
            is = true;
        }
        return is;
    }

    public TestCombo getRegionsCombo() {
        return regionsCombo;
    }

    public TestCombo getStatesCombo() {
        return statesCombo;
    }

    public TestCombo getStoreTypeCombo() {
        return storeTypeCombo;
    }

//    public TestStateBar getStateBarPanel() {
//        return stateBarPanel;
//    }

    /**
     * @return Returns the splitContainer.
     */
    public TestSplitContainer getSplitContainer() {
        return splitContainer;
    }
	
}
