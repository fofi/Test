package com.teralyx.test.client.section.main;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.controller.TestSectionController;

public class TestStartSessionPanel extends Composite{

	
	private TestSectionController sectionController;

    private VerticalPanel mainVerticalPanel;

    private TextBox userInput;

    private PasswordTextBox passInput;

    private Label messageLabel;

    public TestStartSessionPanel(TestSectionController sectionController) {
        this.sectionController = sectionController;
        initialize();
    }

    private void initialize() {

        mainVerticalPanel = new VerticalPanel();

        initWidget(mainVerticalPanel);

        mainVerticalPanel.setStyleName("loginPanel");
        mainVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        mainVerticalPanel.setSpacing(5);

        // Paneles de validaci�n
        final FlexTable formsTable = new FlexTable();
        mainVerticalPanel.add(formsTable);
        mainVerticalPanel.setCellVerticalAlignment(formsTable, HasVerticalAlignment.ALIGN_TOP);
        mainVerticalPanel.setCellHorizontalAlignment(formsTable, HasHorizontalAlignment.ALIGN_LEFT);
        // absolutePanel.add(formsTable, 56, 93);
        formsTable.setCellSpacing(3);
        formsTable.setCellPadding(0);

        final Label userLabel = new Label("Usuario");
        formsTable.setWidget(0, 0, userLabel);
        formsTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
        userLabel.setStyleName("textContentWhite");

        userInput = new TextBox();
        formsTable.setWidget(1, 0, userInput);
        userInput.setText("admin");
        userInput.setSize("250", "30");
        formsTable.getCellFormatter().setWidth(1, 0, "250");
        userInput.setTabIndex(1);

        final Label passLabel = new Label("Contraseña");
        formsTable.setWidget(3, 0, passLabel);
        passLabel.setStyleName("textContentWhite");
        formsTable.getCellFormatter().setWidth(5, 0, "95px");

        userInput.setStyleName("textContentBlack");
        formsTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
        userInput.setMaxLength(12);
        passInput = new PasswordTextBox();
        formsTable.setWidget(4, 0, passInput);
        passInput.setText("admin");
        passInput.setSize("250", "30");
        formsTable.getCellFormatter().setWidth(4, 0, "250");
        passInput.setTabIndex(2);

        passInput.setStyleName("textContentBlack");
        formsTable.getCellFormatter().setHorizontalAlignment(10, 0, HasHorizontalAlignment.ALIGN_CENTER);
        passInput.setTextAlignment(TextBoxBase.ALIGN_LEFT);

        mainVerticalPanel.add(formsTable);

        final FlexTable buttonsTable = new FlexTable();
        mainVerticalPanel.add(buttonsTable);
        mainVerticalPanel.setCellVerticalAlignment(buttonsTable, HasVerticalAlignment.ALIGN_TOP);
        mainVerticalPanel.setCellHorizontalAlignment(buttonsTable, HasHorizontalAlignment.ALIGN_CENTER);
        buttonsTable.setCellSpacing(0);

        final Button startSession = new Button();
        TheHandler handlerStart = new TheHandler();
        startSession.addClickHandler(handlerStart);
        buttonsTable.setWidget(0, 0, startSession);
        startSession.setWidth("125");

        startSession.setText("Iniciar sesión");

        final Button cancelSession = new Button();
        buttonsTable.setWidget(0, 1, cancelSession);

        cancelSession.setText("Cancelar");
        cancelSession.setWidth("125");

        final VerticalPanel messagePanel = new VerticalPanel();
        mainVerticalPanel.add(messagePanel);
        messagePanel.setSize("250", "75");
        mainVerticalPanel.setCellHeight(messagePanel, "75");
        mainVerticalPanel.setCellWidth(messagePanel, "250");
        messagePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        messagePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        messageLabel = new Label("");
        messagePanel.add(messageLabel);
        messageLabel.setStyleName(".textContentWhite");
    }

    class TheHandler implements ClickHandler {
        /**
         * Fired when the user clicks on the sendButton.
         */
        public void onClick(ClickEvent event) {

            getSectionController().getControllerAccess().validateUser(getUserInput().getText(), getPassInput().getText());
        }
    }

    public TextBox getUserInput() {
        return userInput;
    }

    public PasswordTextBox getPassInput() {
        return passInput;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    /**
     * @return Returns the webSectionController.
     */
    public TestSectionController getSectionController() {
        return sectionController;
    }
    
    
}
