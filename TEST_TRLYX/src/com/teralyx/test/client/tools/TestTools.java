package com.teralyx.test.client.tools;

import com.google.gwt.user.client.Window;

public class TestTools {

    /** Redirecciona hacia una URL */
    public static native void redirect(String url)/*-{
        $wnd.location = url;
    }-*/;

    public static native String getPlatform() /*-{
        return $wnd.navigator.platform;
    }-*/;

    public static native String getAppName() /*-{
        return $wnd.navigator.appName;
    }-*/;

    public static native String getAppCodeName() /*-{
        return $wnd.navigator.appCodeName;
    }-*/;

    public static native String getQueryString() /*-{
        return $wnd.location.search;
    }-*/;

    public static native String getProtocol() /*-{
        return $wnd.location.protocol;
    }-*/;

    public static native String getPort() /*-{
        return $wnd.location.port;
    }-*/;

    public static native String getPath() /*-{
        return $wnd.location.pathname;
    }-*/;

    public static native String getHref() /*-{
        return $wnd.location.href;
    }-*/;

    public static native String getHostName() /*-{
        return $wnd.location.hostname;
    }-*/;

    public static native String getHost() /*-{
        return $wnd.location.host;
    }-*/;

    public static native String getHash() /*-{
        return $wnd.location.hash;
    }-*/;

    public static native void refresh(int id) /*-{
        return $wnd.history.go(id);
    }-*/;

    private static native String getTitleImpl() /*-{
        return $wnd.title;
    }-*/;

    public String getTitle() {
        return (getTitleImpl());
    }

    public static void clearWindowTitle() {
        String windowTitle = Window.getTitle();
        int index = windowTitle.indexOf("#");
        Window.setTitle(windowTitle.substring(0, index));
    }

    public static native String getUserAgent() /*-{
        return navigator.userAgent.toLowerCase();
    }-*/;

    public static boolean isInternetExplorer() {
        boolean result = false;

        if (getUserAgent().contains("msie")) {
            result = true;
        }

        return result;
    }

    public static boolean isMozilla() {
        boolean result = false;

        if (getUserAgent().contains("firefox")) {
            result = true;
        }

        return result;
    }

    public static native void refresh()/*-{
        return $wnd.location.reload();
    }-*/;

    public static native void status(String status)/*-{
        return $wnd.window.status(status);
    }-*/;
	
}
