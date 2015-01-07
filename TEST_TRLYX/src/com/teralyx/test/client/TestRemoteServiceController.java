package com.teralyx.test.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
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

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("remoteController")
public interface TestRemoteServiceController extends RemoteService {

	public ArrayList<TestStore> getStores();

    public ArrayList<TestStoreType> getStoreTypes();

    public ArrayList<TestRegionState> getRegionStates();

    public ArrayList<TestRegion> getRegions();

    public Boolean getServerConnectionState();
    
    public Date getServerTime();

    public String getKMLRegionState(TestRegionState regionState, ArrayList<TestStore> stations);

    public String getKMLRegion(TestRegion region, ArrayList<TestRegionState> regionStates,
                    HashMap<Integer, ArrayList<TestStore>> stations, int stationTypeId);

    public String getKMLCountry(ArrayList<TestRegionState> regionStates, HashMap<Integer, ArrayList<TestStore>> stations, int stationTypeId);

    public String getKMLCountry();

    public HashMap<Integer, ArrayList<TestData>> getDataFromStore(int storeId, Date timeFrom, Date timeTo);

    public TestUser getLoggedUser();

    public TestSession getUserSession();

    public void moveToSection(String sectionName);
	
    public ArrayList<TestStoreStateChange> getStoreStateList(int numberOfStoresState, TestUser wUser);
    
    public HashMap<Integer, TestStoreStateChange> getStoreStateByStoreId();

    public ArrayList<TestReliability> getReliabilities();

    public TestUser validateUser(String user, String password);

    public ArrayList<TestData> getNewDataFromStore(int storeId, TestUser wUser);

	public void addNewDataEventListener(int storeId, TestUser wUser);

	public void removeNewDataEventListener(int storeId, TestUser wUser);

	public ArrayList<TestData> getLastDataReceivedFrom(int storeId);

	public boolean exitFromWebApp();

	public ArrayList<TestUser> getUsers();

	public ArrayList<TestUserType> getUserTypes();
    
}
