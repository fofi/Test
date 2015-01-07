package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlStyleMapObject extends KmlStyleSelector {

	public KmlStyleMapObject(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public void 	setUrl (String normalStyleUrl, String highlightStyleUrl)
	{
	setUrlImpl(getImpl(), normalStyleUrl, highlightStyleUrl);
	}
	public native void 	setUrlImpl(JavaScriptObject impl, String normalStyleUrl, String highlightStyleUrl) /*-{
	impl.setUrl(normalStyleUrl, highlightStyleUrl);
	}-*/;
	public void 	setStyle (KmlStyle normalStyle, KmlStyle highlightStyle)
	{
	setStyleImpl(getImpl(), normalStyle.getImpl(), highlightStyle.getImpl());
	}
	public native void 	setStyleImpl(JavaScriptObject impl, JavaScriptObject normalStyleImpl, JavaScriptObject highlightStyleImpl) /*-{
	impl.setStyle(normalStyleImpl, highlightStyleImpl);
	}-*/;
	public String 	getNormalStyleUrl ()
	{
	return getNormalStyleUrlImpl(getImpl());
	}
	public native String 	getNormalStyleUrlImpl(JavaScriptObject impl) /*-{
	return impl.getNormalStyleUrl();
	}-*/;
	public void 	setNormalStyleUrl (String normalStyleUrl)
	{
	setNormalStyleUrlImpl(getImpl(), normalStyleUrl);
	}
	public native void 	setNormalStyleUrlImpl(JavaScriptObject impl, String normalStyleUrl) /*-{
	impl.setNormalStyleUrl(normalStyleUrl);
	}-*/;
	public String 	getHighlightStyleUrl ()
	{
	return getHighlightStyleUrlImpl(getImpl());
	}
	public native String 	getHighlightStyleUrlImpl(JavaScriptObject impl) /*-{
	return impl.getHighlightStyleUrl();
	}-*/;
	public void 	setHighlightStyleUrl (String highlightStyleUrl)
	{
	setHighlightStyleUrlImpl(getImpl(), highlightStyleUrl);
	}
	public native void 	setHighlightStyleUrlImpl(JavaScriptObject impl, String highlightStyleUrl) /*-{
	impl.setHighlightStyleUrl(highlightStyleUrl);
	}-*/;
	public KmlStyle 	getNormalStyle ()
	{
	    
	return getNormalStyleImpl(getImpl());
	}
	public native KmlStyle 	getNormalStyleImpl(JavaScriptObject impl) /*-{
	return impl.getNormalStyle();
	}-*/;
	public void 	setNormalStyle (KmlStyle normalStyle)
	{
	setNormalStyleImpl(getImpl(), normalStyle);
	}
	public native void 	setNormalStyleImpl(JavaScriptObject impl, KmlStyle normalStyle) /*-{
	impl.setNormalStyle(normalStyle);
	}-*/;
	public KmlStyle 	getHighlightStyle ()
	{
	return getHighlightStyleImpl(getImpl());
	}
	public native KmlStyle 	getHighlightStyleImpl(JavaScriptObject impl) /*-{
	return impl.getHighlightStyle();
	}-*/;
	public void 	setHighlightStyle (KmlStyle highlightStyle){
	setHighlightStyleImpl(getImpl(), highlightStyle);
	}
	public native void 	setHighlightStyleImpl(JavaScriptObject impl, KmlStyle highlightStyle) /*-{
	impl.setHighlightStyle(highlightStyle);
	}-*/;


}
