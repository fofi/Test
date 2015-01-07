package com.teralyx.test.client.section.main;

import java.util.HashMap;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.teralyx.test.client.bean.TestUser;
import com.teralyx.test.client.controller.TestSectionController;

public class TestMainMenuWidget extends Composite {

    private HorizontalPanel buttonsContainer;

    private HorizontalPanel horizontalPanel;

    private TestSectionController sectionController;

    private HashMap<String, TestMainMenuButton> buttons = new HashMap<String, TestMainMenuButton>();

    public TestMainMenuWidget(TestSectionController sectionController) {
        this.sectionController = sectionController;
        horizontalPanel = new HorizontalPanel();
        initWidget(horizontalPanel);
        horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        horizontalPanel.setSpacing(0);
        horizontalPanel.setStyleName("menuBar");
        horizontalPanel.setSize("100%", "100%");

        final AbsolutePanel leftMargin = new AbsolutePanel();
        horizontalPanel.add(leftMargin);
        leftMargin.setWidth("30");

        buttonsContainer = new HorizontalPanel();
        horizontalPanel.add(buttonsContainer);
        horizontalPanel.setCellVerticalAlignment(buttonsContainer, HasVerticalAlignment.ALIGN_MIDDLE);
        horizontalPanel.setCellHorizontalAlignment(buttonsContainer, HasHorizontalAlignment.ALIGN_CENTER);
        horizontalPanel.setCellHeight(buttonsContainer, "100%");
        horizontalPanel.setCellWidth(buttonsContainer, "100%");
        buttonsContainer.setSize("100%", "100%");

        final AbsolutePanel rightMargin = new AbsolutePanel();
        horizontalPanel.add(rightMargin);
        rightMargin.setWidth("30");

    }

    public void addButton(TestMainMenuButton button) {
        getButtonsContainer().add(button);
        buttons.put(button.getHistoryToken(), button);
        button.addMenuListener(new TestMenuListenerIF() {
            public void itemSelected(TestMainMenuButton button) {

                unmarkOthers(button);
            }
        });

    }

    private void unmarkOthers(TestMainMenuButton button) {

        for (TestMainMenuButton item : buttons.values()) {

            if (!item.equals(button)) {

                item.setState(false, false);
            }
        }
    }

    private void addSeparator() {
        getButtonsContainer().add(getMenuSeparator());
    }

    private Label getMenuSeparator() {

        Label menuSeparator = new Label("");
        menuSeparator.setSize("0", "100%");
        menuSeparator.setStyleName("menuSeparator");

        return menuSeparator;
    }

    /** Carga los elementos del menú según corresponda al nivel */

    public void loadMenuItems(int value, TestUser wUser) {

        // Añade los botones al menu
        TestMainMenuButton startButton = new TestMainMenuButton(getSectionController(), "INICIO", "1");
        addButton(startButton);
        addSeparator();

        TestMainMenuButton dataButton = null;
        if (wUser.getPermission().isDataVisulization()) {
            dataButton = new TestMainMenuButton(getSectionController(), "DATOS", "4");
            addButton(dataButton);
            addSeparator();
        }



        switch (value) {
        case 1:
            startButton.setState(true, false);
            break;

        case 2:
            dataButton.setState(true, false);
            break;
        default:
            break;
        }

    }

    public void removeOldButtonsAndStyles() {
        horizontalPanel.removeStyleName("menuBar");
        int count = getButtonsContainer().getWidgetCount();
        for (int i = 0; i < count; i++) {
            getButtonsContainer().getWidget(0).removeStyleName("menuButtonBackground");
            getButtonsContainer().remove(0);
        }

    }

    /** Marca el item del menu correspodiente a la seccion */

    public void setMenuSelectedBySection(String token) {
        TestMainMenuButton button = buttons.get(token);
        if (button != null) {

            button.setState(true, false);

        }
    }

    private HorizontalPanel getButtonsContainer() {
        return buttonsContainer;
    }

    public void setWebSectionController(TestSectionController sectionController) {
        this.sectionController = sectionController;
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    public HashMap<String, TestMainMenuButton> getButtons() {
        return buttons;
    }

    public void setButtons(HashMap<String, TestMainMenuButton> buttons) {
        this.buttons = buttons;
    }

}
