package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlLod extends KmlObject {

	public KmlLod(JavaScriptObject impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public void 	set (float minLodPixels, float maxLodPixels, float minFadeExtent, float maxFadeExtent) {
		setImpl(getImpl(), minLodPixels, maxLodPixels, minFadeExtent, maxFadeExtent);
	}
	
	public native void 	setImpl(JavaScriptObject impl, float minLodPixels, float maxLodPixels, float minFadeExtent, float maxFadeExtent) /*-{
		impl.set(minLodPixels, maxLodPixels, minFadeExtent, maxFadeExtent);
	}-*/;
	
	public float 	getMinLodPixels () {
		return getMinLodPixelsImpl(getImpl());
	}
	
	public native float 	getMinLodPixelsImpl(JavaScriptObject impl) /*-{
		return impl.getMinLodPixels();
	}-*/;
	
	public void 	setMinLodPixels (float minLodPixels) {
		setMinLodPixelsImpl(getImpl(), minLodPixels);
	}
	
	public native void 	setMinLodPixelsImpl(JavaScriptObject impl, float minLodPixels) /*-{
		impl.setMinLodPixels(minLodPixels);
	}-*/;
	
	public float 	getMaxLodPixels () {
		return getMaxLodPixelsImpl(getImpl());
	}
	
	public native float 	getMaxLodPixelsImpl(JavaScriptObject impl) /*-{
		return impl.getMaxLodPixels();
	}-*/;
	
	public void 	setMaxLodPixels (float maxLodPixels) {
		setMaxLodPixelsImpl(getImpl(), maxLodPixels);
	}
	
	public native void 	setMaxLodPixelsImpl(JavaScriptObject impl, float maxLodPixels) /*-{
		impl.setMaxLodPixels(maxLodPixels);
	}-*/;
	
	public float 	getMinFadeExtent () {
		return getMinFadeExtentImpl(getImpl());
	}
	
	public native float 	getMinFadeExtentImpl(JavaScriptObject impl) /*-{
		return impl.getMinFadeExtent();
	}-*/;
	
	public void 	setMinFadeExtent (float minFadeExtent) {
		setMinFadeExtentImpl(getImpl(), minFadeExtent);
	}
	
	public native void 	setMinFadeExtentImpl(JavaScriptObject impl, float minFadeExtent) /*-{
		impl.setMinFadeExtent(minFadeExtent);
	}-*/;
	
	public float 	getMaxFadeExtent () {
		return getMaxFadeExtentImpl(getImpl());
	}
	
	public native float 	getMaxFadeExtentImpl(JavaScriptObject impl) /*-{
		return impl.getMaxFadeExtent();
	}-*/;
	
	public void 	setMaxFadeExtent (float maxFadeExtent){
		setMaxFadeExtentImpl(getImpl(), maxFadeExtent);
	}
	
	public native void 	setMaxFadeExtentImpl(JavaScriptObject impl, float maxFadeExtent) /*-{
		impl.setMaxFadeExtent(maxFadeExtent);
	}-*/;

	

}
