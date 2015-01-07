package com.teralyx.test.client.model.connection;

import com.teralyx.test.client.section.TestSectionViewIF;

public interface TestConnectionStateViewIF extends TestSectionViewIF {

    public void modifyConnectionStyle(boolean connected);
}
