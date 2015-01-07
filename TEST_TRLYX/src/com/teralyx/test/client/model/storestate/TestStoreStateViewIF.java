package com.teralyx.test.client.model.storestate;

import com.teralyx.test.client.bean.TestStoreStateChange;
import com.teralyx.test.client.section.TestSectionViewIF;


public interface TestStoreStateViewIF extends TestSectionViewIF {
    
    public void modifyStationStateChange(TestStoreStateChange stationStateChange);
    
}
