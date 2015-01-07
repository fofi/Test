package com.teralyx.test.client.widgets.charts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;








import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gchart.client.GChart;
import com.googlecode.gchart.client.HoverUpdateable;
import com.googlecode.gchart.client.GChart.AnnotationLocation;
import com.googlecode.gchart.client.GChart.Curve;
import com.googlecode.gchart.client.GChart.SymbolType;
import com.googlecode.gchart.client.GChart.Curve.Point;
import com.teralyx.test.client.bean.TestComponent;
import com.teralyx.test.client.bean.TestData;
import com.teralyx.test.client.bean.TestParameterComponent;
import com.teralyx.test.client.bean.TestReliability;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.section.TestSectionConstantsIF;

public class TestChart extends GChart {

    private TestSectionController sectionController;

    private String section;

    private TestComponent testComponent;

    private HashMap<TestComponent, ArrayList<TestData>> componentDatas = null;

    private CellPanel parentPanel;

    private HashMap<Double, TestData> dataListUpdatedCurve1 = new HashMap<Double, TestData>();

    private HashMap<Double, TestData> dataListUpdatedCurve2 = new HashMap<Double, TestData>();

    public TestChart(TestSectionController sectionController, String section, CellPanel parentPanel) {

        super(parentPanel.getOffsetWidth() - parentPanel.getAbsoluteLeft(), (parentPanel.getOffsetHeight() - parentPanel.getAbsoluteTop()));

        this.parentPanel = parentPanel;
        this.sectionController = sectionController;
        this.section = section;

        setStyleName("chartPanel");
        setPadding("35px");

        getXAxis().setTickCount(6);
        getXAxis().setTickLabelFormat("=(Date)dd-MM-yy HH:mm");

        getYAxis().setTickCount(11);
        getYAxis().setTickLabelFormat("#.##");

        getY2Axis().setTickCount(11);
        getY2Axis().setTickLabelFormat("#.##;(#.##)");

        Handler handler = new Handler();
        addClickHandler(handler);
    }

    class Handler implements ClickHandler {

        public void onClick(ClickEvent event) {
            if (section.equals(TestSectionConstantsIF.SECTION_DATA)) {
            	
            } else if (section.equals(TestSectionConstantsIF.SECTION_VALIDATE)) {

                // getTouchedCurve().getPoint().getX()+" "+getTouchedCurve().getPoint().getY();

            }
        }

    }

    @SuppressWarnings("unchecked")
    public void createChart(HashMap<TestComponent, ArrayList<TestData>> componentDatas) {

        deleteDataChart();
        setComponentDatas(componentDatas);
        Iterator it = componentDatas.entrySet().iterator();
        boolean first = true;


        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            TestComponent component = (TestComponent) map.getKey();
            ArrayList<TestData> wDataList = componentDatas.get(component);

            if (first) {
            	TestParameterComponent sigreWebParameterComponent = (TestParameterComponent) component;

                String yAxisLabel = component.getComponentName() + " ";
                String yAxisLabelAux = "<font color='#FF0000'><center><small>";
                for (int i = 0; i < yAxisLabel.length(); i++) {
                    yAxisLabelAux = yAxisLabelAux + yAxisLabel.substring(i, i + 1) + "<br>";
                }
                yAxisLabelAux = yAxisLabelAux + "(" + sigreWebParameterComponent.getParameterType().getUnit().getSmiUnit() + ")"
                                + "</small></center></font>";
                getYAxis().setAxisLabel(yAxisLabelAux);

                addCurve();

                for (int i = 0; i < wDataList.size(); i++) {
                    TestData data = wDataList.get(i);
                    getCurve().getSymbol().setSymbolType(SymbolType.LINE);
                    if (section.equals(TestSectionConstantsIF.SECTION_VALIDATE)) {
                        HoverUpdateable hoverWidget = new CurveEditingForm();
                        getCurve().getSymbol().setHoverWidget(hoverWidget);
                        getCurve().getSymbol().setHoverLocation(AnnotationLocation.WEST);
                        getCurve().getSymbol().setFillThickness(2);
                        getCurve().getSymbol().setFillSpacing(1);
                    } else {

                        getCurve().getSymbol().setSymbolType(SymbolType.LINE);
                        getCurve().getSymbol().setFillThickness(2);
                        getCurve().getSymbol().setBorderWidth(2);
                        getCurve().getSymbol().setWidth(0);
                        getCurve().getSymbol().setHeight(0);

                    }

                    if (data.getReliability() == 1) {

                        getCurve().getSymbol().setBorderColor("red");
                        getCurve().getSymbol().setBackgroundColor("red");
                        getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                        if (((i + 1) < wDataList.size())) {
                            TestData data2 = wDataList.get(i + 1);

                            getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));

                        }

                    } else if (data.getReliability() == 2) {
                        getCurve().getSymbol().setBorderColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);
                        getCurve().getSymbol().setBackgroundColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);
                        getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                        if (((i + 1) < wDataList.size())) {
                            TestData data2 = wDataList.get(i + 1);

                            getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));

                        }
                    } else if (data.getReliability() == 3) {
                        getCurve().getSymbol().setBorderColor(TestSectionConstantsIF.LOW_RELIABILITY_COLOR);
                        getCurve().getSymbol().setBackgroundColor(TestSectionConstantsIF.LOW_RELIABILITY_COLOR);
                        getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                        if (((i + 1) < wDataList.size())) {
                            TestData data2 = wDataList.get(i + 1);
                            getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));
                        }
                    }
                    getCurve().setYAxis(Y_AXIS);
                    addCurve();
                }

                getY2Axis().setAxisLabel(" ");

                first = false;
            } else {

                TestParameterComponent testParameterComponent = (TestParameterComponent) component;

                String y2AxisLabel = component.getComponentName() + " ";

                String y2AxisLabelAux = "<font color='#0066FF'><center><small>";

                for (int i = 0; i < y2AxisLabel.length(); i++) {
                    y2AxisLabelAux = y2AxisLabelAux + y2AxisLabel.substring(i, i + 1) + "<br>";
                }

                y2AxisLabelAux = y2AxisLabelAux + "(" + testParameterComponent.getParameterType().getUnit().getSmiUnit() + ")"
                                + "</small></center></font>";

                getY2Axis().setAxisLabel(y2AxisLabelAux);

                getY2Axis().setAxisMax(maxArray(wDataList));
                getY2Axis().setAxisMin(minArray(wDataList));

                addCurve();

                for (int i = 0; i < wDataList.size(); i++) {
                    TestData data = wDataList.get(i);

                    getCurve().getSymbol().setSymbolType(SymbolType.LINE);

                    if (section.equals(TestSectionConstantsIF.SECTION_VALIDATE)) {
                        HoverUpdateable hoverWidget = new CurveEditingForm();
                        getCurve().getSymbol().setHoverWidget(hoverWidget);
                        getCurve().getSymbol().setHoverLocation(AnnotationLocation.WEST);
                        getCurve().getSymbol().setFillThickness(2);
                        getCurve().getSymbol().setFillSpacing(1);
                    } else {

                        getCurve().getSymbol().setSymbolType(SymbolType.LINE);
                        getCurve().getSymbol().setFillThickness(2);
                        getCurve().getSymbol().setBorderWidth(2);
                        getCurve().getSymbol().setWidth(0);
                        getCurve().getSymbol().setHeight(0);

                    }

                    if (data.getReliability() == 1) {
                        getCurve().getSymbol().setBorderColor("blue");
                        getCurve().getSymbol().setBackgroundColor("blue");

                        getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                        if (((i + 1) < wDataList.size())) {
                            TestData data2 = wDataList.get(i + 1);

                            getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));

                        }

                    } else if (data.getReliability() == 2) {
                        getCurve().getSymbol().setBorderColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);
                        getCurve().getSymbol().setBackgroundColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);

                        getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                        if (((i + 1) < wDataList.size())) {
                            TestData data2 = wDataList.get(i + 1);

                            getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));

                        }
                    } else if (data.getReliability() == 3) {
                        getCurve().getSymbol().setBorderColor(TestSectionConstantsIF.LOW_RELIABILITY_COLOR);
                        getCurve().getSymbol().setBackgroundColor(TestSectionConstantsIF.LOW_RELIABILITY_COLOR);

                        getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                        if (((i + 1) < wDataList.size())) {
                        	TestData data2 = wDataList.get(i + 1);
                            getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));
                        }
                    }
                    getCurve().setYAxis(Y2_AXIS);

                    addCurve();
                }

            }
            updateChart();
        }
    }

    @SuppressWarnings("unchecked")
    public void updateReliability(TestReliability webReliability) {

        deleteDataChart();

        setTestComponent(testComponent);

        int reliabilityValue = webReliability.getReliabilityValue();

        if (reliabilityValue != 3) {

            Iterator it = componentDatas.entrySet().iterator();
            boolean first = true;

            while (it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                TestComponent component = (TestComponent) map.getKey();

                ArrayList<TestData> wDataListAux = componentDatas.get(component);
                ArrayList<TestData> wDataList = new ArrayList<TestData>();

                for (int i = 0; i < wDataListAux.size(); i++) {
                	TestData data = wDataListAux.get(i);

                    if (data.getReliability() <= reliabilityValue) {
                        wDataList.add(data);

                    }
                }

                if (first) {
                    TestParameterComponent sigreWebParameterComponent = (TestParameterComponent) component;

                    String yAxisLabel = component.getComponentName() + " ";
                    String yAxisLabelAux = "<font color='#FF0000'><center><small>";
                    for (int i = 0; i < yAxisLabel.length(); i++) {
                        yAxisLabelAux = yAxisLabelAux + yAxisLabel.substring(i, i + 1) + "<br>";
                    }
                    yAxisLabelAux = yAxisLabelAux + "(" + sigreWebParameterComponent.getParameterType().getUnit().getSmiUnit() + ")"
                                    + "</small></center></font>";
                    getYAxis().setAxisLabel(yAxisLabelAux);

                    addCurve();

                    for (int i = 0; i < wDataList.size(); i++) {

                        TestData data = wDataList.get(i);
                        getCurve().getSymbol().setSymbolType(SymbolType.LINE);
                        getCurve().getSymbol().setFillThickness(2);
                        getCurve().getSymbol().setBorderWidth(2);
                        getCurve().getSymbol().setWidth(0);
                        getCurve().getSymbol().setHeight(0);

                        if (data.getReliability() == 1) {

                            getCurve().getSymbol().setBorderColor("red");
                            getCurve().getSymbol().setBackgroundColor("red");

                            getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                            if (((i + 1) < wDataList.size())) {
                            	TestData data2 = wDataList.get(i + 1);
                                getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));
                            }

                        } else if (data.getReliability() == 2) {

                            getCurve().getSymbol().setBorderColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);
                            getCurve().getSymbol().setBackgroundColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);
                            getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                            if (((i + 1) < wDataList.size())) {
                            	TestData data2 = wDataList.get(i + 1);

                                getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));

                            }
                        }
                        getCurve().setYAxis(Y_AXIS);
                        addCurve();
                    }

                    getY2Axis().setAxisLabel(" ");

                    first = false;
                } else {

                    TestParameterComponent sigreWebParameterComponent = (TestParameterComponent) component;

                    String y2AxisLabel = component.getComponentName() + " ";

                    String y2AxisLabelAux = "<font color='#0066FF'><center><small>";

                    for (int i = 0; i < y2AxisLabel.length(); i++) {
                        y2AxisLabelAux = y2AxisLabelAux + y2AxisLabel.substring(i, i + 1) + "<br>";
                    }

                    y2AxisLabelAux = y2AxisLabelAux + "(" + sigreWebParameterComponent.getParameterType().getUnit().getSmiUnit() + ")"
                                    + "</small></center></font>";

                    getY2Axis().setAxisLabel(y2AxisLabelAux);

                    getY2Axis().setAxisMax(maxArray(wDataList));
                    getY2Axis().setAxisMin(minArray(wDataList));

                    addCurve();

                    for (int i = 0; i < wDataList.size(); i++) {
                        TestData data = wDataList.get(i);

                        getCurve().getSymbol().setSymbolType(SymbolType.LINE);
                        getCurve().getSymbol().setFillThickness(2);
                        getCurve().getSymbol().setBorderWidth(2);
                        getCurve().getSymbol().setWidth(0);
                        getCurve().getSymbol().setHeight(0);

                        if (data.getReliability() == 1) {

                            getCurve().getSymbol().setBorderColor("blue");
                            getCurve().getSymbol().setBackgroundColor("blue");

                            getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                            if (((i + 1) < wDataList.size())) {
                            	TestData data2 = wDataList.get(i + 1);

                                getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));

                            }

                        } else if (data.getReliability() == 2) {
                            if (section.equals(TestSectionConstantsIF.SECTION_VALIDATE)) {
                                HoverUpdateable hoverWidget = new CurveEditingForm();
                                getCurve().getSymbol().setHoverWidget(hoverWidget);
                                getCurve().getSymbol().setHoverLocation(AnnotationLocation.WEST);
                            }

                            getCurve().getSymbol().setBorderColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);
                            getCurve().getSymbol().setBackgroundColor(TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR);

                            getCurve().addPoint(data.getDateTime().getTime(), Float.parseFloat(data.getValue()));

                            if (((i + 1) < wDataList.size())) {
                                TestData data2 = wDataList.get(i + 1);

                                getCurve().addPoint(data2.getDateTime().getTime(), Float.parseFloat(data2.getValue()));

                            }
                        }
                        getCurve().setYAxis(Y2_AXIS);

                        addCurve();
                    }

                }
                updateChart();
            }

        } else {
            createChart(getComponentDatas());
        }
    }

    @SuppressWarnings("unchecked")
    public void changeData(Point point, int reliability) {

        Iterator it = componentDatas.entrySet().iterator();

        boolean firstPosition = true;
        boolean yAxis;

        if (!point.getParent().onY2()) {
            yAxis = true;
        } else {
            yAxis = false;
        }

        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            ArrayList<TestData> wDataList = (ArrayList<TestData>) map.getValue();
            if (firstPosition == true && yAxis == true) {

                for (int i = 0; i < wDataList.size(); i++) {
                	TestData wData = wDataList.get(i);

                    if (wData.getDateTime().getTime() == (long) point.getX()) {
                        wData.setReliability(reliability);
                        dataListUpdatedCurve1.put(point.getX(), wData);
                    }
                }

            } else if (firstPosition == false && yAxis == false) {
                for (int i = 0; i < wDataList.size(); i++) {
                	TestData wData = wDataList.get(i);

                    if (wData.getDateTime().getTime() == (long) point.getX()) {
                        wData.setReliability(reliability);
                        dataListUpdatedCurve2.put(point.getX(), wData);
                    }
                }
            }
            firstPosition = false;

        }

    }

    public void updateChart() {

        setXChartSize(parentPanel.getOffsetWidth());
        setYChartSize(parentPanel.getOffsetHeight());
        // setPadding("35px");

        update();

        int borderX = this.getOffsetWidth() - this.getXChartSize();

        int borderY = this.getOffsetHeight() - this.getYChartSize();
        setXChartSize(this.getXChartSize() - borderX);
        setYChartSize(this.getYChartSize() - borderY);
        update();
    }

    public void deleteDataChart() {
        clearCurves();
        update();
    }

    @SuppressWarnings("unchecked")
    public float maxArray(ArrayList<TestData> arraySigreWebData) {

        if (section.equals(TestSectionConstantsIF.SECTION_VALIDATE)) {
            HoverUpdateable hoverWidget = new CurveEditingForm();
            getCurve().getSymbol().setHoverWidget(hoverWidget);
            getCurve().getSymbol().setHoverLocation(AnnotationLocation.WEST);
        }

        ArrayList<TestData> arraySigreWebDataAux = (ArrayList<TestData>) arraySigreWebData.clone();

        Collections.sort(arraySigreWebDataAux);
        Float f = Float.parseFloat(arraySigreWebDataAux.get(0).getValue());
        return f;
    }

    @SuppressWarnings("unchecked")
    public float minArray(ArrayList<TestData> arraySigreWebData) {
        ArrayList<TestData> arraySigreWebDataAux = (ArrayList<TestData>) arraySigreWebData.clone();

        Collections.sort(arraySigreWebDataAux);
        Float f = Float.parseFloat(arraySigreWebDataAux.get(arraySigreWebDataAux.size() - 1).getValue());

        return f;
    }

    public void changeLabels(TestComponent sigreWebComponent) {
        TestParameterComponent sigreWebParameterComponent = (TestParameterComponent) sigreWebComponent;

        String yAxisLabel = sigreWebParameterComponent.getComponentName() + " ";

        String yAxisLabelAux = "<center><small>";

        for (int i = 0; i < yAxisLabel.length(); i++) {
            yAxisLabelAux = yAxisLabelAux + yAxisLabel.substring(i, i + 1) + "<br>";
        }

        yAxisLabelAux = yAxisLabelAux + "(" + sigreWebParameterComponent.getParameterType().getUnit().getSmiUnit() + ")" + "</small></center>";

        getYAxis().setAxisLabel(yAxisLabelAux);

    }

    public void setComponentDatas(HashMap<TestComponent, ArrayList<TestData>> componentDatas) {
        this.componentDatas = componentDatas;
    }

    public HashMap<TestComponent, ArrayList<TestData>> getComponentDatas() {
        return componentDatas;
    }

    public String getSection() {
        return section;
    }

    class CurveEditingForm extends VerticalPanel implements HoverUpdateable {

        final String[] colorCurve1 = { "red", TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR, TestSectionConstantsIF.LOW_RELIABILITY_COLOR };

        final String[] colorCurve2 = { "blue", TestSectionConstantsIF.MEDIUM_RELIABILITY_COLOR, TestSectionConstantsIF.LOW_RELIABILITY_COLOR };

        final ArrayList<String> colorLabels = new ArrayList<String>();

        final SymbolType[] symbol = { SymbolType.VBAR_SOUTH, SymbolType.BOX_CENTER, SymbolType.PIE_SLICE_HATCHED_SHADING };

        CurveEditingForm() {

            initializeColors();
            setStyleName("monitorStyle7");
            add(new HTML()); // to hold label for color radio-group
            for (int i = 0; i < colorLabels.size(); i++) {
                RadioButton radioButton = new RadioButton("color", colorLabels.get(i));
                radioButton.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        String label = ((RadioButton) event.getSource()).getText();

                        if (!getTouchedCurve().onY2()) {
                            getTouchedCurve().getSymbol().setBorderColor(colorCurve1[colorLabels.indexOf(label)]);
                            getTouchedCurve().getSymbol().setBackgroundColor(colorCurve1[colorLabels.indexOf(label)]);
                        } else {
                            getTouchedCurve().getSymbol().setBorderColor(colorCurve2[colorLabels.indexOf(label)]);
                            getTouchedCurve().getSymbol().setBackgroundColor(colorCurve2[colorLabels.indexOf(label)]);
                        }

                        changeData(getTouchedPoint(), colorLabels.indexOf(label) + 1);
                        update();
                    }
                });
                add(radioButton);
            }
            add(new HTML(" ")); // to hold label for symbol radio-group

        }

        private void loadCurveProperties(Curve c) {

            int iWidget = 0;
            ((HTML) getWidget(iWidget)).setHTML("<div style='padding: 0px 0px 5px 0px;'>Grado de Fiabilidad:</div>");
            iWidget++;

            if (!c.onY2()) {
                for (int i = 0; i < colorCurve1.length; i++) {
                    if (colorCurve1[i].equals(c.getSymbol().getBorderColor()))
                        ((RadioButton) getWidget(iWidget)).setValue(true);
                    else
                        ((RadioButton) getWidget(iWidget)).setValue(false);
                    iWidget++;
                }
            } else {
                for (int i = 0; i < colorCurve2.length; i++) {
                    if (colorCurve2[i].equals(c.getSymbol().getBorderColor()))
                        ((RadioButton) getWidget(iWidget)).setValue(true);
                    else
                        ((RadioButton) getWidget(iWidget)).setValue(false);
                    iWidget++;
                }
            }

        }

        public void hoverUpdate(Curve.Point hoveredOver) {
            loadCurveProperties(getTouchedCurve());
        }

        public void hoverCleanup(Curve.Point hoveredAwayFrom) {
        }

        public void initializeColors() {
            ArrayList<TestReliability> reliabilites = getSectionController().getReliabilities();

            for (int i = 0; i < reliabilites.size(); i++) {
                colorLabels.add(reliabilites.get(i).getReliabilityRankDescription());
            }
        }
    }

    public void setTestComponent(TestComponent testComponent) {
        this.testComponent = testComponent;
    }

    public TestComponent getTestComponent() {
        return testComponent;
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    /**
     * @return Returns the dataListUpdatedCurve1.
     */
    public HashMap<Double, TestData> getDataListUpdatedCurve1() {
        return dataListUpdatedCurve1;
    }

    /**
     * @return Returns the dataListUpdatedCurve2.
     */
    public HashMap<Double, TestData> getDataListUpdatedCurve2() {
        return dataListUpdatedCurve2;
    }
}
