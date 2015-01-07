package com.teralyx.test.client.controller.access;

import java.util.ArrayList;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.teralyx.test.client.TestRemoteServiceControllerAsync;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestReliability;
import com.teralyx.test.client.bean.TestSession;
import com.teralyx.test.client.bean.TestStore;
import com.teralyx.test.client.bean.TestStoreType;
import com.teralyx.test.client.bean.TestUser;
import com.teralyx.test.client.bean.TestUserType;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionConstantsIF;
import com.teralyx.test.client.tools.TestTools;

public class TestAccessController {

	
	/*
     * Timers to request data from server
     */
    private int delayQueryUploadTime = 2000;

    
    private TestRemoteServiceControllerAsync remoteServiceController;

    private TestSectionController sectionController;

    public TestAccessController(TestSectionController sectionController, TestRemoteServiceControllerAsync remoteServiceController) {
        this.remoteServiceController = remoteServiceController;
        this.sectionController = sectionController;
    }

    /**
     * @return Returns the remoteServiceController.
     */
    public TestRemoteServiceControllerAsync getRemoteServiceController() {
        return remoteServiceController;
    }

    /**
     * @return Returns the webSectionController.
     */
    public TestSectionController getSectionController() {
        return sectionController;
    }
    
    
    
    
    public void verifyUserSession() {
        getRemoteServiceController().getUserSession(new AsyncCallback<TestSession>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                delayedVerifyUserSession();
            }

            public void onSuccess(TestSession result) {
                if (result != null) {
                	getSectionController().setOnlineUser(result.getUser());
                	getSectionController().goToSection(result.getSectionMenu());
                } else {
                    // Carga la sección principal en background para que se vaya cargando el plugin
                    // de GE
                    // getWebSectionController().getWebStartSection();
                	getSectionController().getMainSection().addStartSessionPanel();
                }
            }
        });
    }

    private void delayedVerifyUserSession() {
        Timer queryIsValidateTimer = new Timer() {
            public void run() {
                verifyUserSession();
            }
        };
        queryIsValidateTimer.schedule(20);
    }

    public void validateUser(String user, String password) {

        getRemoteServiceController().validateUser(user, password, new AsyncCallback<TestUser>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
            }

            public void onSuccess(TestUser result) {
                // onlineUser = result;
            	getSectionController().setOnlineUser(result);
                if (result != null) {

                	getSectionController().getMainSection().getStartSessionPanel().getMessageLabel().setText("");
                	getSectionController().getMainSection().removeStartSessionPanel();
                	getSectionController().goToSection(TestSectionConstantsIF.SECTION_START);
                	getSectionController().getMainSection().getMainContentPanel().setStyleName("backgroundPanel");
                } else {

                	getSectionController().getMainSection().getStartSessionPanel().getUserInput().setText("");
                	getSectionController().getMainSection().getStartSessionPanel().getPassInput().setText("");
                	getSectionController().getMainSection().getStartSessionPanel().getMessageLabel()
                                    .setText("Usuario o contraseña incorrectos");
                }

            }
        });
    }

    public void exitUser() {
        getRemoteServiceController().exitFromWebApp(new AsyncCallback<Boolean>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                // delayedExitFromWebApp();
                TestTools.refresh();
            }

            public void onSuccess(Boolean result) {
                if (result) {
                    System.out.println("CERRANDO SESION: Pasar a la pantalla de login ");
                    getSectionController().logOutAllView();
                    // getWebSectionController().getWebMainSection().removeUserExitPanel();
                }
            }
        });

    }

    public void delayedExitFromWebApp() {
        Timer queryExitFromAppTimer = new Timer() {
            public void run() {
                exitUser();
            }
        };
        queryExitFromAppTimer.schedule(20);
    }

    public void changeSessionSection(final String sectionName) {
        getRemoteServiceController().moveToSection(sectionName, new AsyncCallback<Void>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                delayedChangeSessionSection(sectionName);
            }

            public void onSuccess(Void result) {
                System.out.println("Se ha cambiado se seccion en la sesion");
            }

        });
    }

    private void delayedChangeSessionSection(final String sectionName) {
        Timer queryChangeSessionSection = new Timer() {
            public void run() {
                changeSessionSection(sectionName);
            }
        };
        queryChangeSessionSection.schedule(20);
    }
    
    
    public void getKmlRegionState(final TestRegionState regionState, ArrayList<TestStore> stores) {
        getRemoteServiceController().getKMLRegionState(regionState, stores, new AsyncCallback<String>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
            }

            public void onSuccess(String result) {
                getSectionController().getStartSection().getMapPanel().loadStateRegion(regionState, result);
            }
        });

    }

    public void getKmlRegionStateWithStore(final TestRegionState regionState, ArrayList<TestStore> stores, final TestStore store) {
        getRemoteServiceController().getKMLRegionState(regionState, stores, new AsyncCallback<String>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
            }

            public void onSuccess(String result) {
                getSectionController().getStartSection().getMapPanel().loadStateRegion(regionState, result, store);
            }
        });

    }

    public void getKmlRegion(final TestRegion region, ArrayList<TestRegionState> regionStates) {

    	TestStoreType stationTypeSelected = (TestStoreType) getSectionController().getStartSection().getLeftPanel()
                        .getStoreTypeCombo().getItemSelected().getValue();

        getRemoteServiceController().getKMLRegion(region, regionStates, getSectionController().getStoreByRegionStateId(),
                        stationTypeSelected.getStoreTypeId(), new AsyncCallback<String>() {

                            public void onFailure(Throwable caught) {
                                caught.printStackTrace();
                            }

                            public void onSuccess(String result) {
                                if (result != null && result.length() != 0) {
                                    getSectionController().getStartSection().getMapPanel().loadKmlRegion(region, result);
                                }
                            }
                        });

    }

    public void getKmlCountry() {

        getRemoteServiceController().getKMLCountry(new AsyncCallback<String>() {

            public void onFailure(Throwable caught) {

                caught.printStackTrace();
            }

            public void onSuccess(String result) {
                getSectionController().getStartSection().getMapPanel().loadKmlCountry(result);

            }
        });

    }

    public void getKmlCountry2() {

    	TestStoreType storeTypeSelected = (TestStoreType) getSectionController().getStartSection().getLeftPanel()
                        .getStoreTypeCombo().getItemSelected().getValue();

        // System.out.println("El id es: " + stationTypeSelected.getStationTypeId());
        getRemoteServiceController().getKMLCountry(getSectionController().getRegionStateList(),
                        getSectionController().getStoreByRegionStateId(), storeTypeSelected.getStoreTypeId(), new AsyncCallback<String>() {

                            public void onFailure(Throwable caught) {

                                caught.printStackTrace();
                            }

                            public void onSuccess(String result) {
                                getSectionController().getStartSection().getMapPanel().loadKmlCountry2(result);

                            }
                        });

    }
    
      
    public void loadReliabilityList() {
        getRemoteServiceController().getReliabilities(new AsyncCallback<ArrayList<TestReliability>>() {
            public void onFailure(Throwable caught) {
                getSectionController().setReliabilities(null);
                caught.printStackTrace();
                delayedQueryReliabilities();
            }

            public void onSuccess(ArrayList<TestReliability> reliabilities) {
                if (reliabilities != null) {
                    getSectionController().setReliabilities(reliabilities);
                } else {
                    delayedQueryReliabilities();
                }
            }
        });
    }

    private void delayedQueryReliabilities() {
        Timer timer = new Timer() {
            public void run() {
                loadReliabilityList();
            }
        };
        timer.schedule(delayQueryUploadTime);
    }
    
    

    /**
     * @return Returns the environmentalWebStationList.
     */
    public void loadStoreList() {
        getRemoteServiceController().getStores(new AsyncCallback<ArrayList<TestStore>>() {
            public void onFailure(Throwable caught) {
                getSectionController().setStoreList(null);
                caught.printStackTrace();
                delayedQueryStations();
            }

            public void onSuccess(ArrayList<TestStore> stores) {
                if (stores != null) {
                    getSectionController().setStoreList(stores);
                } else {
                    delayedQueryStations();
                }
            }
        });
    }

    
    private void delayedQueryStations() {
        Timer timer = new Timer() {
            public void run() {
            	loadStoreList();
            }
        };
        timer.schedule(delayQueryUploadTime);
    }

    /**
     * @return Returns the webRegionsList.
     */
    public void loadRegionsList() {
        getRemoteServiceController().getRegions(new AsyncCallback<ArrayList<TestRegion>>() {
            public void onFailure(Throwable caught) {
                getSectionController().setRegionsList(null);
                caught.printStackTrace();
                delayedQueryRegions();
            }

            public void onSuccess(ArrayList<TestRegion> result) {
                if (result != null) {
                    getSectionController().setRegionsList(result);
                } else {
                    delayedQueryRegions();
                }
            }
        });
    }

    private void delayedQueryRegions() {
        Timer timer = new Timer() {
            public void run() {
                loadRegionsList();
            }
        };
        timer.schedule(delayQueryUploadTime);
    }

    /**
     * @return Returns the webRegionStateList.
     */
    public void loadRegionStateList() {
        getRemoteServiceController().getRegionStates(new AsyncCallback<ArrayList<TestRegionState>>() {
            public void onFailure(Throwable caught) {
                getSectionController().setRegionStateList(null);
                caught.printStackTrace();
                delayedQueryRegionsState();
            }

            public void onSuccess(ArrayList<TestRegionState> result) {
                if (result != null) {
                    getSectionController().setRegionStateList(result);
                } else {
                    delayedQueryRegionsState();
                }

            }
        });
    }

    private void delayedQueryRegionsState() {
        Timer timer = new Timer() {
            public void run() {
                loadRegionStateList();
            }
        };
        timer.schedule(delayQueryUploadTime);
    }

    /**
     * @return Returns the storeTypeList.
     */
    public void loadStoreTypeList() {
        getRemoteServiceController().getStoreTypes(new AsyncCallback<ArrayList<TestStoreType>>() {
            public void onFailure(Throwable caught) {
                getSectionController().setStoreTypeList(null);
                caught.printStackTrace();
                delayedQueryStationTypes();
            }

            public void onSuccess(ArrayList<TestStoreType> result) {
                if (result != null) {
                    getSectionController().setStoreTypeList(result);
                } else {
                    delayedQueryStationTypes();
                }

            }
        });
    }

    private void delayedQueryStationTypes() {
        Timer timer = new Timer() {
            public void run() {
            	loadStoreTypeList();
            }
        };
        timer.schedule(delayQueryUploadTime);
    }

    public void loadUserTypeList() {

        getRemoteServiceController().getUserTypes(new AsyncCallback<ArrayList<TestUserType>>() {

            public void onFailure(Throwable caught) {
                getSectionController().setUserTypeList(null);
                caught.printStackTrace();
                delayedQueryUserTypes();
            }

            public void onSuccess(ArrayList<TestUserType> result) {
                if (result != null) {
                    getSectionController().setUserTypeList(result);
                } else {
                    delayedQueryUserTypes();
                }
            }
        });
    }

    private void delayedQueryUserTypes() {
        Timer timer = new Timer() {
            public void run() {
                loadUserTypeList();
            }
        };
        timer.schedule(delayQueryUploadTime);
    }
    
    
	public void loadUsersList() {
		getRemoteServiceController().getUsers(new AsyncCallback<ArrayList<TestUser>>() {
					
			public void onFailure(Throwable caught) {
					getSectionController().setUserList(null);
					caught.printStackTrace();

			}

			public void onSuccess(ArrayList<TestUser> result) {
			// getWebSectionController().setWebUserList(result);
				if (result != null) {
					getSectionController().setUserList(result);
				} else {
					delayedQueryUserList();
				}
			}
		});
	}

	private void delayedQueryUserList() {
		Timer timer = new Timer() {
			public void run() {
				loadUsersList();
			}
		};
		timer.schedule(delayQueryUploadTime);
	}

}
