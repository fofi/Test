/*
 * KmlMultiGeometry.java Created on 19/03/2009
 * 
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $ $Revision: $ $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlMultiGeometry extends KmlGeometry {

    public KmlMultiGeometry(JavaScriptObject impl) {
        super(impl);
    }

    public GEGeometryContainer getGeometries() {
        GEGeometryContainer continer = new GEGeometryContainer(getGeometriesImpl(getImpl()));
        return continer;
    }

    private native JavaScriptObject getGeometriesImpl(JavaScriptObject impl) /*-{
           return impl.getGeometries();
           }-*/;

}
