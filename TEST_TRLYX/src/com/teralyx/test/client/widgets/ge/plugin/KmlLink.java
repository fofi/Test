/*
 * Copyright 2008 Google Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 * Author: Samuel Charron
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlLink extends KmlObject {

	public KmlLink(JavaScriptObject impl) {
		super(impl);
	}
	
	public String getHref() {
		return getHrefImpl(getImpl());
	}
	

	public void setHref(String s) {
		setHrefImpl(getImpl(), s);
	}
	
	public KmlRefreshModeEnum getRefreshMode () {
		return getRefreshModeImpl(getImpl());
	}
	
	public void setRefreshMode(KmlRefreshModeEnum refreshMode) {
		setRefreshModeImpl(getImpl(), refreshMode);
	}
	
	public float getRefreshInterval() {
		return getRefreshIntervalImpl(getImpl());
	}
	
	public void setRefreshInterval(float refreshInterval) {
		setRefreshIntervalImpl(getImpl(), refreshInterval);
	}
	
	public KmlViewRefreshModeEnum getViewRefreshMode() {
		return getViewRefreshModeImpl(getImpl());
	}
	
	public void setViewRefreshMode(KmlViewRefreshModeEnum viewRefreshMode) {
		setViewRefreshModeImpl(getImpl(), viewRefreshMode);
	}
	
	public float getViewRefreshTime() {
		return getViewRefreshTimeImpl(getImpl());
	}
	
	public void setViewRefreshTime(float viewRefreshTime) {
		setViewRefreshTimeImpl(getImpl(), viewRefreshTime);
	}
	
	public float getViewBoundScale() {
		return getViewBoundScaleImpl(getImpl());
	}
	
	public void setViewBoundScale(float viewBoundScale) {
		setViewBoundScaleImpl(getImpl(), viewBoundScale);
	}
	
	public String getViewFormat() {
		return getViewFormatImpl(getImpl());
	}
	
	public void setViewFormat(String viewFormat) {
		setViewFormatImpl(getImpl(), viewFormat);
	}
	
	
	
	
	
	//Impl
	
	public native String getHrefImpl(JavaScriptObject impl) /*-{
		return impl.getHref();
	}-*/;
	
	public native void setHrefImpl(JavaScriptObject impl, String href) /*-{
		return impl.setHref(href);		
	}-*/;
	
	public native KmlRefreshModeEnum getRefreshModeImpl(JavaScriptObject impl) /*-{
		return impl.getRefreshModeImpl();
	}-*/;
	
	public native void setRefreshModeImpl(JavaScriptObject impl, KmlRefreshModeEnum refreshMode) /*-{
		impl.setRefreshModeImpl(refreshMode);
	}-*/;
	
	public native float getRefreshIntervalImpl(JavaScriptObject impl) /*-{
		return impl.getRefreshInterval();
	}-*/;
	
	public native void setRefreshIntervalImpl(JavaScriptObject impl, float refreshInterval) /*-{
		impl.setRefreshInterval(refreshInterval);
	}-*/;
	
	public native KmlViewRefreshModeEnum getViewRefreshModeImpl(JavaScriptObject impl) /*-{
		return impl.getViewRefreshMode();
	}-*/;
	
	public native void setViewRefreshModeImpl(JavaScriptObject impl, KmlViewRefreshModeEnum viewRefreshMode) /*-{
		impl.setViewRefreshModeImpl(viewRefreshMode);
	}-*/;
	
	public native float getViewRefreshTimeImpl(JavaScriptObject impl) /*-{
		return impl.getViewRefreshTimeImpl();
	}-*/;
	
	public native void setViewRefreshTimeImpl(JavaScriptObject impl, float viewRefreshTime) /*-{
		impl.setViewRefreshTimeImpl(viewRefreshTime);
	}-*/;
	
	public native float getViewBoundScaleImpl(JavaScriptObject impl) /*-{
		return impl.getViewBoundScale();
	}-*/;
	
	public native void setViewBoundScaleImpl(JavaScriptObject impl, float viewBoundScale) /*-{
		impl.setViewBoundScale(viewBoundScale);
	}-*/;
	
	public native String getViewFormatImpl(JavaScriptObject impl) /*-{
		return impl.getViewFormatImpl();
	}-*/;
	
	public native void setViewFormatImpl(JavaScriptObject impl, String viewFormat) /*-{
		impl.setViewFormatImpl(viewFormat);
	}-*/;
	
}
