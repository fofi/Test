package com.teralyx.test.client.section.dataSection.widgets.panels;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.Format;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionConstantsIF;
import com.teralyx.test.client.widgets.combo.TestCombo;

public class TestDataLeftPanel extends Composite {

	private TestSectionController sectionController = null;

    private VerticalPanel dataLeftPanel;

    private VerticalPanel centralMargin;

    private VerticalPanel graphicsForm;

    private DateBox dateBox;

    private DateBox dateBox2;

    private Button buttonGenerate;

    private VerticalPanel parametersForm;

    private Format format;

    private TestCombo reliabilitiesCombo;

    private Button buttonConfigurate;

    private ScrollPanel sp2;

    private VerticalPanel vp76;

    private Label informationLabel;

    public TestDataLeftPanel(TestSectionController sectionController) {
        this.sectionController = sectionController;

        DateTimeFormat dtf = DateTimeFormat.getFormat("dd MMM yyyy - HH:mm");
        format = new DateBox.DefaultFormat(dtf);

        initialize();
    }

    public void initialize() {

        dataLeftPanel = new VerticalPanel();

        initWidget(dataLeftPanel);
        dataLeftPanel.setSize("280", "610");
        dataLeftPanel.addStyleName("backgroundChartLeftPanel");
        centralMargin = new VerticalPanel();
        centralMargin.addStyleName("backgroundStateBarPanel");
        centralMargin.setSize("100%", "72");

        dataLeftPanel.add(centralMargin);

        AbsolutePanel rigthMargin = new AbsolutePanel();
        rigthMargin.setWidth("100%");
        rigthMargin.setHeight("3");
        rigthMargin.addStyleName("backgroundPanel");
        dataLeftPanel.add(rigthMargin);

        graphicsForm = new VerticalPanel();
        graphicsForm.setSize("100%", "465");
        graphicsForm.addStyleName("backgroundStateBarPanel");

        HorizontalPanel titlePanel = new HorizontalPanel();
        graphicsForm.add(titlePanel);
        titlePanel.setSize("100%", "35");
        titlePanel.setSpacing(4);
        titlePanel.setStyleName("simpleContainerTitle");
        titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        Label opcionsLabel = new Label("Formulario GeneraciÃ³n de GrÃ¡ficas");
        titlePanel.add(opcionsLabel);
        opcionsLabel.setWidth("100%");
        titlePanel.setCellWidth(opcionsLabel, "100%");
        opcionsLabel.setStyleName("simpleContainerText");

        // Formulario de Generación de gráficas
        Grid formGrid = new Grid(3, 1);

        FocusPanel fp = new FocusPanel();
        fp.setWidth("100%");
        fp.setHeight("265");

        VerticalPanel storeDataPanel = new VerticalPanel();
        storeDataPanel.setSize("100%", "200");
        // stationDataPanel.setSpacing(10);
        storeDataPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

        Label storeDataTitleLabel = new Label("Parámetros Seleccionados de las Estaciones Meteorológicas");
        storeDataTitleLabel.setStyleName("formTitleText");
        storeDataPanel.add(storeDataTitleLabel);

        Label regionsComboLabel = new Label("ParÃ¡metros:");
        regionsComboLabel.setWidth("80");
        regionsComboLabel.addStyleName("formText");

        storeDataPanel.add(regionsComboLabel);

        FocusPanel lb2 = new FocusPanel();

        lb2.setWidth("260");
        lb2.setHeight("40");

        // sp2 = new ScrollPanel();
        // sp2.setSize("225", "75");
        vp76 = new VerticalPanel();

        lb2.setWidget(vp76);
        vp76.setStyleName("loginPanel");
        vp76.setWidth("100%");
        vp76.setSpacing(2);
        // lb2.setWidget(sp2);
        // vp76.setSpacing(2);

        informationLabel = new Label("(Configure los parámetros)");
        vp76.add(informationLabel);

        storeDataPanel.add(lb2);
        storeDataPanel.setCellHorizontalAlignment(lb2, HasHorizontalAlignment.ALIGN_CENTER);
        storeDataPanel.setCellVerticalAlignment(lb2, HasVerticalAlignment.ALIGN_MIDDLE);

        buttonConfigurate = new Button();
        buttonConfigurate.setText("Configurar parámetros");

        buttonConfigurate.setWidth("250");
        storeDataPanel.add(buttonConfigurate);
        storeDataPanel.setCellHorizontalAlignment(buttonConfigurate, HasHorizontalAlignment.ALIGN_CENTER);
        storeDataPanel.setCellVerticalAlignment(buttonConfigurate, HasVerticalAlignment.ALIGN_MIDDLE);

        fp.setWidget(storeDataPanel);
        formGrid.setWidget(0, 0, fp);

        //       
        VerticalPanel datesPanel = new VerticalPanel();
        datesPanel.setSize("90%", "75");
        // datesPanel.setSpacing(5);
        Label datesTitleLabel = new Label("Rango de Fechas");
        datesTitleLabel.setStyleName("formTitleText");
        datesPanel.add(datesTitleLabel);

        FlexTable datasFlexTable = new FlexTable();
        datasFlexTable.setCellSpacing(1);
        datasFlexTable.setCellPadding(2);

        Label sinceDataLabel = new Label("Desde:");
        sinceDataLabel.setWidth("80");
        sinceDataLabel.addStyleName("formText");
        datasFlexTable.setWidget(0, 0, sinceDataLabel);
        dateBox = new DateBox();
        dateBox.setFormat(format);
        dateBox.setWidth("180");
        datasFlexTable.setWidget(0, 1, dateBox);

        Label toDataLabel = new Label("Hasta:");
        toDataLabel.setWidth("80");
        toDataLabel.addStyleName("formText");
        datasFlexTable.setWidget(1, 0, toDataLabel);
        dateBox2 = new DateBox();
        dateBox2.setFormat(format);
        dateBox2.setWidth("180");
        datasFlexTable.setWidget(1, 1, dateBox2);

        datesPanel.add(datasFlexTable);
        datesPanel.setCellHorizontalAlignment(datasFlexTable, HasHorizontalAlignment.ALIGN_CENTER);
        datesPanel.setCellVerticalAlignment(datasFlexTable, HasVerticalAlignment.ALIGN_TOP);

        formGrid.setWidget(1, 0, datesPanel);

        VerticalPanel buttonPanel = new VerticalPanel();
        buttonPanel.setSize("100%", "25");
        buttonPanel.setSpacing(2);
        buttonGenerate = new Button();
        buttonGenerate.setText("Generar GrÃ¡fica");
        buttonGenerate.setWidth("250");
        buttonPanel.add(buttonGenerate);
        buttonPanel.setCellHorizontalAlignment(buttonGenerate, HasHorizontalAlignment.ALIGN_CENTER);
        buttonPanel.setCellVerticalAlignment(buttonGenerate, HasVerticalAlignment.ALIGN_BOTTOM);

        formGrid.setWidget(2, 0, buttonPanel);

        graphicsForm.add(formGrid);
        graphicsForm.setCellHorizontalAlignment(formGrid, HasHorizontalAlignment.ALIGN_CENTER);
        graphicsForm.setCellVerticalAlignment(formGrid, HasVerticalAlignment.ALIGN_TOP);

        dataLeftPanel.add(graphicsForm);

        AbsolutePanel downMargin = new AbsolutePanel();
        downMargin.setWidth("100%");
        downMargin.setHeight("3");
        downMargin.addStyleName("backgroundPanel");
        dataLeftPanel.add(downMargin);

        parametersForm = new VerticalPanel();
        parametersForm.addStyleName("backgroundStateBarPanel");

        HorizontalPanel parametersFormTitlePanel = new HorizontalPanel();
        parametersForm.add(parametersFormTitlePanel);
        parametersFormTitlePanel.setSize("100%", "35");
        parametersFormTitlePanel.setSpacing(4);
        parametersFormTitlePanel.setStyleName("simpleContainerTitle");
        parametersFormTitlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        Label parametersLabel = new Label("Selector Parámetro de la Gráfica");
        parametersFormTitlePanel.add(parametersLabel);
        parametersLabel.setWidth("100%");
        parametersFormTitlePanel.setCellWidth(parametersLabel, "100%");
        parametersLabel.setStyleName("simpleContainerText");

        VerticalPanel parameterSelectorPanel = new VerticalPanel();

        FlexTable selectorReliabilityFlexTable = new FlexTable();
        selectorReliabilityFlexTable.setCellSpacing(1);
        selectorReliabilityFlexTable.setCellPadding(2);

        Label reliabilityComboLabel = new Label("Grado de Fiabilidad:");
        reliabilityComboLabel.setWidth("130");
        reliabilityComboLabel.addStyleName("formText");
        selectorReliabilityFlexTable.setWidget(0, 0, reliabilityComboLabel);

        reliabilitiesCombo = new TestCombo(getSectionController(), TestSectionConstantsIF.SECTION_DATA);
        reliabilitiesCombo.setWidth("130");
        selectorReliabilityFlexTable.setWidget(0, 1, reliabilitiesCombo);

        parameterSelectorPanel.add(selectorReliabilityFlexTable);
        parameterSelectorPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        parameterSelectorPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        parametersForm.add(parameterSelectorPanel);

        dataLeftPanel.add(parametersForm);
        parametersForm.setSize("100%", "100%");

        /*******/
        TheHandler th = new TheHandler(this);
        buttonGenerate.addClickHandler(th);
        buttonConfigurate.addClickHandler(th);
    }

    class TheHandler implements ClickHandler {
        /**
         * Fired when the user clicks on the sendButton.
         */
        TestDataLeftPanel dataLeftPanel;

        public TheHandler(TestDataLeftPanel dataLeftPanel) {
            this.dataLeftPanel = dataLeftPanel;
        }

        public void onClick(ClickEvent event) {

            Button buttonSelected = (Button) event.getSource();

            if (buttonSelected.equals(buttonGenerate)) {
  

            } else if (buttonSelected.equals(buttonConfigurate)) {


            }
        }

    }

    private TestSectionController getSectionController() {

        return sectionController;
    }

    public Button getButtonGenerate() {
        return buttonGenerate;
    }

    public void setButtonGenerate(Button buttonGenerate) {
        this.buttonGenerate = buttonGenerate;
    }

 
    /**
     * @return Returns the vp76.
     */
    public VerticalPanel getVp76() {
        return vp76;
    }

    /**
     * @return Returns the sp2.
     */
    public ScrollPanel getSp2() {
        return sp2;
    }
    
   /**
     * @return Returns the informationLabel.
     */
    public Label getInformationLabel() {
        return informationLabel;
    }
	
}
