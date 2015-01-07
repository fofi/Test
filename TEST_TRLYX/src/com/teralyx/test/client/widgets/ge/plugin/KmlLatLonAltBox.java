package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlLatLonAltBox extends KmlLatLonBox {

	public KmlLatLonAltBox(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}

	public void setAltBox (double north, double south, double east, double west, double rotation, float minAltitude, float maxAltitude, KmlAltitudeModeEnum altitudeMode)
	{
		setAltBoxImpl(getImpl(), north, south, east, west, rotation, minAltitude, maxAltitude, altitudeMode.getImpl());
	}
	
	public native void 	setAltBoxImpl(JavaScriptObject impl, double north, double south, double east, double west, double rotation, float minAltitude, float maxAltitude, JavaScriptObject altitudeMode) /*-{
		impl.setAltBox(north, south, east, west, rotation, minAltitude, maxAltitude, altitudeMode);
	}-*/;
	
	public float getMinAltitude ()
	{
		return getMinAltitudeImpl(getImpl());
	}
	
	public native float getMinAltitudeImpl(JavaScriptObject impl) /*-{
		return impl.getMinAltitude();
	}-*/;
	
	public void etMinAltitude (float minAltitude)
	{
		setMinAltitudeImpl(getImpl(), minAltitude);
	}
	
	public native void 	setMinAltitudeImpl(JavaScriptObject impl, float minAltitude) /*-{
		impl.setMinAltitude(minAltitude);
	}-*/;
	
	public float getMaxAltitude ()
	{
		return getMaxAltitudeImpl(getImpl());
	}
	
	public native float getMaxAltitudeImpl(JavaScriptObject impl) /*-{
		return impl.getMaxAltitude();
	}-*/;
	
	public void setMaxAltitude (float maxAltitude)
	{
		setMaxAltitudeImpl(getImpl(), maxAltitude);
	}
	
	public native void setMaxAltitudeImpl(JavaScriptObject impl, float maxAltitude) /*-{
		impl.setMaxAltitude(maxAltitude);
	}-*/;
	
	public KmlAltitudeModeEnum getAltitudeMode ()
	{
		KmlAltitudeModeEnum KmlAltitudeModeEnum=new KmlAltitudeModeEnum(getAltitudeModeImpl(getImpl()));
		return KmlAltitudeModeEnum;
	}
	
	public native JavaScriptObject getAltitudeModeImpl(JavaScriptObject impl) /*-{
		return impl.getAltitudeMode();
	}-*/;
	
	public void setAltitudeMode (KmlAltitudeModeEnum altitudeMode){
		setAltitudeModeImpl(getImpl(), altitudeMode.getImpl());
	}
	
	public native void setAltitudeModeImpl(JavaScriptObject impl, JavaScriptObject altitudeMode) /*-{
		impl.setAltitudeMode(altitudeMode);
	}-*/;

}
