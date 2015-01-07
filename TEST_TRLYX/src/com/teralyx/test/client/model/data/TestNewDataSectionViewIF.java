package com.teralyx.test.client.model.data;

import java.util.ArrayList;

import com.teralyx.test.client.bean.TestData;
import com.teralyx.test.client.section.TestSectionViewIF;

public interface TestNewDataSectionViewIF extends TestSectionViewIF {

	
public void updateNewData(ArrayList<TestData> newDataList);
    
    public void setDeleted(boolean deleted);
    
    public boolean isDeleted();
}
