package org.acme.geometry;

public class WktVisitor implements GeometryVisitor{

    private StringBuilder buffer = new StringBuilder();

    public String getResult(){
        return this.buffer.toString();
    }

    @Override
    public void visit(Point point) {
        if( point.isEmpty()) {
            this.buffer.append("POINT EMPTY");
        }
        else{
            this.buffer.append( "POINT (" + point.getCoordinate().getX() + ' ' + point.getCoordinate().getY() + ')' );
        }
    }

    @Override
    public void visit(LineString lineString) {
        if( lineString.isEmpty()) {
            this.buffer.append("LINESTRING EMPTY");
        }
        else{
            this.buffer.append("LINESTRING (");
            for(int i = 0; i < lineString.getNumPoints(); i++){
                if( i != 0){
                    this.buffer.append(", ");
                }
                this.buffer.append(lineString.getPointN(i).getCoordinate().getX());
                this.buffer.append(' ');
                this.buffer.append(lineString.getPointN(i).getCoordinate().getY());
            }
            this.buffer.append(')');
        }
    }
}
