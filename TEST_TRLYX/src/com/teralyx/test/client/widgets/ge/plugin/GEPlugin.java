package com.teralyx.test.client.widgets.ge.plugin;

import java.util.HashMap;

import com.google.gwt.core.client.JavaScriptObject;
import com.teralyx.test.client.widgets.ge.GEPluginListenerIF;
import com.teralyx.test.client.widgets.ge.GoogleEarthWidget;

public class GEPlugin {

    // private GEPlugin instance;

    public static final int UNITS_PIXELS = KmlXY.UNITS_PIXELS;

    public static final int UNITS_FRACTION = KmlXY.UNITS_FRACTION;

    public static final int UNITS_INSET_PIXELS = KmlXY.UNITS_INSET_PIXELS;

    public static final int ALTITUDE_CLAMP_TO_GROUND = 0;

    public static final int ALTITUDE_RELATIVE_TO_GROUND = 1;

    public static final int ALTITUDE_ABSOLUTE = 2;

    private GENavigationControl navigationControl = null;

    private JavaScriptObject ge;

    private GEPluginNative gePluginNative = null;

    private HashMap<String, KmlPlacemark> kmlPlacemarkList = null;

    /**
     * Never call this yourself. Use {@link GoogleEarthWidget}.getGEPlugin()
     * 
     * @param ge : the real javascript object
     */
    public GEPlugin(JavaScriptObject ge) {
        this.ge = ge;
        navigationControl = new GENavigationControl(ge);
        // instance = this;
        gePluginNative = new GEPluginNative();

    }

    public HashMap<String, KmlPlacemark> getKmlPlacemarkList() {
        if (gePluginNative != null) {
            kmlPlacemarkList = gePluginNative.getKmlPlacemarkList();
        }
        return kmlPlacemarkList;
    }

    public void setKmlPlacemarkList(HashMap<String, KmlPlacemark> kmlPlacemarkList) {
        this.kmlPlacemarkList = kmlPlacemarkList;
    }

    public GEView getView() {
        return new GEView(GEPluginNative.getView(ge));
    }

    public KmlDocument getDocument() {
        return new KmlDocument(GEPluginNative.getDocument(ge));
    }

    public KmlPlacemark createPlacemark(String s) {
        return new KmlPlacemark(GEPluginNative.createPlacemark(ge, s));
    }

    public KmlPoint createPoint(String s) {
        return new KmlPoint(GEPluginNative.createPoint(ge, s));
    }

    public KmlIcon createIcon(String s) {
        return new KmlIcon(GEPluginNative.createIcon(ge, s));
    }

    public KmlLookAt createLookAt(String s) {
        return new KmlLookAt(GEPluginNative.createLookAt(ge, s));
    }

    public KmlScreenOverlay createScreenOverlay(String s) {
        return new KmlScreenOverlay(GEPluginNative.createScreenOverlay(ge, s));
    }

    public KmlFeature parseKml(String s) {
        return new KmlFeature(GEPluginNative.parseKml(ge, s));
    }

    public void fetchKml(String s) {
        GEPluginNative.fetchKml(ge, s);
    }

    /** Does not work ! */
    public String getEarthVersion() {
        return GEPluginNative.getEarthVersion(ge);
    }

    /** Does not work ! */
    public String getPluginVersion() {
        return GEPluginNative.getPluginVersion(ge);
    }

    public KmlFeatures getFeatures() {
        return new KmlFeatures(GEPluginNative.getFeatures(ge));
    }

    /*
     * public void visShow(){ GEPluginNative.navigationControlAuto(ge); }
     */
    public GENavigationControl getNavigationControl() {
        return navigationControl;
    }

    public void setFlyValue(double speed) {
        GEPluginNative.setFlyValue(ge, speed);

    }

    public void setTilt(double value) {
        GEPluginNative.setTilt(ge, value);

    }

    public void addTilt(double value) {
        GEPluginNative.addTilt(ge, value);

    }

    public void flyToElement(String s) {
        GEPluginNative.flyToElement(ge, s);
    }

    public void limpiar() {
        GEPluginNative.limpiar(ge);
    }

    public KmlPlacemark findPlacemark(String name) {
        KmlPlacemark kmlPlacemark = gePluginNative.getKmlPlacemarkList().get(name);
        JavaScriptObject placemarkImpl = null;
        if (kmlPlacemark == null) {

            placemarkImpl = gePluginNative.findPlacemark(ge, name);
        }
        if (placemarkImpl != null) {
            kmlPlacemark = new KmlPlacemark(placemarkImpl);
            gePluginNative.getKmlPlacemarkList().put(name, kmlPlacemark);
        }
        return kmlPlacemark;
    }

    public void ocultar(JavaScriptObject objectName) {
        // System.out.println("Llama a ocultar de GENative");
        GEPluginNative.ocultar(objectName);

    }

    public void unloadPlugin() {
        GEPluginNative.unloadPlugin(ge);
    }

    public void showLayer_TERRAIN(boolean state) {
        GEPluginNative.showLayer_TERRAIN(ge, state);
    }

    public void showLAYER_BORDERS(boolean state) {
        GEPluginNative.showLAYER_BORDERS(ge, state);
    }

    public void showLAYER_REGIONS_BORDERS(boolean state) {
        GEPluginNative.showLAYER_BORDERS(ge, state);
    }

    public void getModel(KmlPlacemark obj) {
        GEPluginNative.animatePlacemark(obj.getImpl());

    }

    public void clear() {
        GEPluginNative.clear(ge);

    }

    public void addEventListener() {

        gePluginNative.addEventListener(ge);
    }

    public void addGEClickEventListener(GEPluginListenerIF listener) {
        gePluginNative.addClicklistener(listener);
        gePluginNative.addEventListener(ge);
        
        

    }

    public KmlNetworkLink createNetworkLink() {
        return new KmlNetworkLink(GEPluginNative.createNetworkLink(ge));
    }

    public KmlLink createLink() {
        return new KmlLink(GEPluginNative.createLink(ge));
    }

    public void release() {
        GEPluginNative.release(ge);

    }
    
    public void setBallon(String content,int width,KmlPlacemark placemark){
        GEPluginNative.setBallon(ge,width,placemark.getImpl(), content);
    }
}
