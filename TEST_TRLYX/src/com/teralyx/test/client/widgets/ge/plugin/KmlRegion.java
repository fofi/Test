/*
 * KmlRegion.java
 * Created on 27/03/2009
 *
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $
 * $Revision:  $
 * $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlRegion extends KmlObject{

    public KmlRegion(JavaScriptObject impl) {
        super(impl);
       
    }
    

    public void set (KmlLatLonAltBox latLonAltBox, KmlLod lod) {
    	setImpl(getImpl(), latLonAltBox.getImpl(), lod.getImpl());
    }
    
    public native void setImpl(JavaScriptObject impl, JavaScriptObject latLonAltBox, JavaScriptObject lod) /*-{
    impl.set(latLonAltBox, lod);
    }-*/;
    
    public KmlLatLonAltBox 	getLatLonAltBox () {
    	return new KmlLatLonAltBox(getLatLonAltBoxImpl(getImpl()));
    }
    public native JavaScriptObject 	getLatLonAltBoxImpl(JavaScriptObject impl) /*-{
    	return impl.getLatLonAltBox();
    }-*/;
    
    public void setLatLonAltBox (KmlLatLonAltBox latLonAltBox) {
    	setLatLonAltBoxImpl(getImpl(), latLonAltBox.getImpl());
    }
    
    public native void setLatLonAltBoxImpl(JavaScriptObject impl, JavaScriptObject javaScriptObject) /*-{
    	impl.setLatLonAltBox(latLonAltBox);
    }-*/;
    
    public KmlLod getLod () {
    	return new KmlLod(getLodImpl(getImpl()));
    }
    
    public native JavaScriptObject getLodImpl(JavaScriptObject impl) /*-{
    	return impl.getLod();
    }-*/;
    
    public void setLod (KmlLod lod){
    	setLodImpl(getImpl(), lod.getImpl());
    }
    
    public native void setLodImpl(JavaScriptObject impl, JavaScriptObject lod) /*-{
    	impl.setLod(lod);
    }-*/;


}
