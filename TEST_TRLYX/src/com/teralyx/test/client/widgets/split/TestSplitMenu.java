package com.teralyx.test.client.widgets.split;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestShowCountry;
import com.teralyx.test.client.bean.TestStore;
import com.teralyx.test.client.bean.TestStoreType;
import com.teralyx.test.client.controller.TestSectionController;

public class TestSplitMenu extends Composite {

    private TestSectionController sectionController;

    private VerticalPanel mainVerticalPanel;

    private TestStoreType storeType = null;

    public TestSplitMenu(TestSectionController sectionController, TestStoreType storeType) {
        this.sectionController = sectionController;
        this.storeType = storeType;
        initialize();
    }

    public void initialize() {
        mainVerticalPanel = new VerticalPanel();
        initWidget(mainVerticalPanel);
        mainVerticalPanel.setWidth("100%");

        mainVerticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        mainVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    }

    public synchronized void forceFillSplitPanelWithRegions() {
        this.storeType = null;
        getMainVerticalPanel().clear();
        fillSplitPanelWithRegions();
    }

    public synchronized void forceFillSplitPanelWithRegionsAndStType(TestStoreType storeType) {
        this.storeType = storeType;
        getMainVerticalPanel().clear();
        fillSplitPanelWithRegions();
    }

    public synchronized void fillSplitPanelWithRegions() {
        if (getMainVerticalPanel().getWidgetCount() == 0) {
            ArrayList<TestRegion> regions = getSectionController().getRegionsList();
            if (regions != null) {
                addCountryElement();
                for (int i = 0; i < regions.size(); i++) {
                	TestRegion region = regions.get(i);
                    if (hasThisStationType(region, storeType)){
                        TestSplitMenuElement splitMenuElem = new TestSplitMenuElement(getSectionController(), this, region);
                        getMainVerticalPanel().add(splitMenuElem);
                        splitMenuElem.setWidth("96%");        
                    }

                }
            }
        }
    }

    public synchronized void fillSplitPanelWithOneRegion(TestRegion oneRegion) {
        this.storeType = null;
        getMainVerticalPanel().clear();
        ArrayList<TestRegionState> regionStates = getSectionController().getRegionStatesByRegion().get(oneRegion.getRegionId());
        fillSplitPanelWithRegionStates(regionStates);
    }

    public synchronized void fillSplitPanelWithOneRegionAndStType(TestRegion oneRegion, TestStoreType storeType) {
        this.storeType = storeType;
        getMainVerticalPanel().clear();
        ArrayList<TestRegionState> regionStates = getSectionController().getRegionStatesByRegion().get(oneRegion.getRegionId());
        fillSplitPanelWithRegionStates(regionStates);
    }

    public synchronized void fillSplitPanelWithRegionStates(ArrayList<TestRegionState> regionStates) {
        if (regionStates != null) {
            for (int i = 0; i < regionStates.size(); i++) {
            	TestRegionState regionState = regionStates.get(i);
                if (hasThisStationType(regionState, storeType)){
                	TestSplitMenuElement splitMenuElem = new TestSplitMenuElement(getSectionController(), this, regionState);
                    getMainVerticalPanel().add(splitMenuElem);
                    splitMenuElem.setWidth("93%"); 
                }
            }
        }
    }

    public synchronized void fillSplitPanelWithOneRegionState(TestRegionState oneRegionState) {
        this.storeType = null;
        getMainVerticalPanel().clear();
        ArrayList<TestStore> stores = getSectionController().getStoreByRegionStateId().get(oneRegionState.getRegionStateId());
        fillSplitPanelWithStations(stores);
    }

    public synchronized void fillSplitPanelWithOneRegionStateAndStType(TestRegionState oneRegionState, TestStoreType storeType) {
        this.storeType = storeType;
        getMainVerticalPanel().clear();
        ArrayList<TestStore> stores = getSectionController().getStoreByRegionStateId().get(oneRegionState.getRegionStateId());
        fillSplitPanelWithStations(stores);
    }

    public synchronized void fillSplitPanelWithStations(ArrayList<TestStore> stores) {
        if (stores != null) {
            for (int i = 0; i < stores.size(); i++) {
                TestStore store = stores.get(i);
                if (storeType == null || (storeType != null && store.getStoreType().getStoreTypeId() == storeType.getStoreTypeId())  ) {
                    TestSplitMenuElement splitMenuElem = new TestSplitMenuElement(getSectionController(), this, store);
                    getMainVerticalPanel().add(splitMenuElem);
                    splitMenuElem.setWidth("93%");
                }

            }
        }
    }

    public void addCountryElement() {
        TestSplitMenuElement splitMenuCountry = new TestSplitMenuElement(getSectionController(), this, new TestShowCountry());
        getMainVerticalPanel().add(splitMenuCountry);
        splitMenuCountry.setWidth("96%");
    }

    public void unmarkOthers(TestSplitMenuElement splitMenuElement) {
        for (int i = 0; i < getMainVerticalPanel().getWidgetCount(); i++) {
            if (getMainVerticalPanel().getWidget(i) instanceof TestSplitMenuElement) {
                TestSplitMenuElement oneSplitMenuElement = (TestSplitMenuElement) getMainVerticalPanel().getWidget(i);
                if (!oneSplitMenuElement.equals(splitMenuElement) && oneSplitMenuElement.isOpenned()) {
                    oneSplitMenuElement.setOpenned(false);
                }
                if (!oneSplitMenuElement.equals(splitMenuElement) && oneSplitMenuElement.isActive()){
                    oneSplitMenuElement.setActive(false);
                }
            }

        }
    }

    public boolean hasThisStationType(TestRegion region, TestStoreType storeType) {
        if (storeType != null){
            ArrayList<TestRegionState> regionStates = getSectionController().getRegionStatesByRegion().get(region.getRegionId());
            for (int i = 0; i < regionStates.size(); i++) {
                TestRegionState regionState = regionStates.get(i);
                if ( hasThisStationType( regionState,  storeType)) {
                    return true;
                }
            }
            return false;
        }else {
            return true;
        }
    }
    
    public boolean hasThisStationType(TestRegionState regionState, TestStoreType storeType) {
        if (storeType != null){
            ArrayList<TestStore> stores = getSectionController().getStoreByRegionStateId().get(regionState.getRegionStateId());
            for (int i = 0; stores != null && i < stores.size(); i++) {
            	TestStore store = stores.get(i);
                if ( store.getStoreType().getStoreTypeId() == storeType.getStoreTypeId()) {
                    return true;
                }
            }
            return false;
        }else {
            return true;
        }
    }

    public void closeSplitPanel() {
        for (int i = 0; i < getMainVerticalPanel().getWidgetCount(); i++) {
            if (getMainVerticalPanel().getWidget(i) instanceof TestSplitMenuElement) {
                TestSplitMenuElement oneSplitMenuElement = (TestSplitMenuElement) getMainVerticalPanel().getWidget(i);
                oneSplitMenuElement.setVisible(false);
            }

        }
    }
    
    public void openSplitPanel() {
        for (int i = 0; i < getMainVerticalPanel().getWidgetCount(); i++) {
            if (getMainVerticalPanel().getWidget(i) instanceof TestSplitMenuElement) {
            	TestSplitMenuElement oneSplitMenuElement = (TestSplitMenuElement) getMainVerticalPanel().getWidget(i);
                oneSplitMenuElement.setVisible(true);
                if (oneSplitMenuElement.isOpenned()) {
                    oneSplitMenuElement.setOpenned(false);
                }
                if ( oneSplitMenuElement.isActive()){
                    oneSplitMenuElement.setActive(false);
                }
            }

        }
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    public VerticalPanel getStationsSubMenuPanel() {
        return mainVerticalPanel;
    }

    /**
     * @return Returns the mainVerticalPanel.
     */
    public VerticalPanel getMainVerticalPanel() {
        return mainVerticalPanel;
    }

    /**
     * @return Returns the storeType.
     */
    public TestStoreType getStoreType() {
        return storeType;
    }
    
    public boolean hasElements(){
        if ( getMainVerticalPanel().getWidgetCount() > 0){
            return true;
        }
        return false;
    }

}
