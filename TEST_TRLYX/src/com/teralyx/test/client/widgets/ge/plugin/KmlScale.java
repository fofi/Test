/*
 * KmlScale.java
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

public class KmlScale extends KmlObject{
	
	public KmlScale(JavaScriptObject impl) {
        super(impl);
    }
	
	
	public void set(double x, double y, double z) {
		setImpl(getImpl(), x, y, z);
	}
	
	public double getX() {
		return getXImpl(getImpl());
		
	}
	
	public void setX (double x) {
		setXImpl(getImpl(), x);
	}
	
	public double getY() {
		return getYImpl(getImpl());
	}
	
	public void setY(double y) {
		setYImpl(getImpl(), y);
	}
	
	public double getZ() {
		return getZImpl(getImpl());
	}
	
	public void setZ(double z) {
		setZImpl(getImpl(), z);
	}
	
	
	
	private native void setImpl(JavaScriptObject impl, double x, double y, double z)/*-{
    	impl.set(x,y,z);
    }-*/;
	
	private native double getXImpl(JavaScriptObject impl)/*-{
		return impl.getX();
	}-*/;
	
	private native void setXImpl(JavaScriptObject impl, double x)/*-{
		impl.setX(x);
	}-*/;
	
	private native double getYImpl(JavaScriptObject impl)/*-{
		return impl.getY();
	}-*/;
	
	private native void setYImpl(JavaScriptObject impl, double y)/*-{
		impl.setY(y);
	}-*/;
	
	private native double getZImpl(JavaScriptObject impl)/*-{
		return impl.getZ();
	}-*/;
	
	private native void setZImpl(JavaScriptObject impl, double z)/*-{
		impl.setZ(z);
	}-*/;
	
}
