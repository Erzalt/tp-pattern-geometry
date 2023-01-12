package org.acme.geometry;

import java.beans.Encoder;

public class Point implements Geometry {

    private Coordinate coordinate;

    public Point() {
        this.coordinate = new Coordinate();
    }

    ;


    public Point(Coordinate coordinate) {
        if (coordinate == null) {
            this.coordinate = new Coordinate();
        } else {
            this.coordinate = coordinate;
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String getType() {
        return "Point";
    }

    @Override
    public Boolean isEmpty() {
        if (this.coordinate.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void translate(double dx, double dy) {
        this.coordinate.setX(this.coordinate.getX() + dx);
        this.coordinate.setY(this.coordinate.getY() + dy);
    }

    @Override
    public Point clone() {
        Coordinate co = new Coordinate(this.coordinate.getX(), this.coordinate.getY());
        Point newClone = new Point(co);
        return newClone;
    }

    @Override
    public Envelope getEnvelop() {
        EnvelopeBuilder envPointBuilder = new EnvelopeBuilder();
        envPointBuilder.insert(coordinate);
        Envelope envPoint = envPointBuilder.build();
        return envPoint;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
