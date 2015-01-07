/*
 * KmlNetworkLink.java
 * Created on 28/04/2009
 *
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $
 * $Revision:  $
 * $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlNetworkLink extends KmlObject{

    public KmlNetworkLink(JavaScriptObject impl) {
        super(impl);
    }
    public void  set (KmlLink link, boolean refreshVisibility, boolean flyToView){
        
    } 
    public KmlLink  getLink (){
        return new KmlLink(getLinkImpl(getImpl()));
    } 
    private native JavaScriptObject getLinkImpl(JavaScriptObject impl) /*-{
     return impl.getLink();
    }-*/;
        
      

    public void  setLink (KmlLink link){
        setLinkImpl(link.getImpl());
    } 
    private native void setLinkImpl(JavaScriptObject impl) /*-{
    return impl.setLink(impl);
   }-*/;
    public boolean  getRefreshVisibility () {
        return getRefreshVisibilityImpl(getImpl());
    }
    private native  boolean getRefreshVisibilityImpl(JavaScriptObject impl) /*-{
        return impl.getRefreshVisibility();
        }-*/;
    public void  setRefreshVisibility (boolean refreshVisibility) {
        setRefreshVisibilityImpl(getImpl(),refreshVisibility);
    }
    private native  void setRefreshVisibilityImpl(JavaScriptObject impl, boolean refreshVisibility)  /*-{
     impl.setRefreshVisibility();
    }-*/;
    public boolean  getFlyToView (){
        return getFlyToViewImpl(getImpl());
    } 
    private native boolean getFlyToViewImpl(JavaScriptObject impl) /*-{
    return impl.getFlyToView();
    }-*/;
    public void  setFlyToView (boolean flyToView) {
        setFlyToViewImpl(getImpl(),flyToView);
    }
    private native void setFlyToViewImpl(JavaScriptObject impl, boolean flyToView) /*-{
     impl.setFlyToView();
    }-*/;


}
