package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {

    private List<Point> points;

    public LineString(){
        this.points = new ArrayList<Point>();
    }

    public LineString(List<Point> points) {
        if(points == null){
            this.points = new ArrayList<Point>();}
        else{
            this.points = points;}
    }

    public int getNumPoints(){

        return points.size() ;
    }

    public Point getPointN(int n){
        return points.get(n);

    }
    @Override
    public String getType() {
            return "LineString";
    }

    @Override
    public Boolean isEmpty() {
        for (Point point : points){
            if(point.isEmpty() != true){
                return false;
            }
        }
        return true;
    }

    @Override
    public void translate(double dx, double dy) {
        for (Point point : points){
            point.translate(dx,dy);
            }
        }

    @Override
    public LineString clone() {

        List<Point> cloneArray = new ArrayList<>();
        for (Point point : points){
            cloneArray.add(point.clone());
        }
        LineString newClone = new LineString(cloneArray);
        return newClone;
    }

    @Override
    public Envelope getEnvelop() {
        EnvelopeBuilder envLineBuilder = new EnvelopeBuilder();

        for (Point point : points){
            envLineBuilder.insert(point.getCoordinate());
        }

        Envelope envLine = envLineBuilder.build();
        return envLine;

    }
    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }

    public String asText() {
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = new LineString(this.points);
        geometry.accept(visitor);
        return visitor.getResult();
    }

}
