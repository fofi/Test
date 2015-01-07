/*
 * KmlEvent.java Created on 25/04/2009
 * 
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $ $Revision: $ $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlEvent extends GEJavaScriptObject {

    public KmlEvent(JavaScriptObject impl) {
        super(impl);
    }

    public KmlObject getTarget() {
        KmlObject obj = new KmlObject(getTargetImpl(getImpl()));

        return obj;
    }

    public int getClientX() {
        return getClientXImpl(getImpl());
    }

    public int getClientY() {
        return getClientYImpl(getImpl());
    }

    public int getScreenX() {
        return getScreenXImpl(getImpl());
    }

    public int getScreenY() {
        return getScreenYImpl(getImpl());
    }

    public String getLatitude() {
        return getLatitudeImpl(getImpl());
    }

    public String getLongitude() {
        return getLongitudeImpl(getImpl());
    }

    public String getAltitude() {
        return getAltitudeImpl(getImpl());
    }

    private native JavaScriptObject getTargetImpl(JavaScriptObject impl) /*-{
        var obj;
        try{
        obj= impl.getTarget();
        }catch(err){
        }
        return obj;
    }-*/;

    private native int getClientXImpl(JavaScriptObject impl) /*-{
        return  impl.getClientX();
    }-*/;

    private native int getClientYImpl(JavaScriptObject impl) /*-{
        return  impl.getClientY();
    }-*/;

    private native int getScreenXImpl(JavaScriptObject impl) /*-{
        return  impl.getScreenX();
    }-*/;

    private native int getScreenYImpl(JavaScriptObject impl) /*-{
        return  impl.getScreenY();
    }-*/;

    private native String getLatitudeImpl(JavaScriptObject impl) /*-{
        return impl.getLatitude();
    }-*/;

    private native String getLongitudeImpl(JavaScriptObject impl) /*-{
        return  impl.getLongitude();
    }-*/;

    private native String getAltitudeImpl(JavaScriptObject impl) /*-{
        return  impl.getAltitude();
    }-*/;

}
