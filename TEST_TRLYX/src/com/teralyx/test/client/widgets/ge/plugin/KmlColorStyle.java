package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlColorStyle extends KmlObject {

	public KmlColorStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public KmlColor getColor () {
		return new KmlColor(getColorImpl(getImpl()));
	}
	
	public native JavaScriptObject getColorImpl(JavaScriptObject impl) /*-{
	return impl.getColor();
	}-*/;
	
	public KmlColorModeEnum getColorMode () {
		return getColorModeImpl(getImpl());
	}
	
	public native KmlColorModeEnum getColorModeImpl(JavaScriptObject impl) /*-{
		return impl.getColorMode();
	}-*/;
	
	public void setColorMode (KmlColorModeEnum colorMode){
		setColorModeImpl(getImpl(), colorMode);
	}
	
	public native void setColorModeImpl(JavaScriptObject impl, KmlColorModeEnum colorMode) /*-{
		impl.setColorMode(colorMode);
	}-*/;


}
