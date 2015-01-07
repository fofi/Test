package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlFeature extends KmlObject {

    public KmlFeature(JavaScriptObject impl) {
        super(impl);
    }

    // string getName ()

    public boolean getVisibility() {
        return false;
    }

    public void setVisibility(boolean visibility) {

    }

    public boolean getOpen() {
        return getOpenImpl(getImpl());
    }

    public native boolean getOpenImpl(JavaScriptObject impl) /*-{
             	return impl.getOpen();
             }-*/;

    public void setOpen(boolean open) {
        setOpenImpl(getImpl(), open);
    }

    public native void setOpenImpl(JavaScriptObject impl, boolean open) /*-{
             	return impl.setOpen(open);
             }-*/;

    public String getAddress() {
        return getAddressImpl(getImpl());
    }

    public native String getAddressImpl(JavaScriptObject impl) /*-{
             	return impl.getAddress();
             }-*/;

    public void setAddress(String address) {
        setAddressImpl(getImpl(), address);
    }

    public native void setAddressImpl(JavaScriptObject impl, String address) /*-{
             	impl.setAddress(address);
             }-*/;

    public String getSnippet() {
        return getSnippetImpl(getImpl());
    }

    public native String getSnippetImpl(JavaScriptObject impl) /*-{
             	return impl.getSnippet();
             }-*/;

    public void setSnippet(String snippet) {
        setSnippetImpl(getImpl(), snippet);
    }

    public native void setSnippetImpl(JavaScriptObject impl, String snippet) /*-{
             impl.setSnippet(snippet);
             }-*/;

    public String getDescription() {
        return getDescriptionImpl(getImpl());
    }

    public native String getDescriptionImpl(JavaScriptObject impl) /*-{
             	return impl.getDescription();
             }-*/;

    public void setDescription(String description) {
        setDescriptionImpl(getImpl(), description);
    }

    public native void setDescriptionImpl(JavaScriptObject impl, String description) /*-{
             impl.setDescription(description);
             }-*/;

    public KmlAbstractView getAbstractView() {
        return new KmlAbstractView(getAbstractViewImpl(getImpl()));
    }

    public native JavaScriptObject getAbstractViewImpl(JavaScriptObject impl) /*-{
             	return impl.getAbstractView();
             }-*/;

    public void setAbstractView(KmlAbstractView abstractView) {
        setAbstractViewImpl(getImpl(), abstractView.getImpl());
    }

    public native void setAbstractViewImpl(JavaScriptObject impl, JavaScriptObject abstractView) /*-{
             impl.setAbstractView(abstractView);
             }-*/;

    public String getStyleUrl() {
        return getStyleUrlImpl(getImpl());
    }

    public native String getStyleUrlImpl(JavaScriptObject impl) /*-{
             	return impl.getStyleUrl();
             }-*/;

    public KmlStyleSelector getStyleSelector() {
        return new KmlStyleSelector(getStyleSelectorImpl(getImpl()));
    }

    public native JavaScriptObject getStyleSelectorImpl(JavaScriptObject impl) /*-{
             	return impl.getStyleSelector();
             }-*/;

    public void setStyleSelector(KmlStyleSelector styleSelector) {
        setStyleSelectorImpl(getImpl(), styleSelector.getImpl());
    }

    public native void setStyleSelectorImpl(JavaScriptObject impl, JavaScriptObject styleSelectorImp) /*-{
             impl.setStyleSelector(styleSelector);
             }-*/;

    public KmlRegion getRegion() {
        return new KmlRegion(getRegionImpl(getImpl()));
    }

    public native JavaScriptObject getRegionImpl(JavaScriptObject impl) /*-{
             	return impl.getRegion();
             }-*/;

    public void setRegion(KmlRegion region) {
        setRegionImpl(getImpl(), region.getImpl());
    }

    public native void setRegionImpl(JavaScriptObject impl, JavaScriptObject regionImpl) /*-{
             impl.setRegion( regionImpl);
             }-*/;

    public String getKml() {
        return getKmlImpl(getImpl());
    }

    public native String getKmlImpl(JavaScriptObject impl) /*-{
             	return impl.getKml();
             }-*/;

    public KmlFeature getPreviousSibling() {
        return new KmlFeature(getPreviousSiblingImpl(getImpl()));
    }

    public native JavaScriptObject getPreviousSiblingImpl(JavaScriptObject impl) /*-{
             	return impl.getPreviousSibling();
             }-*/;

    public KmlFeature getNextSibling() {
        return new KmlFeature(getNextSiblingImpl(getImpl()));
    }

    public native JavaScriptObject getNextSiblingImpl(JavaScriptObject impl) /*-{
             	return impl.getNextSibling();
             }-*/;

    public void setStyleUrl(String s) {
        setStyleUrlImpl(getImpl(), s);
    }

    public native void setStyleUrlImpl(JavaScriptObject impl, String s) /*-{
                   	impl.setStyleUrl(s);
                   }-*/;

    public String getName() {
        return getNameImpl(getImpl());
    }
    
    private native String getNameImpl(JavaScriptObject impl) /*-{
    return impl.getName();
    }-*/;


    public void setName(String s) {
        setNameImpl(getImpl(), s);
    }

    public native void setNameImpl(JavaScriptObject impl, String s) /*-{
                   impl.setName(s);
                   }-*/;

}
