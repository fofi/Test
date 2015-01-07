package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlLatLonBox extends KmlObject {

	public KmlLatLonBox(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public void 	setBox (double north, double south, double east, double west, double rotation)
	{
	setBoxImpl(getImpl(), north, south, east, west, rotation);
	}
	
	public native void 	setBoxImpl(JavaScriptObject impl, double north, double south, double east, double west, double rotation) /*-{
	impl.setBox(north, south, east, west, rotation);
	}-*/;
	
	public double 	getNorth ()
	{
	return getNorthImpl(getImpl());
	}
	
	public native double 	getNorthImpl(JavaScriptObject impl) /*-{
	return impl.getNorth();
	}-*/;
	
	public void 	setNorth (double north)
	{
	setNorthImpl(getImpl(), north);
	}
	
	public native void 	setNorthImpl(JavaScriptObject impl, double north) /*-{
	impl.setNorth(north);
	}-*/;
	
	public double 	getSouth ()
	{
	return getSouthImpl(getImpl());
	}
	
	public native double 	getSouthImpl(JavaScriptObject impl) /*-{
	return impl.getSouth();
	}-*/;
	
	public void 	setSouth (double south)
	{
	setSouthImpl(getImpl(), south);
	}
	
	public native void 	setSouthImpl(JavaScriptObject impl, double south) /*-{
	impl.setSouth(south);
	}-*/;
	
	public double 	getEast ()
	{
	return getEastImpl(getImpl());
	}
	
	public native double 	getEastImpl(JavaScriptObject impl) /*-{
	return impl.getEast();
	}-*/;
	
	public void 	setEast (double east)
	{
	setEastImpl(getImpl(), east);
	}
	
	public native void 	setEastImpl(JavaScriptObject impl, double east) /*-{
	impl.setEast(east);
	}-*/;
	
	public double 	getWest ()
	{
	return getWestImpl(getImpl());
	}
	
	public native double 	getWestImpl(JavaScriptObject impl) /*-{
	return impl.getWest();
	}-*/;
	
	public void 	setWest (double west)
	{
	setWestImpl(getImpl(), west);
	}
	
	public native void 	setWestImpl(JavaScriptObject impl, double west) /*-{
	impl.setWest(west);
	}-*/;
	
	public double 	getRotation ()
	{
	return getRotationImpl(getImpl());
	}
	
	public native double 	getRotationImpl(JavaScriptObject impl) /*-{
	return impl.getRotation();
	}-*/;
	
	public void 	setRotation (double rotation){
	setRotationImpl(getImpl(), rotation);
	}
	
	public native void 	setRotationImpl(JavaScriptObject impl, double rotation) /*-{
	impl.setRotation(rotation);
	}-*/;

}
