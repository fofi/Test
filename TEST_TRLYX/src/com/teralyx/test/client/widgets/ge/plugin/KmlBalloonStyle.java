package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlBalloonStyle extends KmlObject {

	public KmlBalloonStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	
	public KmlColor 	getBgColor () {
		return new KmlColor(getBgColorImpl(getImpl()));
	}
	
	public native JavaScriptObject 	getBgColorImpl(JavaScriptObject impl) /*-{
		return impl.getBgColor();
	}-*/;
	
	public KmlColor 	getTextColor () {
		return new KmlColor(getTextColorImpl(getImpl()));
	}
	
	public native JavaScriptObject 	getTextColorImpl(JavaScriptObject impl) /*-{
		return impl.getTextColor();
	}-*/;
	
	public String 	getText () {
		return getTextImpl(getImpl());
	}
	
	public native String 	getTextImpl(JavaScriptObject impl) /*-{
		return impl.getText();
	}-*/;
	
	public void 	setText (String text){
		setTextImpl(getImpl(), text);
	}
	
	public native void 	setTextImpl(JavaScriptObject impl, String text) /*-{
		impl.setText(text);
	}-*/;


}
