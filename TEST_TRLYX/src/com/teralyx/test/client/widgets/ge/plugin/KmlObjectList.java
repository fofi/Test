/*
 * KmlObjectList.java
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

public class KmlObjectList extends KmlObject{

    public KmlObjectList(JavaScriptObject impl) {
        super(impl);
    }
    
    public KmlObject  item (int index) {
        KmlObject kmlObject=new  KmlObject(itemImpl(getImpl(),index));
        return kmlObject;
    }
    private native JavaScriptObject itemImpl(JavaScriptObject impl,int index)  /*-{
    return impl.item(index);
    }-*/;

    public int  getLength (){
        return getLengthImpl(getImpl());
    }

    private native int getLengthImpl(JavaScriptObject impl) /*-{
    return impl.getLength();
    }-*/;

    
}
