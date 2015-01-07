package com.teralyx.test.client.model.data;

import java.util.ArrayList;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.teralyx.test.client.TestRemoteServiceControllerAsync;
import com.teralyx.test.client.bean.TestData;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.model.TestModelBase;

public class TestNewDataModelForStore extends TestModelBase{

	private TestSectionController webSectionController;

    private TestRemoteServiceControllerAsync remoteServiceController;

    private ArrayList<TestData> lastDataList;

    private int storeId;

    private Timer queryTimer = null;

    private Timer queryRenewTimer = null;
    
    private int delayQueryGetNewDataTime = 30000; //TODO Cambiar a 60000 por lo menos
    
    private Timer queryTimerLastDataReceived = null;    

    private int delayQueryLastDataReceived = 1000; 
    
    private Timer queryTimerAdd = null;

    private Timer queryTimerRemove = null;

    private int delayQueryNewDataListenerTime = 5000; 

    public TestNewDataModelForStore(TestSectionController webSectionController, TestRemoteServiceControllerAsync remoteServiceController,
                    int storeId) {
        this.webSectionController = webSectionController;
        this.remoteServiceController = remoteServiceController;
        this.storeId = storeId;
        //startModel();
    }

    /**
     * @return Returns the webSectionController.
     */
    public TestSectionController getWebSectionController() {
        return webSectionController;
    }

    /**
     * Se piden los datos que el servidor haya guardado para la estacion indicada, hasta el momento.
     */
    private void requestNewDataForStore() {
        // getWebSectionController().
        getRemoteServiceController().getNewDataFromStore(storeId, getWebSectionController().getOnlineUser(),
                        new AsyncCallback<ArrayList<TestData>>() {

                            public void onFailure(Throwable caught) {
                                caught.printStackTrace();
                                //Si hay un fallo en la peticion de datos, se intenta añadir de nuevo la tienda al servidor
                                delayedRenewRegistrationQuery();
                                delayedQuery();
                            }

                            public void onSuccess(ArrayList<TestData> lastDataList) {
                                if (lastDataList == null) {
                                  //Si hay un fallo en la peticion de datos, se intenta añadir de nuevo la tienda al servidor
                                    delayedRenewRegistrationQuery();
                                } else if (lastDataList.size() > 0) {
                                    setLastDataList(lastDataList);
                                    //Se actualizan los datos
                                    updateNewDataForStore();
                                }
                                delayedQuery();
                            }

                        });
    }

    private void delayedQuery() {
        if (queryTimer == null) {
            queryTimer = new Timer() {
                public void run() {
                    if (getSectionViewList().size() > 0) {
                        requestNewDataForStore();
                    }
                }
            };
        }
        if (!isFinish()) {
            queryTimer.schedule(delayQueryGetNewDataTime);
        }

    }

    private void delayedRenewRegistrationQuery() {
        if (queryRenewTimer == null) {
            queryRenewTimer = new Timer() {
                public void run() {
                    // getWebSectionController().
                    addStationNewDataListener(storeId);
                }
            };
        }
        queryRenewTimer.schedule(50);

    }

    /**
     * Indica al servidor que empiece a guardar los nuevos datos que se reciban para la tienda identificada por el storeId
     * 
     * @param stationId
     */
    public void addStationNewDataListener(final int storeId) {
        getRemoteServiceController().addNewDataEventListener(storeId, getWebSectionController().getOnlineUser(), new AsyncCallback<Void>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                delayedQueryAdd(storeId);
            }

            public void onSuccess(Void result) {
                System.out.println("Add new data listener for store " + storeId + " OK");
            }
        });
    }

    private void delayedQueryAdd(final int stationId) {
        queryTimerAdd = new Timer() {
            public void run() {
                addStationNewDataListener(stationId);
            }
        };
        queryTimerAdd.schedule(delayQueryNewDataListenerTime);
    }

    /**
     * Indica al servidor que deje a guardar los nuevos datos que se reciban para la estacion identificada por el stationId
     * 
     * @param stationId
     */
    public void removeStationNewDataListener(final int stationId) {
        getRemoteServiceController().removeNewDataEventListener(stationId, getWebSectionController().getOnlineUser(), new AsyncCallback<Void>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                delayedQueryRemove(stationId);
            }

            public void onSuccess(Void result) {
                System.out.println("Remove new data listener for station " + stationId + " OK");
            }
        });
    }

    private void delayedQueryRemove(final int stationId) {
        queryTimerRemove = new Timer() {
            public void run() {
                removeStationNewDataListener(stationId);
            }
        };
        queryTimerRemove.schedule(delayQueryNewDataListenerTime);
    }

    public void updateNewDataForStore() {
        for (int i = 0; i < getSectionViewList().size(); i++) {
            TestNewDataSectionViewIF oneView = (TestNewDataSectionViewIF) getSectionViewList().get(i);
            oneView.updateNewData(getLastDataList());

        }
    }

    public ArrayList<TestNewDataSectionViewIF> reviewViewList() {
        ArrayList<TestNewDataSectionViewIF> viewsToDelete = new ArrayList<TestNewDataSectionViewIF>();
        for (int i = 0; i < getSectionViewList().size(); i++) {
        	TestNewDataSectionViewIF oneView = (TestNewDataSectionViewIF) getSectionViewList().get(i);
            if (oneView.isDeleted()) {
                viewsToDelete.add(oneView);
            }
        }
        return viewsToDelete;
    }

    /**
     * Recupera el Ãºltimo dato recibido para esta estaciÃ³n, cuando termina lanza el un hilo que refresca cada poco tiempo
     * @param stationId
     */
    private void requestLastDataReceived(final int stationId) {
        getRemoteServiceController().getLastDataReceivedFrom(stationId, new AsyncCallback<ArrayList<TestData>>() {

            public void onFailure(Throwable caught) {
                caught.printStackTrace();
                delayedQueryLastDataReceived(stationId);
                
            }

            public void onSuccess(ArrayList<TestData> result) {
                if (result != null && result.size() > 0) {
                      setLastDataList(result);
                      //Se actualizan los datos
                      updateNewDataForStore();
                  }
                  delayedQuery();
            }
        });
    }
    
    private void delayedQueryLastDataReceived(final int stationId) {
        queryTimerLastDataReceived = new Timer() {
            public void run() {
                requestLastDataReceived(stationId);
            }
        };
        queryTimerLastDataReceived.schedule(delayQueryLastDataReceived);
    }
    
    /**
     * @return Returns the lastDataList.
     */
    public ArrayList<TestData> getLastDataList() {
        return lastDataList;
    }

    /**
     * @param lastDataList The lastDataList to set.
     */
    public void setLastDataList(ArrayList<TestData> lastDataList) {
        this.lastDataList = lastDataList;
    }

    /**
     * @return Returns the remoteServiceController.
     */
    public TestRemoteServiceControllerAsync getRemoteServiceController() {
        return remoteServiceController;
    }
    
    @Override
    public void startModel() {
        delayedQueryLastDataReceived(storeId);
    }
	
}
