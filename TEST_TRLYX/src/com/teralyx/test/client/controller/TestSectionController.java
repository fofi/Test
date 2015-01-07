package com.teralyx.test.client.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.teralyx.test.client.TestIndex;
import com.teralyx.test.client.TestRemoteServiceControllerAsync;
import com.teralyx.test.client.bean.TestComponent;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestReliability;
import com.teralyx.test.client.bean.TestStore;
import com.teralyx.test.client.bean.TestStoreType;
import com.teralyx.test.client.bean.TestUser;
import com.teralyx.test.client.bean.TestUserType;
import com.teralyx.test.client.controller.access.TestAccessController;
import com.teralyx.test.client.model.connection.TestConnectionModel;
import com.teralyx.test.client.model.data.TestNewDataModel;
import com.teralyx.test.client.model.storestate.TestStoreStateChangeModel;
import com.teralyx.test.client.section.TestSectionConstantsIF;
import com.teralyx.test.client.section.TestSectionIF;
import com.teralyx.test.client.section.dataSection.TestDataSection;
import com.teralyx.test.client.section.main.TestMainMenuWidget;
import com.teralyx.test.client.section.main.TestMainSection;
import com.teralyx.test.client.section.startSection.TestStartSection;
import com.teralyx.test.client.tools.TestTools;

public class TestSectionController {
	
	
	private RootPanel rootPanel = null;
	
	private TestIndex testIndex;
	
	private TestMainMenuWidget mainMenu = null;
	
	private TestMainSection testMainSection = null;
	
	private TestUser onlineUser = null;
	
	/**
     * Create a remote service proxy to talk to the server-side Remote Service Controller.
     */
    private TestRemoteServiceControllerAsync remoteServiceController = GWT.create(TestRemoteServiceControllerAsync.class);

	
    private TestAccessController controllerAccess = null;

    private TestConnectionModel connectionModel = null;

    private TestNewDataModel newDataModel = null;
    
    private TestStoreStateChangeModel storeStateChangeModel = null;

    
    private ArrayList<TestStore> storeList = null;

    private ArrayList<TestStoreType> storeTypeList = null;

    private ArrayList<TestRegion> regionsList = null;

    private ArrayList<TestRegionState> regionStateList = null;

    private HashMap<Integer, TestStore> storeByStoreId = null;
    
    private HashMap<Integer, ArrayList<TestComponent>> componentListByStoreId = null;
    
    private HashMap<Integer, ArrayList<TestRegionState>> regionStoresByRegionId = null;
    
    private HashMap<Integer, ArrayList<TestRegionState>> regionStatesByRegionId = null;
    
    private HashMap<Integer, ArrayList<TestStore>> storeByRegionStateId = null;
    
    private ArrayList<TestReliability> reliabilities = null;

    private ArrayList<TestUser> userList = null;
    
    private ArrayList<TestUserType> userTypeList = null;
    
    private ArrayList<TestSectionIF> sectionsList = new ArrayList<TestSectionIF>();
    
    private String actualSectionName = TestSectionConstantsIF.NO_SECTION;

    private TestSectionIF actualSection;
    
    private TestMainSection mainSection = null;

    private TestStartSection startSection = null;

    private TestDataSection dataSection = null;
    
    
    /*
     * State variables for upload infro from datababse
     */
    private boolean storesComplete = false;

    private boolean regionsComplete = false;

    private boolean regionsStateComplete = false;

    private boolean storeTypesComplete = false;

    private boolean webReliabilitiesComplete = false;

    private boolean userTypesComplete = false;

    private boolean webReportsComplete = false;

    private boolean userListComplete = false;

    
    
    
    public TestSectionController(TestIndex testIndex) {
        this.testIndex = testIndex;

        rootPanel = RootPanel.get();
        rootPanel.setWidth("100%");
        rootPanel.setHeight("825");
        rootPanel.addStyleName("footPanel");
        rootPanel.add(getMainSection());
        getMainSection().setSize("100%", "825");

        // Comprobar que se puede poner sin problemas aqui
        getControllerAccess().verifyUserSession();

        Handler handler = new Handler();
        Window.addResizeHandler(handler);

    }
    
    
    /**
     * @param environmentalWebStationList The environmentalWebStationList to set.
     */
    public void setStoreList(ArrayList<TestStore> storeList) {
        this.storeList = storeList;
        if (this.storeList != null) {
            storeByRegionStateId = new HashMap<Integer, ArrayList<TestStore>>();
            componentListByStoreId = new HashMap<Integer, ArrayList<TestComponent>>();
            storeByStoreId = new HashMap<Integer, TestStore>();
            for (int i = 0; i < storeList.size(); i++) {
            	TestStore oneStore = storeList.get(i);
            	storeByStoreId.put(oneStore.getStoreId(), oneStore);
                componentListByStoreId.put(oneStore.getStoreId(), oneStore.getComponentList());

                int regionStateId = oneStore.getRegionState().getRegionStateId();
                if (storeByRegionStateId.containsKey(regionStateId)) {
                	storeByRegionStateId.get(regionStateId).add(oneStore);
                } else {
                	storeByRegionStateId.put(regionStateId, new ArrayList<TestStore>());
                	storeByRegionStateId.get(regionStateId).add(oneStore);
                }

            }
            storesComplete = true;
            reviewInfoUploading();
        } else {
            storeByRegionStateId = null;
        }
    }
    
    
    /**
     * @param regionsList The regionsList to set.
     */
    public void setRegionsList(ArrayList<TestRegion> regionsList) {
        this.regionsList = regionsList;
        if (this.regionsList != null) {
            regionsComplete = true;
            reviewInfoUploading();
        }
    }

    /**
     * @param webRegionStateList The webRegionStateList to set.
     */
    public void setRegionStateList(ArrayList<TestRegionState> regionStateList) {
        this.regionStateList = regionStateList;
        if (this.regionStateList != null) {
            regionStatesByRegionId = new HashMap<Integer, ArrayList<TestRegionState>>();
            for (int i = 0; i < regionStateList.size(); i++) {
                TestRegionState oneRegionState = regionStateList.get(i);
                int regionId = oneRegionState.getRegion().getRegionId();
                if (regionStatesByRegionId.containsKey(regionId)) {
                    regionStatesByRegionId.get(regionId).add(oneRegionState);
                } else {
                    regionStatesByRegionId.put(regionId, new ArrayList<TestRegionState>());
                    regionStatesByRegionId.get(regionId).add(oneRegionState);
                }
            }
            regionsStateComplete = true;
            reviewInfoUploading();
        } else {
            regionStatesByRegionId = null;
        }
    }

    /**
     * @param userTypeList The userTypeList to set.
     */
    public void setUserTypeList(ArrayList<TestUserType> userTypeList) {
        this.userTypeList = userTypeList;
        if (this.userTypeList != null) {
        	userTypesComplete = true;
            reviewManagementInfoUploading();
        }
    }

    /**
     * @param userList The webUuserList to set.
     */
    public void setUserList(ArrayList<TestUser> userList) {
        this.userList = userList;
        if (userList != null) {
            userListComplete = true;
            reviewManagementInfoUploading();
        }
    }
    
    
    /**
     * @return Returns the webIndex.
     */
    public TestIndex getTestIndex() {
        return testIndex;
    }
    
    /**
     * @return Returns the remoteServiceController.
     */
    public TestRemoteServiceControllerAsync getRemoteServiceController() {
        return remoteServiceController;
    }

    
    public TestAccessController getControllerAccess() {
        if (controllerAccess == null) {
            controllerAccess = new TestAccessController(this, getRemoteServiceController());
        }
        return controllerAccess;
    }


    //MODELS
    
    public TestConnectionModel getConnectionModel() {
        if (connectionModel == null) {
            connectionModel = new TestConnectionModel(this, getRemoteServiceController());
        }
        return connectionModel;
    }

    public TestNewDataModel getNewDataModel() {
        if (newDataModel == null) {
            newDataModel = new TestNewDataModel(this, getRemoteServiceController());
        }
        return newDataModel;
    }

    public TestStoreStateChangeModel getStationStateChangeModel() {
        if (storeStateChangeModel == null) {
        	storeStateChangeModel = new TestStoreStateChangeModel(this, getRemoteServiceController());
        }
        return storeStateChangeModel;
    }

    //SECTIONS
    
    
    public TestMainSection getMainSection() {
        if (testMainSection == null) {
        	testMainSection = new TestMainSection(this);
        }
        return testMainSection;
    }
    
    public TestStartSection getStartSection() {
        if (startSection == null) {
            startSection = new TestStartSection(this);
            sectionsList.add(startSection);
        }
        return startSection;
    }

    public TestDataSection getDataSection() {
        if (dataSection == null) {
        	dataSection = new TestDataSection(this);
            sectionsList.add(dataSection);
        }
        return dataSection;
    }


    public void setActualSection(String actualSectionName, TestSectionIF actualSection) {
        this.actualSectionName = actualSectionName;
        this.actualSection = actualSection;
    }

    public String getActualSectionName() {
        return actualSectionName;
    }

    /**
     * @return Returns the actualSection.
     */
    public TestSectionIF getActualSection() {
        return actualSection;
    }

    public boolean changeView(String newSectionName) {
        boolean changeSectionPerformed = true;
        String oldSectionName = getActualSectionName();
        // boolean firstTime = false;

        // Si la nueva seccion es diferente a la anterior y ( (la vieja seccion es START y se ha
        // cargado el plugin de GE bien) o (la vieja seccion se diferente de START) )
        if (!oldSectionName.equals(newSectionName)
                        && ((oldSectionName.equals(TestSectionConstantsIF.SECTION_START) && getStartSection().getMapPanel().isInitilalized()) || !oldSectionName
                                        .equals(TestSectionConstantsIF.SECTION_START))) {
            // Se ejecuta el codigo de salida de la seccion actual
            if (getActualSection() != null) {
                getActualSection().onChangeOut();
            }
            if (oldSectionName.equals(TestSectionConstantsIF.SECTION_START)) {
                // getWebStartSection().getMapPanel().viewHidden();
                getMainSection().getContentContainer().remove(getStartSection());
            } else if (oldSectionName.equals(TestSectionConstantsIF.SECTION_DATA)) {
            	getMainSection().getContentContainer().remove(getDataSection());
            } else if (oldSectionName.equals(TestSectionConstantsIF.LOGIN_SECTION)) {
                setActualSection(newSectionName, null);
            } else if (oldSectionName.equals(TestSectionConstantsIF.NO_SECTION)) {
                setActualSection(newSectionName, null);
            }

            generateView(newSectionName);
            getControllerAccess().changeSessionSection(newSectionName);
        } // else if (oldSectionName.equals(TestSectionConstantsIF.SECTION_START) &&
        // !getStartSection().getMapPanel().getMapa().isInitilalized()) {
        else if (oldSectionName.equals(TestSectionConstantsIF.SECTION_START) && !getStartSection().getMapPanel().isInitilalized()) {
            changeSectionPerformed = false;
        }
        return changeSectionPerformed;

    }

    public void generateView(String button) {
        if (button.equals(TestSectionConstantsIF.SECTION_START)) {
        	getMainSection().getContentContainer().add(getStartSection());
        	getMainSection().getContentContainer().setCellVerticalAlignment(getStartSection(), HasVerticalAlignment.ALIGN_MIDDLE);
        	getMainSection().getContentContainer().setCellHorizontalAlignment(getStartSection(), HasHorizontalAlignment.ALIGN_LEFT);
            setActualSection(button, getStartSection());
            // getStartSection().getMapPanel().loadMapWidget();
            // getStartSection().getMapPanel().showMapWidget();
        } else if (button.equals(TestSectionConstantsIF.SECTION_DATA)) {
            getMainSection().getContentContainer().add(getDataSection());
            getMainSection().getContentContainer().setCellVerticalAlignment(getDataSection(), HasVerticalAlignment.ALIGN_MIDDLE);
            getMainSection().getContentContainer().setCellHorizontalAlignment(getDataSection(), HasHorizontalAlignment.ALIGN_LEFT);
            setActualSection(button, getDataSection());
        } 
        // Se ejecuta el codigo de entrada de la seccion actual
        if (getActualSection() != null) {
            getActualSection().onChangeIn();
        }
        loadComboInfo(button);
    }

    private void loadComboInfo(String button) {
        if (button.equals(TestSectionConstantsIF.SECTION_START)) {
            getStartSection().getLeftPanel().fillCombo();
            getStartSection().getLeftPanel().getSplitContainer().getSplitMenu().fillSplitPanelWithRegions();
        } else if (button.equals(TestSectionConstantsIF.SECTION_DATA)) {
            // getWebDataSection().getLeftPanel().fillCombo();
        }
    }

    public TestMainMenuWidget getMainMenu() {
        if (mainMenu == null) {
            mainMenu = new TestMainMenuWidget(this);
        }
        return mainMenu;
    }

    private void loadServerInfo() {
        restartUploadingVariables();
        getControllerAccess().loadStoreList();
        getControllerAccess().loadRegionsList();
        getControllerAccess().loadRegionStateList();
        getControllerAccess().loadStoreTypeList();
        getControllerAccess().loadReliabilityList();

    }

    public void loadManagementInfo() {
        restartManagementUploadingVariables();
        getControllerAccess().loadUserTypeList();
        getControllerAccess().loadUsersList();

    }

    private void restartUploadingVariables() {
        storesComplete = false;
        regionsComplete = false;
        regionsStateComplete = false;
        storeTypesComplete = false;


    }

    private void restartManagementUploadingVariables() {
    	userTypesComplete = false;
        userListComplete = false;

    }

    private void reviewInfoUploading() {
        if (storesComplete && regionsComplete && regionsStateComplete && storeTypesComplete && webReportsComplete && webReliabilitiesComplete) {
            restartUploadingVariables();
            loadComboInfo(getActualSectionName());
        }
    }

    private void reviewManagementInfoUploading() {
        if (userTypesComplete && userListComplete) {
            restartUploadingVariables();
            loadComboInfo(getActualSectionName());
        }
    }

    public void goToSection(String sectionName) {
        changeView(sectionName);

        // Se carga toda la info del servidor
        loadServerInfo();
        // Se crean los modelos para que se empiece a recibir datos
        getStationStateChangeModel();

        // getWebMainSection().getContentContainer().remove(getWebMainSection().getContent());
        getMainSection().addLogoutDataPanel();
        getMainMenu().loadMenuItems(getMenuIndex(sectionName), getOnlineUser());

        getMainSection().setMenu(getMainMenu());

        // getWebMainSection().getUserExitPanel().getUserLabel().setText(onlineUser.getUserName());
        getMainSection().getUserLabel().setText(onlineUser.getUserName());
    }

    public void goToLoginSection() {
        // if (getActualSectionName().equals(SigreWebSectionConstantsIF.SECTION_START)) {
        // // getWebStartSection().getMapPanel().getMapa().viewHidden();
        // getWebStartSection().getMapPanel().viewHidden();
        // }
        if (getActualSection() != null) {
            getActualSection().onChangeOut();
        }

        setActualSection(TestSectionConstantsIF.LOGIN_SECTION, null);

    }

    private int getMenuIndex(String sectionName) {
        int sectionIndex = 1;
        if (sectionName.equals(TestSectionConstantsIF.SECTION_START)) {
            sectionIndex = 1;
        } else if (sectionName.equals(TestSectionConstantsIF.SECTION_STORES)) {
            sectionIndex = 2;
        } else if (sectionName.equals(TestSectionConstantsIF.SECTION_DATA)) {
            sectionIndex = 3;
        } 
        return sectionIndex;
    }

    public void logOutAllView() {
        for (int i = 0; i < sectionsList.size(); i++) {
            sectionsList.get(i).onLogoutApp();
        }
        sectionsList.clear();
        startSection = null;
        dataSection = null;
        
        TestTools.refresh();
    }

    class Handler implements ResizeHandler {
        public void onResize(ResizeEvent event) {

            if (getMainSection() != null) {
                if (event.getHeight() <= 825) {
                	getMainSection().setHeight(825 + "");
                } else {
                	getMainSection().setHeight("100%");
                }
            }
        }
    }

    
	/**
	 * @return Returns the regionStatesByRegion.
	 */
	public HashMap<Integer, ArrayList<TestRegionState>> getRegionStatesByRegion() {
		return regionStatesByRegionId;
	}

	/**
	 * @return Returns the stationByRegionStateId.
	 */
	public HashMap<Integer, ArrayList<TestStore>> getStoreByRegionStateId() {
		return storeByRegionStateId;
	}

	/**
	 * @param storeId
	 *            the store identifier
	 * @return the TestSore Object
	 */
	public TestStore getStore(int storeId) {
		return storeByStoreId.get(storeId);
	}

	   /**
     * @return Returns the stationTypeList.
     */
    public ArrayList<TestStoreType> getStoreTypeList() {
        if (storeTypeList == null) {
            // Si es null se reintenta, auqnue probablemente sea imposible porque no esta el server
            getControllerAccess().loadStoreTypeList();
        }
        return storeTypeList;
    }

   
    public ArrayList<TestRegion> getRegionsList() {
        if (regionsList == null) {
            // Si es null se reintenta, auqnue probablemente sea imposible porque no esta el server
            getControllerAccess().loadRegionsList();
        }
        return regionsList;
    }

    /**
     * @return Returns the webRegionStateList.
     */
    public ArrayList<TestRegionState> getRegionStateList() {
        if (regionStateList == null) {
            // Si es null se reintenta, auqnue probablemente sea imposible porque no esta el server
            getControllerAccess().loadRegionStateList();
        }
        return regionStateList;
    }
	   
    
    
    
    /**
     * @param webStationTypeList The webStationTypeList to set.
     */
    public void setWebStationTypeList(ArrayList<TestStoreType> storeTypeList) {
        this.storeTypeList = storeTypeList;
        if (this.storeTypeList != null) {
            storeTypesComplete = true;
            reviewInfoUploading();
        }
    }

    public ArrayList<TestReliability> getReliabilities() {
        if (reliabilities == null) {
            // Si es null se reintenta, auqnue probablemente sea imposible porque no esta el server
            getControllerAccess().loadReliabilityList();
        }
        return reliabilities;
    }

    
	public TestUser getOnlineUser() {
		return onlineUser;
	}


	public void setOnlineUser(TestUser onlineUser) {
		this.onlineUser = onlineUser;
	}


	public void setReliabilities(ArrayList<TestReliability> reliabilities) {
		this.reliabilities = reliabilities;
	}


	public void setStoreTypeList(ArrayList<TestStoreType> storeTypeList) {
		this.storeTypeList = storeTypeList;
	}

	
}
