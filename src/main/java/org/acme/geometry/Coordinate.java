package org.acme.geometry;

public final class Coordinate {
    private double x;
    private double y;
    public Coordinate(){
        this.x = Double.NaN;
        this.y = Double.NaN;
    }

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public boolean isEmpty() {
        if(Double.isNaN(x) || Double.isNaN(y)){
            return true;}
        else{
        return false ;}
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
