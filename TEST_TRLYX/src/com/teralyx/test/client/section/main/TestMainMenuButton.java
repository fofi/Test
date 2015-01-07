package com.teralyx.test.client.section.main;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.controller.TestSectionController;

public class TestMainMenuButton  extends Composite {

    private VerticalPanel verticalPanel;

    private String historyToken = "";

    private ArrayList<TestMenuListenerIF> menuListeners = new ArrayList<TestMenuListenerIF>();

    private boolean pressed = false;

    private Label menuItem;

    public TestSectionController sectionController;

    public TestMainMenuButton(TestSectionController sectionController, String text, String token) {

        this.sectionController = sectionController;
        this.historyToken = token;

        verticalPanel = new VerticalPanel();
        initWidget(verticalPanel);
        verticalPanel.setStyleName("menuButtonBackground");
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        verticalPanel.setSize("100%", "100%");

        menuItem = new Label(text);
        menuItem.setWordWrap(false);
        menuItem.setStyleName("menuButton");
        menuItem.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        TheHandler handler = new TheHandler();
        menuItem.addClickHandler(handler);
        menuItem.addMouseOutHandler(handler);
        menuItem.addMouseOverHandler(handler);

        verticalPanel.add(menuItem);
        menuItem.setWidth("130");
        verticalPanel.setCellWidth(menuItem, "130");
        verticalPanel.setCellVerticalAlignment(menuItem, HasVerticalAlignment.ALIGN_MIDDLE);
        verticalPanel.setCellHorizontalAlignment(menuItem, HasHorizontalAlignment.ALIGN_CENTER);
    }

    public void setState(boolean pressed, boolean execute) {
        this.pressed = pressed;

        if (pressed) {
            menuItem.setStyleName("menuButtonSelected");
            verticalPanel.setStyleName("menuButtonBackgroundSelected");
            notifyEvent();

            if (execute) {
                changeHistory();
            }

        } else {
            menuItem.setStyleName("menuButton");
            verticalPanel.setStyleName("menuButtonBackground");
        }
    }

    public void setText(String text) {
        menuItem.setText(text);
    }

    private void changeHistory() {
        History.newItem(historyToken);
    }

    public String getHistoryToken() {
        return historyToken;
    }

    public void addMenuListener(TestMenuListenerIF menuListener) {
        menuListeners.add(menuListener);
    }

    public void notifyEvent() {
        for (TestMenuListenerIF listener : menuListeners) {
            listener.itemSelected(this);
        }
    }

    public VerticalPanel getVerticalPanel() {
        return verticalPanel;
    }

    // Create a handler for the sendButton and nameField
    class TheHandler implements ClickHandler, MouseOverHandler, MouseOutHandler {
        /**
         * Fired when the user clicks on the sendButton.
         */
        public void onClick(ClickEvent event) {
            
            Label boton = (Label) event.getSource();

            boolean changeSectionPerformed = getSectionController().changeView(boton.getText());
            if ( changeSectionPerformed ){
                setState(true, false);
            }
//            if (boton.getText().equals(SigreWebSectionConstantsIF.SECTION_START)) {
//                getSectionController().changeView(boton.getText());
//            } else if (boton.getText().equals(SigreWebSectionConstantsIF.SECTION_STORES)) {
//                getSectionController().changeView(boton.getText());
//            } else if (boton.getText().equals(SigreWebSectionConstantsIF.SECTION_DATA)) {
//                getSectionController().changeView(boton.getText());
//            }
        }

        public void onMouseOver(MouseOverEvent event) {
            if (pressed != true) {
                verticalPanel.setStyleName("menuButtonBackgroundSelected2");
            }

        }

        public void onMouseOut(MouseOutEvent event) {
            if (pressed != true) {
                verticalPanel.setStyleName("menuButtonBackground");
            }

        }

    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    public Label getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Label menuItem) {
        this.menuItem = menuItem;
    }

    public void setVerticalPanel(VerticalPanel verticalPanel) {
        this.verticalPanel = verticalPanel;
    }

}
