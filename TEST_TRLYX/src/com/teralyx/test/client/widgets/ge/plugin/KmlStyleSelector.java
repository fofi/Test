package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

public class KmlStyleSelector extends KmlObject {

    final String KmlStyle = "KmlStyle";

    final String KmlStyleMap = "KmlStyleMap";

    private KmlStyle KmlStyleObject = null;

    private KmlStyleMap KmlStyleMapObject = null;

    public KmlStyleSelector(JavaScriptObject impl) {
        super(impl);
        // TODO Auto-generated constructor stub

        if (getType().equalsIgnoreCase(KmlStyle)) {
            KmlStyleObject = new KmlStyle(impl);

        } else if (getType().equalsIgnoreCase(KmlStyleMap)) {
            KmlStyleMapObject = new KmlStyleMap(impl);
        }
    }

    public KmlStyle getKmlStyleObject() {
        return KmlStyleObject;
    }

    public void setKmlStyleObject(KmlStyle kmlStyleObject) {
        KmlStyleObject = kmlStyleObject;
    }

    public KmlStyleMap getKmlStyleMapObject() {
        return KmlStyleMapObject;
    }

    public void setKmlStyleMapObject(KmlStyleMap kmlStyleMapObject) {
        KmlStyleMapObject = kmlStyleMapObject;
    }
}
