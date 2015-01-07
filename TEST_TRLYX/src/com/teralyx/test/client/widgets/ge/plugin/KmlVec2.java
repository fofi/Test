package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlVec2 extends KmlObject {

	public KmlVec2(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public void set (double x, KmlUnitsEnum xUnits, double y, KmlUnitsEnum yUnits) {
		setImpl(getImpl(), x, xUnits, y, yUnits);
	}
		
	public native void setImpl(JavaScriptObject impl, double x, KmlUnitsEnum xUnits, double y, KmlUnitsEnum yUnits) /*-{
	impl.set(x,xUnits,y,yUnits);
	}-*/;


}
