package com.teralyx.test.client.widgets.ge;

import java.util.ArrayList;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.teralyx.test.client.widgets.ge.plugin.GEPlugin;

public class GoogleEarthWidget extends Widget implements GEPluginReadyListenerIF {
    
    static int id = 0;

    private boolean loaded = false;

    private Timer timer;

    @SuppressWarnings("unused")
    private JavaScriptObject ge;

    private GEPlugin gePlugin;

    private ArrayList<GEPluginReadyListenerIF> pluginReadyListeners = new ArrayList<GEPluginReadyListenerIF>();
    
    public GoogleEarthWidget() {
        HTML html = new HTML("<div class='map3dcontainer' id='map3dcontainer" + id + "'>" + "<div class='map3d' id='map3d" + id + "'></div></div>");
        setElement(html.getElement());
    }

    public void init() {

        addPluginReadyListener(this);
        jsInitGE(id);
        System.out.println("GE plug-in inicializado:" + id);
    }

    public void pluginReady(JavaScriptObject ge) {
        loaded = true;
        this.ge = ge;
        System.out.println("GE plug-in inicializado:" + id);
        gePlugin = new GEPlugin(ge);
        id++;

    }

    public void addPluginReadyListener(GEPluginReadyListenerIF listener) {
        pluginReadyListeners.add(listener);
    }

    public GEPlugin getGEPlugin() {
        return gePlugin;
    }

    public void ready(JavaScriptObject ge) {

        for (int i = 0; i < pluginReadyListeners.size(); ++i) {
            ((GEPluginReadyListenerIF) pluginReadyListeners.get(i)).pluginReady(ge);
        }
    }

    private native void jsInitGE(int id) /*-{
              var ge;
              var instance = this;
              
            
              function initCB(obj) {
              ge = obj;
              ge.getWindow().setVisibility(true);
          //    instance.@com.deimos.enerdataweb.web.client.views.widgets.ge.GoogleEarthWidget::ready(Lcom/google/gwt/core/client/JavaScriptObject;)(ge);
              }
              function failureCB(object) {
              alert('load failed');
              }
              //alert('Esto es una prueba');
              $wnd.google.earth.createInstance($doc.getElementById("map3d" + id), initCB, failureCB);
              }-*/;


    @Override
    protected void onLoad() {
        super.onLoad();
        // System.out.print("loaded");
        if (!loaded) {
            startTimer();
            loaded = true;
        }

    }

    /** Creates and starts a timer */
    public void startTimer() {
        timer = new Timer() {
            public void run() {
                init();
                timer.cancel();
                timer = null;
            }
        };
        timer.scheduleRepeating(5000);
    }

    public void release() {
        if (gePlugin != null) {
            gePlugin.unloadPlugin();
            // ge = null;
            // gePlugin = null;
            loaded = false;
        }
    }

    @Override
    protected void onUnload() {
        release();
        super.onUnload();
    }

}
