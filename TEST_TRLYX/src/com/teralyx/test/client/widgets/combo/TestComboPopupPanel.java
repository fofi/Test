package com.teralyx.test.client.widgets.combo;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.teralyx.test.client.bean.TestComboBean;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestStore;
import com.teralyx.test.client.bean.TestStoreType;
import com.teralyx.test.client.section.TestSectionConstantsIF;

public class TestComboPopupPanel extends Composite {

	public HashMap<String, TestComboBean> itemsMap = new HashMap<String, TestComboBean>();

    public HashMap<String, TestComboBean> getItemsMap() {
        return itemsMap;
    }

    private VerticalPanel verticalPanel;

    private TestCombo comboPanel;

    private String section;

    private ScrollPanel scrollPanel;

    private int heigthSC = 20;

    private String EMPTY_TEXT = "Ninguno";

    private String ALL_TEXT = "Todos";

    private String EMPTY_RESULT_TEXT = "No hay coincidencias";

    private int stationIdSelected;

    public TestComboPopupPanel(TestCombo comboPanel, String section) {
        this.section = section;
        this.comboPanel = comboPanel;

        final FocusPanel focusPanel = new FocusPanel();
        initWidget(focusPanel);

        scrollPanel = new ScrollPanel();
        verticalPanel = new VerticalPanel();
        scrollPanel.add(verticalPanel);
        verticalPanel.setSize("100%", "100%");
        focusPanel.setWidget(scrollPanel);
        scrollPanel.setHeight("0");

    }

    public void addItem(TestComboBean combo) {
        itemsMap.put(combo.getText(), combo);
        Label label = new Label(combo.getText());
        label.setStyleName("comboItem");

        TheHandler handler = new TheHandler();
        label.addClickHandler(handler);
        label.addMouseOverHandler(handler);
        label.addMouseOutHandler(handler);

        verticalPanel.add(label);

        if (itemsMap.size() < 7) {
            scrollPanel.setHeight(String.valueOf(heigthSC * itemsMap.size()));
        }

    }

    public void removeItems() {
        scrollPanel.setHeight("0");
        verticalPanel.clear();
        itemsMap.clear();

    }

    private void itemSelected(TestComboBean item) {
        comboPanel.setSelectedItem(item);
    }

    private void unmarkOthers(Widget args) {
        for (int i = 0; i < verticalPanel.getWidgetCount(); i++) {
            if (!args.equals(verticalPanel.getWidget(i))) {
                verticalPanel.getWidget(i).setStyleName("comboItem");
            }
        }
    }

    class TheHandler implements ClickHandler, MouseOverHandler, MouseOutHandler {

        public void onClick(ClickEvent event) {

            if (section.equals(TestSectionConstantsIF.SECTION_START)) {
                String selection = ((Label) event.getSource()).getText();
                itemSelected(itemsMap.get(selection));
                Object selectedObject = itemsMap.get(selection).getValue();

                if (selectedObject instanceof TestRegion) {
                	TestRegion region = (TestRegion) selectedObject;

                    String comboStationTypeSelected = getComboPanel().getSectionController().getStartSection().getLeftPanel()
                                    .getStoreTypeCombo().getItemSelected().getText();

                    if (selection.equals(EMPTY_TEXT)) {
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().getPopupPanel().removeItems();
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getRegionsCombo().getPopupPanel().removeItems();

                        TestComboBean comboBean = new TestComboBean();
                        comboBean.setText(EMPTY_TEXT);
                        comboBean.setValue(new TestRegionState());
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().getLabel().setText(
                                        comboBean.getText());
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().fillCombo();
                        // getComboPanel().getSectionController().getStartSection().getLeftPanel().getTreePanel().forceFillTree();
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                        .forceFillSplitPanelWithRegions();

                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getStoreTypeCombo().getLabel().setText(
                                        ALL_TEXT);

                    } else {

                        if (comboStationTypeSelected.equals(ALL_TEXT)) {

                            ArrayList<TestRegionState> statesList = getComboPanel().getSectionController().getRegionStatesByRegion().get(
                                            region.getRegionId());
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().getPopupPanel()
                                            .removeItems();
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().addItem(EMPTY_TEXT,
                                            new TestRegionState());

                            TestComboBean comboBean = new TestComboBean();
                            comboBean.setText(EMPTY_TEXT);
                            comboBean.setValue(new TestRegionState());
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().getLabel().setText(
                                            comboBean.getText());

                            for (int i = 0; i < statesList.size(); i++) {
                                TestRegionState regionState = statesList.get(i);
                                getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().addItem(
                                                regionState.getRegionStateName(), regionState);
                            }
                            // getComboPanel().getWebSectionController().getWebStartSection().getLeftPanel().getTreePanel().createTreeRegion(region);
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                            .fillSplitPanelWithOneRegion(region);

                        } else {
                            TestStoreType stationType = (TestStoreType) getComboPanel().getSectionController().getStartSection()
                                            .getLeftPanel().getStoreTypeCombo().getItemSelected().getValue();

                            ArrayList<TestRegionState> statesList = getComboPanel().getSectionController().getRegionStatesByRegion().get(
                                            region.getRegionId());
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().getPopupPanel()
                                            .removeItems();
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().addItem(EMPTY_TEXT,
                                            new TestRegionState());

                            TestComboBean comboBean = new TestComboBean();
                            comboBean.setText(EMPTY_TEXT);
                            comboBean.setValue(new TestRegionState());
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().getLabel().setText(
                                            comboBean.getText());

                            for (int i = 0; i < statesList.size(); i++) {
                                TestRegionState regionState = statesList.get(i);
                                getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().addItem(
                                                regionState.getRegionStateName(), regionState);
                            }
                            // getComboPanel().getWebSectionController().getWebStartSection().getLeftPanel().getTreePanel().createTreeRegionWithStationType(region,
                            // stationType);
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                            .fillSplitPanelWithOneRegionAndStType(region, stationType);

                        }

                    }

                } else if (selectedObject instanceof TestRegionState) {
                    String comboRegionsActual = getComboPanel().getSectionController().getStartSection().getLeftPanel().getRegionsCombo()
                                    .getItemSelected().getText();

                    TestRegionState state = (TestRegionState) selectedObject;

                    if (selection.equals(EMPTY_TEXT) && comboRegionsActual.equals(EMPTY_TEXT)) {

                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo().getPopupPanel().removeItems();
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getRegionsCombo().getPopupPanel().removeItems();
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().fillCombo();
                        // getComboPanel().getSectionController().getStartSection().getLeftPanel().getTreePanel().forceFillTree();
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                        .forceFillSplitPanelWithRegions();

                    } else {
                        String comboStationTypeActual = getComboPanel().getSectionController().getStartSection().getLeftPanel()
                                        .getStoreTypeCombo().getItemSelected().getText();

                        if (comboStationTypeActual.equals(ALL_TEXT)) {
                            // getComboPanel().getSectionController().getStartSection().getLeftPanel().getTreePanel().createTreeState(state);
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                            .fillSplitPanelWithOneRegionState(state);

                        } else {
                        	TestStoreType comboStoreTypeSelected = (TestStoreType) getComboPanel().getSectionController()
                                            .getStartSection().getLeftPanel().getStoreTypeCombo().getItemSelected().getValue();

                            if (comboStoreTypeSelected == null) {

                            }
                            // getComboPanel().getSectionController().getStartSection().getLeftPanel().getTreePanel().createTreeStateWithStationType(state,
                            // comboStationTypeSelected);
                            getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                            .fillSplitPanelWithOneRegionStateAndStType(state, comboStoreTypeSelected);

                        }
                    }

                } else if (selectedObject instanceof TestStoreType) {

                	TestStoreType stationType = (TestStoreType) selectedObject;

                    String comboRegionsActual = getComboPanel().getSectionController().getStartSection().getLeftPanel().getRegionsCombo()
                                    .getItemSelected().getText();

                    String comboStatesActual = getComboPanel().getSectionController().getStartSection().getLeftPanel().getStatesCombo()
                                    .getItemSelected().getText();

                    if (comboRegionsActual.equals(EMPTY_TEXT) && comboStatesActual.equals(EMPTY_TEXT)
                                    && stationType.getStoreTypeDescription() != null) {

                        // getComboPanel().getSectionController().getStartSection().getLeftPanel().getTreePanel().forceFillTreeWithStationType(
                        // stationType);
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                        .forceFillSplitPanelWithRegionsAndStType(stationType);

                    } else if (comboRegionsActual.equals(EMPTY_TEXT) && !comboStatesActual.equals(EMPTY_TEXT)) {

                        TestRegionState regionStateSelected = (TestRegionState) getComboPanel().getSectionController()
                                        .getStartSection().getLeftPanel().getStatesCombo().getItemSelected().getValue();
                        // getComboPanel().getSectionController().getStartSection().getLeftPanel().getTreePanel().createTreeStateWithStationType(
                        // regionStateSelected, stationType);
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                        .fillSplitPanelWithOneRegionStateAndStType(regionStateSelected, stationType);

                    } else if (!comboRegionsActual.equals(EMPTY_TEXT) && comboStatesActual.equals(EMPTY_TEXT)) {

                        TestRegion regionSelected = (TestRegion) getComboPanel().getSectionController().getStartSection()
                                        .getLeftPanel().getRegionsCombo().getItemSelected().getValue();

                        // getComboPanel().getWebSectionController().getWebStartSection().getLeftPanel().getTreePanel().createTreeRegionWithStationType(
                        // regionSelected, stationType);
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                        .fillSplitPanelWithOneRegionAndStType(regionSelected, stationType);

                    }

                    else if (!comboStatesActual.equals(EMPTY_TEXT)) {

                        TestRegionState regionState = (TestRegionState) getComboPanel().getSectionController().getStartSection()
                                        .getLeftPanel().getStatesCombo().getItemSelected().getValue();

                        // getComboPanel().getWebSectionController().getWebStartSection().getLeftPanel().getTreePanel().createTreeStateWithStationType(
                        // regionState, stationType);
                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                        .fillSplitPanelWithOneRegionStateAndStType(regionState, stationType);

                    } else {

                        getComboPanel().getSectionController().getStartSection().getLeftPanel().getSplitContainer().getSplitMenu()
                                        .forceFillSplitPanelWithRegionsAndStType(null);
                    }

                }
            } else if (section.equals(TestSectionConstantsIF.SECTION_DATA)) {

                String selection = ((Label) event.getSource()).getText();
                itemSelected(itemsMap.get(selection));

                Object selectedObject = itemsMap.get(selection).getValue();

                /*
                if (selectedObject instanceof TestReliability == false) {
                    TestDialogBoxParametersSelector sw = (TestDialogBoxParametersSelector) getComboPanel().getParent().getParent()
                                    .getParent().getParent().getParent().getParent();

                    FlexTable testDialogStationDataFlexTable = (FlexTable) getComboPanel().getParent();

                    TestCombo regionsCombo = (TestCombo) testDialogStationDataFlexTable.getWidget(0, 1);
                    TestCombo statesCombo = (TestCombo) testDialogStationDataFlexTable.getWidget(1, 1);
                    TestCombo storesCombo = (TestCombo) testDialogStationDataFlexTable.getWidget(2, 1);

                    if (selectedObject instanceof TestRegion) {

                    	TestRegion region = (TestRegion) selectedObject;

                        if (!storesCombo.getPopupPanel().itemsMap.isEmpty()) {
                        	storesCombo.getPopupPanel().removeItems();
                        	storesCombo.addItem(EMPTY_TEXT, new TestStore());
                        	storesCombo.getLabel().setText(EMPTY_TEXT);
                        }

                        if (selection.equals(EMPTY_TEXT)) {
                            statesCombo.getPopupPanel().removeItems();
                            // regionsCombo.getPopupPanel().removeItems();
                            TestComboBean comboBean = new TestComboBean();
                            comboBean.setText(EMPTY_TEXT);
                            comboBean.setValue(new TestRegionState());
                            statesCombo.getLabel().setText(comboBean.getText());

                            ArrayList<TestRegionState> statesList = getComboPanel().getSectionController().getRegionStateList();

                            statesCombo.addItem(EMPTY_TEXT, new TestRegionState());
                            for (int i = 0; i < statesList.size(); i++) {
                                TestRegionState regionState = statesList.get(i);
                                statesCombo.addItem(regionState.getRegionStateName(), regionState);
                            }

                        } else {
                            statesCombo.getPopupPanel().removeItems();
                            TestComboBean comboBean = new TestComboBean();
                            comboBean.setText(EMPTY_TEXT);
                            comboBean.setValue(new TestRegionState());
                            statesCombo.getLabel().setText(comboBean.getText());
                            ArrayList<TestRegionState> statesList = getComboPanel().getSectionController().getRegionStatesByRegion().get(
                                            region.getRegionId());
                            statesCombo.getPopupPanel().removeItems();
                            statesCombo.addItem(EMPTY_TEXT, new TestRegionState());
                            for (int i = 0; i < statesList.size(); i++) {
                                TestRegionState regionState = statesList.get(i);
                                statesCombo.addItem(regionState.getRegionStateName(), regionState);
                            }
                        }
                    } else if (selectedObject instanceof TestRegionState) {
                        String comboRegionsActual = regionsCombo.getItemSelected().getText();

                        TestRegionState state = (TestRegionState) selectedObject;

                        if (!storesCombo.getPopupPanel().itemsMap.isEmpty()) {
                        	storesCombo.getPopupPanel().removeItems();
                        	storesCombo.addItem(EMPTY_TEXT, new TestStore());
                        	storesCombo.getLabel().setText(EMPTY_TEXT);
                        }

                        if (selection.equals(EMPTY_TEXT) && comboRegionsActual.equals(EMPTY_TEXT)) {
                        	storesCombo.getPopupPanel().removeItems();
                            regionsCombo.getPopupPanel().removeItems();

                        } else {

                            ArrayList<TestStore> storesList = getComboPanel().getSectionController().getStoreByRegionStateId().get(
                                            state.getRegionStateId());
                            for (int i = 0; i < storesList.size(); i++) {
                            	TestStore store = storesList.get(i);
                                storesCombo.addItem(store.getStoreName(), store);
                            }
                        }
                    } else if (selectedObject instanceof TestStore) {

                    	TestStore store = (TestStore) selectedObject;

                        sw.setStoreIdSelected(store.getStoreId());
                        if (!selection.equals(EMPTY_TEXT)) {
                            ScrollPanel sp = (ScrollPanel) sw.getParameterListOfStation().getWidget();
                            VerticalPanel verPan = (VerticalPanel) sp.getWidget();

                            int widgetCount = verPan.getWidgetCount();

                            if (widgetCount != 0) {
                                sp.remove(verPan);

                                verPan = new VerticalPanel();
                                sp.add(verPan);
                                verPan.setWidth("100%");
                                verPan.setSpacing(2);

                            }

                            ArrayList<TestComponent> parametersList = store.getComponentList();

                            if (sw.getRowsSelectedList().size() != 0) {
                                for (int i = 0; i < sw.getRowsSelectedList().size(); i++) {
                                	TestComponent param = sw.getRowsSelectedList().get(i).getComponent();
                                    if (parametersList.contains(param)) {
                                        parametersList.remove(param);
                                    }
                                }
                            }
                            if (parametersList.size() != 0) {
                                for (int i = 0; i < parametersList.size(); i++) {
                                	TestComponent component = parametersList.get(i);
                                    verPan.add(new TestDialogBoxRowFocusTable(getComboPanel().getSectionController(), component
                                                    .getComponentName(), component));
                                }
                            }
                        }
                    }
                } else if (selectedObject instanceof TestReliability) {
                	TestReliability reliability = (TestReliability) selectedObject;
                    getComboPanel().getSectionController().getDataSection().getChart().getChartData().updateReliability(reliability);
                }
                */
            } 
            
        }

        public void onMouseOut(MouseOutEvent event) {
            ((Label) event.getSource()).setStyleName("comboItem");
        }

        public void onMouseOver(MouseOverEvent event) {
            ((Label) event.getSource()).setStyleName("comboItemSelected");
            unmarkOthers(((Label) event.getSource()));
        }
    }

    public TestCombo getComboPanel() {
        return comboPanel;
    }

    /**
     * @return Returns the stationIdSelected.
     */
    public int getStationIdSelected() {
        return stationIdSelected;
    }

    /**
     * @param stationIdSelected The stationIdSelected to set.
     */
    public void setStationIdSelected(int stationIdSelected) {
        this.stationIdSelected = stationIdSelected;
    }

	
}
