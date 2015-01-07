package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlLabelStyle extends KmlColorStyle {

	public KmlLabelStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	
	public float 	getScale () {
		return getScaleImpl(getImpl());
	}
	
	public native float 	getScaleImpl(JavaScriptObject impl) /*-{
		return impl.getScale();
	}-*/;
	
	public void 	setScale (float scale){
		setScaleImpl(getImpl(), scale);
	}
	
	public native void 	setScaleImpl(JavaScriptObject impl, float scale) /*-{
		impl.setScale(scale);
	}-*/;


	
}
