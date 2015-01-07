package com.teralyx.test.client.model.connection;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.teralyx.test.client.TestRemoteServiceControllerAsync;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.model.TestModelBase;

public class TestConnectionModel extends TestModelBase{

	 private TestSectionController webSectionController;
	    
	    private TestRemoteServiceControllerAsync remoteServiceController;

	    private Timer queryConnectionTimer = null;

	    private int delayQueryConnectionStateTime = 30000;
	    
	    private boolean connectionState = false;

	    public TestConnectionModel(TestSectionController webSectionController, TestRemoteServiceControllerAsync remoteServiceController) {
	        this.webSectionController = webSectionController;
	        this.remoteServiceController = remoteServiceController;
	        //startModel();
	        requestInitialState();
	    }

	    /**
	     * @return Returns the webIndex.
	     */
	    public TestSectionController getWebSectionController() {
	        return webSectionController;
	    }
	    
	    /**
	     * @return Returns the remoteServiceController.
	     */
	    public TestRemoteServiceControllerAsync getRemoteServiceController() {
	        return remoteServiceController;
	    }

	    public void modifyConnectionStyle(boolean connected) {
	        for (int i = 0; i < getSectionViewList().size(); i++) {
	            TestConnectionStateViewIF oneView = (TestConnectionStateViewIF) getSectionViewList().get(i);
	            oneView.modifyConnectionStyle(connected);
	        }
	    }

	    /**
	     * @return Returns the connectionState.
	     */
	    public boolean getConnectionState() {
	        return connectionState;
	    }

	    /**
	     * @param connectionState The connectionState to set.
	     */
	    public void setConnectionState(boolean connectionState) {
	        this.connectionState = connectionState;
	    }
	    
	    private void requestConnectionState() {
	        getRemoteServiceController().getServerConnectionState(new AsyncCallback<Boolean>() {

	            public void onFailure(Throwable caught) {
	                caught.printStackTrace();
	                //getConnectionModel().
	                setConnectionState(false);
	                delayedConnectionQuery();
	            }

	            public void onSuccess(Boolean result) {
	                //if (getConnectionModel().getConnectionState() != result) {
	                if (getConnectionState() != result) {
	                    //delayedNotifyConnectionState(result);
	                    modifyConnectionStyle(result);
	                }
	                //getConnectionModel().
	                setConnectionState(result);
	                delayedConnectionQuery();

	            }
	        });
	    }
	    
	    public void delayedConnectionQuery() {
	        if (queryConnectionTimer == null) {
	            queryConnectionTimer = new Timer() {
	                public void run() {
	                    requestConnectionState();
	                }
	            };
	        }
	        if ( !isFinish()){
	            queryConnectionTimer.schedule(delayQueryConnectionStateTime);
	        }
	        
	    }

	    
	    private void requestInitialState(){
	        getRemoteServiceController().getServerConnectionState(new AsyncCallback<Boolean>() {
	            public void onFailure(Throwable caught) {
	                caught.printStackTrace();
	                setConnectionState(false);
	            }
	            public void onSuccess(Boolean result) {
	                setConnectionState(result);
	                modifyConnectionStyle(result);
	            }
	        });
	        
	    }
	    @Override
	    public void startModel() {
	        delayedConnectionQuery();
	    }

	
}
