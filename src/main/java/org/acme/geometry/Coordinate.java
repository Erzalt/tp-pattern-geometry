package org.acme.geometry;

public final class Coordinate {
    private double x;
    private double y;
    public Coordinate(){}

    public Coordinate(double x, double y) {
        this.x = 0.0;
        this.y = 0.0;
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
