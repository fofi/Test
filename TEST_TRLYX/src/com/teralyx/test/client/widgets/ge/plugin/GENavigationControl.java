/*
 * GENavigationControl.java
 * Created on 12/01/2009
 *
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $
 * $Revision:  $
 * $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class GENavigationControl {
	private JavaScriptObject ge;

	public GENavigationControl(JavaScriptObject ge) {
		this.ge = ge;
	}

	public void show() {
		GEPluginNative.navigationControlShow(ge);
	}
	public void auto(){
		GEPluginNative.navigationControlAuto(ge);
	}
	public void hide(){
		GEPluginNative.navigationControlHide(ge);
	}
	public void controlPosTopLeft(){
		GEPluginNative.navigationControlPosTopLeft(ge);
	}
	public void ControlPosTopRight(){
		GEPluginNative.navigationControlPosTopRight(ge);
	}
	public void ControlPosBottomRight(){
		GEPluginNative.navigationControlPosBottomRight(ge);
	}
	public void ControlPosBottomLeft(){
		GEPluginNative.navigationControlPosBottomLeft(ge);
	}

}
