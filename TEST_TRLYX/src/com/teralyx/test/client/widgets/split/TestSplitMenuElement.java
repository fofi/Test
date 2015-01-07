package com.teralyx.test.client.widgets.split;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestShowCountry;
import com.teralyx.test.client.bean.TestStore;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.widgets.clickPanels.HorizontalPanelClick;

public class TestSplitMenuElement extends Composite {

	
	private TestSectionController sectionController;

    private VerticalPanel mainMenuElementPanel;

    private HorizontalPanelClick headerElementPanel;
    
    private TestSplitMenu parentSplitMenu;
    
    private TestSplitMenu mainSplitMenu;

    private Label elementLabel;
    
    private Image elementIcon;
 
    private Image openArrow;
    
    private Image closeArrow; 
    
    private String imageUrl;

    private String labelText;

    private Object beanObject;

    private boolean openned = false;
    
    private boolean active = false;
    
//    private final static String BACKGROUND_STYLE_L0 = "backgroundSplitPanel0";
//    
//    private final static String BACKGROUND_STYLE_L1 = "backgroundSplitPanel1";
//    
//    private final static String BACKGROUND_STYLE_L2 = "backgroundSplitPanel2";
//    
//    private final static String BACKGROUND_STYLE_L3 = "backgroundSplitPanel3";

    public TestSplitMenuElement(TestSectionController sectionController, TestSplitMenu parentMenuContainer ,TestRegion region) {
        this.sectionController = sectionController;
        this.parentSplitMenu = parentMenuContainer;
        imageUrl = "res/icons/regions/" + region.getRegionId() + ".png";
        labelText = region.getRegionDescription();
        beanObject = region;
        initialize();
    }

    public TestSplitMenuElement(TestSectionController sectionController, TestSplitMenu parentMenuContainer, TestRegionState regionState) {
        this.sectionController = sectionController;
        this.parentSplitMenu = parentMenuContainer;
        imageUrl = "res/flags/" + regionState.getRegionStateId() + ".png";
        labelText = regionState.getRegionStateName();
        beanObject = regionState;
        initialize();
    }
    
    public TestSplitMenuElement(TestSectionController sectionController, TestSplitMenu parentMenuContainer, TestStore store) {
        this.sectionController = sectionController;
        this.parentSplitMenu = parentMenuContainer;
        imageUrl = "res/icons/" + store.getStoreType().getStoreTypeId() + ".png";
        labelText = store.getStoreName();
        beanObject = store;
        initialize();
    }
    
    public TestSplitMenuElement(TestSectionController sectionController, TestSplitMenu parentMenuContainer, TestShowCountry country) {
        this.sectionController = sectionController;
        this.parentSplitMenu = parentMenuContainer;
        imageUrl = "res/icons/regions/" + country.getCountryId() + ".png";
        labelText = country.getDescription();
        beanObject = country;
        initialize();
    }
    
    public void initialize() {
        mainMenuElementPanel = new VerticalPanel();
        
        initWidget(mainMenuElementPanel);

        openArrow =new Image(); 
        openArrow.setUrl("res/icons/open_arrow.png");
        openArrow.setSize("15", "15");
        
        closeArrow =new Image(); 
        closeArrow.setUrl("res/icons/close_arrow.png");
        closeArrow.setSize("15", "15");
        
        AbsolutePanel leftMargin = new AbsolutePanel();
        leftMargin.setSize("12","100%");
        
        headerElementPanel = new HorizontalPanelClick();
        headerElementPanel.setSpacing(7);
        
        elementIcon = new Image();
        elementIcon.setUrl(imageUrl);
        if (beanObject instanceof TestRegion) {
            elementIcon.setSize("20", "20");
        } else if (beanObject instanceof TestRegionState) {
            elementIcon.setSize("16", "11");
        } else if (beanObject instanceof TestStore) {
            elementIcon.setSize("15", "15");
        }else {
            elementIcon.setSize("25", "25");
        }

        elementLabel = new Label();
        elementLabel.setText(labelText);
        elementLabel.setStyleName("formText");

        if (beanObject instanceof TestRegionState || beanObject instanceof TestRegion) {
            headerElementPanel.add(openArrow);
        }else if (beanObject instanceof TestStore ){
            headerElementPanel.add(leftMargin);
        }
        headerElementPanel.add(elementIcon);
        headerElementPanel.add(elementLabel);
        elementLabel.setWidth("100%");
        headerElementPanel.setCellWidth(elementLabel, "100%");

        mainSplitMenu = new TestSplitMenu(getSectionController(), getParentSplitMenu().getStoreType());
        
        AbsolutePanel bottonMargin = new AbsolutePanel();
        bottonMargin.setSize("100%", "2");
        
        mainMenuElementPanel.add(headerElementPanel);
        mainMenuElementPanel.add(mainSplitMenu);
        mainMenuElementPanel.add(bottonMargin);

        headerElementPanel.addClickHandler(new Handler());
    }

    class Handler implements ClickHandler {

        public void onClick(ClickEvent event) {

            if (event.getSource() instanceof HorizontalPanelClick) {
                setOpenned(!openned);
                doAction();
            }
        }
    }

    
    /**
     * @param selected The selected to set.
     */
    public void setOpenned(boolean selected) {
        this.openned = selected;
        if (selected) {
            if (beanObject instanceof TestRegionState || beanObject instanceof TestRegion) {
                modifyArrow(true);
                addMoreElements();
            }
        } else {
            if (beanObject instanceof TestRegion || beanObject instanceof TestRegionState) {
                modifyArrow(false);
                getMainSplitMenu().closeSplitPanel();
            }
        } 
        
    }
    
    private void modifyArrow(boolean close){
        headerElementPanel.clear();
        if (close){
            headerElementPanel.add(closeArrow);
        }else {
            headerElementPanel.add(openArrow);
        }
        headerElementPanel.add(elementIcon);
        headerElementPanel.add(getElementLabel());
        getElementLabel().setWidth("100%");
        headerElementPanel.setCellWidth(elementLabel, "100%");
    }
    
    private void doAction() {
        setActive(true);
        if (beanObject instanceof TestRegion) {
        	TestRegion region = (TestRegion) beanObject;
            getSectionController().getControllerAccess().getKmlRegion( region,
                            getSectionController().getRegionStatesByRegion().get( region.getRegionId()));
        } else if (beanObject instanceof TestRegionState) {
        	TestRegionState regionState = (TestRegionState) beanObject;
            getSectionController().getControllerAccess().getKmlRegionState( regionState,
                            getSectionController().getStoreByRegionStateId().get( regionState.getRegionStateId()));
        } else if (beanObject instanceof TestStore) {
            TestRegionState state = ((TestStore) beanObject).getRegionState();

            getSectionController().getControllerAccess().getKmlRegionStateWithStore(state,
                            getSectionController().getStoreByRegionStateId().get(state.getRegionStateId()), (TestStore) beanObject);
        }else if (beanObject instanceof TestShowCountry){
            getSectionController().getControllerAccess().getKmlCountry2();
        }

    }
    
    private void addMoreElements(){
        if ( !getMainSplitMenu().hasElements()){
            if (beanObject instanceof TestRegion) {
            	TestRegion region = (TestRegion) beanObject;
                ArrayList<TestRegionState> regionStateList = getSectionController().getRegionStatesByRegion().get(region.getRegionId());
                getMainSplitMenu().fillSplitPanelWithRegionStates(regionStateList);
            } else if (beanObject instanceof TestRegionState) {
            	TestRegionState regionState = (TestRegionState) beanObject;
                ArrayList<TestStore> stationList = getSectionController().getStoreByRegionStateId().get(regionState.getRegionStateId());
                getMainSplitMenu().fillSplitPanelWithStations(stationList);
            } else if (beanObject instanceof TestStore || beanObject instanceof TestShowCountry) {
                //Do nothing
            }
        }else {
            getMainSplitMenu().openSplitPanel();
        }
        
    }
    
    /**
     * @return Returns the selected.
     */
    public boolean isOpenned() {
        return openned;
    }
    
    /**
     * @return Returns the active.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active The active to set.
     */
    public void setActive(boolean active) {
        this.active = active;
        if (active){
            getElementLabel().setStyleName("formTextBold");
            getParentSplitMenu().unmarkOthers(this);
        }else {
            getElementLabel().setStyleName("formText"); 
        }
    }
    
    /**
     * @return Returns the sectionController.
     */
    public TestSectionController getSectionController() {
        return sectionController;
    }

    /**
     * @return Returns the mainMenuElementPanel.
     */
    public VerticalPanel getMainMenuElementPanel() {
        return mainMenuElementPanel;
    }

    /**
     * @return Returns the splitMenuContainer.
     */
    public TestSplitMenu getMainSplitMenu() {
        return mainSplitMenu;
    }

    /**
     * @return Returns the parentMenuContainer.
     */
    public TestSplitMenu getParentSplitMenu() {
        return parentSplitMenu;
    }

    /**
     * @return Returns the beanObject.
     */
    public Object getBeanObject() {
        return beanObject;
    }

    /**
     * @return Returns the elementLabel.
     */
    public Label getElementLabel() {
        return elementLabel;
    }
	
}
