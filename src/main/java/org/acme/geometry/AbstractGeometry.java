package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult() ;
    }

    @Override
    public Geometry clone() {
        return null;
    }

    public Envelope getEnvelop() {return null;}
}