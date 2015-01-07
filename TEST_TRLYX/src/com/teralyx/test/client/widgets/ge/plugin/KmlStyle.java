package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlStyle extends KmlObject {

	public KmlStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub

	}

	public KmlIconStyle getIconStyle() {
		return new KmlIconStyle(getIconStyleImpl(getImpl()));
	}

	public native JavaScriptObject getIconStyleImpl(JavaScriptObject impl) /*-{
	return impl.KmlStyle.getIconStyle();
	}-*/;

	public KmlLabelStyle getLabelStyle() {
		return new KmlLabelStyle(getLabelStyleImpl(getImpl()));
	}

	public native JavaScriptObject getLabelStyleImpl(JavaScriptObject impl) /*-{
	return impl.getLabelStyle();
	}-*/;

	public KmlLineStyle getLineStyle() {
		return new KmlLineStyle(getLineStyleImpl(getImpl()));
	}

	public native JavaScriptObject getLineStyleImpl(JavaScriptObject impl) /*-{
	return impl.KmlStyle.getLineStyle();
	}-*/;

	public KmlListStyle getListStyle() {
		return new KmlListStyle(getListStyleImpl(getImpl()));
	}

	public native JavaScriptObject getListStyleImpl(JavaScriptObject impl) /*-{
	return impl.KmlStyle.getListStyle();
	}-*/;

	public KmlPolyStyle getPolyStyle() {
		return new KmlPolyStyle(getPolyStyleImpl(getImpl()));
	}

	public native JavaScriptObject getPolyStyleImpl(JavaScriptObject impl) /*-{
	return impl.KmlStyle.getPolyStyle();
	}-*/;

	public KmlBalloonStyle getBalloonStyle() {
		return new KmlBalloonStyle(getBalloonStyleImpl(getImpl()));
	}

	public native JavaScriptObject getBalloonStyleImpl(JavaScriptObject impl) /*-{
	return impl.KmlStyle.getBalloonStyle();
	}-*/;

}
