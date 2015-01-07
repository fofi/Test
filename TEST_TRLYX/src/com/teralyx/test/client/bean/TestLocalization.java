package com.teralyx.test.client.bean;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestLocalization implements IsSerializable {

		
	private int latitud_degrees;

    private int latitud_minutes;
    
    private int latitud_seconds;
    
    private double latitud;
    
    private int longitud_degrees;
    
    private int longitud_minutes;
    
    private int longitud_seconds;
    
    private double longitud;
    
    private int altitude;
    
    private int zoom;

    /**
     * @return Returns the latitud_degrees.
     */
    public int getLatitud_degrees() {
        return latitud_degrees;
    }

    /**
     * @param latitud_degrees The latitud_degrees to set.
     */
    public void setLatitud_degrees(int latitud_degrees) {
        this.latitud_degrees = latitud_degrees;
    }

    /**
     * @return Returns the latitud_minutes.
     */
    public int getLatitud_minutes() {
        return latitud_minutes;
    }

    /**
     * @param latitud_minutes The latitud_minutes to set.
     */
    public void setLatitud_minutes(int latitud_minutes) {
        this.latitud_minutes = latitud_minutes;
    }

    /**
     * @return Returns the latitud_seconds.
     */
    public int getLatitud_seconds() {
        return latitud_seconds;
    }

    /**
     * @param latitud_seconds The latitud_seconds to set.
     */
    public void setLatitud_seconds(int latitud_seconds) {
        this.latitud_seconds = latitud_seconds;
    }

    /**
     * @return Returns the latitud.
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud The latitud to set.
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return Returns the longitud_degrees.
     */
    public int getLongitud_degrees() {
        return longitud_degrees;
    }

    /**
     * @param longitud_degrees The longitud_degrees to set.
     */
    public void setLongitud_degrees(int longitud_degrees) {
        this.longitud_degrees = longitud_degrees;
    }

    /**
     * @return Returns the longitud_minutes.
     */
    public int getLongitud_minutes() {
        return longitud_minutes;
    }

    /**
     * @param longitud_minutes The longitud_minutes to set.
     */
    public void setLongitud_minutes(int longitud_minutes) {
        this.longitud_minutes = longitud_minutes;
    }

    /**
     * @return Returns the longitud_seconds.
     */
    public int getLongitud_seconds() {
        return longitud_seconds;
    }

    /**
     * @param longitud_seconds The longitud_seconds to set.
     */
    public void setLongitud_seconds(int longitud_seconds) {
        this.longitud_seconds = longitud_seconds;
    }

    /**
     * @return Returns the longitud.
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud The longitud to set.
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return Returns the altitude.
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * @param altitude The altitude to set.
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    /**
     * @return Returns the zoom.
     */
    public int getZoom() {
        return zoom;
    }

    /**
     * @param zoom The zoom to set.
     */
    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + altitude;
        long temp;
        temp = (long) latitud;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + latitud_degrees;
        result = prime * result + latitud_minutes;
        result = prime * result + latitud_seconds;
        temp = (long) longitud;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + longitud_degrees;
        result = prime * result + longitud_minutes;
        result = prime * result + longitud_seconds;
        result = prime * result + zoom;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TestLocalization other = (TestLocalization) obj;
        if (altitude != other.altitude)
            return false;
        if (latitud != other.latitud)
            return false;
        if (latitud_degrees != other.latitud_degrees)
            return false;
        if (latitud_minutes != other.latitud_minutes)
            return false;
        if (latitud_seconds != other.latitud_seconds)
            return false;
        if (longitud != other.longitud)
            return false;
        if (longitud_degrees != other.longitud_degrees)
            return false;
        if (longitud_minutes != other.longitud_minutes)
            return false;
        if (longitud_seconds != other.longitud_seconds)
            return false;
        if (zoom != other.zoom)
            return false;
        return true;
    }
    
}
