package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlPlacemark extends KmlFeature {

	public KmlPlacemark(JavaScriptObject impl) {
		super(impl);
	}
	
	public void setGeometry(KmlGeometry geo) {
		setGeometryImpl(getImpl(), geo.getImpl());
	}
	
	private native void setGeometryImpl(JavaScriptObject impl,
			JavaScriptObject geoImpl) /*-{
		impl.setGeometry(geoImpl);	
	}-*/;
	
	public KmlGeometry getGeometry() {
	    KmlGeometry geo=new KmlGeometry(getGeometryImpl(getImpl()));
	    return geo;
    }
	private native JavaScriptObject getGeometryImpl(JavaScriptObject impl) /*-{
       return impl.getGeometry();  
    }-*/; 
	
	public void setVisibility(boolean value){
	    setVisibilityImpl(getImpl(),value);  
	}
	private native void setVisibilityImpl(JavaScriptObject impl,boolean value)/*-{
        impl.setVisibility(value);  
    }-*/; 
}
