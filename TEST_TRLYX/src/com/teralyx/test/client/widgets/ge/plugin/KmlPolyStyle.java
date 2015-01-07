package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlPolyStyle extends KmlColorStyle {

	public KmlPolyStyle(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean 	getFill ()
	{
	return getFillImpl(getImpl());
	}
	
	public native boolean 	getFillImpl(JavaScriptObject impl) /*-{
	return impl.getFill();
	}-*/;
	
	public void 	setFill (boolean fill)
	{
	setFillImpl(getImpl(), fill);
	}
	public native void 	setFillImpl(JavaScriptObject impl, boolean fill) /*-{
	impl.setFill(fill);
	}-*/;
	
	public boolean 	getOutline ()
	{
	return getOutlineImpl(getImpl());
	}
	
	public native boolean 	getOutlineImpl(JavaScriptObject impl) /*-{
	return impl.getOutline();
	}-*/;
	
	public void 	setOutline (boolean outline){
	setOutlineImpl(getImpl(), outline);
	}
	
	//TODO esto da error
	public native void 	setOutlineImpl(JavaScriptObject impl, boolean outline) /*-{
	impl.setOutline(outline);
	}-*/;
}
	
	

	