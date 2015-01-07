/*
 * KmlLocation.java
 * Created on 19/03/2009
 *
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $
 * $Revision:  $
 * $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlLocation extends KmlObject{

    public KmlLocation(JavaScriptObject impl) {
        super(impl);
    }
    
    public KmlLocation getLocation() {
    	return getLocationImpl(getImpl());
    }
    
    public void setLocation(KmlLocation location) {
    	setLocationImpl(getImpl(), location);
    }
    
    public KmlOrientation getOrientation() {
    	return getOrientationImpl(getImpl());
    }
    
    public void setOrientation(KmlOrientation orientation) {
    	setOrientationImpl(getImpl(), orientation);
    }
    
    public KmlScale getScale() {
    	return getScaleImpl(getImpl());
    }
    
    public void setScale(KmlScale scale) {
    	setScaleImpl(getImpl(), scale);
    }
    
    public KmlLink getLink() {
    	return getLinkImpl(getImpl());
    }
    
    public void setLink(KmlLink link) {
    	setLinkImpl(getImpl(), link);
    }
    
    
    
    //impl
    
    public native KmlLocation getLocationImpl(JavaScriptObject impl) /*-{
    	return impl.getLocation();
	}-*/;
    
    public native void setLocationImpl(JavaScriptObject impl, KmlLocation location) /*-{
    	return impl.setLocation(location);
	}-*/;
    
    public native KmlOrientation getOrientationImpl(JavaScriptObject impl) /*-{
    	return impl.getOrientation();
	}-*/;
    
    public native void setOrientationImpl(JavaScriptObject impl, KmlOrientation orientation) /*-{
    	return impl.setOrientation(orientation);
	}-*/;
    
    public native KmlScale getScaleImpl(JavaScriptObject impl) /*-{
    	return impl.getScale();
	}-*/;
    
    public native void setScaleImpl(JavaScriptObject impl, KmlScale scale) /*-{
    	return impl.setScale(scale);
	}-*/;
    
    public native KmlLink getLinkImpl(JavaScriptObject impl) /*-{
    	return impl.getLinkImpl();
	}-*/;
    
    public native void setLinkImpl(JavaScriptObject impl, KmlLink link) /*-{
    	return impl.setLink(KmlLink);
	}-*/;

}
