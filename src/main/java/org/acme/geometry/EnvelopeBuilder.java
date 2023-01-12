package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class EnvelopeBuilder implements GeometryVisitor{

    List<Coordinate> coordinates = new ArrayList<>();

    public void insert(Coordinate coordinate){
        this.coordinates.add(coordinate);
    }

    public Envelope build(){

        List<Double> xVals = new ArrayList<Double>();
        List<Double> yVals = new ArrayList<Double>();

        for(Coordinate coordinate: coordinates){
            xVals.add(coordinate.getX());
            yVals.add(coordinate.getY());
        }
        double xmin = Collections.min(xVals);
        double xmax = Collections.max(xVals);
        double ymin = Collections.min(yVals);
        double ymax = Collections.max(yVals);

        Envelope envelope = new Envelope(new Coordinate(xmin,ymin),new Coordinate(xmax,ymax));
        return envelope;
    }

    @Override
    public void visit(Point point) {
    }

    @Override
    public void visit(LineString lineString) {

    }
}
