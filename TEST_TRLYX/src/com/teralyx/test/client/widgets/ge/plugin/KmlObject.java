
package com.teralyx.test.client.widgets.ge.plugin;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * TODO Add class description in english
 * 
 * TODO Añadir la descripción de la clase en español
 * 
 * @author Deimos Space S.L.
 *
 */
public class KmlObject extends GEEventEmitter {

    @SuppressWarnings("unused")
    private String type;
    
    @SuppressWarnings("unused")
    private String id;

    /**
     * @param impl
     */
    public KmlObject(JavaScriptObject impl) {
        super(impl);
        type = getType();
    }

    public String getType() {
        return getTypeImpl(getImpl());
    }

    private native String getTypeImpl(JavaScriptObject impl) /*-{
       return impl.getType();
       }-*/;
    private native String getIdImpl(JavaScriptObject impl) /*-{
    var obj;
    try{
    obj=impl.getId();
    }catch(err){
    }
    return obj; 
    }-*/;

    public String getId() {
        return getIdImpl(getImpl());
    }
    // TODO implementar si es necesario
    // getOwnerDocument() KmlObject
    // getParentNode() KmlObject

}
