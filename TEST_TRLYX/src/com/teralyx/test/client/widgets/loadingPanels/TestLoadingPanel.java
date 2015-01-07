package com.teralyx.test.client.widgets.loadingPanels;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestLoadingPanel extends Composite {

    private VerticalPanel loadingPanel;
    
    private Image loadingImg;
    
    private Label loadingLabel;
    
    private String loadingText;
    
    public TestLoadingPanel( String loadingText) {
        this.loadingText = loadingText;
        initialize();
    }

    public void initialize() {
        
        loadingPanel = new VerticalPanel();
        
        initWidget(loadingPanel);
        
        loadingPanel.setSize("100%", "100%");
        loadingPanel.setStyleName("loadingPanel");
        
        loadingImg = new Image();
        //loadingImg.setPixelSize(100, 100);

        loadingImg.setUrl("res/loading_mini.gif");
        loadingPanel.add(loadingImg);
        
        loadingLabel= new Label();
        loadingLabel.setText(loadingText);
        loadingLabel.setStyleName("loadingText");
        loadingPanel.add(loadingLabel);

        loadingPanel.setCellHorizontalAlignment(loadingImg, HasHorizontalAlignment.ALIGN_CENTER);
        loadingPanel.setCellVerticalAlignment(loadingImg, HasVerticalAlignment.ALIGN_MIDDLE);
        
        loadingPanel.setCellHorizontalAlignment(loadingLabel, HasHorizontalAlignment.ALIGN_CENTER);
    }
	
}
