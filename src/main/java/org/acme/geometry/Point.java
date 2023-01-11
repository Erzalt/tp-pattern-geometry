package org.acme.geometry;

public class Point implements Geometry{

    private Coordinate coordinate;

    public Point(){
        this.coordinate = new Coordinate();
    };


    public Point(Coordinate coordinate) {
        if(coordinate == null){
            this.coordinate = new Coordinate();
        }
        else{
            this.coordinate = coordinate;}
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public Boolean isEmpty() {
        if(this.coordinate.isEmpty()){
            return true;}
        else{return false;}
    }

    @Override
    public void translate(double dx, double dy) {
        this.coordinate.setX(this.coordinate.getX() + dx);
        this.coordinate.setY(this.coordinate.getY() + dy);
    }
}