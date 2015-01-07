package com.teralyx.test.client.section.startSection.widgets.panels;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.maps.client.MapType;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.event.EarthInstanceHandler;
import com.google.gwt.maps.client.event.MapTypeChangedHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.teralyx.test.client.bean.TestRegion;
import com.teralyx.test.client.bean.TestRegionState;
import com.teralyx.test.client.bean.TestStore;
import com.teralyx.test.client.controller.TestSectionController;
import com.teralyx.test.client.widgets.ge.GEPluginListenerIF;
import com.teralyx.test.client.widgets.ge.plugin.GEPlugin;
import com.teralyx.test.client.widgets.ge.plugin.KmlEvent;
import com.teralyx.test.client.widgets.ge.plugin.KmlFeature;
import com.teralyx.test.client.widgets.ge.plugin.KmlLookAt;
import com.teralyx.test.client.widgets.ge.plugin.KmlPlacemark;
import com.teralyx.test.client.widgets.ge.plugin.KmlPoint;

public class TestStartRigthPanel extends Composite implements GEPluginListenerIF{

	
    private TestSectionController sectionController = null;

    private VerticalPanel mapPanel;

    private HorizontalPanel titlePanel;

    private JavaScriptObject earthController = null;

    private GEPlugin gePlugin = null;

    public MapWidget mapWiget = null;

    private int regionStateActual = 0;

    private int regionActual = 0;

    public TestStartRigthPanel(TestSectionController sectionController) {
        this.sectionController = sectionController;

        initialize();
    }

    public TestSectionController getSectionController() {
        return sectionController;
    }

    public void initialize() {

        mapPanel = new VerticalPanel();

        initWidget(mapPanel);

        mapPanel.setSize("100%", "610");
        mapPanel.addStyleName("backgroundLeftPanel");

        titlePanel = new HorizontalPanel();
        mapPanel.add(titlePanel);
        titlePanel.setSize("100%", "35");
        titlePanel.setSpacing(4);
        titlePanel.setStyleName("simpleContainerTitle");
        titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        Label opcionsLabel = new Label("Ubicación de Estaciones Meteorológicas");
        titlePanel.add(opcionsLabel);
        opcionsLabel.setWidth("100%");
        titlePanel.setCellWidth(opcionsLabel, "100%");
        opcionsLabel.setStyleName("simpleContainerText");

        loadMapWidget();

    }

    private void loadMapWidget() {
        // initilalized = false;
        try {
            mapWiget = new MapWidget();
            mapWiget.addMapType(MapType.getSatelliteMap());
            mapWiget.setCurrentMapType(MapType.getSatelliteMap());

            mapWiget.addMapTypeChangedHandler(new MapTypeChangedHandler() {

                public void onTypeChanged(MapTypeChangedEvent event) {

                    MapType mapType = event.getSender().getCurrentMapType();
                    if (mapType == MapType.getEarthMap()) {
                        loadGeInstanceHanlder();
                    } else if (mapType == MapType.getSatelliteMap()) {
                    } else if (mapType == MapType.getNormalMap()) {
                    }
                }
            });

            // mapPanel.add(mapWiget);
            // mapWiget.setSize("100%", "573");
            // mapWiget.setCurrentMapType(MapType.getEarthMap());

        } catch (Exception e) {
            Window.alert("Error loading maps widget:" + e.getMessage());
        }
    }

    public void loadGeInstanceHanlder() {

        /*
         * Guardamos referencia al objeto JavaScriptObject que nos permite controlar el plugin GE
         */
        mapWiget.getEarthInstance(new EarthInstanceHandler() {

            public void onEarthInstance(EarthInstanceEvent event) {
                final JavaScriptObject earth = event.getEarthInstance();
                earthController = earth;
                if (earth == null) {
                    // Window.alert("Failed to init earth plugin");
                    // mapWiget = new MapWidget();
                    // loadMapWidget();
                    // initilalized = true;
                } else {
                    gePlugin = new GEPlugin(earthController);
                    initializeGeViewAfter(3000);
                }

            }

            private void initializeGeViewAfter(int time) {
                Timer timer = new Timer() {
                    @Override
                    public void run() {
                        initializeGeView();
                        gePluginReady();

                    }
                };
                timer.schedule(time);
            }
        });

        //mapWiget.addMapClickHandler(new Handler());
    }

    public void initializeGeView() {

        if (getGePlugin() != null) {
            getGePlugin().setFlyValue(.5);

            KmlLookAt la = getGePlugin().createLookAt("");
            la.set(8.22639, -65.751, 100, GEPlugin.ALTITUDE_RELATIVE_TO_GROUND, 0, 0, 4750000);
            getGePlugin().getView().setAbstractView(la);

            getGePlugin().getNavigationControl().auto();

            // getGePlugin().fetchKml(GWT.getHostPageBaseURL() + "res/kml/country/venezuela.kml");

            // initilalized = true;

            //getSectionController().getControllerAccess().getKmlCountry2();
            getSectionController().getControllerAccess().getKmlCountry();
        }
    }

    public void viewHidden() {
        if (getGePlugin() != null) {
            getGePlugin().clear();
        }

        if (mapPanel.getWidgetIndex(mapWiget) != -1) {
            mapPanel.remove(mapWiget);
        }
        mapWiget = null;
        earthController = null;
        // gePlugin = null;
        if (getGePlugin() != null) {
            getGePlugin().release();
        }
    }

    public void showMapWidget() {
        if (mapWiget == null) {
            loadMapWidget();
        }
        mapPanel.add(mapWiget);
        mapWiget.setSize("100%", "573");
        mapWiget.setCurrentMapType(MapType.getEarthMap());
    }

    public GEPlugin getGePlugin() {
        return gePlugin;
    }

    public void loadStation(TestStore store) {
        if (getGePlugin() != null) {
            getGePlugin().setFlyValue(.5);
            KmlLookAt la = getGePlugin().createLookAt("");
            la.set(store.getLocalization().getLatitud(), store.getLocalization().getLongitud(), 50, GEPlugin.ALTITUDE_RELATIVE_TO_GROUND, Math
                            .random() * 360, Math.random() * 80, store.getLocalization().getZoom());
            getGePlugin().getView().setAbstractView(la);
        }
    }

    public void loadStateRegion(TestRegionState state, String kml) {
        if (getGePlugin() != null) {
            getGePlugin().clear();
            this.regionStateActual = state.getRegionStateId();

            getGePlugin().setFlyValue(.5);

            KmlPlacemark placemark = getGePlugin().createPlacemark("");
            placemark.setStyleUrl("root://styleMaps#default_copy0+" + "nicon=" + GWT.getHostPageBaseURL() + "/res/flags/" + state.getRegionStateId()
                            + ".png+" + "hicon=" + GWT.getHostPageBaseURL() + "/res/flags/" + state.getRegionStateId() + ".png");
            KmlPoint point = getGePlugin().createPoint("");
            placemark.setGeometry(point);

            point.setLatitude(state.getLocalization().getLatitud());
            point.setLongitude(state.getLocalization().getLongitud());
            placemark.setName(state.getRegionStateName());

            KmlLookAt la = getGePlugin().createLookAt("");
            la.set(state.getLocalization().getLatitud(), state.getLocalization().getLongitud(), 100, GEPlugin.ALTITUDE_RELATIVE_TO_GROUND, 0, 0,
                            state.getLocalization().getZoom());

            getGePlugin().getView().setAbstractView(la);

            getGePlugin().getFeatures().appendChild(placemark);

            kml = kml.replaceAll("<href>", "<href>" + GWT.getHostPageBaseURL());

            kml = kml.replaceAll("<h1><img src='", "<h1><img src='" + GWT.getHostPageBaseURL());

            KmlFeature stationsKml = getGePlugin().parseKml(kml);

            getGePlugin().getFeatures().appendChild(stationsKml);

        }
    }

    public void loadStateRegion(TestRegionState state, String kml, TestStore store) {
        if (getGePlugin() != null) {
            getGePlugin().clear();
            this.regionStateActual = state.getRegionStateId();

            getGePlugin().setFlyValue(.5);

            KmlPlacemark placemark = getGePlugin().createPlacemark("");
            placemark.setStyleUrl("root://styleMaps#default_copy0+" + "nicon=" + GWT.getHostPageBaseURL() + "/res/flags/" + state.getRegionStateId()
                            + ".png+" + "hicon=" + GWT.getHostPageBaseURL() + "/res/flags/" + state.getRegionStateId() + ".png");
            KmlPoint point = getGePlugin().createPoint("");
            placemark.setGeometry(point);

            point.setLatitude(state.getLocalization().getLatitud());
            point.setLongitude(state.getLocalization().getLongitud());
            placemark.setName(state.getRegionStateName());

            KmlLookAt la = getGePlugin().createLookAt("");
            la.set(store.getLocalization().getLatitud(), store.getLocalization().getLongitud(), 50, GEPlugin.ALTITUDE_RELATIVE_TO_GROUND, Math
                            .random() * 360, Math.random() * 80, store.getLocalization().getZoom());
            getGePlugin().getView().setAbstractView(la);

            getGePlugin().getFeatures().appendChild(placemark);

            kml = kml.replaceAll("<href>", "<href>" + GWT.getHostPageBaseURL());

            kml = kml.replaceAll("<h1><img src='", "<h1><img src='" + GWT.getHostPageBaseURL());

            KmlFeature stationsKml = getGePlugin().parseKml(kml);

            getGePlugin().getFeatures().appendChild(stationsKml);

        }
    }

    public void loadKmlRegion(TestRegion region, String kml) {
        if (getGePlugin() != null) {

            this.regionActual = region.getRegionId();
            getGePlugin().clear();

            getGePlugin().setFlyValue(.5);

            kml = kml.replaceAll("<href>", "<href>" + GWT.getHostPageBaseURL());

            kml = kml.replaceAll("<h1><img src='", "<h1><img src='" + GWT.getHostPageBaseURL());
            KmlFeature stationsKml = getGePlugin().parseKml(kml);

            getGePlugin().getFeatures().appendChild(stationsKml);

            KmlLookAt la = getGePlugin().createLookAt("");
            la.set(region.getLocalization().getLatitud(), region.getLocalization().getLongitud(), 100, GEPlugin.ALTITUDE_RELATIVE_TO_GROUND, 0, 0,
                            region.getLocalization().getZoom());
            getGePlugin().getView().setAbstractView(la);

        }
    }

    public void loadKmlCountry(String kml) {
        if (getGePlugin() != null) {
            getGePlugin().clear();

            getGePlugin().setFlyValue(.5);

            getGePlugin().fetchKml(GWT.getHostPageBaseURL() + "res/kml/country/venezuela_2.kml");

            KmlPlacemark placemark = getGePlugin().createPlacemark("");
            placemark.setStyleUrl("root://styleMaps#default_copy0+" + "nicon=" + GWT.getHostPageBaseURL() + "/res/flags/1_1.png+" + "hicon="
                            + GWT.getHostPageBaseURL() + "/res/flags/1_1.png");
            KmlPoint point = getGePlugin().createPoint("");
            placemark.setGeometry(point);

            point.setLatitude(8.22638988494873);
            point.setLongitude(-65.7509994506836);

            getGePlugin().getFeatures().appendChild(placemark);

        }
    }
    
    
    public void loadKmlCountry2(String kml) {
        if (getGePlugin() != null) {
 
            getGePlugin().clear();

            getGePlugin().setFlyValue(.5);

            kml = kml.replaceAll("<href>", "<href>" + GWT.getHostPageBaseURL());

            kml = kml.replaceAll("<h1><img src='", "<h1><img src='" + GWT.getHostPageBaseURL());
            KmlFeature stationsKml = getGePlugin().parseKml(kml);

            getGePlugin().getFeatures().appendChild(stationsKml);

            KmlPlacemark placemark = getGePlugin().createPlacemark("");
            placemark.setStyleUrl("root://styleMaps#default_copy0+" + "nicon=" + GWT.getHostPageBaseURL() + "/res/flags/1_1.png+" + "hicon="
                            + GWT.getHostPageBaseURL() + "/res/flags/1_1.png");
            KmlPoint point = getGePlugin().createPoint("");
            placemark.setGeometry(point);

            point.setLatitude(8.22638988494873);
            point.setLongitude(-65.7509994506836);

            getGePlugin().getFeatures().appendChild(placemark);
        }
    }
    
    /**
     * @return Returns the initilalized.
     */
    public boolean isInitilalized() {
        if (mapWiget != null && mapWiget.isAttached()) {
            return true;
        }
        return false;
        // return initilalized;
    }

    /**
     * @return Returns the regionStateActual.
     */
    public int getRegionStateActual() {
        return regionStateActual;
    }

    /**
     * @return Returns the regionActual.
     */
    public int getRegionActual() {
        return regionActual;
    }

    private void gePluginReady() {
        if (gePlugin != null) {
            gePlugin.addGEClickEventListener(this);
        }
    }

    public void processGEClickEvent(KmlEvent javaEvent) {
        KmlPlacemark placemark = new KmlPlacemark(javaEvent.getTarget().getImpl());
        //String itemName = placemark.getName();

        if (placemark.getId().length() != 0) {
            //String content = " " + "<h1><img src='res/icons/1.png'/>" + "</h1> ";

            // Window.alert(javaEvent.getClientX()+" "+ javaEvent.getClientY());
            // Window.alert(javaEvent.getScreenX()+" "+ javaEvent.getScreenY());

            // PopupPanel pp = new PopupPanel(true);

            // pp.setSize("1000", "1000");
            // pp.add(new Label("ohkla"));
            // pp.setPopupPosition(javaEvent.getClientX(), javaEvent.getClientX());

             /**   
               TestMonitoringStationItemPanel s = new TestMonitoringStoreItemPanel(getSectionController().getStore(Integer.valueOf(placemark.getId())), sectionController); 
               getGePlugin().setBallon(s.toString(), s.getOffsetWidth(), placemark);
             **/
               
            // pp.show();

            // +
            // "instance.@com.teralyx.test.client.widgets.ge.plugin.GEPluginNative::prueba(Lcom/google/gwt/core/client/JavaScriptObject;)(event);"

            // getGePlugin().setBallon(d, monitoring.getOffsetWidth(), placemark);

        }

    }
	
}
