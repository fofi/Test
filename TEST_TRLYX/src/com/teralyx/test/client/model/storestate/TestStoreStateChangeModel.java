package com.teralyx.test.client.model.storestate;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.teralyx.test.client.TestRemoteServiceControllerAsync;
import com.teralyx.test.client.bean.TestStoreStateChange;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.model.TestModelBase;

public class TestStoreStateChangeModel extends TestModelBase {

	    private TestSectionController sectionController;
	    
	    private TestRemoteServiceControllerAsync remoteServiceController;
	    
	    private Timer queryStationStateTimer = null;

	    private Timer queryInitialStationStateTimer = null;

	    private int delayQueryStationStateTime = 30000;
	    
	    private int delayQueryInitialStationStateTime = 1000;
	    
	    private int numberOfStationStateToRequest = 100;
	    
	    private HashMap<Integer, TestStoreStateChange> storeStateByStoreId = new HashMap<Integer, TestStoreStateChange>();

	    public TestStoreStateChangeModel(TestSectionController sectionController, TestRemoteServiceControllerAsync remoteServiceController) {
	        this.sectionController = sectionController;
	        this.remoteServiceController = remoteServiceController;
	        //startModel();
	    }

	    public void modifyStoreStateChange(TestStoreStateChange storeStateChange) {
	    	storeStateByStoreId.put(storeStateChange.getStoreId(), storeStateChange);
	        for (int i = 0; i < getSectionViewList().size(); i++) {
	            TestStoreStateViewIF oneView = (TestStoreStateViewIF) getSectionViewList().get(i);
	            oneView.modifyStationStateChange(storeStateChange);
	        }
	    }
	    
	    public TestStoreStateChange getStationState(int storeId){
	        if ( storeStateByStoreId.containsKey(storeId)){
	            return storeStateByStoreId.get(storeId);
	        }
	        return null;
	    }

	    private void requestStoreStateList() {
	        getRemoteServiceController().getStoreStateList(numberOfStationStateToRequest, getSectionController().getOnlineUser(),
	                        new AsyncCallback<ArrayList<TestStoreStateChange>>() {

	                            public void onFailure(Throwable caught) {
	                                caught.printStackTrace();
	                                delayedStationStateQueryList();
	                            }

	                            public void onSuccess(ArrayList<TestStoreStateChange> result) {
	                                for (int i = 0; result != null && i < result.size(); i++) {
	                                    //getStationStateChangeModel().
	                                    modifyStoreStateChange(result.get(i));
	                                }
	                                delayedStationStateQueryList();
	                            }
	                        });
	    }
	    
	    public void delayedStationStateQueryList() {
	        if (queryStationStateTimer == null) {
	            queryStationStateTimer = new Timer() {
	                public void run() {
	                	requestStoreStateList();
	                }
	            };
	        }
	        if (!isFinish()){
	            queryStationStateTimer.schedule(delayQueryStationStateTime);    
	        }
	        
	    }
	    
	    private void requestInitialStoreState() {
	        getRemoteServiceController().getStoreStateByStoreId( new AsyncCallback<HashMap<Integer, TestStoreStateChange>>(){

	            public void onFailure(Throwable caught) {
	                caught.printStackTrace();
	                delayedInitialStationStateQuery();
	                
	            }

	            public void onSuccess(HashMap<Integer, TestStoreStateChange> result) {
	                if ( result!= null ){
	                    storeStateByStoreId = result;
	                    ArrayList<TestStoreStateChange> wStoreStateChange = new ArrayList<TestStoreStateChange>(result.values());
	                    for (int i = 0; i < wStoreStateChange.size(); i++) {
	                        modifyStoreStateChange(wStoreStateChange.get(i));
	                    }
	                }
	                delayedStationStateQueryList();
	            }
	            
	        });
	    }
	    
	    public void delayedInitialStationStateQuery() {
	        if (queryInitialStationStateTimer == null) {
	            queryInitialStationStateTimer = new Timer() {
	                public void run() {
	                	requestInitialStoreState();
	                }
	            };
	        }
	        if (!isFinish()){
	            queryInitialStationStateTimer.schedule(delayQueryInitialStationStateTime);    
	        }
	        
	    }
	    /**
	     * @return Returns the webSectionController.
	     */
	    public TestSectionController getSectionController() {
	        return sectionController;
	    }

	    /**
	     * @return Returns the remoteServiceController.
	     */
	    public TestRemoteServiceControllerAsync getRemoteServiceController() {
	        return remoteServiceController;
	    }

	    @Override
	    public void startModel() {
	        //delayedStationStateQueryList();
	        delayedInitialStationStateQuery();
	    }
	
}
