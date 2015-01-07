/*
 * GESchemaObjectContainer.java Created on 19/03/2009
 * 
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $ $Revision: $ $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class GESchemaObjectContainer extends GEJavaScriptObject {

    public GESchemaObjectContainer(JavaScriptObject impl) {
        super(impl);
    }

    public KmlObjectList getChildNodes() {
        KmlObjectList kmlObjectList = new KmlObjectList(getChildNodesImpl(getImpl()));
        return kmlObjectList;
    }

    private native JavaScriptObject getChildNodesImpl(JavaScriptObject impl) /*-{
      return impl.getChildNodes();
      }-*/;
}
