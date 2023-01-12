package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{

    public String asText(){
        return null;
    }

    @Override
    public Geometry clone() {
        return null;
    }

    public Envelope getEnvelop() {return null;}
}