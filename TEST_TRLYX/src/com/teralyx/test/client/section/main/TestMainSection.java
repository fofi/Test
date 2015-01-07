package com.teralyx.test.client.section.main;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.controller.TestSectionController;

public class TestMainSection extends Composite {

	private TestSectionController sectionController = null;
    
    private TestStartSessionPanel startSessionPanel = null;

    private TestMainMenuWidget menu;
    
    private HorizontalPanel loginDataPanel = null; 
    
    private AbsolutePanel absolutePanel_5;
    
    private Label userLabel;

    private FlowPanel validationPanel;
    
    private VerticalPanel titlePanel;
    
    private AbsolutePanel backgroundPanel;

    private VerticalPanel mainLayoutPanel;

    private HorizontalPanel logosPanel;

    private AbsolutePanel absolutePanel_6;

    private HorizontalPanel footPanel;

    private HorizontalPanel contentContainer;

    private VerticalPanel mainContentPanel;

    private VerticalPanel content;

    private HorizontalPanel menuContainer;

    
    public TestMainSection(TestSectionController sectionController) {
        this.sectionController = sectionController;
        initialize();
    }

    /**
     * @return Returns the webEntrypoint.
     */
    public TestSectionController getSectionController() {
        return sectionController;
    }

    private void initialize() {

        backgroundPanel = new AbsolutePanel();
        initWidget(backgroundPanel);
        backgroundPanel.setStyleName("mainBackground");
        mainLayoutPanel = new VerticalPanel();

        backgroundPanel.add(mainLayoutPanel);
        mainLayoutPanel.setStyleName("contentText");
        mainLayoutPanel.setSize("100%", "100%");

        titlePanel = new VerticalPanel();
        mainLayoutPanel.add(titlePanel);
        titlePanel.setSize("100%", "90");
        mainLayoutPanel.setCellVerticalAlignment(titlePanel, HasVerticalAlignment.ALIGN_TOP);
        mainLayoutPanel.setCellHorizontalAlignment(titlePanel, HasHorizontalAlignment.ALIGN_CENTER);
        titlePanel.setStyleName("titlePanel");
        titlePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        titlePanel.setTitle("");
 
        validationPanel = new FlowPanel();
        titlePanel.add(validationPanel);
        titlePanel.setCellWidth(validationPanel, "100%");
        titlePanel.setCellHeight(validationPanel, "29");
        validationPanel.setSize("100%", "29");
        validationPanel.setStyleName("userOptionsPanel");
        titlePanel.setCellVerticalAlignment(validationPanel, HasVerticalAlignment.ALIGN_TOP);
        titlePanel.setCellHorizontalAlignment(validationPanel, HasHorizontalAlignment.ALIGN_RIGHT);

        loginDataPanel = new HorizontalPanel();
        validationPanel.add(loginDataPanel);
        loginDataPanel.setSize("35", "27");
        loginDataPanel.setSpacing(2);
        loginDataPanel.setStyleName("userOptionsComponent");
        loginDataPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        loginDataPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

        absolutePanel_5 = new AbsolutePanel();
        loginDataPanel.add(absolutePanel_5);
        loginDataPanel.setCellVerticalAlignment(absolutePanel_5, HasVerticalAlignment.ALIGN_MIDDLE);
        absolutePanel_5.setWidth("5");
 

        logosPanel = new HorizontalPanel();
        titlePanel.add(logosPanel);
        logosPanel.setSize("97%", "50%");
        logosPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

        final Image logoGobiernoVenezuela = new Image();
        logosPanel.add(logoGobiernoVenezuela);
        logoGobiernoVenezuela.setUrl("res/images/logo_Teralyx.png");
        
        final AbsolutePanel absolutePanel = new AbsolutePanel();
        logosPanel.add(absolutePanel);
        absolutePanel.setSize("40", "100%");
        logosPanel.setCellHeight(absolutePanel, "100%");
        logosPanel.setCellWidth(absolutePanel, "1");

        HorizontalPanel contentPanel = new HorizontalPanel();
        mainLayoutPanel.add(contentPanel);
        contentPanel.setSize("100%", "665");
        contentPanel.setStyleName("backgroundPanel");
        contentPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        mainLayoutPanel.setCellVerticalAlignment(contentPanel, HasVerticalAlignment.ALIGN_TOP);
        mainLayoutPanel.setCellHorizontalAlignment(contentPanel, HasHorizontalAlignment.ALIGN_LEFT);

        mainContentPanel = new VerticalPanel();
        contentPanel.add(mainContentPanel);
        mainContentPanel.setStyleName("contentBackground");
        contentPanel.setCellHeight(mainContentPanel, "100%");
        contentPanel.setCellWidth(mainContentPanel, "100%");
        mainContentPanel.setSize("100%", "100%");
        mainContentPanel.setSpacing(0);
        contentPanel.setCellVerticalAlignment(mainContentPanel, HasVerticalAlignment.ALIGN_TOP);
        contentPanel.setCellHorizontalAlignment(mainContentPanel, HasHorizontalAlignment.ALIGN_LEFT);

        menuContainer = new HorizontalPanel();
        mainContentPanel.add(menuContainer);
        menuContainer.setSize("100%", "29");
        menuContainer.add(new Label(""));
        menuContainer.addStyleName("mainBackground");

        mainContentPanel.setCellHeight(menuContainer, "29");
        menuContainer.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        menuContainer.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        mainContentPanel.setCellVerticalAlignment(menuContainer, HasVerticalAlignment.ALIGN_MIDDLE);
        mainContentPanel.setCellHorizontalAlignment(menuContainer, HasHorizontalAlignment.ALIGN_CENTER);
        mainContentPanel.setCellWidth(menuContainer, "100%");
        menuContainer.setSpacing(0);

        absolutePanel_6 = new AbsolutePanel();
        absolutePanel_6.setSize("100%", "10");
        absolutePanel_6.addStyleName("superiorMarginPanel");
        mainContentPanel.add(absolutePanel_6);

        contentContainer = new HorizontalPanel();
        mainContentPanel.add(contentContainer);
        contentContainer.setSize("100%", "100%");
        contentContainer.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        mainContentPanel.setCellHeight(contentContainer, "100%");
        mainContentPanel.setCellWidth(contentContainer, "100%");  

        // contentContainer.setCellWidth(s, "100%");

        footPanel = new HorizontalPanel();
        mainLayoutPanel.add(footPanel);
        footPanel.setSize("100%", "70");
        footPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        mainLayoutPanel.setCellVerticalAlignment(footPanel, HasVerticalAlignment.ALIGN_TOP);
        mainLayoutPanel.setCellHorizontalAlignment(footPanel, HasHorizontalAlignment.ALIGN_LEFT);
        footPanel.setStyleName("footPanel");

        /* Panel de la izquierda de abajo */

        HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
        footPanel.add(horizontalPanel_1);
        horizontalPanel_1.setSize("100%", "70");
        horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        horizontalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        final Label feedBack1 = new Label("Ayudenos a mejorar");
        horizontalPanel_1.add(feedBack1);
        horizontalPanel_1.setCellHorizontalAlignment(feedBack1, HasHorizontalAlignment.ALIGN_RIGHT);
        feedBack1.setStyleName("footComponentCursor");
        final Label label_1 = new Label("|");
        horizontalPanel_1.add(label_1);
        label_1.setStyleName("footComponent");
        horizontalPanel_1.setCellWidth(label_1, "1");
        final Label condicionesDeUsoLabel = new Label("Condiciones de uso");
        horizontalPanel_1.add(condicionesDeUsoLabel);
        condicionesDeUsoLabel.setStyleName("footComponentCursor");
        Image image2 = new Image(null);
        image2.setUrl("res/images/logo_venezuela_es_todos.png");

        /* Panel logo de Venzuela es de todos */
        HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
        horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        horizontalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        footPanel.add(horizontalPanel_2);
        Image image3 = new Image(null);
        image3.setUrl("res/images/logo_venezuela_es_todos.png");
        horizontalPanel_2.add(image3);
        horizontalPanel_2.setSize("100%", "70");

        /* Logo MARN */
        HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
        horizontalPanel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        horizontalPanel_3.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        footPanel.add(horizontalPanel_3);
        horizontalPanel_3.setWidth("100%");
        Image image4 = new Image(null);
        image4.setUrl("res/images/marn.png");
        horizontalPanel_3.add(image4);

        footPanel.setCellWidth(horizontalPanel_1, "33%");
        footPanel.setCellWidth(horizontalPanel_2, "33%");
        footPanel.setCellWidth(horizontalPanel_3, "33%");

        final AbsolutePanel absolutePanel_2 = new AbsolutePanel();
        mainLayoutPanel.add(absolutePanel_2);
        absolutePanel_2.setStyleName("footPanelMargin");
        mainLayoutPanel.setCellHeight(absolutePanel_2, "100%");
        absolutePanel_2.setHeight("100%");
    }
    
    public void addStartSessionPanel() {

        // Se añade el panel de login
        startSessionPanel = new TestStartSessionPanel(getSectionController());
        
        content = new VerticalPanel();
        content.setStyleName("contentBackground");
        content.setSpacing(0);
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        getContent().add(startSessionPanel);
        startSessionPanel.setSize("350", "250");
        getContent().setCellVerticalAlignment(startSessionPanel, HasVerticalAlignment.ALIGN_MIDDLE);
        getContent().setCellHorizontalAlignment(startSessionPanel, HasHorizontalAlignment.ALIGN_CENTER);
        
        contentContainer.add(content);
        content.setSize("100%", "100%");
        contentContainer.setCellHeight(content, "100%");
        contentContainer.setCellWidth(content, "100%");
        contentContainer.setCellVerticalAlignment(content, HasVerticalAlignment.ALIGN_MIDDLE);
        contentContainer.setCellHorizontalAlignment(content, HasHorizontalAlignment.ALIGN_CENTER);
    }

    public void addLogoutDataPanel() {
        userLabel = new Label("Usuario");
        loginDataPanel.add(userLabel);
        loginDataPanel.setCellVerticalAlignment(userLabel, HasVerticalAlignment.ALIGN_MIDDLE);
        userLabel.setWordWrap(false);
        userLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        loginDataPanel.setCellHorizontalAlignment(userLabel, HasHorizontalAlignment.ALIGN_RIGHT);
        userLabel.setStyleName("userOptionsComponentCursor");

        final Label label = new Label("|");
        loginDataPanel.add(label);
        loginDataPanel.setCellVerticalAlignment(label, HasVerticalAlignment.ALIGN_MIDDLE);
        label.setWordWrap(false);
        label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        loginDataPanel.setCellHorizontalAlignment(label, HasHorizontalAlignment.ALIGN_RIGHT);
        label.setStyleName("userOptionsComponent");

        final Label exitLabel = new Label("Salir");
        loginDataPanel.add(exitLabel);
        loginDataPanel.setCellVerticalAlignment(exitLabel, HasVerticalAlignment.ALIGN_MIDDLE);
        exitLabel.setWordWrap(false);
        exitLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        loginDataPanel.setCellHorizontalAlignment(exitLabel, HasHorizontalAlignment.ALIGN_RIGHT);
        exitLabel.setStyleName("userOptionsComponentCursor");

        TheHandler handler = new TheHandler();
        exitLabel.addClickHandler(handler);

    }
    
    public void removeStartSessionPanel() {
        getContent().remove(startSessionPanel);
        getContentContainer().remove(getContent());
    }

//    public void removeUserExitPanel() {
//        int count = contentContainer.getWidgetCount();
//        for (int i = 0; i < count; i++) {
//            contentContainer.remove(0);
//        }
//        getMenu().removeOldButtonsAndStyles();
//        getMenuContainer().remove(getMenu());       
//        count = loginDataPanel.getWidgetCount();
//        for (int i = 0; i < count; i++) {
//            loginDataPanel.remove(0);
//        }
//        getMenuContainer().removeStyleName("menuBarDecorationBottom");
//        getWebSectionController().goToLoginSection();
//        addStartSessionPanel();
//    }
    
    class TheHandler implements ClickHandler {
        /**
         * Fired when the user clicks on the sendButton.
         */
        public void onClick(ClickEvent event) {

          getSectionController().getControllerAccess().delayedExitFromWebApp();
          //removeUserExitPanel();
        }
    }
    
    public FlowPanel getValidationPanel() {
        return validationPanel;
    }
    
    public VerticalPanel getTitlePanel() {
        return titlePanel;
    }
    
    public TestMainMenuWidget getMenu() {
        return menu;
    }

    public void setMenu(TestMainMenuWidget menu) {
        this.menu = menu; 
        getMenuContainer().add(menu);
        getMenuContainer().setStyleName("menuBarDecorationBottom");
        getMenuContainer().setCellHeight(menu, "29");
        getMenuContainer().setCellWidth(menu, "100%");
    }

    public AbsolutePanel getBackgroundPanel() {
        return backgroundPanel;
    }

    public VerticalPanel getMainLayoutPanel() {
        return mainLayoutPanel;
    }

    public HorizontalPanel getLogosPanel() {
        return logosPanel;
    }
    
    public AbsolutePanel getAbsolutePanel_6() {
        return absolutePanel_6;
    }
    
    public HorizontalPanel getFootPanel() {
        return footPanel;
    }

    public VerticalPanel getMainContentPanel() {
        return mainContentPanel;
    }

    public VerticalPanel getContent() {
        return content;
    }

    public HorizontalPanel getMenuContainer() {
        return menuContainer;
    }

    /**
     * @return Returns the startSessionPanel.
     */
    public TestStartSessionPanel getStartSessionPanel() {
        return startSessionPanel;
    }

    /**
     * @return Returns the contentContainer.
     */
    public HorizontalPanel getContentContainer() {
        return contentContainer;
    }

    /**
     * @return Returns the loginDataPanel.
     */
    public HorizontalPanel getLoginDataPanel() {
        return loginDataPanel;
    }

    /**
     * @return Returns the userLabel.
     */
    public Label getUserLabel() {
        return userLabel;
    }
	
	
}
