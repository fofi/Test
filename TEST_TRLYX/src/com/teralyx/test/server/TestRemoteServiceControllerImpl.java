package com.teralyx.test.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.teralyx.test.client.TestRemoteServiceController;
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
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TestRemoteServiceControllerImpl extends RemoteServiceServlet implements
		TestRemoteServiceController {

	@Override
	public ArrayList<TestStore> getStores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TestStoreType> getStoreTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TestRegionState> getRegionStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TestRegion> getRegions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getServerConnectionState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getServerTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKMLRegionState(TestRegionState regionState,
			ArrayList<TestStore> stations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKMLRegion(TestRegion region,
			ArrayList<TestRegionState> regionStates,
			HashMap<Integer, ArrayList<TestStore>> stations, int stationTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKMLCountry(ArrayList<TestRegionState> regionStates,
			HashMap<Integer, ArrayList<TestStore>> stations, int stationTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKMLCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, ArrayList<TestData>> getDataFromStore(int storeId,
			Date timeFrom, Date timeTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestUser getLoggedUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestSession getUserSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveToSection(String sectionName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TestStoreStateChange> getStoreStateList(
			int numberOfStoresState, TestUser wUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, TestStoreStateChange> getStoreStateByStoreId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TestReliability> getReliabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestUser validateUser(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TestData> getNewDataFromStore(int storeId, TestUser wUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewDataEventListener(int storeId, TestUser wUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNewDataEventListener(int storeId, TestUser wUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TestData> getLastDataReceivedFrom(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exitFromWebApp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<TestUser> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TestUserType> getUserTypes() {
		// TODO Auto-generated method stub
		return null;
	}


}
