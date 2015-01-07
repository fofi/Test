package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlIconStyle extends KmlColorStyle {

	public KmlIconStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	
	public float getScale() {
		return getScaleImpl(getImpl());
	}
	
	public native float getScaleImpl(JavaScriptObject impl) /*-{
	return impl.KmlIconStyle.getScale();
	}-*/;
	
	public void setScale(float scale) {
		setScaleImpl(getImpl(), scale);
	}
	
	public native void setScaleImpl(JavaScriptObject impl, float scale) /*-{
	impl.KmlIconStyle.setScale(scale);
	}-*/;
	
	public float getHeading () {
		return getHeadingImpl(getImpl());
	}
	
	public native float getHeadingImpl(JavaScriptObject impl) /*-{
		return impl.KmlIconStyle.getHeading();
	}-*/;
	
	public void setHeading (float heading) {
		setHeadingImpl(getImpl(), heading);
	}
	
	public native void setHeadingImpl(JavaScriptObject impl, float heading) /*-{
		impl.KmlIconStyle.setHeading(heading);
	}-*/;
	
	public KmlIcon getIcon () {
		return getIconImpl(getImpl());
	}
	
	public native KmlIcon getIconImpl(JavaScriptObject impl) /*-{
	return impl.KmlIconStyle.getIcon();
	}-*/;
	
	public void setIcon (KmlIcon icon) {
		setIconImpl(getImpl(), icon.getImpl());
	}
	
	public native void setIconImpl(JavaScriptObject impl, JavaScriptObject icon) /*-{
		impl.KmlIconStyle.setIcon(icon);
	}-*/;
	
	public KmlVec2 getHotSpot() {
		return new KmlVec2(getHotSpotImpl(getImpl()));
	}
	
	public native JavaScriptObject getHotSpotImpl(JavaScriptObject impl) /*-{
		return impl.KmlIconStyle.getHotSpot();
	}-*/;


}
