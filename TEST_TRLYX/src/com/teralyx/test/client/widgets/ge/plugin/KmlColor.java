package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlColor extends KmlObject {

	public KmlColor(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public void set (String color){
		setImpl(getImpl(), color);
	}
	
	public native void setImpl(JavaScriptObject impl, String color) /*-{
	impl.set(color);
	}-*/;

	
	
}
