package com.teralyx.test.client.section.dataSection.widgets.panels;

import java.util.HashMap;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.bean.TestComponent;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionConstantsIF;
import com.teralyx.test.client.widgets.charts.TestChart;
import com.teralyx.test.client.widgets.loadingPanels.TestLoadingPanel;

public class TestDataRigthPanel extends Composite {

    private TestSectionController sectionController = null;

    private VerticalPanel dataRigthPanel;

    private TestChart chartData;

    private HashMap<String, TestComponent> components = new HashMap<String, TestComponent>();

    private HorizontalPanel titlePanel;

    private TestLoadingPanel loadingPanel;

    private HorizontalPanel charDataPanel;

    public TestDataRigthPanel(TestSectionController sectionController) {
        this.setSectionController(sectionController);
        initialize();

        Handler handler = new Handler();
        Window.addResizeHandler(handler);
    }

    public void initialize() {

        dataRigthPanel = new VerticalPanel();

        initWidget(dataRigthPanel);

        dataRigthPanel.setSize("100%", "610");
        dataRigthPanel.addStyleName("backgroundLeftPanel");

        titlePanel = new HorizontalPanel();
        dataRigthPanel.add(titlePanel);
        dataRigthPanel.setCellHorizontalAlignment(titlePanel, HasHorizontalAlignment.ALIGN_CENTER);
        dataRigthPanel.setCellVerticalAlignment(titlePanel, HasVerticalAlignment.ALIGN_TOP);
        titlePanel.setSize("100%", "35");
        titlePanel.setSpacing(4);
        titlePanel.setStyleName("simpleContainerTitle");
        titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        Label opcionsLabel = new Label("Visualización de Gráficas");
        titlePanel.add(opcionsLabel);
        opcionsLabel.setWidth("100%");
        titlePanel.setCellWidth(opcionsLabel, "100%");
        opcionsLabel.setStyleName("simpleContainerText");

        charDataPanel = new HorizontalPanel();
        dataRigthPanel.add(charDataPanel);
        dataRigthPanel.setCellHorizontalAlignment(charDataPanel, HasHorizontalAlignment.ALIGN_CENTER);
        dataRigthPanel.setCellVerticalAlignment(charDataPanel, HasVerticalAlignment.ALIGN_MIDDLE);
        charDataPanel.setSize("100%", "573");

        chartData = new TestChart(getSectionController(), TestSectionConstantsIF.SECTION_DATA, charDataPanel);

    }

    public void putLoading() {
        int index = charDataPanel.getWidgetIndex(chartData);
        if (index != -1) {
            charDataPanel.remove(index);
        }
        charDataPanel.add(getLoadingPanel());
        charDataPanel.setCellVerticalAlignment(getLoadingPanel(), HasVerticalAlignment.ALIGN_MIDDLE);
        charDataPanel.setCellHorizontalAlignment(getLoadingPanel(), HasHorizontalAlignment.ALIGN_CENTER);
    }

    public void putChart() {
        int index = charDataPanel.getWidgetIndex(getLoadingPanel());
        if (index != -1) {
            charDataPanel.remove(index);
        }

        charDataPanel.add(chartData);
        chartData.setSize("100%", "100%");

    }

    public TestLoadingPanel getLoadingPanel() {
        if (loadingPanel == null) {
            loadingPanel = new TestLoadingPanel("Cargando...");
        }
        return loadingPanel;
    }

    public TestChart getChartData() {
        return chartData;
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    public void setSectionController(TestSectionController sectionController) {
        this.sectionController = sectionController;
    }

    public TestComponent getIdComponent(String component) {
        return components.get(component);
    }

    public HashMap<String, TestComponent> getComponents() {
        return components;
    }

    class Handler implements ResizeHandler {

        public void onResize(ResizeEvent event) {

            getChartData().setXChartSize(100);
            getChartData().setYChartSize(100);

            getChartData().update();
            getChartData().setXChartSize(charDataPanel.getOffsetWidth() - charDataPanel.getAbsoluteLeft());
            getChartData().setYChartSize(charDataPanel.getOffsetHeight() - charDataPanel.getAbsoluteTop());

            getChartData().update();

            getChartData().updateChart();

        }
    }

}
