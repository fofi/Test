package com.teralyx.test.client.model.data;

import java.util.ArrayList;
import java.util.HashMap;

import com.teralyx.test.client.TestRemoteServiceControllerAsync;
import com.teralyx.test.client.bean.TestData;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionViewIF;

public class TestNewDataModel {

private TestSectionController webSectionController;
    
    private TestRemoteServiceControllerAsync remoteServiceController;

    private HashMap<Integer, TestNewDataModelForStore> newDataModelByStationId = new HashMap<Integer, TestNewDataModelForStore>();
    
    public TestNewDataModel(TestSectionController webSectionController, TestRemoteServiceControllerAsync remoteServiceController) {
        this.webSectionController = webSectionController;
        this.remoteServiceController = remoteServiceController;
    }

    /**
     * @return Returns the webSectionController.
     */
    public TestSectionController getSectionController() {
        return webSectionController;
    }

    public void addViewForStation(TestSectionViewIF oneView, int stationId) {
        if (!newDataModelByStationId.containsKey(stationId)) {
        	TestNewDataModelForStore stModel = new TestNewDataModelForStore(getSectionController(), getRemoteServiceController() ,stationId);
            newDataModelByStationId.put(stationId, stModel);
            stModel.addStationNewDataListener(stationId);
        }
        newDataModelByStationId.get(stationId).addView(oneView);
    }

    public void removeViewForStation(TestSectionViewIF oneView, int stationId) {
        newDataModelByStationId.get(stationId).removeView(oneView);
        if (newDataModelByStationId.get(stationId).getSectionViewList().size() == 0) {
        	TestNewDataModelForStore stModel = newDataModelByStationId.get(stationId);
            stModel.removeStationNewDataListener(stationId);
            stModel.stopModel();
            newDataModelByStationId.remove(stationId);
        }
    }

    public ArrayList<TestData> getLastDataList(int storeId) {
        return newDataModelByStationId.get(storeId).getLastDataList();
    }

    public void refresh(int storeId) {
        ArrayList<TestNewDataSectionViewIF> viewsToDelete = newDataModelByStationId.get(storeId).reviewViewList();
        for (int i = 0; i < viewsToDelete.size(); i++) {
            TestSectionViewIF oneView = viewsToDelete.get(i);
            removeViewForStation(oneView, storeId);
        }
    }
    
   
    /**
     * @return Returns the remoteServiceController.
     */
    public TestRemoteServiceControllerAsync getRemoteServiceController() {
        return remoteServiceController;
    }
}
