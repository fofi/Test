/*
 * KmlOrientation.java Created on 19/03/2009
 * 
 * Copyright (c) 2009, DEIMOS Space SL
 * 
 * $Date: $ $Revision: $ $Log: $
 */
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlOrientation extends KmlObject {

    public KmlOrientation(JavaScriptObject impl) {
        super(impl);
    }

    public void set(double heading, double tilt, double roll) {
        setImpl(getImpl(), heading, tilt, roll);
    }

    public double getHeading() {
        return getHeadingImpl(getImpl());

    }

    public void setHeading(double heading) {

    }

    public double getTilt() {
        return getTiltImpl(getImpl());

    }

    public void setTilt(double tilt) {
        setTiltImpl(getImpl(),tilt );
    }

   

    public double getRoll() {
        return getRollImpl(getImpl());

    }

    public void setRoll(double roll) {
        setRollImpl(getImpl(),roll );
    }

    private native void setImpl(JavaScriptObject impl, double heading, double tilt, double roll)/*-{
           return impl.set(heading,tilt,roll);
                    }-*/;

    private native double getTiltImpl(JavaScriptObject impl)/*-{
            return impl.getTilt();
            }-*/;

    private native double getHeadingImpl(JavaScriptObject impl)/*-{
            return impl.getHeading();
            }-*/;

    private native double getRollImpl(JavaScriptObject impl)/*-{
            return impl.getRoll();
            }-*/;
    

    private native void setRollImpl(JavaScriptObject impl,double roll)/*-{
             impl.setRoll(roll);
            }-*/;
    
    private native void setTiltImpl(JavaScriptObject impl,double till)/*-{
     impl.setTilt(till);
    }-*/;
}
