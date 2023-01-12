package org.acme.geometry;

public class WktWriter {
    public WktWriter(){}

    public String write(Geometry geometry){
        String wkt =  null;

        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            if( point.isEmpty()) {
                wkt = "POINT EMPTY";
            }
            else{
                wkt = "POINT (" + point.getCoordinate().getX() + ' ' + point.getCoordinate().getY() + ')'  ;
            }

            }else if ( geometry instanceof LineString ){

            LineString lineString = (LineString)geometry;

            if( lineString.isEmpty()) {
                wkt = "LINESTRING EMPTY";
            }
            else{
                wkt = "LINESTRING (";
                for(int i = 0; i < lineString.getNumPoints(); i++){
                    if( i != 0){
                        wkt = wkt + ", ";
                    }
                    wkt = wkt +  lineString.getPointN(i).getCoordinate().getX()+' '+lineString.getPointN(i).getCoordinate().getY();
                }
                wkt = wkt + ')';
            }
        }else{
            throw new RuntimeException("geometry type not supported");
        }
        return wkt;
    }
}

