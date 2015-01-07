package com.teralyx.test.client.model;

import java.util.ArrayList;

import com.teralyx.test.client.section.TestSectionViewIF;

public abstract class TestModelBase {

protected boolean finish;
    
    private ArrayList<TestSectionViewIF> sectionViewList = new ArrayList<TestSectionViewIF>();
    
    public void addView(TestSectionViewIF oneView){
        if (!sectionViewList.contains(oneView)){
            sectionViewList.add(oneView);
        }
        if (sectionViewList.size() == 1){
            initModel();
        }
    }
    
    public void removeView(TestSectionViewIF oneView){
        if (sectionViewList.contains(oneView)){
            sectionViewList.remove(oneView);
        }
        if (sectionViewList.size() == 0){
            stopModel();
        }
    }

    /**
     * @return Returns the sectionViewList.
     */
    public ArrayList<TestSectionViewIF> getSectionViewList() {
        return sectionViewList;
    }
    
    public void initModel(){
        finish = false;
        startModel();
    }
    
    public abstract void startModel();
    
    public void stopModel(){
        finish = true;
    }

    /**
     * @return Returns the finish.
     */
    public boolean isFinish() {
        return finish;
    }
	
}
