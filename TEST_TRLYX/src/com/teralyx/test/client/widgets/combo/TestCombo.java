package com.teralyx.test.client.widgets.combo;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.teralyx.test.client.bean.TestComboBean;
import com.teralyx.test.client.controller.TestSectionController;

public class TestCombo extends Composite {

	
	private Label label;

    private TestComboBean itemSelected;

    private PopupPanel popPanel = new PopupPanel(true);

    private FocusPanel focusPanel;

    private TestComboPopupPanel popupPanel;

    private ArrayList<TestComboListener> listeners = new ArrayList<TestComboListener>();

    private TestSectionController sectionController;

    private String section;
    
    private boolean hasData = true;

    public TestCombo(TestSectionController sectionController, String section) {

        this.section = section;
        this.setSectionController(sectionController);

        focusPanel = new FocusPanel();
        initWidget(focusPanel);
        focusPanel.setSize("100%", "23");
        focusPanel.setStyleName("comboPanel");

        TheHandler handler = new TheHandler();
        focusPanel.addClickHandler(handler);

        final HorizontalPanel horizontalPanel = new HorizontalPanel();
        focusPanel.setWidget(horizontalPanel);
        horizontalPanel.setSize("100%", "100%");

        label = new Label("");
        horizontalPanel.add(label);
        label.setStyleName("comboText");
        horizontalPanel.setCellVerticalAlignment(label, HasVerticalAlignment.ALIGN_MIDDLE);
        horizontalPanel.setCellHorizontalAlignment(label, HasHorizontalAlignment.ALIGN_LEFT);
        horizontalPanel.setCellHeight(label, "100%");
        horizontalPanel.setCellWidth(label, "100%");
        label.setSize("100%", "100%");

        final Image image = new Image();
        horizontalPanel.add(image);
        image.setSize("19", "23");
        image.setUrl("res/images/flechaCombo.png");
        horizontalPanel.setCellVerticalAlignment(image, HasVerticalAlignment.ALIGN_MIDDLE);
        horizontalPanel.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_CENTER);
        horizontalPanel.setCellHeight(image, "14");
        horizontalPanel.setCellWidth(image, "23");
    }

    /** AÃ±ade un item */
    public void addItem(String text, Object value) {
    	TestComboBean comboBean = new TestComboBean();
        comboBean.setText(text);
        comboBean.setValue(value);
        getPopupPanel().addItem(comboBean);

        // Selecciona el primer elemento
        if (getItemSelected() == null) {
            this.itemSelected = comboBean;
            label.setText(comboBean.getText());
        }
    }

    public void setSelectedItem(TestComboBean itemSelected) {
        this.itemSelected = itemSelected;
        label.setText(itemSelected.getText());
        popPanel.hide();

        for (TestComboListener listener : listeners) {
            listener.itemSelected(getItemSelected());
        }

    }

    public TestComboBean getItemSelected() {
        return itemSelected;
    }

    public Label getLabel() {
        return label;
    }

    public TestComboPopupPanel getPopupPanel() {
        if (popupPanel == null) {
            popupPanel = new TestComboPopupPanel(this, section);
        }

        return popupPanel;
    }

    public void addComboBoxListener(TestComboListener listener) {
        listeners.add(listener);
    }

    public void setSectionController(TestSectionController sectionController) {
        this.sectionController = sectionController;
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }
    
    public boolean HasData() {
		return hasData;
	}

	public void setHasData(boolean hasData) {
		this.hasData = hasData;
	}

    class TheHandler implements ClickHandler {

        public void onClick(ClickEvent event) {
        	if(hasData){
	            popPanel.setStyleName("comboListPanel");
	            popPanel.setWidget(getPopupPanel());
	            int left = focusPanel.getAbsoluteLeft();
	            int top = focusPanel.getAbsoluteTop() + 25;
	            popPanel.setWidth(focusPanel.getOffsetWidth() - 2 + "");
	            popPanel.setPopupPosition(left, top);
	            popPanel.show();
        	}

        }
    }
	
}
