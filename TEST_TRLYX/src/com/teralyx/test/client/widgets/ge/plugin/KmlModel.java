/*
 * KmlModel.java Created on 19/03/2009
 * 
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $ $Revision: $ $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlModel extends KmlObject {

    public KmlModel(JavaScriptObject impl) {
        super(impl);

    }

    public KmlLocation getLocation() {
        return null;
    }

    public void setLocation(KmlLocation location) {

    }

    public KmlOrientation getOrientation() {
        KmlOrientation kmlOrientation = new KmlOrientation(getOrientationImpl(getImpl()));
        return kmlOrientation;

    }

    public void setOrientation(KmlOrientation orientation) {

    }

    public KmlScale getScale() {
        return null;

    }

    public void setScale(KmlScale scale) {

    }

    public KmlLink getLink() {
        return null;

    }

    public void setLink(KmlLink link) {

    }

    private native JavaScriptObject getOrientationImpl(JavaScriptObject impl)/*-{
        return impl.getOrientation();
        }-*/;

}
