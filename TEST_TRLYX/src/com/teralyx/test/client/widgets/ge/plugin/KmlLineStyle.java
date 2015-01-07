package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlLineStyle extends KmlColorStyle {

	public KmlLineStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public float 	getWidth ()
	{
	return getWidthImpl(getImpl());
	}
	public native float 	getWidthImpl(JavaScriptObject impl) /*-{
	return impl.getWidth();
	}-*/;
	public void 	setWidth (float width){
	setWidthImpl(getImpl(), width);
	}
	public native void 	setWidthImpl(JavaScriptObject impl, float width) /*-{
	impl.setWidth(width);
	}-*/;


}
