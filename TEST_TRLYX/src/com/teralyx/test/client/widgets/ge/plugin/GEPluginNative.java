package com.teralyx.test.client.widgets.ge.plugin;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.IncrementalCommand;
import com.google.gwt.user.client.Window;
import com.teralyx.test.client.widgets.ge.GEPluginListenerIF;

public class GEPluginNative {

    private ArrayList<GEPluginListenerIF> clicklistener = null;

    private HashMap<String, KmlPlacemark> kmlPlacemarkList;

    public GEPluginNative() {
        clicklistener = new ArrayList<GEPluginListenerIF>();
        kmlPlacemarkList = new HashMap<String, KmlPlacemark>();
    }

    public HashMap<String, KmlPlacemark> getKmlPlacemarkList() {
        return kmlPlacemarkList;
    }

    public void setKmlPlacemarkList(HashMap<String, KmlPlacemark> kmlPlacemarkList) {
        this.kmlPlacemarkList = kmlPlacemarkList;
    }

    public static native JavaScriptObject createPlacemark(JavaScriptObject ge, String s)/*-{
        return ge.createPlacemark(s);
    }-*/;

    public static native JavaScriptObject createPoint(JavaScriptObject ge, String s)/*-{
        return ge.createPoint(s);
    }-*/;

    public static native JavaScriptObject createIcon(JavaScriptObject ge, String s)/*-{
        return ge.createIcon(s);
    }-*/;

    public static native JavaScriptObject createLookAt(JavaScriptObject ge, String s)/*-{
        return ge.createLookAt(s);
    }-*/;

    public static native JavaScriptObject createScreenOverlay(JavaScriptObject ge, String s)/*-{
        return ge.createScreenOverlay(s);
    }-*/;

    public static native JavaScriptObject getView(JavaScriptObject ge)/*-{
        return ge.getView();
    }-*/;

    public static native JavaScriptObject getDocument(JavaScriptObject ge)/*-{
        return ge.getDocument();
    }-*/;

    public static native JavaScriptObject parseKml(JavaScriptObject ge, String s)/*-{
        return ge.parseKml(s);
    }-*/;

    public static native void fetchKml(JavaScriptObject ge, String s)/*-{
        function finishFetchKml(kmlObject) {

        if (kmlObject) {
           // add the fetched KML to Earth
           currentKmlObject = kmlObject;
           ge.getFeatures().appendChild(currentKmlObject);
        } else {
           debug('Bad KML');
        }
        }
        $wnd.google.earth.fetchKml(ge, s, finishFetchKml);
    }-*/;

    /** Does not work ! */
    public static native String getEarthVersion(JavaScriptObject ge)/*-{
        return ge.getEearthVersion();
    }-*/;

    /** Does not work ! */
    public static native String getPluginVersion(JavaScriptObject ge)/*-{
        return ge.getPluginVersion();
    }-*/;

    public static native JavaScriptObject getFeatures(JavaScriptObject ge)/*-{
        return ge.getFeatures();
    }-*/;

    // ----------------------------------------------------------------------------
    // FUNCIONES NAVIGATION CONTROL
    // ------------------------------------------------------------------------

    public static native void navigationControlShow(JavaScriptObject ge)/*-{
        ge.getNavigationControl().setVisibility(ge.VISIBILITY_SHOW);
    }-*/;

    public static native void navigationControlAuto(JavaScriptObject ge)/*-{
        ge.getNavigationControl().setVisibility(ge.VISIBILITY_AUTO);
    }-*/;

    public static native void navigationControlHide(JavaScriptObject ge)/*-{
        ge.getNavigationControl().setVisibility(ge.VISIBILITY_HIDE);
    }-*/;

    public static native void navigationControlPosTopLeft(JavaScriptObject ge)/*-{
        ge.getNavigationControl().getScreenXY().setXUnits(ge.UNITS_PIXELS);
        ge.getNavigationControl().getScreenXY().setYUnits(ge.UNITS_INSET_PIXELS);
    }-*/;

    public static native void navigationControlPosTopRight(JavaScriptObject ge)/*-{
        ge.getNavigationControl().getScreenXY().setXUnits(ge.UNITS_INSET_PIXELS);
        ge.getNavigationControl().getScreenXY().setYUnits(ge.UNITS_INSET_PIXELS);
    }-*/;

    public static native void navigationControlPosBottomRight(JavaScriptObject ge)/*-{
        ge.getNavigationControl().getScreenXY().setXUnits(ge.UNITS_INSET_PIXELS);
        ge.getNavigationControl().getScreenXY().setYUnits(ge.UNITS_PIXELS);
    }-*/;

    public static native void navigationControlPosBottomLeft(JavaScriptObject ge)/*-{
        ge.getNavigationControl().getScreenXY().setXUnits(ge.UNITS_PIXELS);
        ge.getNavigationControl().getScreenXY().setYUnits(ge.UNITS_PIXELS);
    }-*/;

    // speed to fly
    public static native void setFlyValue(JavaScriptObject ge, double speed)/*-{
        try{
        ge.getOptions().setFlyToSpeed(speed);
        }catch(err){
        }
    }-*/;

    public static native void setTilt(JavaScriptObject ge, double value)/*-{
        var go = function(count) {

        var la = ge.getView().copyAsLookAt(ge.ALTITUDE_RELATIVE_TO_GROUND);
        var tilt = la.getTilt();
        //log(tilt);
        tilt=count+tilt;
        //log(tilt);
        la.setTilt(tilt);
        ge.getView().setAbstractView(la);
        }
        go(value);
    }-*/;

    public static native void addTilt(JavaScriptObject ge, double value)/*-{
        //	alert("Cambiado el Tilt");
        var la = ge.getView().copyAsLookAt(ge.ALTITUDE_RELATIVE_TO_GROUND);
        var tilt = la.getTilt();

        tilt=value+tilt;
        la.setTilt(tilt);
        ge.getView().setAbstractView(la);
        //	alert("Cambiado el Tilt");
    }-*/;

    public static native void flyToElement(JavaScriptObject ge, String elementName)/*-{
        var pm= findPlacemark( ge,elementName );

        debug('Vuelve a visualizar');

        if (pm==null){
        debug('PlaceMark no encontrado');
        }else{
        debug ('Placemark: '+pm);
        ge.getView().setAbstractView(pm.getAbstractView ());
        }
    }-*/;

    public static native void limpiar(JavaScriptObject ge)/*-{
        initializeCurrentKmlObject();
    }-*/;

    public native JavaScriptObject findPlacemark(JavaScriptObject ge, String objetName)/*-{
        var instance =this;
        var findPlacemarkFunction = function findPlacemark(node, namePlaceMark) {
        var debug=false;

        if (debug)
        $wnd.alert ("Ha entrado en Placemark");
        var placemark = null;
        if (debug)
        $wnd.alert("TipoNodoInicial: " + node.getType());

        // Si el tipo de nodo es GEPlugin
        if (node.getType() == 'GEPlugin') {
        if (debug)
        alert("node.getType() == 'GEPlugin'");
        var subNodes = node.getFeatures().getChildNodes(); // Obtengo los nodos
                                        // hijos.
        var length = subNodes.getLength();
        if (debug)
        alert("inside: GEPlugin " + node.getType() + "nodos:" + length);

        for ( var i = 0; i < length; i++) { // Me recorro los hijos buscando mas
                        // hijos
        var subNode = subNodes.item(i);
        if (debug)    
        alert(subNode.getType() + ' :' + i);


        placemark = findPlacemark(subNode, namePlaceMark);

        if (placemark != null) {
        return placemark;
        }else{
        if (debug)
        alert("seguimos buscando GEPlugin i="+i);
        }
        }
        return placemark;
        }

        // Si el tipo de nodo es GEFeatureContainer
        if (node.getType() == 'GEFeatureContainer') {
        //alert("node.getType() == 'GEFeatureContainer'");
        var subNodesGEFeatureContainer = node.getChildNodes();
        var lengthGEFeatureContainer = subNodesGEFeatureContainer.getLength();

        // alert("SubNodos: " + lengthGEFeatureContainer);
        //alert("inside GEFeatureContainer"
        //       + subNodesGEFeatureContainer.getType());

        for ( var j = 0; j < length; j++) {
        var subNodeGEFeatureContainer = subNodesGEFeatureContainer.item(j);
        //   alert('inside GEFeatureContainer:'
        //           + subNodeGEFeatureContainer.getType() + " item: " + j);
        placemark = findPlacemark(subNodeGEFeatureContainer, namePlaceMark);
        if (placemark != null) {
        return placemark;
        }
        }
        return placemark;
        }

        if (node.getType() == 'KmlObjectList') {
        //alert("node.getType() == 'KmlObjectList'");
        var subNodesKmlObjectList = node;
        var lengthsubNodesKmlObjectList = subNodesKmlObjectList.getLength();
        // alert("SubNodos: " + length);
        // alert("inside KmlObjectList" + subNodesKmlObjectList.getType());

        for ( var ji = 0; ji < lengthsubNodesKmlObjectList; ji++) {
        var subNodesubNodesKmlObjectList = subNodes.item(ji);
        // alert('inside KmlObjectList:'
        //         + subNodesubNodesKmlObjectList.getType() + " item: " + ji);
        placemark = findPlacemark(subNodesubNodesKmlObjectList,
        namePlaceMark);
        if (placemark != null) {
        return placemark;
        }
        }

        return placemark;
        }

        if (node.getType() == 'KmlFolder') {
        // alert("node.getType() == 'KmlFolder'");
        var subNodesKmlFolder = node.getFeatures().getChildNodes();
        var lengthKmlFolder = subNodesKmlFolder.getLength();

        // alert("SubNodos: " + lengthKmlFolder);
        // alert("inside KmlFolder:" + subNodesKmlFolder.getType());

        for ( var jij = 0; jij < lengthKmlFolder; jij++) {
        var subNodeKmlFolder = subNodesKmlFolder.item(jij);
        //     alert('inside KmlObjectList:' + subNodeKmlFolder.getType()
        //             + " item: " + jij);
        placemark = findPlacemark(subNodeKmlFolder, namePlaceMark);
        if (placemark != null) {
        return placemark;
        }
        }

        return placemark; 

        }

        //alert("Comienza con el case");
        var nodeType = node.getType();
        var nodeName = node.getName();
        // var nodeID = node.getID();
        //alert(nodeType + '; ' + nodeName + ' ' + nodeID);

        // Una vez ubicada en la etiqueta que buscamos, se ejecuta el metodo
        // correspondiente a cada etiqueta.
        switch (nodeType) {
        //   alert ("Dentro del case: "+nodeType);
        case 'KmlFolder':
        var array = folder(node); // Array con todos los objetos que tiene mi
                // folder.
        // Busco entre todos los objetos de mi array donde esta la vista_Camara
        for ( var i = 0; i < array.length; i++) {
        var name = array[i].getName();
        if (name == 'Vista_Camara') {
        placemark = array[i];
        //alert('Ubicacion_Camara en la iteracion: ' + i);
        }
        }
        return placemark;
        break;

        case 'KmlPlacemark':
        // alert("Entra en KMLPlacemark");
        if (nodeName == namePlaceMark) { // Comprueba que es el Placemark que
                        // estaba buscando
        placemark = node;
        return placemark;
        //    alert ("Encontrado!!!!");
        }else{
        //  alert (nodeName+ "!="+namePlaceMark);
        //                                                                 instance.@com.deimos.enerdataweb.web.client.views.widgets.ge.plugin.GEPluginNative::addPlacemark(Lcom/google/gwt/core/client/JavaScriptObject;)(node);

        //return null;
        }   
        }

        }   
        // alert(" buscar: " +objetName);
        obj=findPlacemarkFunction(ge,objetName);
        if (obj!=null){
        // alert(" encontrado obj");
        }else {
        // alert(" no encontrado");
        }
        return obj;
    }-*/;

    public static native void ocultar(JavaScriptObject objectName)/*-{
        //alert ("Ha entrado en ocultar");		
        objectName.setVisibility(!objectName.getVisibility());
    }-*/;

    public static native void unloadPlugin(JavaScriptObject ge)/*-{
        ge=null;
    }-*/;

    public static native void showLayer_TERRAIN(JavaScriptObject ge, boolean state)/*-{
        var layerRoot = ge.getLayerRoot();
        var terrainLayer = layerRoot.getLayerById(ge.LAYER_TERRAIN);
        if (terrainLayer.getVisibility()) {
        layerRoot.enableLayerById(ge.LAYER_TERRAIN, state);
        } else {
        layerRoot.enableLayerById(ge.LAYER_TERRAIN, state);
        }
    }-*/;

    public static native void showLAYER_BORDERS(JavaScriptObject ge, boolean state)/*-{
        var layerRoot = ge.getLayerRoot();   
        layerRoot.enableLayerById(ge.LAYER_BORDERS, state);
    }-*/;

    public static native void animatePlacemark(JavaScriptObject placemarkObject)/*-{
        var geometry= placemarkObject.getGeometry ();
        alert (geometry.getType());
        var geometries=geometry.getGeometries ();

        if (geometries.hasChildNodes()){

        var subNodes = geometries.getChildNodes(); // Obtengo los nodos

        var length = subNodes.getLength();
        alert("inside: GEPlugin " + subNodes.getType() + "nodos:" + length);

        for ( var i = 0; i < length; i++) { 
        var subNode = subNodes.item(i);  
        alert(subNode.getType() + ' :' + i);
        }


        }
    }-*/;

    public static native JavaScriptObject showImage(JavaScriptObject ge, float posX, float posY, String urlImage)/*-{
        console.info(urlImage);

        // create an image for the screen overlay
        var icon = ge.createIcon('');
        icon.setHref(urlImage);

        // create the screen overlay
        var screenOverlay = ge.createScreenOverlay('');
        screenOverlay.setIcon(icon);

        // Set screen position in fractions.
        screenOverlay.getOverlayXY().setXUnits(ge.UNITS_FRACTION);
        screenOverlay.getOverlayXY().setYUnits(ge.UNITS_FRACTION);

        screenOverlay.getOverlayXY().setX(posX); 
        screenOverlay.getOverlayXY().setY(posY);

        // add the screen overlay to Earth
        ge.getFeatures().appendChild(screenOverlay);
        return screenOverlay;
    }-*/;

    // TODO esto esta un poco experimental todavia
    // TODO ojo se esta borrando todos los objetos, hay que borrar el objeto concreto
    public static native void hideImage(JavaScriptObject ge, JavaScriptObject element2Hide)/*-{
        var c = ge.getFeatures().getFirstChild();

        while (c) {
        var s = c.getNextSibling();
        ge.getFeatures().removeChild(c);
        c = s;
        }
    }-*/;

    // Cambiado codigo, el antiguo es:
    // var c = ge.getFeatures().getFirstChild();
    //    
    // while (c) {
    // var s = c.getNextSibling();
    // ge.getFeatures().removeChild(c);
    // c = s;
    // }
    public static native void clear(JavaScriptObject ge) /*-{
        try{
        while (ge.getFeatures().hasChildNodes()) {
        var c = ge.getFeatures().getFirstChild();
        ge.getFeatures().removeChild(c);
        }
        }catch(err){
        }
    }-*/;

    public native void addEventListener(JavaScriptObject ge)/*-{
        var instance = this;

        $wnd.google.earth.addEventListener(ge.getWindow(), 'click', function(event) {
        var text = 'Click:';
        if (event.getTarget().getType() == 'KmlPlacemark') {
        event.preventDefault();
        var placemark = event.getTarget();


        function addToMessage(append1, append2) {
        text += ' ' + append1 + ': ' + append2 + '\n' ;
        }

        addToMessage('target type', event.getTarget().getType());
        addToMessage('currentTarget type',
        event.getCurrentTarget().getType());
        addToMessage('button', event.getButton());
        addToMessage('clientX', event.getClientX());
        addToMessage('clientY', event.getClientY());
        addToMessage('screenX', event.getScreenX());
        addToMessage('screenY', event.getScreenY());
        addToMessage('latitude', event.getLatitude());
        addToMessage('longitude', event.getLongitude());
        addToMessage('altitude', event.getAltitude());
        addToMessage('didHitGlobe', event.getDidHitGlobe());
        addToMessage('altKey', event.getAltKey());
        addToMessage('ctrlKey', event.getCtrlKey());
        addToMessage('shiftKey', event.getShiftKey());
        addToMessage('timeStamp', event.getTimeStamp());

        // Prevent default balloon from popping up for marker placemarks
        event.preventDefault();
        // alert(text);
        instance.@com.teralyx.test.client.widgets.ge.plugin.GEPluginNative::processClickEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(event);

        }
        });
    }-*/;

    public void addClicklistener(GEPluginListenerIF listener) {
        if (clicklistener != null && !clicklistener.contains(listener)) {
            clicklistener.add(listener);
        }
    }

    @SuppressWarnings("unused")
    private void processClickEvent(JavaScriptObject event) {

        
        
         
        final KmlEvent javaEvent = new KmlEvent(event);
      
        if (javaEvent.getTarget().getType().equalsIgnoreCase("KmlPlacemark")) {
            for (int i = 0; i < clicklistener.size(); i++) {
                final int j = i;
                DeferredCommand.addCommand(new IncrementalCommand() {
                    public boolean execute() {
                        clicklistener.get(j).processGEClickEvent(javaEvent);
                        return false;
                    }
                });

            }
        }

    }

    @SuppressWarnings("unused")
    private void addPlacemark(JavaScriptObject placemarkImpl) {
        try {
            if (placemarkImpl != null) {
                KmlPlacemark KmlPlacemark = new KmlPlacemark(placemarkImpl);
                if (!kmlPlacemarkList.containsKey(KmlPlacemark.getName())) {
                    kmlPlacemarkList.put(KmlPlacemark.getName(), KmlPlacemark);
                }
            }
        } catch (Exception e) {
            Window.alert(e.getMessage());
        }

    }

    public native static JavaScriptObject createNetworkLink(JavaScriptObject ge) /*-{
        return ge.createNetworkLink();
    }-*/;

    public native static JavaScriptObject createLink(JavaScriptObject ge) /*-{
        return ge.createLink();
    }-*/;

    public native static void release(JavaScriptObject ge) /*-{
        ge=null;
    }-*/;
    
    public native static void setBallon(JavaScriptObject ge,int width,JavaScriptObject placemark,String content)/*-{
    var balloon = ge.createHtmlStringBalloon('');
    balloon.setFeature(placemark); 
    balloon.setMaxWidth(width);
    // optional
      balloon.setContentString( content);
      ge.setBalloon(balloon);
    
     }-*/;
}
