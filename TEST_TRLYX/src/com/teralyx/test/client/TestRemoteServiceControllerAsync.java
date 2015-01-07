package com.teralyx.test.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.teralyx.test.client.bean.TestData;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestReliability;
import com.teralyx.test.client.bean.TestSession;
import com.teralyx.test.client.bean.TestStore;
import com.teralyx.test.client.bean.TestStoreStateChange;
import com.teralyx.test.client.bean.TestStoreType;
import com.teralyx.test.client.bean.TestUser;
import com.teralyx.test.client.bean.TestUserType;


public interface TestRemoteServiceControllerAsync {


	
	public void getStores(AsyncCallback<ArrayList<TestStore>> callback);

    public void getStoreTypes(AsyncCallback<ArrayList<TestStoreType>> callback);

    public void getRegionStates(AsyncCallback<ArrayList<TestRegionState>> callback);

    public void getRegions(AsyncCallback<ArrayList<TestRegion>> callback);

    public void getServerConnectionState(AsyncCallback<Boolean> callback);
    
    public void getServerTime(AsyncCallback<Date> callback);

    public void getKMLRegionState(TestRegionState regionState, ArrayList<TestStore> stations, AsyncCallback<String> callback);

    public void getKMLRegion(TestRegion region, ArrayList<TestRegionState> regionStates,
                    HashMap<Integer, ArrayList<TestStore>> stations, int stationTypeId, AsyncCallback<String> callback);

    public void getKMLCountry(ArrayList<TestRegionState> regionStates, HashMap<Integer, ArrayList<TestStore>> stations, int stationTypeId, AsyncCallback<String> callback);

    public void getKMLCountry(AsyncCallback<String> callback);

    public void getDataFromStore(int storeId, Date timeFrom, Date timeTo, AsyncCallback<HashMap<Integer, ArrayList<TestData>>> callback);

    public void getLoggedUser(AsyncCallback<TestUser> callback);

    public void getUserSession(AsyncCallback<TestSession> callback);

    public void moveToSection(String sectionName, AsyncCallback<Void> callback);
    
    public void getStoreStateList(int numberOfStoresState, TestUser wUser, AsyncCallback<ArrayList<TestStoreStateChange>> callback);
    
    public void getStoreStateByStoreId(AsyncCallback<HashMap<Integer, TestStoreStateChange>> callback);
    
    public void getReliabilities(AsyncCallback<ArrayList<TestReliability>> callback);
    
    public void validateUser(String user, String password, AsyncCallback<TestUser> callback);

    public void getNewDataFromStore(int storeId, TestUser wUser, AsyncCallback<ArrayList<TestData>> callback);
    
    public void addNewDataEventListener(int storeId, TestUser wUser, AsyncCallback<Void> callback);
    
    public void removeNewDataEventListener(int storeId, TestUser wUser, AsyncCallback<Void> callback);
    
    public void getLastDataReceivedFrom(int storeId, AsyncCallback<ArrayList<TestData>> callback);
    
    public void exitFromWebApp(AsyncCallback<Boolean> callback);
    
    public void getUsers(AsyncCallback<ArrayList<TestUser>> callback);

    public void getUserTypes(AsyncCallback<ArrayList<TestUserType>> callback);
    
}
