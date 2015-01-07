package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlListStyle extends KmlColorStyle {

	public KmlListStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public KmlColor 	getBgColor () {
		return new KmlColor(getBgColorImpl(getImpl()));
	}
	
	public native JavaScriptObject 	getBgColorImpl(JavaScriptObject impl) /*-{
		return impl.getBgColor();
	}-*/;
	
	public int 	getMaxSnippetLines () {
		return getMaxSnippetLinesImpl(getImpl());
	}
	
	public native int 	getMaxSnippetLinesImpl(JavaScriptObject impl) /*-{
		return impl.getMaxSnippetLines();
	}-*/;
	
	public void 	setMaxSnippetLines (int maxSnippetLines){
		setMaxSnippetLinesImpl(getImpl(), maxSnippetLines);
	}
	
	public native void 	setMaxSnippetLinesImpl(JavaScriptObject impl, int maxSnippetLines) /*-{
		impl.setMaxSnippetLines(maxSnippetLines);
	}-*/;


}
