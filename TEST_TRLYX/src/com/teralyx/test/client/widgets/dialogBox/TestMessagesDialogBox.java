package com.teralyx.test.client.widgets.dialogBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionConstantsIF;

public class TestMessagesDialogBox extends DialogBox {

    private TestSectionController sectionController;

    private Label informtionLabel;

    private String section;

    private Button cancelButton;

    private Button aceptButton;


    public TestMessagesDialogBox(TestSectionController sectionController, String section) {
        super(false);
        this.section = section;
        this.sectionController = sectionController;
        this.setWidth("450");

        if (section.equals(TestSectionConstantsIF.SECTION_VALIDATE)) {
            center();
            setText("Información de Validación de Gráficas");

            VerticalPanel dialogBoxPanel = new VerticalPanel();

            Grid dialogBoxFlexTable = new Grid(1, 2);

            dialogBoxFlexTable.setCellSpacing(1);
            dialogBoxFlexTable.setCellPadding(2);

            VerticalPanel imagePanel = new VerticalPanel();
            Image image = new Image();
            image.setUrl("res/icons/warning.png");
            image.setSize("60", "60");
            imagePanel.add(image);
            imagePanel.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_CENTER);
            imagePanel.setCellVerticalAlignment(image, HasVerticalAlignment.ALIGN_MIDDLE);

            dialogBoxFlexTable.setWidget(0, 0, imagePanel);
            imagePanel.setWidth("100%");

            VerticalPanel informtionLabelPanel = new VerticalPanel();
            informtionLabel = new Label("¿Esta seguro de que de desea guardar los datos modificados?");
            informtionLabelPanel.add(informtionLabel);
            informtionLabelPanel.setCellHorizontalAlignment(informtionLabel, HasHorizontalAlignment.ALIGN_CENTER);
            informtionLabelPanel.setCellVerticalAlignment(informtionLabel, HasVerticalAlignment.ALIGN_MIDDLE);

            dialogBoxFlexTable.setWidget(0, 1, informtionLabelPanel);
            informtionLabelPanel.setWidth("100%");

            HorizontalPanel downHorizontalPanel = new HorizontalPanel();
            downHorizontalPanel.setSpacing(2);

            aceptButton = new Button("Aceptar");
            aceptButton.setWidth("100");

            Handler handler = new Handler(this);
            aceptButton.addClickHandler(handler);

            downHorizontalPanel.add(aceptButton);
            downHorizontalPanel.setCellHorizontalAlignment(aceptButton, HasHorizontalAlignment.ALIGN_CENTER);
            downHorizontalPanel.setCellVerticalAlignment(aceptButton, HasVerticalAlignment.ALIGN_MIDDLE);

        

            dialogBoxPanel.add(dialogBoxFlexTable);
            dialogBoxFlexTable.setWidth("100%");

            dialogBoxPanel.add(downHorizontalPanel);
            downHorizontalPanel.setWidth("100%");

            setWidget(dialogBoxPanel);
            dialogBoxPanel.setWidth("100%");

            removeStyleName("gwt-DialogBox");
            setStyleName("demo-DialogBox2");

        } else if (section.equals(TestSectionConstantsIF.SECTION_DATA)){

            center();
            setText("InformaciÃ³n de GeneraciÃ³n de GrÃ¡ficas");

            VerticalPanel dialogBoxPanel = new VerticalPanel();

            Grid dialogBoxFlexTable = new Grid(1, 2);

            dialogBoxFlexTable.setCellSpacing(1);
            dialogBoxFlexTable.setCellPadding(2);

            VerticalPanel imagePanel = new VerticalPanel();
            Image image = new Image();
            image.setUrl("res/icons/warning.png");
            image.setSize("60", "60");
            imagePanel.add(image);
            imagePanel.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_CENTER);
            imagePanel.setCellVerticalAlignment(image, HasVerticalAlignment.ALIGN_MIDDLE);

            dialogBoxFlexTable.setWidget(0, 0, imagePanel);
            imagePanel.setWidth("100%");

            VerticalPanel informtionLabelPanel = new VerticalPanel();
            informtionLabel = new Label("Â¿Esta seguro de que de desea guardar los datos modificados?");
            informtionLabelPanel.add(informtionLabel);
            informtionLabelPanel.setCellHorizontalAlignment(informtionLabel, HasHorizontalAlignment.ALIGN_CENTER);
            informtionLabelPanel.setCellVerticalAlignment(informtionLabel, HasVerticalAlignment.ALIGN_MIDDLE);

            dialogBoxFlexTable.setWidget(0, 1, informtionLabelPanel);
            informtionLabelPanel.setWidth("100%");

            HorizontalPanel downHorizontalPanel = new HorizontalPanel();
            downHorizontalPanel.setSpacing(2);

            aceptButton = new Button("Aceptar");
            aceptButton.setWidth("100");

            Handler handler = new Handler(this);
            aceptButton.addClickHandler(handler);

            downHorizontalPanel.add(aceptButton);
            downHorizontalPanel.setCellHorizontalAlignment(aceptButton, HasHorizontalAlignment.ALIGN_CENTER);
            downHorizontalPanel.setCellVerticalAlignment(aceptButton, HasVerticalAlignment.ALIGN_MIDDLE);

        

            dialogBoxPanel.add(dialogBoxFlexTable);
            dialogBoxFlexTable.setWidth("100%");

            dialogBoxPanel.add(downHorizontalPanel);
            downHorizontalPanel.setWidth("100%");

            setWidget(dialogBoxPanel);
            dialogBoxPanel.setWidth("100%");

            removeStyleName("gwt-DialogBox");
            setStyleName("demo-DialogBox2");

        }

    }

    class Handler implements ClickHandler {

        private TestMessagesDialogBox messagesDialogBox;

        public Handler(TestMessagesDialogBox messagesDialogBox) {
            this.messagesDialogBox = messagesDialogBox;
        }

        public void onClick(ClickEvent event) {

            Button buttonSelected = (Button) event.getSource();

            if (messagesDialogBox.getSection().equals("Modificar Datos")) {
                hide();
                if (buttonSelected.equals(messagesDialogBox.getCancelButton())) {

                } else if (buttonSelected.equals(messagesDialogBox.getAceptButton())) {



                }
            } else {
                hide();

            }

        }
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    public Label getInformtionLabel() {
        return informtionLabel;
    }

    /**
     * @return Returns the cancelButton.
     */
    public Button getCancelButton() {
        return cancelButton;
    }

    /**
     * @return Returns the aceptButton.
     */
    public Button getAceptButton() {
        return aceptButton;
    }

    /**
     * @return Returns the textButton.
     */
    public String getSection() {
        return section;
    }

    public void setInformtionLabel(Label informtionLabel) {
        this.informtionLabel = informtionLabel;
    }
}
